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
	 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 음식을 몇 번 섞었는지 구하는 문제
	 * 섞은 음식의 스코빌 지수는 다음과 같이 구한다.
	 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	 * @param scoville 모든 음식의 스코빌 지수
	 * @param K 최소한의 스코빌 지수 값
	 * @return 음식을 섞은 횟수
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