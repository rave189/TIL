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
	 * CLIȯ���� �����ϴ� ����
	 * ��ɾ�� program, flag, argument������ ���´�.
	 * program�� �Է����� ���� program�� ������ Ȯ���Ѵ�.
	 * flag�� flag_rules�� ����ִ� ������ Ȯ���Ѵ�.
	 * @param program ���α׷�
	 * @param flag_rules flag�� �� �� �ִ� ��Ģ��
	 * @param commands ��ɾ��� �迭
	 * @return �� ��ɾ�� ��ɾ ���� �����ϸ� true �������� ������ false
	 */
	public boolean[] solution(String program, String[] flag_rules, String[] commands) {
		boolean[] answer = new boolean[commands.length];
		start: for (int i = 0; i < commands.length; i++) {
			String[] line = commands[i].split(" ");
			// program�� ��ɾ��� ù ��° ������ ������ ���մϴ�.
			if (!programCheck(program, line[0])) {
				answer[i] = false;
				continue;
			}

			for (int j = 1; j < line.length; j += 2) {
				// flag�� �޾� �־��� ���ǿ� �´��� Ȯ���ϰ� ���ǿ� ���� ������ ù for������ ���ư��ϴ�.
				String flag = line[j];
				if (!flagCheck(flag)) {
					answer[i] = false;
					continue start;
				}

				// flag�� n�̳� s�̸� ���� �Է��� �ִٴ� �ǹ��Դϴ�.
				if (flag.charAt(1) != 'e') {
					// argument type�� flag�� �Է��� ��ġ�ϴ��� Ȯ���ϰ� �ٸ��ٸ� ù for������ ���ư��ϴ�.
					if (!arguTypeCheck(flag, line[j + 1])) {
						answer[i] = false;
						continue start;
					}
				}
			}
			// ��� ������ �����Ͽ����Ƿ� ù ������ true�� �˴ϴ�.
			answer[i] = true;
		}
		return answer;
	}

	// program�� �Է����� ���� ���� �������� Ȯ���ϴ� �޼ҵ�
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

	// ���ڷ� ������ argument�� ���� ��ȿ���� �˻��ϴ� �޼ҵ�
	public boolean arguTypeCheck(String flag, String argument) {
		if (flag.charAt(1) == 'n')
			return isNumber(argument);
		else
			return isString(argument);
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