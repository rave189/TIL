package LineInternTest;

/**
 * 0~9������ ���ڰ� ���� ��Ű�� �ִ�.
 * �� ������ �����Ͽ� 1���� N������ ���� �����س���.
 * �� �� �� ���� ���ڰ� ���� ��Ű�� �Ծ ���ȴ�.
 * �� �� N�� �� �� �ִ� �ּ��� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main1 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String inputString = // "123903";
				// "12345";
				"2349101";
		// "7777729";
		// "7234032479947";
		System.out.println(s.solution(inputString));
	}

	static class Solution {
		public int solution(String inputString) {
			int answer = 1;
			// 1���� �־�� ���� �� �ִ� ������ Ȯ���Ѵ�.
			for (int i = 0; i < inputString.length(); answer++) {
				String str = Integer.toString(answer);
				// 1���� String���� ��ȯ�Ͽ� ���� �ϳ��� �´ٸ� ���� �� �ִ� ���̴�.
				for (int j = 0; j < str.length(); j++) {
					// ������ Ž���Ͽ��ٸ� �����Ѵ�.
					if(i == inputString.length())
						break;
					// ���غ��� ���ٸ� i���� �������� ���� ���ڸ� ������ ����.
					else if (inputString.charAt(i) == str.charAt(j))
						i++;
				}
			}
			// for�� ������ answer++�� �����Ͽ����Ƿ� 1�� ���ش�.
			return answer - 1;
		}
	}
}
