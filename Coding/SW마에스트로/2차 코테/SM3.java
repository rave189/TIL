package Test3;

import java.util.Scanner;

public class SM3 {

	static int[][] map;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = sc.nextInt();
		Point start = new Point(0, 0);
		Point end = new Point(n, n);
		Search(start, end, 0);
		System.out.println(answer);
	}

	public static void Search(Point start, Point end, int sum) {
		if (end.x - start.x == 1 && end.y - start.y == 1) {
			answer = Math.max(answer, sum);
			return;
		}
		int ceilMidX = (int) Math.ceil((start.x + end.x) / 2.0);
		int ceilMidY = (int) Math.ceil((start.y + end.y) / 2.0);
		int midX = (start.x + end.x) / 2;
		int midY = (start.y + end.y) / 2;
		Point halfUp = new Point(start.x, ceilMidY);
		Point halfDown = new Point(end.x, midY);
		Point halfLeft = new Point(ceilMidX, start.y);
		Point halfRight = new Point(midX, end.y);

		int max = 0;
		if (end.y - halfUp.y >= 1) {
			max = findMax(start, halfDown);
			Search(halfUp, end, sum + max);
		}

		if (halfDown.y - start.y >= 1) {
			max = findMax(halfUp, end);
			Search(start, halfDown, sum + max);
		}

		if (halfRight.x - start.x >= 1) {
			max = findMax(start, halfRight);
			Search(halfLeft, end, sum + max);
		}

		if (end.x - halfLeft.x >= 1) {
			max = findMax(halfLeft, end);
			Search(start, halfRight, sum + max);
		}
	}

	public static int findMax(Point start, Point end) {
		int max = 0;
		for (int i = start.x; i < end.x; i++)
			for (int j = start.y; j < end.y; j++)
				max = Math.max(max, map[i][j]);
		return max;
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