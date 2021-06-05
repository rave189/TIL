package LineInternTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 새로운 스택 알고리즘을 구현하는 문제
 * 스택은 중앙 공간 공유한다.
 * 만약 중앙 공간을 지우려고 한다면 시계 방향으로 탐색하여
 * 처음으로 남아 있는 스택의 값을 중앙 공간으로 내린다.
 * @author Rave
 *
 */
public class Main4 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = // 3;
				// 4;
				5;
		int[][] queries = // { { 1, 4 }, { 2, 2 }, { 1, 3 }, { 1, 6 }, { 3, -1 }, { 2, -1 } };
				// { { 1, 3 }, { 1, 2 }, { 3, 6 }, { 3, -1 }, { 4, 5 }, { 2, -1 }, { 3, -1 }, { 1, -1 } };
				{ { 1, -1 }, { 2, -1 }, { 3, -1 }, { 4, -1 }, { 5, -1 } };
		int[] result = s.solution(n, queries);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}

	static class Solution {
		public int[] solution(int n, int[][] queries) {
			ArrayList<Integer> answer = new ArrayList<>();
			NewStack newStack = new NewStack(n);
			for (int i = 0; i < queries.length; i++) {
				int index = queries[i][0] - 1;
				int value = queries[i][1];
				// value가 -1이라면 pop을 하고 아니라면 push를 한다.
				if (value == -1)
					answer.add(newStack.pop(index));
				else
					newStack.push(index, value);
			}
			return answer.stream().mapToInt(v -> v.intValue()).toArray();
		}
	}
}

class NewStack {
	// 앞뒤로 넣고 빼야 하므로 덱으로 구현한다.
	private Deque<Integer>[] dq;
	private int totalSize = 0;

	public NewStack(int n) {
		dq = new ArrayDeque[n];
		for (int i = 0; i < n; i++)
			dq[i] = new ArrayDeque<>();
	}

	/**
	 * 처음으로 넣는 수는 중앙 공간에 넣고 아니라면 index에 넣는다.
	 * @param index 넣는 스택의 인덱스
	 * @param value 넣을 값
	 */
	public void push(int index, int value) {
		// totalSize가 0이라면 모든 덱에 넣어 중앙 공간을 설정해준다.
		if (totalSize == 0) {
			for (int i = 0; i < dq.length; i++)
				dq[i].add(value);
		} else
			dq[index].addLast(value);
		totalSize++;
	}

	/**
	 * 스택에서 한 개를 뺀다.
	 * 중앙 공간을 빼려고 하면 시계 방향으로 탐색하여
	 * 값이 2개 이상인 스택을 내려 중앙 공간을 사용하게 한다.
	 * @param index 뺄 스택의 인덱스
	 * @return 뺀 값
	 */
	public int pop(int index) {
		if (dq[index].size() == 0)
			return -1;

		if (dq[index].size() == 1) {
			int value = dq[index].peek();
			// totalSize가 1이라면 중앙 공간을 지운다.
			if (totalSize == 1)
				removeMid();
			// totalSize가 1이 아니라면 시계 방향으로 탐색하여 값이 2개 이상인 스택을 찾는다.
			// 찾은 스택을 한 칸씩 내려 중앙 공간을 사용하게 한다.
			else {
				int nextIdx = getIdx(index);
				removeMid();
				int newMid = dq[nextIdx].peek();
				for (int i = 1; i < dq.length; i++)
					dq[(nextIdx + i) % dq.length].addFirst(newMid);
			}
			totalSize--;
			return value;
		}
		totalSize--;
		return dq[index].removeLast();
	}

	/**
	 * 중앙 공간의 값을 덱에서 모두 지운다.
	 */
	private void removeMid() {
		for (int i = 0; i < dq.length; i++)
			dq[i].removeFirst();
	}

	/**
	 * 시계 방향으로 2개 이상의 값을 가진 스택을 찾아 인덱스를 반환한다.
	 * @param index 탐색을 시작할 인덱스
	 * @return 2개 이상인 스택의 인덱스, 없다면 원래 index를 반환한다.
	 */
	private int getIdx(int index) {
		for (int i = 1; i < dq.length; i++) {
			if (dq[(index + i) % dq.length].size() > 1)
				return (index + i) % dq.length;
		}
		return index;
	}
}
