package NHNCommerceTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 블록들이 주어진다.
 * 블록 범위 밖 오른쪽에는 레이저가 있고, 레이저를 쏘아 블록부실 수 있다.
 * 블록에는 각각의 내구도가 있고, 레이저를 쏘아 부시는 블록의 최대 내구도를 구하는 문제
 * 블록은 총 K번 밀 수 있고, K번보다 많거나 적게 밀 수 없다.
 * @author Rave
 *
 */
public class Main3 {

	static int[][] blocks;
	static int[] carry;
	static int m;
	static int answer = 0;

	/**
	 * 10, 5, 10인 경우 시간 초과가 난다.
	 * 어떻게풀지..?
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
