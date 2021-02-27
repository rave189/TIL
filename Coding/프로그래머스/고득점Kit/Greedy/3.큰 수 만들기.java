package Programmers;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		String number = "1924";
		// "1231234";
		// "4177252841"
		int k = 2;
		// 3;
		// 4;
		System.out.println(s.solution(number, k));
	}
}

class Solution {
	/**
	 * �־��� ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���� ���ϴ� ����
	 * 
	 * @param number �־��� ����
	 * @param k      ������� �ϴ� ���� ����
	 * @return ����� ���� ���� ū ��
	 */
	public String solution(String number, int k) {
		String[] numbers = number.split("");
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < numbers.length; i++) {
			while (!st.isEmpty() && k > 0 && st.peek().compareTo(numbers[i]) < 0) {
				st.pop();
				k--;
			}
			st.push(numbers[i]);
		}
		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			if (k-- > 0)
				st.pop();
			else
				sb.append(st.pop());
		}
		return sb.reverse().toString();
	}
}