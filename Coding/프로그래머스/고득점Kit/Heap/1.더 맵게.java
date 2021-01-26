package Programmers;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] scoville = {7, 4, 5, 6};
		int k = 7;
		System.out.println(s.solution(scoville, k));
	}
}

class Solution {
	/**
	 * ��� ������ ���ں� ������ K �̻����� ����� ���� ������ �� �� �������� ���ϴ� ����
	 * ���� ������ ���ں� ������ ������ ���� ���Ѵ�.
	 * ���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
	 * @param scoville ��� ������ ���ں� ����
	 * @param K �ּ����� ���ں� ���� ��
	 * @return ������ ���� Ƚ��
	 */
	public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int food : scoville)
        	pq.add(food);
        for(; pq.size() > 1 && pq.peek() < K; answer++) {
        	pq.add(pq.poll() + (pq.poll() * 2));
        }
        if(pq.peek() < K)
        	return -1;
        return answer;
    }
}