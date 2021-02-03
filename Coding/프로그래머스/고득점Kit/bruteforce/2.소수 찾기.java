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
	 * �� ���� ������ ���� ���ڰ� ���ڿ��� �־��� ��
	 * ���� �������� ���� �� �ִ� �Ҽ��� �� ������ ���ϴ� ����
	 * @param numbers ���� ������ ���� ���ڵ�
	 * @return �Ҽ��� ����
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