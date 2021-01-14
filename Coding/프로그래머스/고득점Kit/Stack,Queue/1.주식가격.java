package Programmers;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] prices = { 1, 2, 3, 2, 3 };
		int[] result = s.solution(prices);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}
}

class Solution {
	/**
	 * 초 단위로 기록된 주식 가격이 담긴 prices 배열이 주어질 때
	 * 가격이 떨어지지 않은 기간이 몇 초인지를 구하는 메소드
	 * @param prices 초 단위로 기록된 주식 가격
	 * @return 몇 초 동안 떨어지지 않았는지 저장된 배열
	 */
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0; i<prices.length; i++) {
			while(!st.isEmpty() && prices[st.peek()] > prices[i])
				answer[st.peek()] = i-st.pop();
			st.push(i);
		}
		while(!st.isEmpty())
			answer[st.peek()] = prices.length-(st.pop()+1);
		return answer;
	}
}