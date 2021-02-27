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
	 * ���̽�ƽ�� �̿��Ͽ� �ּ����� ���� Ƚ���� �̸��� �ϼ��ϴ� ����
	 * ó������ ��� A�� �̷���� �ִ�.
	 * ������ ��ư�� ������ ���������� �̵�
	 * ���� ��ư�� ������ �������� �̵�(ù ��° ��ġ�� ��� ������ ��ġ��)
	 * �� ��ư�� ������ ���� ���ĺ����� �̵�
	 * �Ʒ� ��ư�� ������ ���� ���ĺ�(A�� ��� Z��)���� �̵��Ѵ�.
	 * @param name �������� �̸�
	 * @return �ּ� ���� Ƚ��
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