package Line2;

public class Line1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String program = "line";
		String[] flag_rules = { "-s STRING", "-n NUMBER", "-e NULL" };
		// { "-s STRING", "-n NUMBER", "-e NULL" };
		String[] commands = { "line -n 100 -s hi -e", "lien -s Bye" };
		// { "line -s 123 -n HI", "line fun" };
		boolean[] t = s.solution(program, flag_rules, commands);
		for (int i = 0; i < t.length; i++)
			System.out.println(t[i]);
	}
}

class Solution1 {
	/**
	 * CLI환경을 구현하는 문제
	 * 명령어는 program, flag, argument순으로 들어온다.
	 * program과 입력으로 받은 program이 같은지 확인한다.
	 * flag가 flag_rules에 들어있는 값인지 확인한다.
	 * @param program 프로그램
	 * @param flag_rules flag에 들어갈 수 있는 규칙들
	 * @param commands 명령어의 배열
	 * @return 각 명령어별로 명령어가 수행 가능하면 true 가능하지 않으면 false
	 */
	public boolean[] solution(String program, String[] flag_rules, String[] commands) {
		boolean[] answer = new boolean[commands.length];
		start: for (int i = 0; i < commands.length; i++) {
			String[] line = commands[i].split(" ");
			// program과 명령어의 첫 번째 문장이 같은지 비교합니다.
			if (!programCheck(program, line[0])) {
				answer[i] = false;
				continue;
			}

			for (int j = 1; j < line.length; j += 2) {
				// flag를 받아 주어진 조건에 맞는지 확인하고 조건에 맞지 않으면 첫 for문으로 돌아갑니다.
				String flag = line[j];
				if (!flagCheck(flag)) {
					answer[i] = false;
					continue start;
				}

				// flag가 n이나 s이면 다음 입력이 있다는 의미입니다.
				if (flag.charAt(1) != 'e') {
					// argument type과 flag의 입력이 일치하는지 확인하고 다르다면 첫 for문으로 돌아갑니다.
					if (!arguTypeCheck(flag, line[j + 1])) {
						answer[i] = false;
						continue start;
					}
				}
			}
			// 모든 조건을 부합하였으므로 첫 문장은 true가 됩니다.
			answer[i] = true;
		}
		return answer;
	}

	// program과 입력으로 받은 값이 동일한지 확인하는 메소드
	public boolean programCheck(String program, String compareStr) {
		return program.equals(compareStr);
	}

	public boolean flagCheck(String flag) {
		if (flag.length() == 2) {
			if (flag.charAt(0) == '-') {
				char ch = flag.charAt(1);
				if (ch == 'n' || ch == 's' || ch == 'e')
					return true;
			}
		}
		return false;
	}

	// 인자로 들어오는 argument의 값이 유효한지 검사하는 메소드
	public boolean arguTypeCheck(String flag, String argument) {
		if (flag.charAt(1) == 'n')
			return isNumber(argument);
		else
			return isString(argument);
	}

	// 인자로 들어온 argument가 숫자인지 확인하는 메소드
	public boolean isNumber(String argument) {
		try {
			Integer.parseInt(argument);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 인자로 들어온 argument가 알파벳 대소문자인지 확인하는 메소드
	public boolean isString(String argument) {
		for (int i = 0; i < argument.length(); i++) {
			char ch = argument.charAt(i);
			boolean upperCase = 65 <= ch && ch <= 90 ? true : false;
			boolean lowerCase = 97 <= ch && ch <= 122 ? true : false;
			if (!(upperCase || lowerCase))
				return false;
		}
		return true;
	}
}