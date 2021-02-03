package Programmers;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int brown = //10;
		//8;
		24;
		int yellow = //2;
		//1;
		24;
		int[] result = s.solution(brown, yellow);
		System.out.println(result[0]+" "+result[1]);
	}
}

class Solution {
	/**
	 * 테두리가 갈색 격자로 이루어져 있고 그 안에 노란색 격자로 채워져 있다.
	 * 갈색 격자의 수와 노란색 격자의 수가 주어졌을 때
	 * 가로의 길이와 세로의 길이를 구하는 문제
	 * @param brown 갈색 격자의 수
	 * @param yellow 노란색 격자의 수
	 * @return 가로, 세로의 길이
	 */
	public int[] solution(int brown, int yellow) {
		for (int i = brown/2-1; i > 0; i--) {
			int rowB = i;
			int colB = (brown/2)-i;
			for (int j = 1; j <= yellow; j++) {
				int rowY = j;
				double colY = yellow/(double)j;
				if (rowY + 2 == rowB && colY == colB)
					return new int[] { rowB, colB+2 };
			}
		}
		return new int[] {};
	}
}