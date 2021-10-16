package ProgrammersTest;

import java.util.HashMap;
import java.util.HashSet;

public class Main2 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int leave = // 4;
				// 3;
				30;
		String day = // "FRI";
				// "SUN";
				"MON";
		int[] holidays = // { 6, 21, 23, 27, 28 };
				// {2, 6, 17, 29};
				{ 1, 2, 3, 4, 28, 29, 30 };
		System.out.println(s.solution(leave, day, holidays));
	}

	static class Solution {
		String[] dayTypeList = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
		HashMap<String, Integer> dayType = new HashMap<>();
		HashSet<Integer> holiday = new HashSet<>();
		int remainingLeave;

		/**
		 * 연차가 주어질 때 현재 달에서 가장 길게 휴가를 사용할 수 있는게 며칠인지 출력한다.
		 * @param leave 연차 사용가능 일
		 * @param day 현재 달의 첫 요일
		 * @param holidays 공휴일
		 * @return 가장 긴 휴가
		 */
		public int solution(int leave, String day, int[] holidays) {
			init(holidays, leave);
			int type = dayType.get(day);
			DateType start = new DateType(1, type);
			DateType end = getFirstEndDate(type);
			int answer = end.day - start.day;
			while (end.day <= 30) {
				if (!(holiday.contains(end.day) || end.type >= 5)) {
					if (remainingLeave == 0) {
						start = getNextStartDate(start);
					}
				}
				end = new DateType(end.day + 1, getNextDayType(end.type));
				answer = Math.max(answer, end.day - start.day);
			}
			return answer;
		}

		public void init(int[] holidays, int leave) {
			for (int day : holidays)
				holiday.add(day);
			for (int i = 0; i < dayTypeList.length; i++)
				dayType.put(dayTypeList[i], i);
			remainingLeave = leave;
		}

		public DateType getFirstEndDate(int dayType) {
			int end = 1;
			for (; remainingLeave > 0 && end <= 30; end++, dayType = getNextDayType(dayType)) {
				if (dayType >= 5 || holiday.contains(end))
					continue;
				remainingLeave--;
			}
			return new DateType(end, dayType);
		}

		public int getNextDayType(int type) {
			return (type + 1) % dayTypeList.length;
		}

		public DateType getNextStartDate(DateType start) {
			int curDay = start.day;
			int type = start.type;
			for (; curDay <= 30; curDay++, type = getNextDayType(type)) {
				if (type >= 5 || holiday.contains(curDay))
					continue;
				break;
			}
			return new DateType(curDay + 1, getNextDayType(type));
		}
	}

	static class DateType {
		int day, type;

		public DateType(int day, int type) {
			this.day = day;
			this.type = type;
		}

		@Override
		public String toString() {
			return "DateType [day=" + day + ", type=" + type + "]";
		}
	}
}