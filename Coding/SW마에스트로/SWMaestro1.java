package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SWMaestro1 {

	static StringBuilder answer = new StringBuilder();
	static HashMap<Character, ArrayList<Character>> totalSkill;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		totalSkill = new HashMap<>();
		ArrayList<String> singleSkillList = new ArrayList<>();
		String input = sc.nextLine();
		for (int index = 0; index < input.length(); index += 2) {
			char ch = input.charAt(index);
			totalSkill.putIfAbsent(ch, new ArrayList<Character>());
			singleSkillList.add(ch + "");
		}
		int linkSkillCnt = sc.nextInt();
		for (int i = 0; i < linkSkillCnt; i++) {
			char prevSkill = sc.next().charAt(0);
			char nextSkill = sc.next().charAt(0);
			totalSkill.get(prevSkill).add(nextSkill);
			singleSkillList.remove(nextSkill + "");
		}
		for (String skill : singleSkillList) {
			ArrayList<Character> nextSkillList = totalSkill.get(skill.charAt(0));
			Search(nextSkillList, skill + " ");
		}
		System.out.println(answer);
	}

	public static void Search(ArrayList<Character> nextSkillList, String result) {
		if (nextSkillList.size() == 0) {
			answer.append(result + "\n");
			return;
		}

		for (char skill : nextSkillList)
			Search(totalSkill.get(skill), result + skill + " ");
	}
}