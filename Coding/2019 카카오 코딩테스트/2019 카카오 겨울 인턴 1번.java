package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 2019 카카오 겨울 인턴 문제
 * 죠르디는 인형뽑기를 하려고 한다.
 * 게임 화면에서 인형을 뽑으면 바구니로 인형이 들어가게 된다.
 * 바구니에 서로 같은 인형이 2개 연속으로 쌓이게 되면 2개의 인형은 사라진다.
 * 이 때, 사라진 인형의 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(s.solution(board, moves));
	}
}

class Solution {
	Queue<Integer>[] dolls;

	/**
	 * 탐색에 많은 시간이 소요되지 않도록 큐의 배열을 만들어 사용한다.
	 * 이후 집게가 움직이는 곳에서 인형을 하나씩 꺼내온다. (인형이 없다면 아무일도 일어나지 않는다.)
	 * 꺼낸 인형을 스택에 집어 넣는다.
	 * 스택에 넣을 때에는 가장 위의 인형과 같은 인형이라면 스택에서 인형을 하나 뺀 후 answer을 증가시킨다.
	 * 인형이 같지 않다면 그대로 스택에 넣는다.
	 * @param board 게임 화면
	 * @param moves 집게가 이동할 방향
	 * @return 사라진 인형의 수
	 */
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		int n = board.length;
		dolls = new LinkedList[n];
		for (int i = 0; i < n; i++)
			dolls[i] = new LinkedList<>();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (board[j][i] != 0)
					dolls[i].add(board[j][i]);
		Stack<Integer> st = new Stack<>();
		for (int move : moves) {
			int doll = dolls[move - 1].isEmpty() ? -1 : dolls[move - 1].poll();
			if (doll < 0)
				continue;
			if (!st.isEmpty() && st.peek() == doll) {
				st.pop();
				answer += 2;
			} else
				st.push(doll);
		}
		return answer;
	}
}