package techcourseTest;

public class Main6 {

	public static void main(String[] args) {
		Solution s = new Solution();
		double time = 3.5;
		String[][] plans = { { "홍콩", "11PM", "9AM" }, { "엘에이", "3PM", "2PM" } };
		System.out.println(s.solution(time, plans));
	}

	static class Solution {
		double[] monday = { 13, 18 };
	    double[] friday = { 9.5, 18 };

	    /**
	     * 시간제 휴가로 운영되는 회사에서 금요일날 출발하여 월요일날 도착하는 비행기로 여행을 가려고 한다.
	     * 이 때, 올해 마지막으로 갈 수 있는 여행지를 구하는 문제
	     * 
	     * 앞의 비행기 일정을 갈 수 있으면 계속 가다가 종료될 때의 여행지를 구하는 건지
	     * 갈 수 있는거 쭉 찾다가 마지막에 발견한 비행기를 찾는 건지 모르겟음.
	     * 아마 1번인거 같아서 1번으로 구현함
	     * @param time 남은 휴가 시간
	     * @param plans 비행기 일정
	     * @return 마지막 여행지
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
	     * 12시간제로 표기된 시간을 24시간제로 바꿔주는 메소드
	     * @param time 12시간제로 표기된 시간
	     * @return 24시간제 시간
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