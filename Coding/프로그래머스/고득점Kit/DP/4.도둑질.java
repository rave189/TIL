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
	 * ������ ���� �з��� �� �� ��ĥ �� �ִ� ���� �ִ밪�� ���ϴ� ����
	 * �� ������ ���� ������ ����� �����ġ�� ����Ǿ� �־� ������ �� ���� �� �� ����.
	 * @param money �� ���� �ִ� ���� ����� �迭
	 * @return ������ ��ĥ �� �ִ� ���� �ִ밪
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