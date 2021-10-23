package NHNCodingTest;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main2 {

	public static void main(String[] args) {

	}

	static class Solution {
		/**
		 * N개의 지역에 특정 주파수를 중계하는 중계기가 있다.
		 * 모든 주파수 대역을 공격할 수 있다면 좋지만, 기술력의 한계로 최대 K개의 주파수 대역만 공격할 수 있다.
		 * 어떤 주파수 대역을 공격해야 가장 큰 피해를 끼칠 수 있는지 구하는 문제
		 * 
		 * @param numOfRegion 지역의 수
		 * @param numOfAttackableFrequency 공격할 수 있는 주파수 대역의 수
		 * @param frequencies 이웃 지역들의 중계기가 사용하는 주파수 대역
		 */
		public void solution(int numOfRegion, int numOfAttackableFrequency, int[][] frequencies) {
			int answer = 0;
			Map<Integer, Integer> frequencyMap = new HashMap<>();
			PriorityQueue<Repeater> result = new PriorityQueue<>((v1, v2) -> v2.count - v1.count);
			
			// hashmap에 넣어 각각의 주파수 대역이 나온 횟수를 구한다.
			for (int i = 0; i < numOfRegion; i++) {
				for (int j = 0; j < frequencies[i].length; j++) {
					int frequency = frequencies[i][j];
					frequencyMap.put(frequency, frequencyMap.getOrDefault(frequency, 0) + 1);
				}
			}

			// hashmap의 값을 모두 priorityqueue에 넣는다.
			for (int key : frequencyMap.keySet()) {
				result.add(new Repeater(key, frequencyMap.get(key)));
			}
			// K개의 주파수 대역만을 꺼내 횟수를 더해준다.
			while (numOfAttackableFrequency-- > 0) {
				answer += result.poll().count;
			}
			System.out.println(answer);
		}

		static class Repeater {
			int frequency, count;

			public Repeater(int frequency, int count) {
				this.frequency = frequency;
				this.count = count;
			}
		}
	}
}
