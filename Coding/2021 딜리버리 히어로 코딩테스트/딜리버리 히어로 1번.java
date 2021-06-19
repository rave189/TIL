package DeliveryHeroTest;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 이름이 주어질 때, '이름 <firstName.LastName@회사이름.com>'으로 만들어 반환하는 문제
 * 이름에는 중간 이름이 들어갈 수도 있고 안들어갈 수도 있다.
 * 이메일의 firstName과 LastName은 소문자로 치환하여 사용한다.
 * 만약 firstName과 LastName이 같아 이메일이 같아진다면
 * firstName.LastName뒤에 몇 번째로 같은 것인지 숫자를 붙인다.
 * @author Rave
 *
 */
public class Main1 {

	public static void main(String[] args) {
		Solution s = new Solution();
		// 이름들
		String S = "John Doe, Peter Benjamin Parker, Mary Jane Watson-Parker, John Elvis Doe, John Evan Doe, Jane Doe, Peter Brian Parker";
		// 회사 이름
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
		 * 이메일을 만들어 반환하는 메소드
		 * 같은 이메일이 hash에 존재한다면 그 숫자에 +1한 숫자를 뒤에 붙인다.
		 * @param fullName 전체 이름
		 * @param company 회사명
		 * @return 이메일
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