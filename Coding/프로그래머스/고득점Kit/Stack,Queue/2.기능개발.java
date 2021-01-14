package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] progresses =
				// { 93, 30, 55 };
				{ 95, 90, 99, 99, 80, 99 };
		int[] speeds =
				// { 1, 30, 5 };
				{ 1, 1, 1, 1, 1, 1 };
		int[] result = s.solution(progresses, speeds);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}
}

class Solution {
	/**
	 * ��������� ���� ������ ���� progresses�� ���� �ӵ��� ��� speeds �迭�� �־��� ��
	 * �� ���� ������ �̷���� �� �� ���� ����� ������ �� �ִ��� ���ϴ� �޼ҵ�
	 * �ڿ� �ִ� ����� ���� ������ �Ϸ�Ǿ �տ� �ִ� ����� �Ϸᰡ �Ǿ�� ���� ������ �� �ִ�.
	 * @param progresses ���� ������ ����� �迭
	 * @param speeds ���� �ӵ��� ����� �迭
	 * @return �� �������� �� ���� ����� �����Ǵ����� ������ �迭
	 */
	public int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> total = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < progresses.length; i++) {
			int publish = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
			int count = 0;
			while (!q.isEmpty() && q.peek() < publish) {
				count++;
				q.poll();
			}
			if (count != 0)
				total.add(count);
			q.add(publish);
		}
		if (q.size() != 0)
			total.add(q.size());
		int[] answer = new int[total.size()];
		for (int i = 0; i < total.size(); i++)
			answer[i] = total.get(i);
		return answer;
	}
}