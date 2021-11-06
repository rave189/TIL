package techcourseTest;

public class Main7 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] grid = // { "1", "234", "56789" };
				{ "A", "MAN", "DRINK", "WATER11" };
		boolean clockwise = // true;
				false;
		String[] result = s.solution(grid, clockwise);
		for (String v : result)
			System.out.println(v);
	}

	static class Solution {
		char[][] triangles;
		char[][] rotateTriangles;

		/**
		 * �� ���� ���̰� 1�� ���ﰢ�� n^2���� ������ ���ﰢ�� ���ڰ� �ִ�.
		 * �� �ﰢ���� �ð� ���� Ȥ�� �ݽð� �������� ȸ����Ų �� ����� ����ϴ� ����
		 * @param grid ���ﰢ��
		 * @param clockwise true�̸� �ð� ����, false�̸� �ݽð� ����
		 * @return ȸ���� �ﰢ��
		 */
		public String[] solution(String[] grid, boolean clockwise) {
			init(grid);
			if (clockwise)
				clockwise();
			else
				counterClockwise();
			return changeStrArr();
		}

		public void init(String[] grid) {
			triangles = new char[grid.length][];
			rotateTriangles = new char[grid.length][];
			for (int i = 0; i < grid.length; i++) {
				triangles[i] = new char[2 * i + 1];
				rotateTriangles[i] = new char[2 * i + 1];
				for (int j = 0; j < triangles[i].length; j++)
					triangles[i][j] = grid[i].charAt(j);
			}
		}

		/**
		 * �ð� �������� ȸ����Ű�� �޼ҵ�
		 */
		public void clockwise() {
			for (int i = triangles.length - 1, t = 0; i >= 0; i--, t++) {
				int nextX = t, nextY = triangles[t].length - 1, count = 0;
				for (int j = 0; j < triangles[i].length; j++) {
					try {
						rotateTriangles[nextX][nextY] = triangles[i][j];
						if (count++ % 2 == 0) {
							nextX += 1;
							nextY += 1;
						} else
							nextY -= 1;
					} catch (ArrayIndexOutOfBoundsException e) {
						break;
					}
				}
			}
		}

		/**
		 * �ݽð� ȸ����Ű�� �޼ҵ�
		 */
		public void counterClockwise() {
			for (int i = 0, t = triangles.length - 1; i < triangles.length; i++, t--) {
				int nextX = t, nextY = triangles[t].length - 1, count = 0;
				for (int j = 0; j < triangles[i].length; j++) {
					try {
						rotateTriangles[i][j] = triangles[nextX][nextY];
						if (count++ % 2 == 0) {
							nextX += 1;
							nextY += 1;
						} else
							nextY -= 1;
					} catch (ArrayIndexOutOfBoundsException e) {
						break;
					}
				}
			}
		}

		/**
		 * char[][]�� String[]�� �ٲ��ִ� �޼ҵ�
		 * @return
		 */
		public String[] changeStrArr() {
			String[] answer = new String[rotateTriangles.length];
			for (int i = 0; i < rotateTriangles.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < rotateTriangles[i].length; j++)
					sb.append(rotateTriangles[i][j]);
				answer[i] = sb.toString();
			}
			return answer;
		}
	}
}