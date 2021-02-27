package Programmers;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] money = { 1, 2, 3};
		System.out.println(s.solution(money));
	}
}

class Solution {
	/**
	 * 도둑이 집을 털려고 할 때 훔칠 수 있는 돈의 최대값을 구하는 문제
	 * 각 집들은 서로 인접한 집들과 방범장치가 연결되어 있어 인접한 두 집을 털 수 없다.
	 * @param money 각 집에 있는 돈이 저장된 배열
	 * @return 도둑이 훔칠 수 있는 돈의 최대값
	 */
	public int solution(int[] money) {
		int[][] dp = new int[money.length][2];
		dp[0][0] = money[0];
		dp[1][0] = money[0];
		dp[1][1] = money[1];
		for (int i = 2; i < dp.length; i++) {
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + money[i]);
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + money[i]);
		}
		return Math.max(dp[money.length - 2][0], dp[money.length - 1][1]);
	}
}