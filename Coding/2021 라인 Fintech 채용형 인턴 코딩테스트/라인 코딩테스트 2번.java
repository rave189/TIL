package LineInternTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ���ο� �˰��� RealTimeQueue�� �����Ͽ���.
 * �˰����� ������ ���� Job�� return�ϴ� ������� �迭�� ��� ����ϴ� ����
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
				// ���� �ð� ���Ŀ� ���� ���̸� ����
				if (cur.inputTime > endingTime)
					break;
				// ���� �ð��� ��ȿ�ð��� �����ٸ� ���� �۾��� �����Ѵ�.
				if (cur.validTime < time)
					continue;
				// ���� �ð����� �ڿ� input���� ���Դٸ� ������Ʈ���ش�.
				if (cur.inputTime > time)
					time = cur.inputTime;
				// �۾� �ð��� ����ð��� �Ѿ�� �����Ѵ�.
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
