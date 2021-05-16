package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] number = {0, 1, 1, 1, 3, 3, 1};
	static int[] number2 = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String m = //"kkaxbycyz";
				"acbbcdc";
		StringBuilder answer = new StringBuilder(m);
		String k = "abc";
		int kCnt = 0;
		for(int i=0; i<m.length(); i++) {
			if(kCnt >= k.length())
				break;
			char ch = answer.charAt(i);
			char key = k.charAt(kCnt);
			if(ch == key) {
				answer.deleteCharAt(i);
				i--;
				kCnt++;
			}
		}
		System.out.println(answer);
	}
}