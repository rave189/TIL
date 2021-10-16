package ProgrammersTest;

import java.util.HashSet;

public class Main1 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] registered_list = // { "card", "ace13", "ace16", "banker", "ace17", "ace14" };
				// { "cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5" };
				// {"bird99", "bird98", "bird101", "gotoxy"};
				{ "apple1", "orange", "banana3" };
		String new_id = // "ace15";
				// "cow";
				// "bird98";
				"apple";
		System.out.println(s.solution(registered_list, new_id));
	}

	static class Solution {
		HashSet<String> hash = new HashSet<>();

		/**
		 * ��ϵ� id�� ���ο� id�� ���´�.
		 * id�� 3~6�ڸ��� ���ڿ� 3�ڸ�(?)������ ���ڷ� ���´�.
		 * ���� ���ο� id�� ��ϵ� id�� ���ԵǾ� �ִٸ� �� ���� �κ��� +1�Ѵ�.
		 * ���� ���� �۾��� ��ϵ� id�� ���������� ������ return ���ش�.
		 * @param registered_list ��ϵ� id��
		 * @param new_id ���� ���� id
		 * @return ������ id
		 */
		public String solution(String[] registered_list, String new_id) {
			for (String id : registered_list)
				hash.add(id);
			int sliceIdx = getIdx(new_id);
			String str = new_id.substring(0, sliceIdx);
			int num = sliceIdx == new_id.length() ? 0 : Integer.parseInt(new_id.substring(sliceIdx));
			while (hash.contains(new_id)) {
				new_id = str + ++num;
			}
			return new_id;
		}

		public int getIdx(String id) {
			for (int i = 0; i < id.length(); i++) {
				char ch = id.charAt(i);
				if ('0' <= ch && ch <= '9')
					return i;
			}
			return id.length();
		}
	}
}