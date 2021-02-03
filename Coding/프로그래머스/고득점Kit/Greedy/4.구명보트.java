package Programmers;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println(s.solution(people, limit));
	}
}

class Solution {
	/**
	 * 최대 2명이 탈 수 있고 무게 제한이 있는 구명보트가 있을 때
	 * 최소한의 구명보트로 무인도에 갇힌 사람을 구하는 문제
	 * @param people 사람들의 몸무게
	 * @param limit 구명보트의 무게 제한
	 * @return 필요한 구명보트의 최소값
	 */
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		for (int i = people.length - 1, j = 0; i - j >= 0; i--) {
			if (people[i] + people[j] <= limit)
				j++;
			answer++;
		}
		return answer;
	}
}