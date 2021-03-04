package Test;

import java.util.Scanner;

public class SWMaestro6 {

	static int[] line;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		line = new int[n];
		for (int i = 0; i < n; i++)
			line[i] = sc.nextInt();
		System.out.println(Search(0, n));
	}

	public static int Search(int left, int right) {
		if(right-left <= 1)
			return 0;
		int mid = (left + right) / 2;
		int leftMax = 0;
		for (int index = left; index < mid; index++)
			leftMax = Math.max(leftMax, line[index]);
		int rightMax = 0;
		for (int index = mid; index < right; index++)
			rightMax = Math.max(rightMax, line[index]);

		if (leftMax > rightMax)
			return leftMax + Search(mid, right);
		else if (leftMax == rightMax)
			return leftMax + Math.max(Search(left, mid), Search(mid, right));
		else
			return rightMax + Search(left, mid);
	}
}