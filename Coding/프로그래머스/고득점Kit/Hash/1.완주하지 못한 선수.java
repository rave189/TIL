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
	 * 마라톤 경기에서 완주하지 못한 1명의 선수가 있을 때 1명의 선수를 반환하는 메소드
	 * @param participant 참여한 선수의 리스트
	 * @param completion 완주한 선수의 리스트
	 * @return 완주하지 못한 선수의 이름
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