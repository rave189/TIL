package DeliveryHeroTest;

import java.util.HashMap;

/**
 * byteũ�� ������¥ ���� �̸����� ���� ���� �Է��� �ϳ��� String���� ������ ���´�.
 * ��¥�� 1990�� 1�� 31�� ���Ŀ� �����Ǿ���
 * ������ ũ�Ⱑ 240*2^10���� ū ������ ������ ����ϴ� ����
 * �̷��� ������ �ϳ��� ���ٸ� NO FILES�� ����Ѵ�.
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
			// �� ���� �߶� ���ǰ� �����ϴ��� �˻��Ѵ�.
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
		 * ��¥�� 1990�� 1�� 31�� ���� ������ �˻��ϴ� �޼ҵ�
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