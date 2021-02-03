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
	 * n���� ���� �־����� �� �� ���� ������ ���ϰų� ����
	 * target ���� ����� ����� ã�� ����
	 * @param numbers n���� ��
	 * @param target ����� ���� ��
	 * @return target�� ����� ����� ��
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