package Programmers;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println(s.solution(people, limit));
	}
}

class Solution {
	/**
	 * �ִ� 2���� Ż �� �ְ� ���� ������ �ִ� ����Ʈ�� ���� ��
	 * �ּ����� ����Ʈ�� ���ε��� ���� ����� ���ϴ� ����
	 * @param people ������� ������
	 * @param limit ����Ʈ�� ���� ����
	 * @return �ʿ��� ����Ʈ�� �ּҰ�
	 */
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		for (int i = people.length - 1, j = 0; i - j >= 0; i--) {
			if (people[i] + people[j] <= limit)
				j++;
			answer++;
		}
		return answer;
	}
}