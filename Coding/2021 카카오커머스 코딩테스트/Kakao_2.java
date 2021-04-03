package CodingTest;

import java.util.ArrayList;
import java.util.HashMap;

public class Kakao_2 {

	public static void main(String[] args) {
		int[][] needs = { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int r = 2;
		System.out.println(solution(needs, r));
	}

	/**
	 * 로봇 한 대는 부품 한 종류만을 처리할 수 있다.
	 * 이러한 로봇 r대를 이용하여 완제품을 만들 때
	 * 만들 수 있는 최대 완제품을 구하는 문제
	 * @param needs 로봇의 번호와 로봇을 만드는 데 필요한 부품의 번호(1은 필요한 부품, 0은 필요하지 않는 부품)
	 * @param r 사용할 수 있는 로봇의 최대 개수
	 * @return 최대로 만들 수 있는 완제품의 개수
	 */
	public static int solution(int[][] needs, int r) {
		Node node = new Node();
		for (int i = 0; i < needs.length; i++)
			node.add(needs[i], i);
		node.Search(node.hash, r, 0);
		return node.answer;
	}
}

class Node {
	ArrayList<Integer> finishRobot = new ArrayList<Integer>();
	HashMap<Integer, Node> hash = new HashMap<>();
	int answer = 0;

	public void add(int[] parts, int roboId) {
		Node cur = this;
		for (int i = 0; i < parts.length; i++) {
			if (parts[i] == 1) {
				cur.hash.putIfAbsent(i, new Node());
				cur = cur.hash.get(i);
			}
		}
		cur.finishRobot.add(roboId);
	}

	public void Search(HashMap<Integer, Node> cur, int depth, int sum) {
		answer = Math.max(answer, sum);
		if (depth == 0)
			return;
		for (int key : cur.keySet()) {
			Node next = cur.get(key);
			Search(next.hash, depth - 1, sum + next.finishRobot.size());
		}
	}
}