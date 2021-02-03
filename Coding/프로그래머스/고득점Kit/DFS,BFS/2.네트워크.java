package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 3;
		// 3;
		int[][] computers = // { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
				{ { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		System.out.println(s.solution(n, computers));
	}
}

class Solution {
	/**
	 * 컴퓨터 상호 간에 연결된 상태를 네트워크라고 한다.
	 * 이 때 주어진 컴퓨터들이 몇 개의 네트워크를 이루고 있는지 구하는 문제
	 * 컴퓨터가 연결되어 있으면 1로 표현한다.
	 * @param n 컴퓨터의 수
	 * @param computers 연결된 컴퓨터의 정보
	 * @return 네트워크의 수
	 */
	public int solution(int n, int[][] computers) {
		int answer = 1;
		boolean[] check = new boolean[n];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		while (true) {
			while (!q.isEmpty()) {
				int computer = q.poll();
				check[computer] = true;
				for (int i = 0; i < computers[computer].length; i++)
					if (computers[computer][i] == 1 && !check[i])
						q.add(i);
			}
			int done = VisitCheck(check);
			if (done >= 0) {
				q.add(done);
				answer++;
			} else
				break;
		}
		return answer;
	}

	public int VisitCheck(boolean[] check) {
		for (int i = 0; i < check.length; i++)
			if (!check[i])
				return i;
		return -1;
	}
}