package NHNCommerceTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ��ϵ��� �־�����.
 * ��� ���� �� �����ʿ��� �������� �ְ�, �������� ��� ��Ϻν� �� �ִ�.
 * ��Ͽ��� ������ �������� �ְ�, �������� ��� �νô� ����� �ִ� �������� ���ϴ� ����
 * ����� �� K�� �� �� �ְ�, K������ ���ų� ���� �� �� ����.
 * @author Rave
 *
 */
public class Main3 {

	static int[][] blocks;
	static int[] carry;
	static int m;
	static int answer = 0;

	/**
	 * 10, 5, 10�� ��� �ð� �ʰ��� ����.
	 * ���Ǯ��..?
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		blocks = new int[n][m];
		carry = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				blocks[i][j] = Integer.parseInt(st.nextToken());
		}
		bruteforce(k);
		System.out.println(answer);
	}

	public static void bruteforce(int k) {
		if (k == 0) {
			answer = Math.max(answer, calc());
			return;
		}

		for (int i = 0; i < carry.length; i++) {
			if (carry[i] >= m)
				continue;
			carry[i]++;
			bruteforce(k - 1);
			carry[i]--;
		}
	}

	public static int calc() {
		int sum = 0;
		for (int i = 0; i < blocks.length; i++) {
			try {
				sum += blocks[i][m - carry[i]];
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
		return sum;
	}
}
