package Programmers;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] operations = //{ "I 16", "D 1" };
			{"I 7", "I 5", "I -5", "D -1"};
		int[] answer = s.solution(operations);
		for(int i=0; i<answer.length; i++)
			System.out.print(answer[i]+" ");
	}
}

class Solution {
	/**
	 * 명령어가 주어졌을 때 이중우선순위 큐에서 각 명령을 수행하는 문제
	 * "I 숫자" 이면 이중 우선순위 큐에 숫자를 삽입한다.
	 * "D 1" 이면 이중 우선순위 큐에서 최대값을 삭제한다.
	 * "D -1" 이면 이중 우선순위 큐에서 최소값을 삭제한다.
	 * @param operations 명령어가 저장된 배열
	 * @return 최대값, 최소값
	 */
	public int[] solution(String[] operations) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < operations.length; i++) {
			char op = operations[i].charAt(0);
			int number = Integer.parseInt(operations[i].substring(2));
			if (op == 'I') {
				arr.add(number);
			} else if (op == 'D') {
				arr.sort(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					}
				});
				if (arr.size() != 0) {
					int index = number == 1 ? arr.size() - 1 : 0;
					arr.remove(index);
				}
			}
		}
		if (arr.size() == 0)
			return new int[] { 0, 0 };
		arr.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		return new int[] { arr.get(arr.size() - 1), arr.get(0) };
	}
}