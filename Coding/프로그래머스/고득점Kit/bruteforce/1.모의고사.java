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
	 * 1, 2, 3번의 수포자가 있을 때 수포자가 찍는 방법으로 찍었을 때
	 * 가장 높은 점수를 받는 사람을 구하는 문제
	 * 가장 높은 점수가 여러 명일 경우 오름차순으로 모두 출력한다.
	 * @param answers 문제의 정답을 저장한 배열
	 * @return 가장 높은 점수를 받은 사람의 배열
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