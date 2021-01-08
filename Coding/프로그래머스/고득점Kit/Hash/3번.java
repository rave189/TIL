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