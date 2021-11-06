package techcourseTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main4 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String ss = //"aaabbaaa";
		 "wowwow";
		int[] result = s.solution(ss);
		for (int v : result)
			System.out.println(v);
	}

	static class Solution {
		Map<Integer, Integer> hash = new HashMap<>();

		/**
		 * ó���� ���� �̾����ִ� ���ڿ� s�� �־�����. (����)
		 * �� ���ڿ����� ���� ���ڰ� ������ �ִ� ������ ���̸� ���Ϸ��� �Ѵ�.
		 * �� ������ ���̵��� ������������ ����ϴ� ����
		 * @param s ���ڿ�
		 * @return ������������ ���ĵ� ���� ���ڰ� �������� ������ ������ ����
		 */
		public int[] solution(String s) {
			for (int i = 0; i < s.length();) {
				int start = i;
				char ch = s.charAt(i);
				for (; i < s.length(); i++) {
					if (ch != s.charAt(i))
						break;
				}
				// �� �ڿ� Ž���� ���ӵ� ���ڿ� ó�� Ž���� ���ڰ� ������ �̾��ش�.
				if (i == s.length() && ch == s.charAt(0)) {
					hash.put(start, hash.get(0));
					hash.remove(0);
				}
				// �ƴ϶�� �׳� �߰�
				else
					hash.put(start, i);
			}
			ArrayList<Integer> answer = new ArrayList<>();
			for (int key : hash.keySet()) {
				int value = hash.get(key);
				// key�� ũ�ٴ� ���� ó���� �������� �̾��� �ִٴ� ��
				// �׷� length - key���ٰ� value�� ���Ͽ� ���̸� ���� �� �ִ�.
				answer.add(value >= key ? value - key : value + s.length() - key);
			}
			answer.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
			return answer.stream().mapToInt(v -> v.intValue()).toArray();
		}
	}
}