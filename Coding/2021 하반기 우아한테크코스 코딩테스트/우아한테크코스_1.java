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
		 * 1, 2, 3을 담고 있는 배열이 주어진다.
		 * 이 배열에 원소를 추가하여 1, 2, 3의 개수가 같아지도록 하려고 한다.
		 * 이 때 추가해야하는 원소의 최소 개수를 구하는 문제
		 * @param arr 1, 2, 3을 담고 있는 배열
		 * @return 각각 1, 2, 3을 추가해야하는 개수
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
