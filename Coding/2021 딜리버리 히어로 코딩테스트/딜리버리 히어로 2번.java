package DeliveryHeroTest;

import java.util.HashMap;

/**
 * byte크기 생성날짜 파일 이름으로 여러 개의 입력이 하나의 String으로 묶여서 들어온다.
 * 날짜가 1990년 1월 31일 이후에 생성되었고
 * 파일의 크기가 240*2^10보다 큰 파일의 개수를 출력하는 문제
 * 이러한 파일이 하나도 없다면 NO FILES를 출력한다.
 * @author Rave
 *
 */
public class Main2 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String S = " 779091968 23 Sep 2009 system.zip\n 284164096 14 Aug 2013 to-do-list.xml\n 714080256 19 Jun 2013 blockbuster.mpeg\n       329 12 Dec 2010 notes.html\n 444596224 17 Jan 1950 delete-this.zip\n       641 24 May 1987 setup.png\n    245760 16 Jul 2005 archive.zip\n 839909376 31 Jan 1990 library.dll";
		System.out.println(s.solution(S));
	}

	static class Solution {
		HashMap<String, Integer> hash = new HashMap<>();
		String[] Months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		int minByteSize = 240 * 1024;

		public String solution(String S) {
			int answer = 0;
			init();
			String[] line = S.split("\\n");
			// 한 줄을 잘라 조건과 부합하는지 검사한다.
			for (int i = 0; i < line.length; i++) {
				String[] split = line[i].trim().split(" ");
				int size = Integer.parseInt(split[0]);
				int day = Integer.parseInt(split[1]);
				int month = hash.get(split[2]);
				int year = Integer.parseInt(split[3]);
				boolean checkByteSize = size >= minByteSize;
				boolean checkDate = isOverDate(year, month, day);
				answer = checkByteSize && checkDate ? answer + 1 : answer;
			}
			return answer == 0 ? "NO FILES" : Integer.toString(answer);
		}

		public void init() {
			for (int i = 0; i < Months.length; i++)
				hash.put(Months[i], i + 1);
		}

		/**
		 * 날짜가 1990년 1월 31일 보다 뒤인지 검사하는 메소드
		 */
		public boolean isOverDate(int year, int month, int day) {
			if (year > 1990)
				if (month >= 2)
					if (day >= 1)
						return true;
			return false;
		}
	}
}