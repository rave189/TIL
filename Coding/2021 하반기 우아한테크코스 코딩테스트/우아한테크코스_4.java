package techcourseTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main4 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String ss = //"aaabbaaa";
		 "wowwow";
		int[] result = s.solution(ss);
		for (int v : result)
			System.out.println(v);
	}

	static class Solution {
		Map<Integer, Integer> hash = new HashMap<>();

		/**
		 * 처음과 끝이 이어져있는 문자열 s가 주어진다. (원형)
		 * 이 문자열에서 같은 글자가 연속해 있는 구간의 길이를 구하려고 한다.
		 * 이 구간의 길이들을 오름차순으로 출력하는 문제
		 * @param s 문자열
		 * @return 오름차순으로 정렬된 같은 글자가 연속으로 나오는 구간의 길이
		 */
		public int[] solution(String s) {
			for (int i = 0; i < s.length();) {
				int start = i;
				char ch = s.charAt(i);
				for (; i < s.length(); i++) {
					if (ch != s.charAt(i))
						break;
				}
				// 맨 뒤에 탐색한 연속된 문자와 처음 탐색한 문자가 같으면 이어준다.
				if (i == s.length() && ch == s.charAt(0)) {
					hash.put(start, hash.get(0));
					hash.remove(0);
				}
				// 아니라면 그냥 추가
				else
					hash.put(start, i);
			}
			ArrayList<Integer> answer = new ArrayList<>();
			for (int key : hash.keySet()) {
				int value = hash.get(key);
				// key가 크다는 것은 처음과 마지막이 이어져 있다는 뜻
				// 그럼 length - key에다가 value를 더하여 길이를 구할 수 있다.
				answer.add(value >= key ? value - key : value + s.length() - key);
			}
			answer.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
			return answer.stream().mapToInt(v -> v.intValue()).toArray();
		}
	}
}