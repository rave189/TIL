package Line;

import java.util.ArrayList;

public class Line1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
				"GAME C++ C# JAVASCRIPT C JAVA" };
		String[] languages = // { "PYTHON", "C++", "SQL" };
				{ "JAVA", "JAVASCRIPT" };
		int[] preference = // { 7, 5, 5 };
				{ 7, 5 };
		System.out.println(s.solution(table, languages, preference));
	}
}

class Solution1 {
	/**
	 * �� ���� ���� ���̺��� �־����� ����ϴ� ���� ��ȣ���� �־����� ��
	 * �о߸� ��õ���ִ� �˰����� ����� ����
	 * �� �о��� ������ ����� ���� * ��ȣ���� ����Ѵ�.
	 * @param table �� �о��� �� ���� ���� ���̺�
	 * @param languages ����ϴ� ���
	 * @param preference �� ����� ��ȣ��
	 * @return ��õ�ϴ� �о�
	 */
	public String solution(String[] table, String[] languages, int[] preference) {
		String[][] map = new String[table.length][table.length];
		ArrayList<String> keyList = new ArrayList<String>();
		for (int i = 0; i < table.length; i++) {
			String[] scoreList = table[i].split(" ");
			keyList.add(scoreList[0]);
			for (int j = 1; j < scoreList.length; j++)
				map[j - 1][i] = scoreList[j];
		}

		int[] result = new int[map.length];
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map.length; j++)
				for (int t = 0; t < languages.length; t++) {
					if (map[i][j].equals(languages[t])) {
						result[j] += preference[t] * (5 - i);
						break;
					}
				}

		int max = result[0];
		String answer = keyList.get(0);
		for (int i = 1; i < result.length; i++) {
			if (result[i] > max) {
				max = result[i];
				answer = keyList.get(i);
			} else if (result[i] == max && answer.compareTo(keyList.get(i)) > 0) {
				answer = keyList.get(i);
			}
		}
		return answer;
	}
}