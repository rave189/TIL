package LineInternTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * ���ο� ���� �˰����� �����ϴ� ����
 * ������ �߾� ���� �����Ѵ�.
 * ���� �߾� ������ ������� �Ѵٸ� �ð� �������� Ž���Ͽ�
 * ó������ ���� �ִ� ������ ���� �߾� �������� ������.
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
				// value�� -1�̶�� pop�� �ϰ� �ƴ϶�� push�� �Ѵ�.
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
	// �յڷ� �ְ� ���� �ϹǷ� ������ �����Ѵ�.
	private Deque<Integer>[] dq;
	private int totalSize = 0;

	public NewStack(int n) {
		dq = new ArrayDeque[n];
		for (int i = 0; i < n; i++)
			dq[i] = new ArrayDeque<>();
	}

	/**
	 * ó������ �ִ� ���� �߾� ������ �ְ� �ƴ϶�� index�� �ִ´�.
	 * @param index �ִ� ������ �ε���
	 * @param value ���� ��
	 */
	public void push(int index, int value) {
		// totalSize�� 0�̶�� ��� ���� �־� �߾� ������ �������ش�.
		if (totalSize == 0) {
			for (int i = 0; i < dq.length; i++)
				dq[i].add(value);
		} else
			dq[index].addLast(value);
		totalSize++;
	}

	/**
	 * ���ÿ��� �� ���� ����.
	 * �߾� ������ ������ �ϸ� �ð� �������� Ž���Ͽ�
	 * ���� 2�� �̻��� ������ ���� �߾� ������ ����ϰ� �Ѵ�.
	 * @param index �� ������ �ε���
	 * @return �� ��
	 */
	public int pop(int index) {
		if (dq[index].size() == 0)
			return -1;

		if (dq[index].size() == 1) {
			int value = dq[index].peek();
			// totalSize�� 1�̶�� �߾� ������ �����.
			if (totalSize == 1)
				removeMid();
			// totalSize�� 1�� �ƴ϶�� �ð� �������� Ž���Ͽ� ���� 2�� �̻��� ������ ã�´�.
			// ã�� ������ �� ĭ�� ���� �߾� ������ ����ϰ� �Ѵ�.
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
	 * �߾� ������ ���� ������ ��� �����.
	 */
	private void removeMid() {
		for (int i = 0; i < dq.length; i++)
			dq[i].removeFirst();
	}

	/**
	 * �ð� �������� 2�� �̻��� ���� ���� ������ ã�� �ε����� ��ȯ�Ѵ�.
	 * @param index Ž���� ������ �ε���
	 * @return 2�� �̻��� ������ �ε���, ���ٸ� ���� index�� ��ȯ�Ѵ�.
	 */
	private int getIdx(int index) {
		for (int i = 1; i < dq.length; i++) {
			if (dq[(index + i) % dq.length].size() > 1)
				return (index + i) % dq.length;
		}
		return index;
	}
}
