package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n + 1];
			int[] sumArr = new int[n + 1];
			for (int j = 1; j <= n; j++)
				arr[j] = Integer.parseInt(st.nextToken());
			int answer = 0;
			for (int j = 1; j <= n; j++) {
				try {
					if (sumArr[j] + arr[j] > sumArr[j + arr[j]])
						sumArr[j + arr[j]] = sumArr[j] + arr[j];
				} catch (Exception e) {
					answer = Math.max(answer, sumArr[j] + arr[j]);
				}
			}
			System.out.println(answer);
		}
	}
}