package ProgrammersTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main3 {
	/**
	 * 1분 차이로 제출 못함 ㅠ 구현 다했는데
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] macaron = { { 1, 1 }, { 2, 1 }, { 1, 2 }, { 3, 3 }, { 6, 4 }, { 3, 1 }, { 3, 3 }, { 3, 3 }, { 3, 4 },
				{ 2, 1 } };
		String[] result = s.solution(macaron);
		for (String v : result)
			System.out.println(v);
	}

	static class Solution {
		int[][] map = new int[6][6];
		boolean[][] visited;
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		/**
		 * 테트리스 문제
		 * 마카롱이 주어지고 3개 이상이 되면 터진다.
		 * @param macaron 마카롱이 떨어지는 자리
		 * @return 테트리스가 종료된 후 결과
		 */
		public String[] solution(int[][] macaron) {
			String[] answer = new String[map.length];
			for (int[] maca : macaron) {
				drop(maca);
				while (bomb())
					falling();
			}
			for (int i = 0; i < map.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < map[0].length; j++)
					sb.append(map[i][j]);
				answer[i] = sb.toString();
			}
			return answer;
		}

		public void drop(int[] maca) {
			for (int i = map.length - 1; i >= 0; i--) {
				if (map[i][maca[0] - 1] == 0) {
					map[i][maca[0] - 1] = maca[1];
					return;
				}
			}
		}

		public boolean bomb() {
			boolean isBomb = false;
			visited = new boolean[map.length][map[0].length];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j] != 0) {
						ArrayList<Point> removeList = BFS(new Point(i, j, map[i][j]));
						if (removeList.size() >= 3) {
							remove(removeList);
							isBomb = true;
						}
					}
				}
			}
			return isBomb;
		}

		public ArrayList<Point> BFS(Point start) {
			ArrayList<Point> removeList = new ArrayList<>();
			Queue<Point> q = new LinkedList<>();
			q.add(start);
			removeList.add(start);
			visited[start.x][start.y] = true;
			while (!q.isEmpty()) {
				Point cur = q.poll();
				for (int i = 0; i < dx.length; i++) {
					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];
					try {
						if (visited[nextX][nextY] || map[nextX][nextY] != cur.type)
							continue;
						Point next = new Point(nextX, nextY, map[nextX][nextY]);
						q.add(next);
						removeList.add(next);
						visited[nextX][nextY] = true;
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
			}
			return removeList;
		}

		public void remove(ArrayList<Point> remove) {
			for (Point cur : remove)
				map[cur.x][cur.y] = 0;
		}

		public void falling() {
			for (int i = 0; i < map.length; i++) {
				for (int j = map.length - 1; j > 0; j--)
					if (map[j][i] == 0) {
						int next = j;
						for(; next>=0; next--) {
							if(map[next][i] != 0) {
								map[j][i] = map[next][i];
								map[next][i] = 0;
								break;
							}
						}
					}
			}
		}
	}

	static class Point {
		int x, y, type;

		public Point(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", type=" + type + "]";
		}
	}
}