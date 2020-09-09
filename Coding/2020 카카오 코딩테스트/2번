import java.util.Scanner;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		String ans = solution(s);
		System.out.println(ans);
	}

	public static String solution(String s) {
		String answer = "";
		int lc = 0;
		int rc = 0;
		int splitNumber = 0;
		if (s.equals(""))
			return "";
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals("("))
				lc++;
			else
				rc++;
			if (lc == rc) {
				splitNumber = i;
				break;
			}
		}
		String u = s.substring(0, splitNumber + 1);
		String v = s.substring(splitNumber + 1, s.length());
		if (Check(u))
			u += solution(v);
		else {
			String tmp = "(";
			tmp += solution(v);
			tmp += ")";
			u = u.substring(1, u.length() - 1);
			u = reverse(u);
			u = tmp + u;
		}
		answer = u;
		return answer;
	}

	public static String reverse(String u) {
		String ret = "";
		for (int i = 0; i < u.length(); i++)
			if (u.substring(i, i + 1).equals("("))
				ret += ")";
			else
				ret += "(";
		return ret;
	}

	public static boolean Check(String u) {
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < u.length(); i++) {
			if (u.substring(i, i + 1).equals("("))
				st.push("(");
			else {
				if (!st.empty())
					st.pop();
				else
					return false;
			}
		}
		return true;
	}
}
