package Programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[][] clothes =
				// {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban",
				// "headgear"}};
				{ { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } };
		System.out.println(s.solution(clothes));
	}
}

class Solution {
	/**
	 * 스파이가 매일 다른 옷을 조합하여 위장을 하려고 할 때 매일 서로 다른 옷의 조합의 수를 반환하는 메소드
	 * @param clothes 스파이가 가진 의상들
	 * @return 다른 옷을 입는 조합의 수
	 */
	public int solution(String[][] clothes) {
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		ArrayList<String> keys = new ArrayList<String>();
		for (int i = 0; i < clothes.length; i++) {
			if (!hash.containsKey(clothes[i][1]))
				keys.add(clothes[i][1]);
			hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1], 0) + 1);
		}
		int answer = 1;
		for (int i = 0; i < hash.size(); i++)
			answer *= hash.get(keys.get(i)) + 1;
		return answer - 1;
	}
}