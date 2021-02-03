package Programmers;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(s.solution(begin, target, words));
	}
}

class Solution {
	int answer = Integer.MAX_VALUE;
	boolean[] check;

	/**
	 * 주어진 단어를 변환하여 최소 몇 번의 변화로 원하는 단어로 변경할 수 있는지 구하는 문제
	 * 단어는 한 번에 한 개의 알파벳만 바꿀 수 있다.
	 * 단어는  words에 있는 단어로만 변환할 수 있다. 
	 * @param begin 주어진 단어
	 * @param target 원하는 단어
	 * @param words 단어의 집합
	 * @return 변환에 필요한 최소 횟수
	 */
	public int solution(String begin, String target, String[] words) {
		check = new boolean[words.length];
		Search(begin, target, words, 0);
		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	public void Search(String begin, String target, String[] words, int transCnt) {
		if (begin.compareTo(target) == 0) {
			answer = Math.min(answer, transCnt);
			return;
		}
		for (int i = 0; i < words.length; i++) {
			String compare = words[i];
			for (int j = 0; j < begin.length(); j++)
				if (!check[i] && begin.charAt(j) != compare.charAt(j)) {
					String newString = j > 0 ? begin.substring(0, j) : "";
					newString += compare.charAt(j) + begin.substring(j + 1);
					if (newString.compareTo(compare) == 0) {
						check[i] = true;
						Search(newString, target, words, transCnt + 1);
						check[i] = false;
					}
				}
		}
	}
}