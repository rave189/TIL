package Programmers;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		String numbers = // "17";
				"011";
		System.out.println(s.solution(numbers));
	}
}

class Solution {
	HashSet<Integer> valueCheck = new HashSet<Integer>();
	boolean[] useCheck;
	int answer = 0;

	/**
	 * 각 종이 조각에 적힌 숫자가 문자열로 주어질 때
	 * 종이 조각으로 만들 수 있는 소수가 몇 개인지 구하는 문제
	 * @param numbers 종이 조각에 적힌 숫자들
	 * @return 소수의 개수
	 */
	public int solution(String numbers) {
		String[] numArr = numbers.split("");
		useCheck = new boolean[numArr.length];
		Search(numArr, "");
		return answer;
	}

	public void Search(String[] numArr, String result) {
		for (int i = 0; i < numArr.length; i++) {
			if (!useCheck[i]) {
				useCheck[i] = true;
				int number = Integer.parseInt(result + numArr[i]);
				if (PrimeCheck(number))
					if (!valueCheck.contains(number)) {
						valueCheck.add(number);
						answer++;
					}
				Search(numArr, result + numArr[i]);
				useCheck[i] = false;
			}
		}
	}

	public boolean PrimeCheck(int num) {
		if (num < 2)
			return false;
		for (int i = 2; i * i <= num; i++)
			if (num % i == 0)
				return false;
		return true;
	}
}