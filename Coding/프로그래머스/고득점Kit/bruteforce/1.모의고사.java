package Programmers;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] answers = //{ 1, 2, 3, 4, 5 };
		{ 1, 3, 2, 4, 2 };
		int[] result = s.solution(answers);
		for (int item : result)
			System.out.print(item + " ");
	}
}

class Solution {
	int[] first = { 1, 2, 3, 4, 5 };
	int[] second = { 2, 1, 2, 3, 2, 4, 2, 5 };
	int[] third = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
	
	/**
	 * 1, 2, 3���� �����ڰ� ���� �� �����ڰ� ��� ������� ����� ��
	 * ���� ���� ������ �޴� ����� ���ϴ� ����
	 * ���� ���� ������ ���� ���� ��� ������������ ��� ����Ѵ�.
	 * @param answers ������ ������ ������ �迭
	 * @return ���� ���� ������ ���� ����� �迭
	 */
	public int[] solution(int[] answers) {
		int[] correct = new int[3];
		for (int i = 0; i < answers.length; i++) {
			correct[0] = first[i % first.length] == answers[i] ? correct[0] + 1 : correct[0];
			correct[1] = second[i % second.length] == answers[i] ? correct[1] + 1 : correct[1];
			correct[2] = third[i % third.length] == answers[i] ? correct[2] + 1 : correct[2];
		}
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(1);
		for (int i = 2; i <= 3; i++) {
			if (correct[answer.get(0) - 1] < correct[i - 1]) {
				answer.clear();
				answer.add(i);
			}
			else if (correct[answer.get(0) - 1] == correct[i - 1])
				answer.add(i);
		}
		return answer.stream().mapToInt(i -> i.intValue()).toArray();
	}
}