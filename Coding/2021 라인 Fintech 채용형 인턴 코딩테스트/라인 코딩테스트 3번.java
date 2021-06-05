package LineInternTest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * N���� ������ Ǯ������ �˰����� �����ؾ� �Ѵ�.
 * �� �� �ð��� ������ ���Ѻ��� ���� ���� ������ �˰����� ���ϴ� ����
 * @author Rave
 *
 */
public class Main3 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n =  2;
				//3;
		String[] data =  { "a1 1 5 9", "a2 1 9 5", "b1 2 3 3" };
				//{ "a1 1 5 5", "b1 2 1 1", "c1 3 5 1" };
		String limit =  "0 10";
				//"10 10";
		String[] result = s.solution(n, data, limit);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}

	static class Solution {
		HashMap<Integer, Algo> hash = new HashMap<>();
		int totalSum = Integer.MAX_VALUE;
		ArrayList<String> answer = new ArrayList<>();
		Algo[] algoList;
		int n;
		int timeLimit;
		int spaceLimit;

		public String[] solution(int n, String[] data, String limit) {
			init(n, data, limit);
			BruteForce(0, 0, 0);
			return answer.toArray(new String[answer.size()]);
		}
		
		/**
		 * �ʱⰪ�� �����ϴ� �޼ҵ�
		 * @param n Ǯ����ϴ� ������ ����
		 * @param data �˰��� �̸�, ���� ��ȣ, �ɸ��� �ð�, ����ϴ� ������ ������ ��� �迭
		 * @param limit �ð����� ���������� ��� ����, 0�̸� ������ ���ٴ� �ǹ��̴�.
		 */
		public void init(int n, String[] data, String limit) {
			algoList = new Algo[data.length];
			for (int i = 0; i < data.length; i++) {
				String[] split = data[i].split(" ");
				String name = split[0];
				int id = Integer.parseInt(split[1]);
				int time = Integer.parseInt(split[2]);
				int space = Integer.parseInt(split[3]);
				algoList[i] = new Algo(name, id, time, space);
			}
			String[] split = limit.split(" ");
			timeLimit = Integer.parseInt(split[0]);
			spaceLimit = Integer.parseInt(split[1]);
			this.n = n;
		}

		/**
		 * ����ؾ��ϴ� �˰����� ���Ʈ ������ Ž���Ѵ�.
		 * @param depth ������ �˰����� ��
		 * @param timeSum ����� �ð�
		 * @param spaceSum ����� ����
		 */
		public void BruteForce(int depth, int timeSum, int spaceSum) {
			if (depth == n) {
				// �ð��� ���� ����� ���Ѻ��� �Ʒ�����
				if (validCheck(timeSum, timeLimit) && validCheck(spaceSum, spaceLimit))
					// �� ���� ����ϴ� �˰�������
					if (timeSum + spaceSum < totalSum) {
						answer.clear();
						for (int i = 0; i < n; i++)
							answer.add(hash.get(i + 1).name);
						totalSum = timeSum + spaceSum;
					}
				return;
			}

			for (int i = 0; i < algoList.length; i++) {
				if (hash.containsKey(algoList[i].id))
					continue;
				Algo algo = algoList[i];
				hash.put(algo.id, algo);
				BruteForce(depth + 1, timeSum + algo.time, spaceSum + algo.space);
				hash.remove(algo.id);
			}
		}

		/**
		 * value���� limit���� ���� �� ���Ͽ� ��ȿ�� ������ Ȯ���ϴ� �޼ҵ�
		 * @param value Ȯ���� ��
		 * @param limit ����
		 * @return ��ȿ�ϴٸ� true, �ƴ϶�� false
		 */
		public boolean validCheck(int value, int limit) {
			if (limit == 0)
				return true;
			return value <= limit;
		}
	}
}

class Algo {
	String name;
	int id, time, space;

	public Algo(String _name, int _id, int _time, int _space) {
		this.name = _name;
		this.id = _id;
		this.time = _time;
		this.space = _space;
	}
}
