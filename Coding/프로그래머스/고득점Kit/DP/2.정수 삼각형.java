package Programmers;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		System.out.println(s.solution(triangle));
	}
}

class Solution {
	/**
	 * 삼각형의 꼭대기에서 바닥까지의 이동 경로 중
	 * 거쳐간 숫자의 합이 가장 큰 수를 찾는 문제
	 * @param triangle 삼각형의 정보가 담긴 배열
	 * @return 가장 큰 이동 경로
	 */
	public int solution(int[][] triangle) {
		int answer = 0;
		int size = triangle.length;
		int[][] result = new int[size][];
		for (int i = 0; i < size; i++)
			result[i] = new int[triangle[i].length];
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] += triangle[i][j];
				result[i + 1][j] = Math.max(result[i + 1][j], result[i][j]);
				result[i + 1][j + 1] = Math.max(result[i + 1][j + 1], result[i][j]);
			}
		}
		for (int i = 0; i < triangle[size - 1].length; i++)
			answer = Math.max(answer, result[size - 1][i] + triangle[size - 1][i]);
		return answer;
	}
}