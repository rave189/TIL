package NHNCodingTest;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Main1 {

	public static void main(String[] args) {
	}

	static class Solution {
		/**
		 * ���������� 2���� ������ �����Ű���� �Ѵ�.
		 * ó������ 1�� ���������� �ִ� ���¿��� �����Ѵ�.
		 * branch : 1�� ���������� �ϳ��� ���������� �����δ�. �� �� ��������� ����������
		 * 			���� ���� �� �ִ� ��ȣ �� ���� ���� ��ȣ�� �ȴ�.
		 * merge a : a�� ���������� 1�� ���������� ��ģ��. ��ģ �Ŀ� a�� ���������� �������.
		 * 
		 * @param numOfOperation ������ ����
		 * @param operations ������ �����
		 */
		public void solution(int numOfOperation, Operation[] operations) {
			int count = 2;
			HashSet<Integer> branchs = new HashSet<>();
			PriorityQueue<Integer> possibleUseNumber = new PriorityQueue<>();
			PriorityQueue<Integer> result = new PriorityQueue<>();

			branchs.add(1);
			for (int i = 0; i < numOfOperation; i++) {
				Operation cur = operations[i];
				// branch�� count�� possibleUseNumber�� �� �� ���� ��ȣ�� ���������� �����Ѵ�.
				if (cur.type == OperationType.branch) {
					if (possibleUseNumber.isEmpty()) {
						branchs.add(count++);
					} else {
						branchs.add(possibleUseNumber.poll());
					}
				} else {
					// merge�� ���������� ������Ƿ� possibleUseNumber�� ��ȣ�� �߰��Ѵ�.
					possibleUseNumber.add(cur.value);
					// branchs���� ���������� �����Ѵ�.
					branchs.remove(cur.value);
				}
			}

			for (int key : branchs) {
				result.add(key);
			}
			while (!result.isEmpty()) {
				System.out.print(result.poll() + " ");
			}
		}
	}

	static class Operation {
		OperationType type;
		Integer value;

		public Operation(OperationType type, Integer value) {
			this.type = type;
			this.value = value;
		}
	}

	static enum OperationType {
		branch, merge;
	}
}
