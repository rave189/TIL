package Programmers;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int distance = 25;
		int[] rocks = { 2, 14, 11, 21, 17 };
		int n = 2;
		System.out.println(s.solution(distance, rocks, n));
	}
}

class Solution {
	/**
	 * 출발 지점 부터 distance까지 바위가 놓여있을 때
	 * n개의 바위를 제거하여 각 바위 사이의 거리의 최솟값이 최대가 되는 값을 구하는 문제
	 * @param distance 도착지점
	 * @param rocks 바위의 위치가 저장된 배열
	 * @param n 제거할 바위의 수
	 * @return 거리의 최솟값의 최대값
	 */
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;
		Arrays.sort(rocks);
		int left = 0;
		int right = distance;
		while (left <= right) {
			int mid = (left + right) / 2;
			int prevRock = 0;
			int removeRock = 0;
			for (int i = 0; i < rocks.length; i++)
				if (rocks[i] - prevRock < mid)
					removeRock++;
				else
					prevRock = rocks[i];
			if (distance - prevRock < mid)
				removeRock++;
			if (removeRock > n)
				right = mid - 1;
			else {
				answer = Math.max(answer, mid);
				left = mid + 1;
			}
		}
		return answer;
	}
}