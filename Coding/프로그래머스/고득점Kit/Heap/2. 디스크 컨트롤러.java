package Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] jobs = // { { 0, 3 }, { 1, 9 }, { 2, 6 } };
				{ { 0, 3 }, { 4, 7 } };
		System.out.println(s.solution(jobs));
	}
}

class Solution {
	/**
	 * �� ���� �ϳ��� �۾��� ������ �� �ִ� �ϵ��ũ�� ���� �� �� �۾��� ��û�� �ð����� ����� �ð����� �ɸ� ��� �ð��� �ּҰ��� ���ϴ�
	 * ���� A: {0, 3} �� 0ms���� 3ms���� �����ϹǷ� 3ms �ҿ� B: {1, 9} �� 3ms���� �����Ͽ� 12ms���� �����Ͽ����Ƿ�
	 * ��û���� ������� 11ms �ҿ�
	 * 
	 * @param jobs �� �۾��� ��û�ð�, �۾� ����ð��� ��� �迭
	 * @return ��� �۾��� ��� �ð��� �ּڰ�
	 */
	public int solution(int[][] jobs) {
		int answer = 0;
		PriorityQueue<Disk> pq = new PriorityQueue<Disk>();
		for (int i = 0; i < jobs.length; i++)
			pq.add(new Disk(jobs[i][0], jobs[i][1]));
		PriorityQueue<Disk> waitQ = new PriorityQueue<Disk>(new Comparator<Disk>() {
			@Override
			public int compare(Disk o1, Disk o2) {
				return o1.time - o2.time;
			}
		});
		waitQ.add(pq.poll());
		int time = waitQ.peek().start;
		while (!waitQ.isEmpty()) {
			Disk perform = waitQ.poll();
			while (!pq.isEmpty() && pq.peek().start <= time + perform.time)
				waitQ.add(pq.poll());
			time += perform.time;
			answer += time - perform.start;
			if (waitQ.isEmpty() && !pq.isEmpty()) {
				time = pq.peek().start;
				waitQ.add(pq.poll());
			}
		}
		return answer / jobs.length;
	}
}

class Disk implements Comparable<Disk> {
	int start;
	int time;

	public Disk(int _start, int _time) {
		this.start = _start;
		this.time = _time;
	}

	@Override
	public int compareTo(Disk o) {
		if (start < o.start)
			return -1;
		else if (start == o.start) {
			return time - o.time;
		} else
			return 1;
	}

	public String toString() {
		return start + " " + time;
	}
}