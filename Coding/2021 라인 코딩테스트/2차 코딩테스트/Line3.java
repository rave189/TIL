package Line2;

import java.util.ArrayList;

public class Line3 {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		String program = // "line";
				"bank";
		String[] flag_rules = // { "-s STRING", "-num NUMBER", "-e NULL", "-n ALIAS -num" };
				{ "-send STRING", "-a ALIAS -amount", "-amount NUMBERS" };
		String[] commands = // { "line -n 100 -s hi -e", "line -n 100 -e -num 150" };
				{ "bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey" };
		boolean[] t = s.solution(program, flag_rules, commands);
		for (int i = 0; i < t.length; i++)
			System.out.println(t[i]);
	}
}

class Solution3 {

	/**
	 * 미제출 2번에서 이어진다.
	 * ALIAS 기능이 추가되어 별칭을 지정할 수 있다.
	 * flag1 ALIAS flag2와 같이 주어지고 flag1은 flag2로 변환하여 문제를 풀 수 있다.
	 * ALIAS의 flag1과 flag2는 연속하여 나올 수 없다.
	 * @param program    프로그램
	 * @param flag_rules flag에 들어갈 수 있는 규칙들
	 * @param commands   명령어의 배열
	 * @return 각 명령어별로 명령어가 수행 가능하면 true 가능하지 않으면 false
	 */
	public boolean[] solution(String program, String[] flag_rules, String[] commands) {
		boolean[] answer = new boolean[commands.length];
		for (int i = 0; i < commands.length; i++) {
			String[] command = commands[i].split(" ");
			if (!isProgram(program, command[0])) {
				answer[i] = false;
				continue;
			}

			if (!isValid(command, flag_rules)) {
				answer[i] = false;
				continue;
			}

			// 모든 조건을 부합하였으므로 i번째 command는 true가 됩니다.
			answer[i] = true;
		}
		return answer;
	}

	// program과 입력으로 받은 값이 동일한지 확인하는 메소드
	public boolean isProgram(String program, String compareStr) {
		return program.equals(compareStr);
	}

	// program 다음의 모든 명령들이 유효한지 확인하는 메소드
	public boolean isValid(String[] command, String[] flag_rules) {
		String prevFlag = "";
		for (int j = 1; j < command.length; j++) {
			String flag = command[j];
			int flagIdx = isFlag(flag, flag_rules);
			if (flagIdx < 0)
				return false;
			String[] flag_rule = flag_rules[flagIdx].split(" ");
			String curFlag = flag_rule[0];
			if (prevFlag.equals(curFlag))
				return false;

			ArrayList<String> arguments = new ArrayList<String>();

			// 다음 명령어를 탐색한 후 탐색할 때 사용한 인덱스를 j에 복사합니다.
			j = findArguments(arguments, flag_rules, command, j + 1);

			if (!isArgument(flag_rules[flagIdx], arguments))
				return false;
		}
		return true;
	}

	// flag가 flag 규칙에 있는지 확인하는 메소드
	public int isFlag(String flag, String[] flag_rules) {
		for (int i = 0; i < flag_rules.length; i++) {
			String[] flag_rule = flag_rules[i].split(" ");
			if (flag.equals(flag_rule[0])) {
				if (flag_rule[1].equals("ALIAS"))
					return isFlag(flag_rule[2], flag_rules);
				return i;
			}
		}
		return -1;
	}

	// 다음 명령어를 탐색하며 flag가 나오거나 명령어가 끝날 때 까지 명령어를 arguments에 추가하는 메소드
	public int findArguments(ArrayList<String> arguments, String[] flag_rules, String[] command, int idx) {
		for (; idx < command.length; idx++) {
			String nextStr = command[idx];
			int flagCheck = isFlag(nextStr, flag_rules);
			if (flagCheck >= 0)
				return idx - 1;
			arguments.add(nextStr);
		}
		return idx;
	}

	// 인자로 들어온 arguments에 들어있는 값들이 flag에 맞는 값들인지 확인하는 메소드
	public boolean isArgument(String flag_rule, ArrayList<String> arguments) {
		String argument_type = flag_rule.split(" ")[1];
		if (argument_type.equals("NULL") && arguments.size() > 0)
			return false;
		else if (argument_type.equals("NUMBER") && arguments.size() > 1)
			return false;
		else if (argument_type.equals("STRING") && arguments.size() > 1)
			return false;

		for (int i = 0; i < arguments.size(); i++) {
			if (argument_type.equals("NUMBERS") && !isNumber(arguments.get(i)))
				return false;
			else if (argument_type.equals("STRINGS") && !isString(arguments.get(i)))
				return false;
		}
		return true;
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