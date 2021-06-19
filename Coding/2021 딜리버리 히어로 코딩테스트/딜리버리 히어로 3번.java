package DeliveryHeroTest;

/**
 * �Է����� �־��� ���ڿ��� a�� ������ �Ȱ����� �� �κ����� �������� �Ѵ�.
 * �̷��� ����� ���� ���ϴ� ����
 * a�� �ϳ��� ���� ���� �ִ�.
 * @author Rave
 *
 */
public class Main3 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String S = "babaa";
		System.out.println(s.solution(S));
	}

	static class Solution {

		int aCnt = 0;
		int answer = 0;
		StringBuilder input;

		public int solution(String S) {
			init(S);
			if (aCnt % 3 != 0)
				return 0;
			// �� �ڵ�� ���� ����
			else if(aCnt == 0) {
				// S�� b�θ� �̷���� �ִٸ� ���� ó���� ���־�� �Ѵ�.
				// 3 �̸��̸� 0�� ��ȯ�Ѵ�.
				if(S.length() < 3)
					return 0;
				else {
					// �ƴ϶�� b�� �ϳ��� �й��� ���� ���� b�� �� �κп� �й��ϴ� ����� ���� ���Ѵ�.
					int size = S.length()-3;
				}
			}
			// �������
			SeparateS();
			return answer;
		}

		public void init(String S) {
			for (char ch : S.toCharArray())
				if (ch == 'a')
					aCnt++;
			input = new StringBuilder(S);
		}

		public void SeparateS() {
			// ù 1/3 ������ �ڸ���.
			Split();
			// b�� ������ ���Ѵ�.
			// b�� ���� ��쵵 �ϳ��� ����̹Ƿ� +1�� ���ش�.
			int leftBCnt = getBCnt() + 1;
			// �ٽ� 1/3 ������ �ڸ���.
			Split();
			// b�� ������ ���Ѵ�.
			int rightBCnt = getBCnt() + 1;
			// �� �� ���� ���Ͽ� ����� ���� ���Ѵ�.
			answer = leftBCnt * rightBCnt;
		}

		/**
		 * a�� ������ ��ü a�� ������ 1/3�� �ɶ����� �ڸ��� �޼ҵ�
		 */
		public void Split() {
			int count = 0;
			int index = 0;
			while (count < aCnt / 3) {
				if (input.charAt(index++) == 'a')
					count++;
			}
			input = input.delete(0, index);
		}

		/**
		 * ó������ a�� ������ �������� b�� ������ ���ϴ� �޼ҵ�
		 * @return b�� ����
		 */
		public int getBCnt() {
			int count = 0;
			while (input.length() != 0 && input.charAt(0) == 'b') {
				input.deleteCharAt(0);
				count++;
			}
			return count;
		}
	}
}