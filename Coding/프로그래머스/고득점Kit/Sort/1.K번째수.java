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
	 * i��° ������ j��° �������� �迭�� �����Ͽ��� �� k��° ���� ���ϴ� ����
	 * i, j, k�� commands�ȿ� ����ִ�.
	 * @param array �־����� �迭
	 * @param commands i, j, k�� ����ִ� �迭
	 * @return k ��° ���� ��Ƴ��� �迭
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