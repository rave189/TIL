package techcourseTest;

public class Main2 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] log = // { "08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11" };
				{ "01:00", "08:00", "15:00", "15:04", "23:00", "23:59" };
		System.out.println(s.solution(log));
	}

	static class Solution {
		/**
		 * 애플리케이션을 활용하여 공부를 시작할때와 종료할 때를 기록할 수 있다.
		 * 하지만 5분 미만으로 공부한 시간은 포함시키지 않고, 1시간 45분 초과는 1시간 45분만 추가하려고 한다.
		 * 이 때, 실제 공부한 시간을 구하는 문제
		 * @param log 애플리케이션의 시작과 종료 로그(항상 [시작, 종료, 시작, 종료 ... 종료]로 입력이 주어진다.)
		 * @return 실제 공부한 시간을 HH:MM으로 출력
		 */
		public String solution(String[] log) {
			int realStudyTime = 0;
			for (int i = 1; i < log.length; i += 2) {
				int start = strTimeToMinute(log[i - 1]);
				int end = strTimeToMinute(log[i]);
				int diff = end - start;
				if (5 <= diff && diff <= 105)
					realStudyTime += diff;
				else if (diff > 105)
					realStudyTime += 105;
			}
			return minuteToTime(realStudyTime);
		}

		public int strTimeToMinute(String time) {
			String hour = time.substring(0, 2);
			String minute = time.substring(3);
			return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
		}

		public String minuteToTime(int totalMinute) {
			int hour = totalMinute / 60;
			int minute = totalMinute % 60;
			return String.format("%02d", hour) + ":" + String.format("%02d", minute);
		}
	}
}