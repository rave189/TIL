package DeliveryHeroTest;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * �̸��� �־��� ��, '�̸� <firstName.LastName@ȸ���̸�.com>'���� ����� ��ȯ�ϴ� ����
 * �̸����� �߰� �̸��� �� ���� �ְ� �ȵ� ���� �ִ�.
 * �̸����� firstName�� LastName�� �ҹ��ڷ� ġȯ�Ͽ� ����Ѵ�.
 * ���� firstName�� LastName�� ���� �̸����� �������ٸ�
 * firstName.LastName�ڿ� �� ��°�� ���� ������ ���ڸ� ���δ�.
 * @author Rave
 *
 */
public class Main1 {

	public static void main(String[] args) {
		Solution s = new Solution();
		// �̸���
		String S = "John Doe, Peter Benjamin Parker, Mary Jane Watson-Parker, John Elvis Doe, John Evan Doe, Jane Doe, Peter Brian Parker";
		// ȸ�� �̸�
		String C = "Example";
		System.out.println(s.solution(S, C));
	}

	static class Solution {
		HashMap<String, Integer> hash = new HashMap<>();
		StringBuilder answer = new StringBuilder();

		public String solution(String S, String C) {
			C = C.toLowerCase();
			StringTokenizer people = new StringTokenizer(S, ",");
			while (people.hasMoreTokens()) {
				String email = getEmailAddress(people.nextToken().trim(), C);
				answer.append(email + ", ");
			}
			return answer.substring(0, answer.length()-2).toString();
		}

		/**
		 * �̸����� ����� ��ȯ�ϴ� �޼ҵ�
		 * ���� �̸����� hash�� �����Ѵٸ� �� ���ڿ� +1�� ���ڸ� �ڿ� ���δ�.
		 * @param fullName ��ü �̸�
		 * @param company ȸ���
		 * @return �̸���
		 */
		public String getEmailAddress(String fullName, String company) {
			String[] splitName = fullName.toLowerCase().replaceAll("-", "").split(" ");
			String key = splitName[0] + "." + splitName[splitName.length - 1];
			StringBuilder emailId = new StringBuilder(key);
			if (hash.containsKey(key))
				emailId.append(hash.get(key) + 1);
			hash.put(key, hash.getOrDefault(key, 0) + 1);
			return fullName + " <" + emailId.toString() + "@" + company + ".com>";
		}
	}
}