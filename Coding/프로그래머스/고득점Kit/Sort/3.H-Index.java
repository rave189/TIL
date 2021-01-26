package Programmers;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println(s.solution(citations));
	}
}

class Solution {
	/**
	 * 논문의 인용 횟수가 주어졌을 때
	 * h번 이상 인용된 논문이 h편 이상이고
	 * 나머지 논문이 h번 이하로 인용되었다면 h의 최대값이 과학자의 H-Index이다.
	 * 과학자의 H-Index를 구하는 문제
	 * max{ f(x) >= x }
	 * @param citations 인용된 횟수가 저장된 배열
	 * @return H-Index
	 */
	public int solution(int[] citations) {
		Arrays.sort(citations);
		int answer = 0;
		for(int i=0; i<citations.length; i++)
			answer = citations[citations.length - 1 - i] >= i+1 ? Math.max(answer, i+1) : answer;
		return answer;
	}
}