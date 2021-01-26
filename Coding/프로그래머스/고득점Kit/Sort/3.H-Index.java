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
	 * ���� �ο� Ƚ���� �־����� ��
	 * h�� �̻� �ο�� ���� h�� �̻��̰�
	 * ������ ���� h�� ���Ϸ� �ο�Ǿ��ٸ� h�� �ִ밪�� �������� H-Index�̴�.
	 * �������� H-Index�� ���ϴ� ����
	 * max{ f(x) >= x }
	 * @param citations �ο�� Ƚ���� ����� �迭
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