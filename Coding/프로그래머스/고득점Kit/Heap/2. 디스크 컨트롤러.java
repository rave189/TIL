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
	 * 한 번에 하나의 작업만 수행할 수 있는 하드디스크가 있을 때 각 작업이 요청된 시간부터 종료된 시간까지 걸린 평균 시간의 최소값을 구하는
	 * 문제 A: {0, 3} 은 0ms부터 3ms까지 수행하므로 3ms 소요 B: {1, 9} 은 3ms부터 시작하여 12ms까지 수행하였으므로
	 * 요청부터 종료까지 11ms 소요
	 * 
	 * @param jobs 각 작업의 요청시간, 작업 수행시간이 담긴 배열
	 * @return 모든 작업의 평균 시간의 최솟값
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