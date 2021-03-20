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
	 * 언어에 대한 점수 테이블이 주어지고 사용하는 언어와 선호도가 주어졌을 때
	 * 분야를 추천해주는 알고리즘을 만드는 문제
	 * 각 분야의 점수는 언어의 점수 * 선호도로 계산한다.
	 * @param table 각 분야의 언어에 대한 점수 테이블
	 * @param languages 사용하는 언어
	 * @param preference 각 언어의 선호도
	 * @return 추천하는 분야
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