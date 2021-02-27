package Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] routes = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		System.out.println(s.solution(routes));
	}
}

class Solution {
	/**
	 * 고속도로에 단속용 카메라를 설치하려고 할 때
	 * 모든 차량이 단속용 카메라를 한번이라도 만나게 하려고 하면
	 * 최소 몇 대의 카메라를 설치해야 하는지를 구하는 문제
	 * @param routes 차량의 진입, 진출 시점이 저장된 배열
	 * @return 카메라의 최소 설치 수
	 */
	public int solution(int[][] routes) {
		int answer = 1;
		PriorityQueue<int[]> result = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		for (int[] car : routes)
			result.add(car);
		int[] prev = result.poll();
		while (!result.isEmpty()) {
			int[] cur = result.poll();
			if (prev[1] > cur[0])
				prev = new int[] { cur[0], prev[1] };
			else {
				answer++;
				prev = cur;
			}
		}
		return answer;
	}
}