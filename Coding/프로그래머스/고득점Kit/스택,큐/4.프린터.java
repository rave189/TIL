package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] priorities = //{ 2, 1, 3, 2 };
		{ 1, 1, 9, 1, 1, 1 };
		int location = //2;
		0;
		System.out.println(s.solution(priorities, location));
	}
}

class Solution {
	/**
	 * �����ͱ⿡�� �μ⸦ �Ϸ��� �� �� ���� ��û�� �μⰡ �� ��°�� ����Ǵ��� ���ϴ� ����
	 * �����ͱⰡ �μ⸦ �ϴ� ����� ������ ����.
	 * 1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
	 * 2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
	 * 3. �׷��� ������ J�� �μ��մϴ�.
	 * @param priorities �� �μ� ��û�� �߿䵵�� ����� �迭
	 * @param location ���� ��û�� �μ� ����
	 * @return
	 */
	public int solution(int[] priorities, int location) {
		int answer = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i<priorities.length; i++)
			q.add(i);
		begin: while (!q.isEmpty()) {
			int index = q.poll();
			for(int item : q)
				if (priorities[item] > priorities[index]) {
					q.add(index);
					continue begin;
				}
			if (index == location)
				break;
			answer++;
		}
		return answer;
	}
}