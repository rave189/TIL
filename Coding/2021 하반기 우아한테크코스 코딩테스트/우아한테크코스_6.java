package techcourseTest;

public class Main6 {

	public static void main(String[] args) {
		Solution s = new Solution();
		double time = 3.5;
		String[][] plans = { { "ȫ��", "11PM", "9AM" }, { "������", "3PM", "2PM" } };
		System.out.println(s.solution(time, plans));
	}

	static class Solution {
		double[] monday = { 13, 18 };
	    double[] friday = { 9.5, 18 };

	    /**
	     * �ð��� �ް��� ��Ǵ� ȸ�翡�� �ݿ��ϳ� ����Ͽ� �����ϳ� �����ϴ� ������ ������ ������ �Ѵ�.
	     * �� ��, ���� ���������� �� �� �ִ� �������� ���ϴ� ����
	     * 
	     * ���� ����� ������ �� �� ������ ��� ���ٰ� ����� ���� �������� ���ϴ� ����
	     * �� �� �ִ°� �� ã�ٰ� �������� �߰��� ����⸦ ã�� ���� �𸣰���.
	     * �Ƹ� 1���ΰ� ���Ƽ� 1������ ������
	     * @param time ���� �ް� �ð�
	     * @param plans ����� ����
	     * @return ������ ������
	     */
	    public String solution(double time, String[][] plans) {
	        String answer = "";
	        for (String[] plan : plans) {
	            String country = plan[0];
	            int start = strTimeToHour(plan[1]);
	            int end = strTimeToHour(plan[2]);
	            double totalTime = 0;
	            if (start < friday[0])
	                totalTime += friday[1] - friday[0];
	            else if (friday[0] <= start && start <= friday[1])
	                totalTime += friday[1] - start;
	            if (monday[0] <= end && end <= monday[1])
	                totalTime += end - monday[0];
	            else if (monday[1] < end)
	                totalTime += monday[1] - monday[0];
	            if (totalTime <= time) {
	                time -= totalTime;
	                answer = country;
	            }
	        }
	        return answer;
	    }

	    /**
	     * 12�ð����� ǥ��� �ð��� 24�ð����� �ٲ��ִ� �޼ҵ�
	     * @param time 12�ð����� ǥ��� �ð�
	     * @return 24�ð��� �ð�
	     */
	    public int strTimeToHour(String time) {
	        int hour = -1;
	        if (time.length() == 3) {
	            hour = time.charAt(0) - '0';
	            if (time.substring(1).equals("PM"))
	                hour += 12;
	        } else {
	            hour = Integer.parseInt(time.substring(0, 2));
	            if (time.substring(2).equals("PM"))
	                hour += 12;
	        }
	        return hour;
	    }
	}
}