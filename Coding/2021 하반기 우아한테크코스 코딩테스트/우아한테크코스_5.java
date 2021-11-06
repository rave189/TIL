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
		 * ������ ���� ������ ���� �迭�� ���ڸ� ä���ִ� ����
		 * ���� ��ġ�� 1�� 1���� ���ϰ�, �� ��ġ�� ���� 1�� ���ϴ�.
		 * r�� ���� ��ġ�� ��, c�� ���� ��ġ�� ���� �����մϴ�.
		 * ���� ���� ���� 0�� ���� ĭ�� ���ų�, �� �̻� 0�� ���� �ִ� ĭ�� �ٸ� ���ڸ� �� �� ���� �ȴٸ� ������ ��� �����մϴ�.
		 * ���� ���� �ֱٿ� �� ���ڰ� ¦�����, r�� c������ r+1�� c���� �̵��մϴ�. r = rows���, 1������ �̵��մϴ�.
		 * ���� ���� �ֱٿ� �� ���ڰ� Ȧ�����, r�� c������ r�� c+1���� �̵��մϴ�. c = columns���, 1���� �̵��մϴ�.
		 * ������ ĭ�� ���� ���� �ִ� ���� ����� ���� �ֱٿ� �� ���� + 1�� ���ϴ�.
		 * 2�� �������� ���ư��ϴ�.
		 * @param rows ���� ����
		 * @param columns ���� ����
		 * @return
		 */
		public int[][] solution(int rows, int columns) {
			int[][] answer = new int[rows][columns];
			zeroCount = rows * columns;
			int x = 0, y = 0, num = 1;
			while (zeroCount > 0) {
				if (answer[x][y] == 0)
					zeroCount--;
				// �̹� �湮�� ĭ�� ���� Ȧ¦���� �ٽ� �湮�Ϸ��� �ϸ� �����Ѵ�.
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