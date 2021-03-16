package Test2;

import java.util.Scanner;

public class SM2 {

    static int answer = 0;
	static int[] arr;
	static boolean[] check;
    
    public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		arr = new int[n];
		check = new boolean[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		for (int i = 0; i < n; i++)
			Search(i, i + arr[i], 1);
		System.out.println(answer);
    }
    
    public static boolean Search(int startIdx, int next, int cnt) {
		if (startIdx == next) {
			answer = Math.max(answer, cnt);
			return true;
		} else if (check[next])
			return false;

		check[next] = true;
		if (next < arr.length)
			return check[next] = Search(startIdx, next + arr[next], cnt + 1);

		return false;
	}
}