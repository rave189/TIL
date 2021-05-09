package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 2019 īī�� �ܿ� ���� ����
 * ȣ�ڿ��� ������ ���� �������ַ��� �Ѵ�.
 * ���� ���ϴ� ���� �ְ�, ���ϴ� ���� ����ִٸ� �ٷ� ���� �������ش�.
 * ���� ������� �ʴٸ� ���� ���ϴ¹溸�� ũ�鼭 ����ִ� �� �� ���� ��ȣ�� ���� ���� �����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		long k = 10;
		long[] room_number = { 1, 3, 4, 1, 3, 1 };
		long[] result = s.solution(k, room_number);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}
}

class Solution {
	HashMap<Long, Long> hash = new HashMap<>();

	/**
	 * ������ ���� ������ �� �� ������ ������ �� ��ȣ�� ��ȯ�Ѵ�.
	 * @param k ���� ����
	 * @param room_number ������ ���ϴ� �� ��ȣ
	 * @return ���鿡�� ������ �� ��ȣ
	 */
	public long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		for (int i = 0; i < room_number.length; i++) {
			long wanted = room_number[i];
			answer[i] = findNext(wanted);
			hash.put(wanted, answer[i] + 1);
		}
		return answer;
	}

	/**
	 * ����ִ� ���� ���� Ž���ϴ� �޼ҵ�
	 * hash�� ���� ���ٸ� ����ִ� ���̹Ƿ� ���� ������ �� �׵��� �湮 �ߴ� ���� ������Ʈ ���ش�.
	 * @param curRoom ���� �� ��ȣ
	 * @return �������� �� ��ȣ
	 */
	public long findNext(long curRoom) {
		if (!hash.containsKey(curRoom)) {
			hash.put(curRoom, curRoom + 1);
			return curRoom;
		}
		hash.put(curRoom, findNext(hash.get(curRoom)));
		return hash.get(curRoom);
	}
}