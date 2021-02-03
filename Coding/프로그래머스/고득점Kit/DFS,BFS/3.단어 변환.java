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
	 * �־��� �ܾ ��ȯ�Ͽ� �ּ� �� ���� ��ȭ�� ���ϴ� �ܾ�� ������ �� �ִ��� ���ϴ� ����
	 * �ܾ�� �� ���� �� ���� ���ĺ��� �ٲ� �� �ִ�.
	 * �ܾ��  words�� �ִ� �ܾ�θ� ��ȯ�� �� �ִ�. 
	 * @param begin �־��� �ܾ�
	 * @param target ���ϴ� �ܾ�
	 * @param words �ܾ��� ����
	 * @return ��ȯ�� �ʿ��� �ּ� Ƚ��
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