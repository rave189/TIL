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
		 * 8명의 아이들이 소풍을 떠나기 위해 일렬로 줄을 세우려고 한다.
		 * 하지만 몇몇 아이들은 옆에 붙어있다면 싸운다.
		 * 싸움이 일어나지 않게 아이들을 줄 세우는 방법의 수를 구하는 문제
		 * 
		 * @param numOfConflict 갈등 관계의 수
		 * @param conflicts     갈등 관계
		 */
		public void solution(int numOfConflict, int[][] conflicts) {
			// 관계를 모두 hashmap에 넣는다.
			init(numOfConflict, conflicts);

			// 브루트포스를 사용하여 아이들을 직접 일렬로 세워본다.
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
