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
	 * ��ǻ�� ��ȣ ���� ����� ���¸� ��Ʈ��ũ��� �Ѵ�.
	 * �� �� �־��� ��ǻ�͵��� �� ���� ��Ʈ��ũ�� �̷�� �ִ��� ���ϴ� ����
	 * ��ǻ�Ͱ� ����Ǿ� ������ 1�� ǥ���Ѵ�.
	 * @param n ��ǻ���� ��
	 * @param computers ����� ��ǻ���� ����
	 * @return ��Ʈ��ũ�� ��
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