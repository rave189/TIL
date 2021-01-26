package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int bridge_length = 2;
		// 100;
		int weight = 10;
		// 100;
		int[] truck_weights = { 7, 4, 5, 6 };
		// { 10 };
		// { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		System.out.println(s.solution(bridge_length, weight, truck_weights));
	}
}

class Solution {
	/**
	 * ���� ���� Ʈ���� �ٸ��� ������ �� �� ���� �ð��� �ɸ����� ���ϴ� ����
	 * Ʈ���� �ٸ��� ������ ������ ������ �� Ʈ���� ���Դ� ������� �ʴ´�.
	 * Ʈ���� 1�ʿ� 1��ŭ �̵��Ѵ�.
	 * �ٸ��� �ߵ� �� �ִ� ���� weight�� �ʰ��ϴ� ��� Ʈ���� �ٸ��� ������ ���Ѵ�.
	 * @param bridge_length �ٸ��� ����
	 * @param weight �ٸ��� �ߵ� �� �ִ� �� ����
	 * @param truck_weights Ʈ���� ���Ը� ������ �迭
	 * @return �ɸ� �ð�
	 */
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		int total = 0;
		for (int i = 0; i < truck_weights.length; i++, answer++) {
			if (q.size() == bridge_length)
				total -= q.poll();
			if (total + truck_weights[i] <= weight) {
				q.add(truck_weights[i]);
				total += truck_weights[i];
			} else {
				q.add(0);
				i--;
			}
		}
		return answer + bridge_length;
	}
}