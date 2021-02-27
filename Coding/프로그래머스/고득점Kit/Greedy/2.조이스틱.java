package Programmers;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		String name = "JEROEN";
		// "JAN";
		System.out.println(s.solution(name));
	}
}

class Solution {
	/**
	 * 조이스틱을 이용하여 최소한의 조작 횟수로 이름을 완성하는 문제
	 * 처음에는 모두 A로 이루어져 있다.
	 * 오른쪽 버튼을 누르면 오른쪽으로 이동
	 * 왼쪽 버튼을 누르면 왼쪽으로 이동(첫 번째 위치일 경우 마지막 위치로)
	 * 위 버튼을 누르면 다음 알파벳으로 이동
	 * 아래 버튼을 누르면 이전 알파벳(A일 경우 Z로)으로 이동한다.
	 * @param name 만들어야할 이름
	 * @return 최소 조작 횟수
	 */
	public int solution(String name) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < name.length(); i++)
			sb.append("A");
		int index = 0;
		while (true) {
			answer += Math.min(name.charAt(index) - 'A', 'Z' - name.charAt(index) + 1);
			sb.replace(index, index + 1, name.charAt(index) + "");
			if (name.equals(sb.toString()))
				break;
			int leftCnt = 1;
			int leftIdx = index;
			for (int i = index; i != index - 1; leftCnt++) {
				i = ++i % name.length();
				if (name.charAt(i) != sb.charAt(i)) {
					leftIdx = i;
					break;
				}
			}
			int rightCnt = 1;
			int rightIdx = index;
			for (int i = index; i != index + 1; rightCnt++) {
				i = --i < 0 ? name.length() - 1 : i;
				if (name.charAt(i) != sb.charAt(i)) {
					rightIdx = i;
					break;
				}
			}
			if (leftCnt <= rightCnt) {
				index = leftIdx;
				answer += leftCnt;
			} else {
				index = rightIdx;
				answer += rightCnt;
			}
		}
		return answer;
	}
}