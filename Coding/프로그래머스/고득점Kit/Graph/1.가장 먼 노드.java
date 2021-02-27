package Programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 6;
				//5;
		int[][] costs = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
				//{{4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(s.solution(n, costs));
	}
}

class Solution {
	/**
	 * n���� ��尡 �ִ�.
	 * 1������ �ִܰ�η� �̵����� �� ���� �ָ� ������ ����� ������ ���ϴ� ����
	 * @param n ����� ����
	 * @param edge ���� ������ ��� �迭
	 * @return ���� �ָ� ������ ����� ��
	 */
	public int solution(int n, int[][] edge) {
		int answer = 0;
		boolean[] check = new boolean[n + 1];
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 0; i < edge.length; i++) {
			if (map.containsKey(edge[i][0]))
				map.get(edge[i][0]).add(edge[i][1]);
			else {
				LinkedList<Integer> value = new LinkedList<Integer>();
				value.add(edge[i][1]);
				map.put(edge[i][0], value);
			}
			if (map.containsKey(edge[i][1]))
				map.get(edge[i][1]).add(edge[i][0]);
			else {
				LinkedList<Integer> value = new LinkedList<Integer>();
				value.add(edge[i][0]);
				map.put(edge[i][1], value);
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		check[1] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			answer = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				LinkedList<Integer> vertex = map.getOrDefault(cur, new LinkedList<Integer>());
				for (int j = 0; j < vertex.size(); j++) {
					int node = vertex.get(j);
					if (!check[node]) {
						check[node] = true;
						q.add(node);
					}
				}
			}
		}
		return answer;
	}
}