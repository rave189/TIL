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
	 * 주어진 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 수를 구하는 문제
	 * 
	 * @param number 주어진 숫자
	 * @param k      지우려고 하는 수의 개수
	 * @return 지우고 남은 가장 큰 수
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