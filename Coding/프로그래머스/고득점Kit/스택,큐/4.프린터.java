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
	 * 프린터기에서 인쇄를 하려고 할 때 내가 요청한 인쇄가 몇 번째로 수행되는지 구하는 문제
	 * 프린터기가 인쇄를 하는 방법은 다음과 같다.
	 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
	 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
	 * 3. 그렇지 않으면 J를 인쇄합니다.
	 * @param priorities 각 인쇄 요청의 중요도가 저장된 배열
	 * @param location 내가 요청한 인쇄 문서
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