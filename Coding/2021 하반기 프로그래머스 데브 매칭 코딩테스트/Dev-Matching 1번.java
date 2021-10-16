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
		 * 등록된 id와 새로운 id가 들어온다.
		 * id는 3~6자리의 문자와 3자리(?)까지의 숫자로 들어온다.
		 * 만약 새로운 id가 등록된 id에 포함되어 있다면 이 숫자 부분을 +1한다.
		 * 위와 같은 작업을 등록된 id가 없을때까지 돌리고 return 해준다.
		 * @param registered_list 등록된 id들
		 * @param new_id 새로 들어온 id
		 * @return 보정된 id
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