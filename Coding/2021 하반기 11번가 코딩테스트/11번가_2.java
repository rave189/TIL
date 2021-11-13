package Street11Test;

import java.util.ArrayList;

public class Main2 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String S = //"babaa";
				//"bbbab";
				"bbbaaabbb";
		System.out.println(s.solution(S));
	}

	static class Solution {
		/**
		 * S�� a�� b�� �̷���� �ִ�.
		 * �� ��, ���ӵ� ������ ���ڵ��� ���� ����� �̷� �� �ֵ��� ������.
		 * ������ ��ϵ� �� ���� �� ����� ���̸�ŭ ��� ��Ͽ� ����� �߰����ַ��� �Ѵ�.
		 * �߰��ؾ��ϴ� ����� �ּ� ������ ���ϴ� ����
		 * @param S
		 * @return
		 */
		public int solution(String S) {
			ArrayList<Integer> countList = new ArrayList<>();
			char prev = S.charAt(0);
			int count = 1;
			int max = 0;
			for (int idx = 1; idx < S.length(); idx++) {
				char compare = S.charAt(idx);
				if (compare != prev) {
					countList.add(count);
					max = Math.max(max, count);
					count = 1;
					prev = compare;
				} else
					count++;
			}
			if (prev == S.charAt(S.length() - 1)) {
				countList.add(count);
				max = Math.max(max, count);
			}
			int answer = 0;
			for (int value : countList)
				answer += max - value;
			return answer;
		}
	}
}
