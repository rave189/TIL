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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int need = Integer.parseInt(st.nextToken());
			int piece = 1;
			while (w % 2 == 0 || h % 2 == 0) {
				if (w % 2 == 0) {
					w /= 2;
					piece *= 2;
				} else {
					h /= 2;
					piece *= 2;
				}
			}
			if (piece >= need)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}