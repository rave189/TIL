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
	 * 여러 대의 트럭이 다리를 지나갈 때 몇 초의 시간이 걸리는지 구하는 문제
	 * 트럭이 다리에 완전히 오르지 않으면 이 트럭의 무게는 고려하지 않는다.
	 * 트럭은 1초에 1만큼 이동한다.
	 * 다리가 견딜 수 있는 무게 weight를 초과하는 경우 트럭이 다리에 오르지 못한다.
	 * @param bridge_length 다리의 길이
	 * @param weight 다리가 견딜 수 있는 총 무게
	 * @param truck_weights 트럭의 무게를 저장한 배열
	 * @return 걸린 시간
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