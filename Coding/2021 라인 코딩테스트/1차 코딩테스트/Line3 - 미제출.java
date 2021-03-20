package Line;

import java.util.Stack;

public class Line3 {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int[] enter = { 1, 3, 2 };
		int[] leave = { 1, 2, 3 };
		int[] t = s.solution(enter, leave);
		for (int i = 0; i < t.length; i++)
			System.out.println(t[i]);
	}
}

class Solution3 {
	/**
	 * ȸ�ǽǿ� ���Ը�ΰ� �־����� ��, ���Ը�ο��� �Խ��� ������ ����� ������ ��ϵȴ�. �̶� �ݵ�� ���� ����� ���� ���ϴ� ����
	 * @param enter �Խ��� ������� ����
	 * @param leave ����� ������� ����
	 * @return �ݵ�� ���� ����� ��
	 */
	public int[] solution(int[] enter, int[] leave) {
		int[] answer = new int[enter.length];
		Stack<Integer> st = new Stack<>();
		int leaveCnt = 0;
		for (int i = 0; i < enter.length; i++) {
			int people = enter[i];
			while (!st.isEmpty() && st.peek() == leave[leaveCnt]) {
				for (int leftPeople : st) {
					answer[leftPeople - 1]++;
					answer[people - 1]++;
				}
				leaveCnt++;
				st.pop();
			}
			st.add(people);
		}
		return answer;
	}
}