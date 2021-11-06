package techcourseTest;

public class Main1 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = // { 2, 1, 3, 1, 2, 1 };
				// {3, 3, 3, 3, 3, 3};
				{ 1, 2, 3 };
		int[] result = s.solution(arr);
		for (int v : result)
			System.out.println(v);
	}

	static class Solution {
		/**
		 * 1, 2, 3�� ��� �ִ� �迭�� �־�����.
		 * �� �迭�� ���Ҹ� �߰��Ͽ� 1, 2, 3�� ������ ���������� �Ϸ��� �Ѵ�.
		 * �� �� �߰��ؾ��ϴ� ������ �ּ� ������ ���ϴ� ����
		 * @param arr 1, 2, 3�� ��� �ִ� �迭
		 * @return ���� 1, 2, 3�� �߰��ؾ��ϴ� ����
		 */
		public int[] solution(int[] arr) {
			int[] answer = new int[3];
			for (int num : arr)
				answer[num - 1]++;
			int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
			for (int i = 0; i < answer.length; i++)
				answer[i] = max - answer[i];
			return answer;
		}
	}
}
