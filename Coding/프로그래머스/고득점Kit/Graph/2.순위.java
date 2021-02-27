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
	 * n명의 권투선수가 대회에 참여하여 대회를 진행하였지만 몇몇 경기 결과를 분실하였을 때
	 * 주어진 결과로 정확하게 순위를 매길 수 있는 선수의 수를 구하는 문제
	 * 권투는 1대1 경기이고 [A,B]는 A 선수가 B 선수를 항상 이긴다는 의미이다.
	 * @param n 선수의 수
	 * @param results 경기 결과들이 저장된 배열
	 * @return 정확하게 순위를 매길 수 있는 선수의 수
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