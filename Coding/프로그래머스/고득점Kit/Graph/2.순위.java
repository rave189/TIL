package Programmers;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 5;
		int[][] costs = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		System.out.println(s.solution(n, costs));
	}
}

class Solution {
	/**
	 * n���� ���������� ��ȸ�� �����Ͽ� ��ȸ�� �����Ͽ����� ��� ��� ����� �н��Ͽ��� ��
	 * �־��� ����� ��Ȯ�ϰ� ������ �ű� �� �ִ� ������ ���� ���ϴ� ����
	 * ������ 1��1 ����̰� [A,B]�� A ������ B ������ �׻� �̱�ٴ� �ǹ��̴�.
	 * @param n ������ ��
	 * @param results ��� ������� ����� �迭
	 * @return ��Ȯ�ϰ� ������ �ű� �� �ִ� ������ ��
	 */
	public int solution(int n, int[][] results) {
		int answer = 0;
		int[][] map = new int[n][n];
		for (int i = 0; i < results.length; i++) {
			int win = results[i][0] - 1;
			int lose = results[i][1] - 1;
			map[win][lose] = 1;
			map[lose][win] = -1;
		}

		for (int mid = 0; mid < n; mid++)
			for (int start = 0; start < n; start++)
				for (int end = 0; end < n; end++)
					if (start != end)
						if (map[end][mid] == 1 && map[mid][start] == 1) {
							map[end][start] = 1;
							map[start][end] = -1;
						} else if (map[end][mid] == -1 && map[mid][start] == -1) {
							map[start][end] = 1;
							map[end][start] = -1;
						}
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++)
				if (map[i][j] != 0)
					sum++;
			if (sum == n - 1)
				answer++;
		}
		return answer;
	}
}