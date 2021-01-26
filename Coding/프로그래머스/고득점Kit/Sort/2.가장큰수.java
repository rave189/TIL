package Programmers;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = // { 6, 10, 2 };
				// { 3, 30, 34, 5, 9 };
				// { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				{ 40, 403 };
		System.out.println(s.solution(numbers));
	}
}

class Solution {
	/**
	 * 배열에 들어있는 수를 이어 붙여 가장 큰 수를 만드는 문제
	 * @param numbers 숫자가 저장된 배열
	 * @return 가장 큰 수
	 */
	public String solution(int[] numbers) {
		PriorityQueue<Num> result = new PriorityQueue<Num>();
		for (int item : numbers)
			result.add(new Num(Integer.toString(item)));
		StringBuilder answer = new StringBuilder();
		while (!result.isEmpty())
			answer.append(result.poll().value);
		while (answer.length() != 0 && answer.charAt(0) == '0')
			answer.deleteCharAt(0);
		return answer.length() == 0 ? "0" : answer.toString();
	}
}

class Num implements Comparable<Num> {
	String value;

	public Num(String _value) {
		this.value = _value;
	}

	@Override
	public int compareTo(Num o) {
		int size = value.length() > o.value.length() ? value.length() : o.value.length();
		for (int i = 0; i < size; i++) {
			char base = i >= value.length() ? value.charAt(value.length() - 1) : value.charAt(i);
			char compare = i >= o.value.length() ? o.value.charAt(o.value.length() - 1) : o.value.charAt(i);
			if (base > compare)
				return -1;
			else if (base < compare)
				return 1;
		}
		return 0;
	}

}