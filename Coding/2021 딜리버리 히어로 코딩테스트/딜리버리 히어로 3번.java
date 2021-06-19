package DeliveryHeroTest;

/**
 * 입력으로 주어진 문자열을 a의 개수가 똑같도록 세 부분으로 나누려고 한다.
 * 이러한 경우의 수를 구하는 문제
 * a가 하나도 없을 수도 있다.
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
			// 이 코드는 제출 못함
			else if(aCnt == 0) {
				// S가 b로만 이루어져 있다면 예외 처리를 해주어야 한다.
				// 3 미만이면 0을 반환한다.
				if(S.length() < 3)
					return 0;
				else {
					// 아니라면 b를 하나씩 분배한 다음 남은 b로 세 부분에 분배하는 경우의 수를 구한다.
					int size = S.length()-3;
				}
			}
			// 여기까지
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
			// 첫 1/3 지점을 자른다.
			Split();
			// b의 개수를 구한다.
			// b가 없는 경우도 하나의 경우이므로 +1을 해준다.
			int leftBCnt = getBCnt() + 1;
			// 다시 1/3 지점을 자른다.
			Split();
			// b의 개수를 구한다.
			int rightBCnt = getBCnt() + 1;
			// 이 두 수를 곱하여 경우의 수를 구한다.
			answer = leftBCnt * rightBCnt;
		}

		/**
		 * a의 개수가 전체 a의 개수의 1/3이 될때까지 자르는 메소드
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
		 * 처음으로 a를 만나기 전까지의 b의 개수를 구하는 메소드
		 * @return b의 개수
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