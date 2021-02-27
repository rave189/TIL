package Programmers;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 6;
		int[] times = { 7, 10 };
		System.out.println(s.solution(n, times));
	}
}

class Solution {
	/**
	 * n���� ����� �Ա��ɻ縦 ���� �˻縦 �������� �Ѵ�.
	 * �ɻ���� �˻��ϴµ� �ʿ��� �ð��� �־����� ��
	 * ��� ����� �˻縦 �޴µ� �ɸ��� �ð��� �ּڰ��� ���ϴ� ����
	 * @param n �˻�������� ����� ��
	 * @param times �ɻ���� �˻��ϴµ� �ҿ�Ǵ� �ð��� ����� �迭
	 * @return ��� ����� �˻�޴µ� �ɸ��� �ð��� �ּڰ�
	 */
	public long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		Arrays.sort(times);
		long left = 0;
		long right = (long)times[times.length - 1] * (long)n;
		while (left <= right) {
			long mid = (left + right) / 2;
			long checkPeople = 0;
			for (int i = 0; i < times.length; i++)
				checkPeople += mid / times[i];
			if (checkPeople >= n) {
				right = mid - 1;
				answer = Math.min(mid, answer);
			} else
				left = mid + 1;
		}
		return answer;
	}
}