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
	 * ��ӵ��ο� �ܼӿ� ī�޶� ��ġ�Ϸ��� �� ��
	 * ��� ������ �ܼӿ� ī�޶� �ѹ��̶� ������ �Ϸ��� �ϸ�
	 * �ּ� �� ���� ī�޶� ��ġ�ؾ� �ϴ����� ���ϴ� ����
	 * @param routes ������ ����, ���� ������ ����� �迭
	 * @return ī�޶��� �ּ� ��ġ ��
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