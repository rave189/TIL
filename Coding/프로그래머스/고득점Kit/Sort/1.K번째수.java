package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[] result = s.solution(array, commands);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}
}

class Solution {
	/**
	 * i번째 수부터 j번째 수까지의 배열을 정렬하였을 때 k번째 수를 구하는 문제
	 * i, j, k는 commands안에 들어있다.
	 * @param array 주어지는 배열
	 * @param commands i, j, k가 들어있는 배열
	 * @return k 번째 수를 모아놓은 배열
	 */
	public int[] solution(int[] array, int[][] commands) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0] - 1;
			int end = commands[i][1] - 1;
			int k = commands[i][2];
			int[] result = new int[end - start + 1];
			int resultCnt = 0;
			for (int j = start; j <= end; j++)
				result[resultCnt++] = array[j];
			Arrays.sort(result);
			answer.add(result[k - 1]);
		}
		return Arrays.stream(answer.toArray(new Integer[answer.size()])).mapToInt(Integer::intValue).toArray();
	}
}