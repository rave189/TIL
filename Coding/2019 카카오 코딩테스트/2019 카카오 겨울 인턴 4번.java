package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 2019 카카오 겨울 인턴 문제
 * 호텔에서 고객에게 방을 배정해주려고 한다.
 * 고객은 원하는 방이 있고, 원하는 방이 비어있다면 바로 방을 배정해준다.
 * 방이 비어있지 않다면 고객이 원하는방보다 크면서 비어있는 방 중 가장 번호가 작은 방을 배정한다.
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
	 * 고객에게 방을 배정한 후 각 고객에게 배정된 방 번호를 반환한다.
	 * @param k 방의 개수
	 * @param room_number 고객들이 원하는 방 번호
	 * @return 고객들에게 배정된 방 번호
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
	 * 비어있는 다음 방을 탐색하는 메소드
	 * hash에 방이 없다면 비어있는 방이므로 방을 배정한 후 그동안 방문 했던 방을 업데이트 해준다.
	 * @param curRoom 현재 방 번호
	 * @return 배정받은 방 번호
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