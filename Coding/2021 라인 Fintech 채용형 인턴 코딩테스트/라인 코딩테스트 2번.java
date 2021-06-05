package LineInternTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 새로운 알고리즘 RealTimeQueue를 구현하였다.
 * 알고리즘의 설명을 보고 Job을 return하는 순서대로 배열에 담아 출력하는 문제
 * @author Rave
 *
 */
public class Main2 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int endingTime = // 10;
				// 30;
				40;
		int[][] jobs = // {};
				// {{1, 10, 20, 6}, {2, 12, 20, 8}, {3, 20, 30, 2}, {4, 25, 40, 10}};
				{ { 1, 10, 20, 3 }, { 2, 14, 20, 9 }, { 3, 18, 24, 2 }, { 4, 25, 40, 5 }, { 5, 28, 40, 1 } };
		int[] result = s.solution(endingTime, jobs);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}

	static class Solution {
		public int[] solution(int endingTime, int[][] jobs) {
			ArrayList<Integer> answer = new ArrayList<>();
			Queue<Job> q = new LinkedList<>();
			for (int i = 0; i < jobs.length; i++)
				q.add(new Job(jobs[i][0], jobs[i][1], jobs[i][2], jobs[i][3]));
			int time = 0;
			while (!q.isEmpty()) {
				Job cur = q.poll();
				// 종료 시간 이후에 들어온 값이면 종료
				if (cur.inputTime > endingTime)
					break;
				// 현재 시간이 유효시간을 지났다면 다음 작업을 수행한다.
				if (cur.validTime < time)
					continue;
				// 현재 시간보다 뒤에 input값이 들어왔다면 업데이트해준다.
				if (cur.inputTime > time)
					time = cur.inputTime;
				// 작업 시간이 종료시간을 넘어가면 종료한다.
				if (time + cur.workTime > endingTime)
					break;
				time += cur.workTime;
				if (time <= cur.validTime)
					answer.add(cur.id);
			}
			return answer.stream().mapToInt(v -> v.intValue()).toArray();
		}
	}
}

class Job {
	int id, inputTime, validTime, workTime;

	public Job(int _id, int _inputTime, int _validTime, int _workTime) {
		this.id = _id;
		this.inputTime = _inputTime;
		this.validTime = _validTime;
		this.workTime = _workTime;
	}
}
