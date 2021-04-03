package CodingTest;

public class Kakao_1 {

	static boolean[] isEnd;

	public static void main(String[] args) {
		int[] gift_cards = // { 4, 5, 3, 2, 1 };
				{ 5, 4, 5, 4, 5 };
		int[] wants = // { 2, 4, 4, 5, 1 };
				{ 1, 2, 3, 5, 4 };
		System.out.println(solution(gift_cards, wants));
	}

	/**
	 * 상품권을 가진 사람들이 실제로 가지고 싶은 상품권이 따로 있을 때,
	 * 서로 교환하여 원하는 상품권을 가질 수 있다.
	 * 이 때, 원하는 상품을 받지 못하는 사람의 수를 구하는 문제
	 * @param gift_cards 가지고 있는 상품권
	 * @param wants 가지고 싶어 하는 상품권
	 * @return 원하는 상품을 받지 못하는 사람의 수
	 */
	public static int solution(int[] gift_cards, int[] wants) {
		int answer = 0;
		isEnd = new boolean[gift_cards.length];
		for (int i = 0; i < gift_cards.length; i++) {
			if (gift_cards[i] == wants[i]) {
				answer++;
				isEnd[i] = true;
				continue;
			}
			int isFind = FindWants(wants[i], gift_cards);
			if (isFind >= 0) {
				Swap(gift_cards, i, isFind);
				answer++;
				isEnd[i] = true;
			}
		}
		return gift_cards.length - answer;
	}

	public static int FindWants(int myWant, int[] gift_cards) {
		for (int i = 0; i < gift_cards.length; i++) {
			if (!isEnd[i] && myWant == gift_cards[i])
				return i;
		}
		return -1;
	}

	public static void Swap(int[] gift_cards, int myCard, int yourCard) {
		int tmp = gift_cards[myCard];
		gift_cards[myCard] = gift_cards[yourCard];
		gift_cards[yourCard] = tmp;
	}
}