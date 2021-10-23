package NHNCodingTest;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main2 {

	public static void main(String[] args) {

	}

	static class Solution {
		/**
		 * N���� ������ Ư�� ���ļ��� �߰��ϴ� �߰�Ⱑ �ִ�.
		 * ��� ���ļ� �뿪�� ������ �� �ִٸ� ������, ������� �Ѱ�� �ִ� K���� ���ļ� �뿪�� ������ �� �ִ�.
		 * � ���ļ� �뿪�� �����ؾ� ���� ū ���ظ� ��ĥ �� �ִ��� ���ϴ� ����
		 * 
		 * @param numOfRegion ������ ��
		 * @param numOfAttackableFrequency ������ �� �ִ� ���ļ� �뿪�� ��
		 * @param frequencies �̿� �������� �߰�Ⱑ ����ϴ� ���ļ� �뿪
		 */
		public void solution(int numOfRegion, int numOfAttackableFrequency, int[][] frequencies) {
			int answer = 0;
			Map<Integer, Integer> frequencyMap = new HashMap<>();
			PriorityQueue<Repeater> result = new PriorityQueue<>((v1, v2) -> v2.count - v1.count);
			
			// hashmap�� �־� ������ ���ļ� �뿪�� ���� Ƚ���� ���Ѵ�.
			for (int i = 0; i < numOfRegion; i++) {
				for (int j = 0; j < frequencies[i].length; j++) {
					int frequency = frequencies[i][j];
					frequencyMap.put(frequency, frequencyMap.getOrDefault(frequency, 0) + 1);
				}
			}

			// hashmap�� ���� ��� priorityqueue�� �ִ´�.
			for (int key : frequencyMap.keySet()) {
				result.add(new Repeater(key, frequencyMap.get(key)));
			}
			// K���� ���ļ� �뿪���� ���� Ƚ���� �����ش�.
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
