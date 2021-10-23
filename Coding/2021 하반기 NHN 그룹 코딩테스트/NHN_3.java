package NHNCodingTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main3 {

	public static void main(String[] args) {
	}

	static class Solution {
		Map<Integer, HashSet<Integer>> relationship = new HashMap<>();
		boolean[] visited = new boolean[9];
		int answer = 0;

		/**
		 * 8���� ���̵��� ��ǳ�� ������ ���� �Ϸķ� ���� ������� �Ѵ�.
		 * ������ ��� ���̵��� ���� �پ��ִٸ� �ο��.
		 * �ο��� �Ͼ�� �ʰ� ���̵��� �� ����� ����� ���� ���ϴ� ����
		 * 
		 * @param numOfConflict ���� ������ ��
		 * @param conflicts     ���� ����
		 */
		public void solution(int numOfConflict, int[][] conflicts) {
			// ���踦 ��� hashmap�� �ִ´�.
			init(numOfConflict, conflicts);

			// ���Ʈ������ ����Ͽ� ���̵��� ���� �Ϸķ� ��������.
			for (int curChild = 1; curChild <= 8; curChild++) {
				visited[curChild] = true;
				bruteforce(curChild, 7);
				visited[curChild] = false;
			}

			System.out.println(answer);
		}

		public void init(int numOfConflict, int[][] conflicts) {
			for (int i = 1; i <= 8; i++)
				relationship.put(i, new HashSet<>());
			for (int i = 0; i < numOfConflict; i++) {
				int firstChild = conflicts[i][0];
				int secondChild = conflicts[i][1];
				relationship.get(firstChild).add(secondChild);
				relationship.get(secondChild).add(firstChild);
			}
		}

		public void bruteforce(int prevChild, int remainChild) {
			if (remainChild == 0) {
				answer++;
				return;
			}
			for (int curChild = 1; curChild <= 8; curChild++) {
				if (visited[curChild] || relationship.get(prevChild).contains(curChild))
					continue;
				visited[curChild] = true;
				bruteforce(curChild, remainChild - 1);
				visited[curChild] = false;
			}
		}
	}
}
