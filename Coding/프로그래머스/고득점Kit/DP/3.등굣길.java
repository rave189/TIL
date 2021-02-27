package Programmers;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 2 } };
		System.out.println(s.solution(m, n, puddles));
	}
}

class Solution {
	final int mod = 1000000007;

	/**
	 * 집에서 학교까지 갈 수 있는 최단 경로의 수를 구하는 문제
	 * 최단 경로의 수를 1,000,000,007의 값으로 나눈 나머지를 출력한다.
	 * @param m 가로의 길이
	 * @param n 세로의 길이
	 * @param puddles 물 웅덩이의 위치를 저장한 배열
	 * @return 최단 경로의 수
	 */
	public int solution(int m, int n, int[][] puddles) {
		int[][] map = new int[m + 1][n + 1];
		for (int i = 0; i < puddles.length; i++)
			map[puddles[i][0]][puddles[i][1]] = -1;
		map[0][1] = 1;
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				if (map[i][j] == -1)
					map[i][j] = 0;
				else
					map[i][j] = ((map[i - 1][j] % mod) + (map[i][j - 1] % mod)) % mod;
		return map[m][n];
	}
}