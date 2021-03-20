package Line2;

import java.util.ArrayList;

public class Line2 {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		String program = // "line";
				"trip";
		String[] flag_rules = // { "-s STRINGS", "-n NUMBERS", "-e NULL" };
				{ "-days NUMBERS", "-dest STRING" };
		String[] commands = // { "line -n 100 102 -s hi -e", "line -n id pwd -n 100" };
				{ "trip -days 15 10 -dest Seoul Paris", "trip -days 10 -dest Seoul" };
		boolean[] t = s.solution(program, flag_rules, commands);
		for (int i = 0; i < t.length; i++)
			System.out.println(t[i]);
	}
}

class Solution2 {

	/**
	 * 1�� �������� �̾�����.
	 * NUMBERS�� STRINGS�� ���� ���� ���ڸ� �Է����� ���� �� �ִ�.
	 * @param program ���α׷�
	 * @param flag_rules flag�� �� �� �ִ� ��Ģ��
	 * @param commands ��ɾ��� �迭
	 * @return �� ��ɾ�� ��ɾ ���� �����ϸ� true �������� ������ false
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

			// ��� ������ �����Ͽ����Ƿ� i��° command�� true�� �˴ϴ�.
			answer[i] = true;
		}
		return answer;
	}

	// program�� �Է����� ���� ���� �������� Ȯ���ϴ� �޼ҵ�
	public boolean isProgram(String program, String compareStr) {
		return program.equals(compareStr);
	}

	// program ������ ��� ��ɵ��� ��ȿ���� Ȯ���ϴ� �޼ҵ�
	public boolean isValid(String[] command, String[] flag_rules) {
		for (int j = 1; j < command.length; j++) {
			String flag = command[j];
			int flagIdx = isFlag(flag, flag_rules);
			if (flagIdx < 0)
				return false;

			ArrayList<String> arguments = new ArrayList<String>();

			// ���� ��ɾ Ž���� �� Ž���� �� ����� �ε����� j�� �����մϴ�.
			j = findArguments(arguments, flag_rules, command, j + 1);

			if (!isArgument(flag_rules[flagIdx], arguments))
				return false;
		}
		return true;
	}

	// flag�� flag ��Ģ�� �ִ��� Ȯ���ϴ� �޼ҵ�
	public int isFlag(String flag, String[] flag_rules) {
		for (int i = 0; i < flag_rules.length; i++) {
			String[] flag_rule = flag_rules[i].split(" ");
			if (flag_rule[1].equals("ALIAS"))
				return isFlag("ALIAS", flag_rules);
			else if (flag.equals(flag_rule[0]))
				return i;
		}
		return -1;
	}

	// ���� ��ɾ Ž���ϸ� flag�� �����ų� ��ɾ ���� �� ���� ��ɾ arguments�� �߰��ϴ� �޼ҵ�
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

	// ���ڷ� ���� arguments�� ����ִ� ������ flag�� �´� �������� Ȯ���ϴ� �޼ҵ�
	public boolean isArgument(String flag_rule, ArrayList<String> arguments) {
		String argument_type = flag_rule.split(" ")[flag_rule.length() - 1];
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

	// ���ڷ� ���� argument�� �������� Ȯ���ϴ� �޼ҵ�
	public boolean isNumber(String argument) {
		try {
			Integer.parseInt(argument);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// ���ڷ� ���� argument�� ���ĺ� ��ҹ������� Ȯ���ϴ� �޼ҵ�
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