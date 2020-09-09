import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		int ans = solution(s);
		System.out.println(ans);
	}

	public static int solution(String s) {
		int answer = s.length();
		int length = answer;
		for (int i = 0; i < length / 2; i++) {
			int count = 1;
			String prev = s.substring(0, i + 1);
			String compare = "";
			String sb = "";
			int j;
			for (j = i + 1; j + i + 1 <= length; j += i + 1) {
				compare = s.substring(j, j + i + 1);
				if (prev.equals(compare))
					count++;
				else {
					if (count != 1)
						sb += count + prev;
					else
						sb += prev;
					count = 1;
					prev = compare.toString();
				}
			}
			if (count != 1)
				sb += count + compare;
			else
				sb += compare;
			if (j < length)
				sb += s.substring(j, length);
			System.out.println(sb);
			if (sb.length() < answer)
				answer = sb.length();
		}
		return answer;
	}
}
