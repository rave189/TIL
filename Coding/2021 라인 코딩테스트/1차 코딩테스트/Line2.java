package Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Line2 {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		String inp_str = // "AaTa+!12-3";
				// "aaaaZZZZ)";
				// "CaCbCgCdC888834A";
				// "UUUUU";
				"ZzZz9Z824";
		int[] t = s.solution(inp_str);
		for (int i = 0; i < t.length; i++)
			System.out.println(t[i]);
	}
}

class Solution2 {
	boolean[] charType = new boolean[4];

	/**
	 * 비밀번호를 입력받아 비밀번호가 유효한지 검사하는 문제 
	 * 1. 비밀번호는 8부터 15자리의 숫자여야 한다. 
	 * 2. 비밀번호는 대문자 알파벳, 소문자 알파벳, 숫자, ~!@#$%^&*의 특수문자만 가능하다.
	 * 3. 2번의 조건 중 3개 이상이 포함되어야 한다.
	 * 4. 같은 문자가 4번 연속 나오지 않는다.
	 * 5. 같은 문자가 5번 이상 나오지 않는다.
	 * @param inp_str 비밀번호
	 * @return 지키지 못한 규칙들의 배열
	 */
	public int[] solution(String inp_str) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		if (inp_str.length() < 8 || inp_str.length() > 15)
			answer.add(1);
		HashMap<Character, Integer> frequency = new HashMap<>();
		int charCnt = 1;
		char prev = ' ';
		boolean[] check = new boolean[4];
		for (int i = 0; i < inp_str.length(); i++) {
			char ch = inp_str.charAt(i);
			if (!rule2(ch))
				check[0] = true;

			if (!check[2]) {
				if (prev == ch)
					charCnt++;
				else {
					prev = ch;
					charCnt = 1;
				}
				if (charCnt == 4)
					check[2] = true;
			}

			if (!check[3]) {
				frequency.putIfAbsent(ch, 0);
				int freq = frequency.get(ch) + 1;
				if (freq == 5)
					check[3] = true;
				frequency.replace(ch, freq);
			}
		}
		charCnt = 0;
		for (int i = 0; i < charType.length; i++)
			if (charType[i])
				charCnt++;
		if (charCnt < 3)
			check[1] = true;

		for (int i = 0; i < check.length; i++)
			if (check[i])
				answer.add(i + 2);
		if (answer.size() == 0)
			answer.add(0);
		return Arrays.stream(answer.toArray(new Integer[answer.size()])).mapToInt(Integer::intValue).toArray();
	}

	public boolean rule2(char ch) {
		boolean upperCase = ch >= 65 && ch <= 90 ? true : false;
		if (upperCase)
			charType[0] = true;

		boolean lowerCase = ch >= 97 && ch <= 122 ? true : false;
		if (lowerCase)
			charType[1] = true;

		boolean number = ch >= 48 && ch <= 57 ? true : false;
		if (number)
			charType[2] = true;

		boolean specialChar = false;
		if (ch == '~' || ch == '!' || ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&'
				|| ch == '*')
			specialChar = true;
		if (specialChar)
			charType[3] = true;

		return upperCase || lowerCase || number || specialChar;
	}
}