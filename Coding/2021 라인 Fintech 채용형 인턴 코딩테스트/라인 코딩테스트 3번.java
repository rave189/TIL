package LineInternTest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * N개의 문제를 풀기위해 알고리즘을 선택해야 한다.
 * 이 때 시간과 공간의 제한보다 적게 쓰는 최적의 알고리즘을 구하는 문제
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
		 * 초기값을 설정하는 메소드
		 * @param n 풀어야하는 문제의 개수
		 * @param data 알고리즘 이름, 고유 번호, 걸리는 시간, 사용하는 공간의 정보가 담긴 배열
		 * @param limit 시간제한 공간제한이 담긴 정보, 0이면 제한이 없다는 의미이다.
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
		 * 사용해야하는 알고리즘을 브루트 포스로 탐색한다.
		 * @param depth 선택한 알고리즘의 수
		 * @param timeSum 사용한 시간
		 * @param spaceSum 사용한 공간
		 */
		public void BruteForce(int depth, int timeSum, int spaceSum) {
			if (depth == n) {
				// 시간과 공간 사용이 제한보다 아래인지
				if (validCheck(timeSum, timeLimit) && validCheck(spaceSum, spaceLimit))
					// 저 적게 사용하는 알고리즘인지
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
		 * value값이 limit보다 작은 지 구하여 유효한 값인지 확인하는 메소드
		 * @param value 확인할 값
		 * @param limit 제한
		 * @return 유효하다면 true, 아니라면 false
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
