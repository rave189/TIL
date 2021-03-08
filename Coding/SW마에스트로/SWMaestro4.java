package Test;

import java.util.Arrays;
import java.util.Scanner;

public class SWMaestro4 {

	static int answer = 0;
	static int[] line;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		line = new int[n + 1];
		check = new boolean[n + 1];
		for (int i = 1; i <= n; i++)
			line[i] = sc.nextInt();
		for (int start = 1; start <= 3; start++) {
			Search(start, 1);
			Arrays.fill(check, false);
		}
		System.out.println(answer);
	}

	public static void Search(int index, int sum) {
		if (check[index]) {
			answer = Math.max(answer, sum);
			return;
		} else
			check[index] = true;
		int next = index + line[index];
		Search(next, sum + 1);
	}
}