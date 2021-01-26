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
	 * ��ɾ �־����� �� ���߿켱���� ť���� �� ����� �����ϴ� ����
	 * "I ����" �̸� ���� �켱���� ť�� ���ڸ� �����Ѵ�.
	 * "D 1" �̸� ���� �켱���� ť���� �ִ밪�� �����Ѵ�.
	 * "D -1" �̸� ���� �켱���� ť���� �ּҰ��� �����Ѵ�.
	 * @param operations ��ɾ ����� �迭
	 * @return �ִ밪, �ּҰ�
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