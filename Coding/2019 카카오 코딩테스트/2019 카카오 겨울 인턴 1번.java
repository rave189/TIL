package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 2019 īī�� �ܿ� ���� ����
 * �Ҹ���� �����̱⸦ �Ϸ��� �Ѵ�.
 * ���� ȭ�鿡�� ������ ������ �ٱ��Ϸ� ������ ���� �ȴ�.
 * �ٱ��Ͽ� ���� ���� ������ 2�� �������� ���̰� �Ǹ� 2���� ������ �������.
 * �� ��, ����� ������ ������ ���ϴ� ����
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
	 * Ž���� ���� �ð��� �ҿ���� �ʵ��� ť�� �迭�� ����� ����Ѵ�.
	 * ���� ���԰� �����̴� ������ ������ �ϳ��� �����´�. (������ ���ٸ� �ƹ��ϵ� �Ͼ�� �ʴ´�.)
	 * ���� ������ ���ÿ� ���� �ִ´�.
	 * ���ÿ� ���� ������ ���� ���� ������ ���� �����̶�� ���ÿ��� ������ �ϳ� �� �� answer�� ������Ų��.
	 * ������ ���� �ʴٸ� �״�� ���ÿ� �ִ´�.
	 * @param board ���� ȭ��
	 * @param moves ���԰� �̵��� ����
	 * @return ����� ������ ��
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