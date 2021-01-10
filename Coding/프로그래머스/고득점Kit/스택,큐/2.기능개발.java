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
	 * 현재까지의 개발 진도가 적힌 progresses와 개발 속도가 담긴 speeds 배열이 주어질 때
	 * 한 번의 배포가 이루어질 때 몇 개의 기능을 배포할 수 있는지 구하는 메소드
	 * 뒤에 있는 기능이 먼저 개발이 완료되어도 앞에 있는 기능이 완료가 되어야 같이 배포될 수 있다.
	 * @param progresses 개발 진도가 저장된 배열
	 * @param speeds 개발 속도가 저장된 배열
	 * @return 각 배포마다 몇 개의 기능이 배포되는지를 저장한 배열
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