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
	 * �� ���̿� �ٸ��� �Ǽ��Ͽ� ��� ���� ������ �����ϵ��� ����� ����
	 * �ٸ��� ������ �ǳʴ��� ������ �� �ִٸ� ������ ������ ������ �����Ѵ�.
	 * ��� �� ������ �ٸ� �Ǽ� ����� �־����� �ʴ´�. (�Ǽ��� �Ұ���)
	 * @param n ���� ����
	 * @param costs ���� �����̿� �ٸ��� �Ǽ��ϴ� ����� ����� �迭
	 * @return �ٸ� �Ǽ� ����� �ּҰ�
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