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
	 * �׵θ��� ���� ���ڷ� �̷���� �ְ� �� �ȿ� ����� ���ڷ� ä���� �ִ�.
	 * ���� ������ ���� ����� ������ ���� �־����� ��
	 * ������ ���̿� ������ ���̸� ���ϴ� ����
	 * @param brown ���� ������ ��
	 * @param yellow ����� ������ ��
	 * @return ����, ������ ����
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