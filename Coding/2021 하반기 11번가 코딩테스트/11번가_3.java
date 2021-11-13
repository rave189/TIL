package Street11Test;

public class Main3 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = //{ 1, 1, 3, 4, 4, 4 };
			//{1, 2, 2, 2, 5, 5, 5, 8};
			//{1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4};
			{10, 10, 10};
		System.out.println(s.solution(A));
	}

	static class Solution {
		/**
		 * N���� ���� ����ִ� �迭 A�� �־�����.
		 * �� �迭�� ���� �񳻸��������� ���ĵǾ��ִ�.
		 * ������ �迭�� ���Ҹ� ����ų� �߰��� �� ������
		 * X�� ������ X�� �ǰų� ���� ������� �Ѵ�.
		 * �� �� �ּ����� �������� ���ϴ� ����
		 * @param A �迭 A
		 * @return �ּ����� ������
		 */
		public int solution(int[] A) {
			int answer = 0;
			int prev = A[0];
			int count = 1;
			for (int idx = 1; idx < A.length; idx++) {
				int compare = A[idx];
				if (prev == compare)
					count++;
				else {
					answer += Math.min(count, Math.abs(prev - count));
					count = 1;
					prev = compare;
				}
			}
			answer += Math.min(count, Math.abs(prev - count));
			return answer;
		}
	}
}
