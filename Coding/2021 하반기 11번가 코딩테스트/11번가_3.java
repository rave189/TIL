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
		 * N개의 수가 들어있는 배열 A가 주어진다.
		 * 이 배열의 수는 비내림차순으로 정렬되어있다.
		 * 각각의 배열의 원소를 지우거나 추가할 수 있을때
		 * X의 개수가 X가 되거나 없게 만들려고 한다.
		 * 이 때 최소한의 움직임을 구하는 문제
		 * @param A 배열 A
		 * @return 최소한의 움직임
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
