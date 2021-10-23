package NHNCodingTest;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Main1 {

	public static void main(String[] args) {
	}

	static class Solution {
		/**
		 * 나뭇가지에 2가지 연산을 적용시키려고 한다.
		 * 처음에는 1번 나뭇가지만 있는 상태에서 시작한다.
		 * branch : 1번 나뭇가지에 하나의 나뭇가지를 덧붙인다. 이 때 만들어지는 나뭇가지는
		 * 			현재 붙일 수 있는 번호 중 가장 작은 번호가 된다.
		 * merge a : a번 나뭇가지를 1번 나뭇가지에 합친다. 합친 후에 a번 나뭇가지는 사라진다.
		 * 
		 * @param numOfOperation 연산의 개수
		 * @param operations 실행할 연산들
		 */
		public void solution(int numOfOperation, Operation[] operations) {
			int count = 2;
			HashSet<Integer> branchs = new HashSet<>();
			PriorityQueue<Integer> possibleUseNumber = new PriorityQueue<>();
			PriorityQueue<Integer> result = new PriorityQueue<>();

			branchs.add(1);
			for (int i = 0; i < numOfOperation; i++) {
				Operation cur = operations[i];
				// branch면 count와 possibleUseNumber의 수 중 작은 번호의 나뭇가지를 생성한다.
				if (cur.type == OperationType.branch) {
					if (possibleUseNumber.isEmpty()) {
						branchs.add(count++);
					} else {
						branchs.add(possibleUseNumber.poll());
					}
				} else {
					// merge면 나뭇가지가 사라지므로 possibleUseNumber에 번호를 추가한다.
					possibleUseNumber.add(cur.value);
					// branchs에서 나뭇가지를 삭제한다.
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
