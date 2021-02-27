package Programmers;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int distance = 25;
		int[] rocks = { 2, 14, 11, 21, 17 };
		int n = 2;
		System.out.println(s.solution(distance, rocks, n));
	}
}

class Solution {
	/**
	 * ��� ���� ���� distance���� ������ �������� ��
	 * n���� ������ �����Ͽ� �� ���� ������ �Ÿ��� �ּڰ��� �ִ밡 �Ǵ� ���� ���ϴ� ����
	 * @param distance ��������
	 * @param rocks ������ ��ġ�� ����� �迭
	 * @param n ������ ������ ��
	 * @return �Ÿ��� �ּڰ��� �ִ밪
	 */
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;
		Arrays.sort(rocks);
		int left = 0;
		int right = distance;
		while (left <= right) {
			int mid = (left + right) / 2;
			int prevRock = 0;
			int removeRock = 0;
			for (int i = 0; i < rocks.length; i++)
				if (rocks[i] - prevRock < mid)
					removeRock++;
				else
					prevRock = rocks[i];
			if (distance - prevRock < mid)
				removeRock++;
			if (removeRock > n)
				right = mid - 1;
			else {
				answer = Math.max(answer, mid);
				left = mid + 1;
			}
		}
		return answer;
	}
}