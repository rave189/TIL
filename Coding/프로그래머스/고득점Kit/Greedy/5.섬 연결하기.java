package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = // 4;
				5;
		int[][] costs = // { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
				{ { 0, 1, 1 }, { 3, 1, 1 }, { 0, 2, 2 }, { 0, 3, 2 }, { 0, 4, 100 } };
		System.out.println(s.solution(n, costs));
	}
}

class Solution {
	/**
	 * 섬 사이에 다리를 건설하여 모든 섬이 통행이 가능하도록 만드는 문제
	 * 다리를 여러번 건너더라도 도달할 수 있다면 통행이 가능한 것으로 간주한다.
	 * 모든 섬 사이의 다리 건설 비용이 주어지지 않는다. (건설이 불가능)
	 * @param n 섬의 개수
	 * @param costs 섬과 섬사이에 다리를 건설하는 비용이 저장된 배열
	 * @return 다리 건설 비용의 최소값
	 */
	public int solution(int n, int[][] costs) {
		int answer = 0;
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		int[] unionFind = new int[n];
		for (int i = 1; i < n; i++)
			unionFind[i] = i;
		for (int i = 0; i < costs.length; i++) {
			int island1 = parentSearch(unionFind, costs[i][0]);
			int island2 = parentSearch(unionFind, costs[i][1]);
			if (island1 != island2) {
				unionFind[island2] = island1;
				answer += costs[i][2];
			}
		}
		return answer;
	}

	public int parentSearch(int[] unionFind, int child) {
		if (unionFind[child] == child)
			return child;
		return parentSearch(unionFind, unionFind[child]);
	}
}