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
		 * ���ø����̼��� Ȱ���Ͽ� ���θ� �����Ҷ��� ������ ���� ����� �� �ִ�.
		 * ������ 5�� �̸����� ������ �ð��� ���Խ�Ű�� �ʰ�, 1�ð� 45�� �ʰ��� 1�ð� 45�и� �߰��Ϸ��� �Ѵ�.
		 * �� ��, ���� ������ �ð��� ���ϴ� ����
		 * @param log ���ø����̼��� ���۰� ���� �α�(�׻� [����, ����, ����, ���� ... ����]�� �Է��� �־�����.)
		 * @return ���� ������ �ð��� HH:MM���� ���
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