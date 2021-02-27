package Programmers;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 5;
		// 5;
		// 3;
		int[] lost = { 2, 4 };
		// { 2, 4 };
		// { 3 };
		int[] reserve = { 1, 3, 5 };
		// { 3 };
		// { 1 };
		System.out.println(s.solution(n, lost, reserve));
	}
}

class Solution {
	/**
	 * �б����� ü������ �������ߴ�.
	 * �������� ü������ ������ �л����� ���� ü�� ������ �������� �� ��
	 * �� ���� �л��� ü�� ������ ���� �� �ִ��� ���ϴ� ����
	 * @param n �л� ��
	 * @param lost ü������ �Ҿ���� �л�
	 * @param reserve ������ ü������ �ִ� �л�
	 * @return ü�� ������ ���� �� �ִ� �л��� ��
	 */
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] people = new int[n];
		for (int i = 0; i < lost.length; i++)
			people[lost[i] - 1]--;
		for (int i = 0; i < reserve.length; i++)
			people[reserve[i] - 1]++;
		for (int i = 0; i < n; i++) {
			if (people[i] > 0) {
				try {
					answer++;
					if (i > 0 && people[i - 1] < 0) {
						people[i - 1]++;
						people[i]--;
						answer++;
					} else if (people[i + 1] < 0) {
						people[i + 1]++;
						people[i]--;
					}
				} catch (Exception e) {
				}
			} else if (people[i] == 0)
				answer++;
		}
		return answer;
	}
}