package Programmers;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 5;
		// 5;
		// 3;
		int[] lost = { 2, 4 };
		// { 2, 4 };
		// { 3 };
		int[] reserve = { 1, 3, 5 };
		// { 3 };
		// { 1 };
		System.out.println(s.solution(n, lost, reserve));
	}
}

class Solution {
	/**
	 * 학교에서 체육복이 도난당했다.
	 * 여분으로 체육복을 가져온 학생에게 빌려 체육 수업을 들으려고 할 때
	 * 몇 명의 학생이 체육 수업을 들을 수 있는지 구하는 문제
	 * @param n 학생 수
	 * @param lost 체육복을 잃어버린 학생
	 * @param reserve 여벌의 체육복이 있는 학생
	 * @return 체육 수업을 들을 수 있는 학생의 수
	 */
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] people = new int[n];
		for (int i = 0; i < lost.length; i++)
			people[lost[i] - 1]--;
		for (int i = 0; i < reserve.length; i++)
			people[reserve[i] - 1]++;
		for (int i = 0; i < n; i++) {
			if (people[i] > 0) {
				try {
					answer++;
					if (i > 0 && people[i - 1] < 0) {
						people[i - 1]++;
						people[i]--;
						answer++;
					} else if (people[i + 1] < 0) {
						people[i + 1]++;
						people[i]--;
					}
				} catch (Exception e) {
				}
			} else if (people[i] == 0)
				answer++;
		}
		return answer;
	}
}