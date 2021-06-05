package LineInternTest;

/**
 * 0~9까지의 숫자가 적힌 쿠키가 있다.
 * 이 수들을 조합하여 1부터 N까지의 수를 나열해놨다.
 * 이 중 몇 개의 숫자가 적힌 쿠키를 먹어가 버렸다.
 * 이 때 N이 될 수 있는 최소의 수를 구하는 문제
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
			// 1부터 넣어보며 만들 수 있는 수인지 확인한다.
			for (int i = 0; i < inputString.length(); answer++) {
				String str = Integer.toString(answer);
				// 1부터 String으로 변환하여 숫자 하나라도 맞다면 맞출 수 있는 수이다.
				for (int j = 0; j < str.length(); j++) {
					// 끝까지 탐색하였다면 종료한다.
					if(i == inputString.length())
						break;
					// 비교해보며 같다면 i값을 증가시켜 다음 숫자를 대입해 본다.
					else if (inputString.charAt(i) == str.charAt(j))
						i++;
				}
			}
			// for문 마지막 answer++을 실행하였으므로 1을 빼준다.
			return answer - 1;
		}
	}
}
