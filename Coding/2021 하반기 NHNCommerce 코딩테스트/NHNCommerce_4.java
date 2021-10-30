package NHNCommerceTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main4 {

	static List<Point>[] map;
	static int[] distance;
	static int gfPlanet;
	static int start;
	static int end;
	static int INF = 100000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		map = new ArrayList[n];
		distance = new int[n];
		for (int i = 0; i < n; i++) {
			map[i] = new ArrayList<>();
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
			map[first].add(new Point(second));
		}
		st = new StringTokenizer(br.readLine());
		gfPlanet = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		Arrays.fill(distance, INF);
	}
	
	public static int DFS(int cur) {
		for(Point next : map[cur]) {
			
		}
		return -1;
	}
}

class Point {
	int end, weight;

	public Point(int end) {
		this.end = end;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}