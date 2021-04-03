package CodingTest;

import java.util.ArrayList;
import java.util.HashMap;

public class Kakao_3 {

	static HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();
	static boolean[] visited;
	static int answer = 0;
	static int ansStation = 1;

	public static void main(String[] args) {
		int n = // 6;
				// 4;
				5;
		int[] passenger = // { 1, 1, 1, 1, 1, 1 };
				// {2, 1, 2, 2};
				{ 1, 1, 2, 3, 4 };
		int[][] train = // { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 3, 5 }, { 3, 6 } };
				// {{1, 2}, {1, 3}, {2, 4}};
				{ { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 } };
		int[] answer = solution(n, passenger, train);
		System.out.println(answer[0] + " " + answer[1]);
	}

	/**
	 * 1번에서 시작하여 종착역을 결정하려고 한다.
	 * 종착역이 되는 기준은 일일 이용객이 가장 많은 역이다.
	 * 일일 이용객이 같을 때는 종착역 번호가 큰 역을 선택한다.
	 * @param n 역의 개수
	 * @param passenger 각 역의 이용객 정보
	 * @param train 역과 역 사이의 연결 정보
	 * @return 종착역과 그 때의 최대 이용객
	 */
	public static int[] solution(int n, int[] passenger, int[][] train) {
		visited = new boolean[n + 1];
		for (int i = 0; i < train.length; i++) {
			int first = train[i][0];
			int second = train[i][1];
			hash.putIfAbsent(first, new ArrayList<>());
			hash.putIfAbsent(second, new ArrayList<>());
			hash.get(first).add(second);
			hash.get(second).add(first);
		}
		visited[1] = true;
		DFS(passenger, 1, passenger[0]);

		return new int[] { ansStation, answer };
	}

	public static void DFS(int[] passenger, int cur, int sum) {
		ArrayList<Integer> route = hash.get(cur);
		for (int next : route) {
			if (!visited[next]) {
				visited[next] = true;
				DFS(passenger, next, sum + passenger[next - 1]);
				visited[next] = false;
			}
		}
		if (sum > answer || (sum == answer && cur > ansStation)) {
			answer = sum;
			ansStation = cur;
		}
	}
}