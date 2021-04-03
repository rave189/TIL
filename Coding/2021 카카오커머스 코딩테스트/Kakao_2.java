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
	 * �κ� �� ��� ��ǰ �� �������� ó���� �� �ִ�.
	 * �̷��� �κ� r�븦 �̿��Ͽ� ����ǰ�� ���� ��
	 * ���� �� �ִ� �ִ� ����ǰ�� ���ϴ� ����
	 * @param needs �κ��� ��ȣ�� �κ��� ����� �� �ʿ��� ��ǰ�� ��ȣ(1�� �ʿ��� ��ǰ, 0�� �ʿ����� �ʴ� ��ǰ)
	 * @param r ����� �� �ִ� �κ��� �ִ� ����
	 * @return �ִ�� ���� �� �ִ� ����ǰ�� ����
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