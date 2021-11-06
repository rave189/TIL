package techcourseTest;

import java.util.HashMap;
import java.util.Map;

public class Main3 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] ings = //{ "r 10", "a 23", "t 124", "k 9" };
			{"x 25", "y 20", "z 1000"};
		String[] menu = //{ "PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20" };
			{"AAAA xyxy 15", "TTT yy 30", "BBBB xx 30"};
		String[] sell = //{ "BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1" };
			{"BBBB 3", "TTT 2"};
		System.out.println(s.solution(ings, menu, sell));
	}

	static class Solution {
		int[] ingredients = new int[26];
		Map<String, Integer> priceList = new HashMap<>();

		/**
		 * 음식점의 하루 판매 수익을 구하는 문제
		 * @param ings 각 재료의 이름과 가격
		 * @param menu 각 메뉴의 이름, 메뉴를 제작하는데 필요한 재료, 판매가
		 * @param sell 하루 동안의 판매 실적
		 * @return
		 */
		public int solution(String[] ings, String[] menu, String[] sell) {
			int answer = 0;
			init(ings, menu);
			for (String food : sell) {
				String[] split = food.split(" ");
				String name = split[0];
				int count = Integer.parseInt(split[1]);
				answer += priceList.get(name) * count;
			}
			return answer;
		}

		public void init(String[] ings, String[] menu) {
			// 각 재료의 값을 배열에 저장
			for (String ing : ings) {
				String[] split = ing.split(" ");
				char name = split[0].charAt(0);
				int price = Integer.parseInt(split[1]);
				ingredients[name - 'a'] = price;
			}

			// 각 음식의 순이익을 hash에 넣는다.
			for (String food : menu) {
				String[] split = food.split(" ");
				String name = split[0];
				int ingsPrice = getIngsPrice(split[1]);
				int sellPrice = Integer.parseInt(split[2]);
				priceList.put(name, sellPrice - ingsPrice);
			}
		}

		/**
		 * 레시피가 주어지면 레시피에 들어가는 재료의 총 가격을 구한다.
		 * @param recipe 음식의 레시피
		 * @return 재료의 총 구매 비용
		 */
		public int getIngsPrice(String recipe) {
			int sum = 0;
			for (char ing : recipe.toCharArray())
				sum += ingredients[ing - 'a'];
			return sum;
		}
	}
}
