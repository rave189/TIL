package Programmers;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(s.solution(numbers, target));
	}
}

class Solution {
	int answer = 0;

	/**
	 * n개의 수가 주어졌을 때 이 수를 적절히 더하거나 빼서
	 * target 수를 만드는 방법을 찾는 문제
	 * @param numbers n개의 수
	 * @param target 만들고 싶은 수
	 * @return target을 만드는 방법의 수
	 */
	public int solution(int[] numbers, int target) {
		Search(numbers, target, 0, 0);
		return answer;
	}

	public void Search(int[] numbers, int target, int index, int sum) {
		if (index >= numbers.length) {
			answer = target == sum ? answer + 1 : answer;
			return;
		}
		Search(numbers, target, index + 1, sum + numbers[index]);
		Search(numbers, target, index + 1, sum - numbers[index]);
	}
}