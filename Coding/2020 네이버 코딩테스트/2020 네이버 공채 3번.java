package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	// 리스트로 구현하는게 훨씬 빠른 탐색임 ( 순서 상관 없음 )
	static boolean[][] map;
	static int answer = Integer.MAX_VALUE;
	static int infectionCnt = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 19;
				//14;
				//10;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 }, { 3, 8 }, { 3, 9 },
				{ 4, 10 }, { 4, 11 }, { 5, 12 }, { 5, 13 }, { 6, 14 }, { 6, 15 }, { 6, 16 }, { 8, 17 }, { 8, 18 } };
			//{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {2, 7}, {3, 8}, {3, 9}, {3, 10}, {4, 11}, {4, 12}, {4, 13}};
			//{{0, 1}, {0, 2}, {1, 3}, {2, 4}, {2, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}};
		map = new boolean[n][n];
		for (int i = 0; i < edges.length; i++)
			map[edges[i][0]][edges[i][1]] = true;
		ArrayList<Integer> connect = new ArrayList<>();
		connect.add(0);
		spread(connect);
		System.out.println(answer);
	}

	public static void spread(ArrayList<Integer> connect) {
		int size = connect.size();
		if (size == 0) {
			answer = Math.min(answer, infectionCnt);
			return;
		}
		while (size-- > 0) {
			int remove = connect.remove(0);
			infectionCnt += connect.size();
			ArrayList<Integer> nextConnect = findNext(connect);
			spread(nextConnect);
			infectionCnt -= connect.size();
			connect.add(remove);
		}
	}

	public static ArrayList<Integer> findNext(ArrayList<Integer> connect) {
		ArrayList<Integer> next = new ArrayList<>();
		for (int node : connect)
			for (int i = 0; i < map.length; i++)
				if (map[node][i])
					next.add(i);
		return next;
	}
}