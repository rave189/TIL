package Programmers;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] phone_book = 
			//{ "123", "4565245", "456" };
			//{"119", "97674223", "1195524421"};
			{"12","123","1235","567","88"};
		System.out.println(s.solution(phone_book));
	}
}

class Solution {
	/**
	 * 전화번호부에 적힌 전화번호 중 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하는 메소드
	 * @param phone_book 전화번호부
	 * @return true=접두어인 번호가 없는 경우, false=접두어인 번호가 있는 경우
	 */
	public boolean solution(String[] phone_book) {
		HashSet<String> hash = new HashSet<String>();
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book.length; j++)
				if (i != j && phone_book[j].length() >= phone_book[i].length()) {
					hash.add(phone_book[j].substring(0, phone_book[i].length()));
					if (hash.contains(phone_book[i]))
						return false;
				}
			hash.clear();
		}
		return true;
	}
}