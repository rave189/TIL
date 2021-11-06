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
		 * 한 변의 길이가 1인 정삼각형 n^2개로 구성된 정삼각형 격자가 있다.
		 * 이 삼각형을 시계 방향 혹은 반시계 방향으로 회전시킨 후 결과를 출력하는 문제
		 * @param grid 정삼각형
		 * @param clockwise true이면 시계 방향, false이면 반시계 방향
		 * @return 회전한 삼각형
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
		 * 시계 방향으로 회전시키는 메소드
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
		 * 반시계 회전시키는 메소드
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
		 * char[][]를 String[]로 바꿔주는 메소드
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