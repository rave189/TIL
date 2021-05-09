package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2019�� īī�� �ܿ� ���� ����
 * ¡�˴ٸ��� �ǳʷ��� �� �� �ִ� ����� �ϴ�� ¡�˴ٸ��� �ǳ� �� �ִ��� ���ϴ� ����
 * ¡�˴ٸ��� ������ ���� ��Ģ���� �ǳʹ�.
 * 1.¡�˴ٸ��� �Ϸķ� ���� �ְ� �� ¡�˴ٸ��� ��������� ��� ���ڰ� ���� ������ ������� ���ڴ� �� �� ���� ������ 1�� �پ��ϴ�.
 * 1.������� ���ڰ� 0�� �Ǹ� �� �̻� ���� �� ������ �̶��� �� ���� ������� �ѹ��� ���� ĭ�� �ǳ� �� �� �ֽ��ϴ�.
 * 3.��, �������� ���� �� �ִ� ������� ���� ���� ��� ������ ���� ����� ������θ� �ǳʶ� �� �ֽ��ϴ�.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		System.out.println(s.solution(stones, k));
	}
}

class Solution {
	/**
	 * �Է� ����
	 * �ϴ��� ģ������ ������
	 * stones �迭�� ũ��� 20�� ������ �ڿ���
	 * stones �� ������ ���� 2�� ������ �ڿ���
	 * k�� 1�̻� stones�� ���� ������ �ڿ���
	 * @param stones ¡�˴ٸ��� �� ������ ��
	 * @param k �ִ�� �ǳʶ� �� �ִ� ¡�˴ٸ��� ��
	 * @return �ִ�� �ǳ� �� �ִ� �ϴ��� ģ������ ��
	 */
	public int solution(int[] stones, int k) {
		int left = 1;
		int right = 200000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			int zeroCnt = 0;
			boolean isPossible = true;
			for (int value : stones) {
				if (value - mid <= 0) {
					zeroCnt++;
					if (zeroCnt == k)
						isPossible = false;
				} else
					zeroCnt = 0;
			}
			if (isPossible)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left;
	}
}