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
	 * ��ǰ���� ���� ������� ������ ������ ���� ��ǰ���� ���� ���� ��,
	 * ���� ��ȯ�Ͽ� ���ϴ� ��ǰ���� ���� �� �ִ�.
	 * �� ��, ���ϴ� ��ǰ�� ���� ���ϴ� ����� ���� ���ϴ� ����
	 * @param gift_cards ������ �ִ� ��ǰ��
	 * @param wants ������ �;� �ϴ� ��ǰ��
	 * @return ���ϴ� ��ǰ�� ���� ���ϴ� ����� ��
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