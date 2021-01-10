package Programmers;

import java.util.HashMap;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] participant = { "leo", "kiki", "eden" };
		// = {"marina", "josipa", "nikola", "vinko", "filipa"};
		// = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "eden", "kiki" };
		// = {"josipa", "filipa", "marina", "nikola"};
		// = { "stanko", "ana", "mislav" };
		String answer = s.solution(participant, completion);
		System.out.println(answer);
	}
}

class Solution {
	/**
	 * ������ ��⿡�� �������� ���� 1���� ������ ���� �� 1���� ������ ��ȯ�ϴ� �޼ҵ�
	 * @param participant ������ ������ ����Ʈ
	 * @param completion ������ ������ ����Ʈ
	 * @return �������� ���� ������ �̸�
	 */
	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for (int i = 0; i < participant.length; i++)
			if (hash.containsKey(participant[i]))
				hash.replace(participant[i], hash.get(participant[i]) + 1);
			else
				hash.put(participant[i], 1);
		for (int i = 0; i < completion.length; i++)
			if (hash.containsKey(completion[i])) {
				int value = hash.get(completion[i]);
				if (--value <= 0)
					hash.remove(completion[i]);
				else
					hash.replace(completion[i], value);
			}
		Set<String> key = hash.keySet();
		String answer = key.iterator().next();
		return answer;
	}
}