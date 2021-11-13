package Street11Test;

import java.util.ArrayList;

public class Main2 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String S = //"babaa";
				//"bbbab";
				"bbbaaabbb";
		System.out.println(s.solution(S));
	}

	static class Solution {
		/**
		 * S는 a와 b로 이루어져 있다.
		 * 이 때, 연속된 동일한 문자들을 합쳐 블록을 이룰 수 있도록 나눈다.
		 * 각각의 블록들 중 가장 긴 블록의 길이만큼 모든 블록에 블록을 추가해주려고 한다.
		 * 추가해야하는 블록의 최소 개수를 구하는 문제
		 * @param S
		 * @return
		 */
		public int solution(String S) {
			ArrayList<Integer> countList = new ArrayList<>();
			char prev = S.charAt(0);
			int count = 1;
			int max = 0;
			for (int idx = 1; idx < S.length(); idx++) {
				char compare = S.charAt(idx);
				if (compare != prev) {
					countList.add(count);
					max = Math.max(max, count);
					count = 1;
					prev = compare;
				} else
					count++;
			}
			if (prev == S.charAt(S.length() - 1)) {
				countList.add(count);
				max = Math.max(max, count);
			}
			int answer = 0;
			for (int value : countList)
				answer += max - value;
			return answer;
		}
	}
}
