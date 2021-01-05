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
			int oneCount = 0;
			int twoCount = 0;
			for (int j = 0; j < n; j++) {
				int candy = Integer.parseInt(st.nextToken());
				if (candy == 1)
					oneCount++;
				else
					twoCount++;
			}
			if (n % 2 == 0) {
				if (oneCount % 2 == 0 && twoCount % 2 == 0)
					System.out.println("YES");
				else
					System.out.println("NO");
			} else {
				if (oneCount != 0 && oneCount % 2 == 0)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
}