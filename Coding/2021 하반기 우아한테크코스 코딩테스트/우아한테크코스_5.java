package techcourseTest;

public class Main5 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int rows = 3;
		int columns = 4;
		int[][] result = s.solution(rows, columns);
		for (int[] arr : result) {
			for (int v : arr)
				System.out.print(v + " ");
			System.out.println();
		}
	}

	static class Solution {
		int zeroCount;

		/**
		 * 다음과 같은 과정을 통해 배열에 숫자를 채워넣는 문제
		 * 현재 위치를 1행 1열로 정하고, 그 위치에 숫자 1을 씁니다.
		 * r을 현재 위치의 행, c를 현재 위치의 열로 정의합니다.
		 * 만약 격자 내에 0이 쓰인 칸이 없거나, 더 이상 0이 쓰여 있는 칸에 다른 숫자를 쓸 수 없게 된다면 과정을 즉시 종료합니다.
		 * 만약 가장 최근에 쓴 숫자가 짝수라면, r행 c열에서 r+1행 c열로 이동합니다. r = rows라면, 1행으로 이동합니다.
		 * 만약 가장 최근에 쓴 숫자가 홀수라면, r행 c열에서 r행 c+1열로 이동합니다. c = columns라면, 1열로 이동합니다.
		 * 도착한 칸에 원래 쓰여 있던 수를 지우고 가장 최근에 쓴 숫자 + 1을 씁니다.
		 * 2번 과정으로 돌아갑니다.
		 * @param rows 행의 개수
		 * @param columns 열의 개수
		 * @return
		 */
		public int[][] solution(int rows, int columns) {
			int[][] answer = new int[rows][columns];
			zeroCount = rows * columns;
			int x = 0, y = 0, num = 1;
			while (zeroCount > 0) {
				if (answer[x][y] == 0)
					zeroCount--;
				// 이미 방문한 칸을 같은 홀짝으로 다시 방문하려고 하면 종료한다.
				else if (answer[x][y] % 2 == num % 2)
					break;
				answer[x][y] = num;
				if (num++ % 2 == 0)
					x = x + 1 == rows ? 0 : x + 1;
				else
					y = y + 1 == columns ? 0 : y + 1;
			}
			return answer;
		}
	}
}