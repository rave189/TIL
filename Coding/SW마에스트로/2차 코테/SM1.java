package Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SM1 {

	static int[] drtX = { 1, -1, 0, 0 };
	static int[] drtY = { 0, 0, 1, -1 };
	static int[][] map;
	static boolean[][] check;
	static Point key;
	static Point soma;
	static Point gold;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 0; t < testCase; t++) {
			// 입력 받기
			int n = sc.nextInt();
			int m = sc.nextInt();
			map = new int[n][m];
			check = new boolean[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 2)
						gold = new Point(i, j);
					else if (map[i][j] == 3)
						soma = new Point(i, j);
					else if (map[i][j] == 4)
						key = new Point(i, j);
				}

			// 현재 소마 위치 true로 변경 후 key값 찾기
			check[soma.x][soma.y] = true;
			if (Search(key)) {
				// 방문했던 위치 정보를 초기화 한 후 다시 한번 소마위치를 true로 변경
				check = new boolean[n][m];
				check[soma.x][soma.y] = true;
				if (Search(gold)) {
					System.out.println(1);
					continue;
				}
			}
			System.out.println(0);
		}
	}

	public static boolean Search(Point desti) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(soma);
		while (!q.isEmpty()) {
			Point cur = q.poll();
			check[cur.x][cur.y] = true;
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + drtX[i];
				int nextY = cur.y + drtY[i];
				try {
					if (map[nextX][nextY] != 1 && !check[nextX][nextY]) {
						if (nextX == desti.x && nextY == desti.y) {
							soma = new Point(nextX, nextY);
							return true;
						}
						q.add(new Point(nextX, nextY));
					}
				} catch (Exception e) {
				}
			}
		}
		return false;
	}
}

class Point {
	int x;
	int y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}