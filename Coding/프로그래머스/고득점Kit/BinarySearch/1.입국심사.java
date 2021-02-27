package Programmers;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 6;
		int[] times = { 7, 10 };
		System.out.println(s.solution(n, times));
	}
}

class Solution {
	/**
	 * n명의 사람이 입국심사를 위해 검사를 받으려고 한다.
	 * 심사관이 검사하는데 필요한 시간이 주어졌을 때
	 * 모든 사람이 검사를 받는데 걸리는 시간의 최솟값을 구하는 문제
	 * @param n 검사받으려는 사람의 수
	 * @param times 심사관이 검사하는데 소요되는 시간이 저장된 배열
	 * @return 모든 사람이 검사받는데 걸리는 시간의 최솟값
	 */
	public long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		Arrays.sort(times);
		long left = 0;
		long right = (long)times[times.length - 1] * (long)n;
		while (left <= right) {
			long mid = (left + right) / 2;
			long checkPeople = 0;
			for (int i = 0; i < times.length; i++)
				checkPeople += mid / times[i];
			if (checkPeople >= n) {
				right = mid - 1;
				answer = Math.min(mid, answer);
			} else
				left = mid + 1;
		}
		return answer;
	}
}