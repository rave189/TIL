package NHNCommerceTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 같은 타입의 연속된 번호를 압축하는 문제
 * 이전 메세지와 타입이 같고 전화번호도 같은 경우 하나로 합친 후
 * 연속으로 나온 횟수를 추가하여 출력한다.
 * @author Rave
 *
 */
public class Main1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		List<Message> result = new ArrayList<>();
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String[] input = scanner.nextLine().split(" ");
			if (result.size() > 0) {
				Message prev = result.get(result.size() - 1);
				if (prev.type.equals(input[0]) && prev.phoneNumber.equals(input[1]))
					prev.addCount();
				else
					result.add(new Message(input[0], input[1]));
			} else
				result.add(new Message(input[0], input[1]));
		}
		answer.append(result.size() + "\n");
		for (int i = 0; i < result.size(); i++) {
			Message cur = result.get(i);
			answer.append(cur.type + " " + cur.phoneNumber);
			if (cur.count > 1)
				answer.append(" (" + cur.count + ")");
			answer.append("\n");
		}
		System.out.println(answer);
	}
}

class Message {
	String type, phoneNumber;
	int count = 1;

	public Message(String type, String phoneNumber) {
		this.type = type;
		this.phoneNumber = phoneNumber;
	}

	public void addCount() {
		this.count++;
	}

	@Override
	public String toString() {
		return "Message [type=" + type + ", phoneNumber=" + phoneNumber + ", count=" + count + "]";
	}

}