package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 2019 카카오 겨울 인턴 문제
 * 튜플은 (a1, a2, a3, ... an)과 같이 나타낼 수 있다.
 * 중복되는 원소가 없는 튜플이 주어진다면 다음과 같이 집합 기호를 이용해 표현할 수 있다ㅓ
 * {{a1}, {a1, a2}, {a1, a2, a3}, ... {a1, a2, a3, a4, ..., an}}
 * 특정 튜플을 표현하는 집합이 주어질 때, 튜플을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution solution = new Solution();
		String s = // "{{2},{2,1},{2,1,3},{2,1,3,4}}";
					// "{{1,2,3},{2,1},{1,2,4,3},{2}}";
					// "{{20,111},{111}}";
					// "{{123}}";
				"{{4,2,3},{3},{2,3,4,1},{2,3}}";
		int[] result = solution.solution(s);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}
}

class Solution {
	/**
	 * 집합이 문자열로 주어질 때, 집합이 가리키는 튜플을 구한다.
	 * @param s 집합
	 * @return 튜플
	 */
	public int[] solution(String s) {
		ArrayList<Integer> answer = new ArrayList<>();
		String[] split = splitStr(s.substring(1, s.length() - 1));
		Arrays.sort(split, (a, b) -> a.length()-b.length());
		for (int i = 0; i < split.length; i++) {
			StringTokenizer st = new StringTokenizer(split[i], "{,}");
			while (st.hasMoreTokens()) {
				int next = Integer.parseInt(st.nextToken());
				if (!answer.contains(next))
					answer.add(next);
			}
		}
		return answer.stream().mapToInt(v -> v.intValue()).toArray();
	}

	/**
	 * 인자로 주어진 s를 집합별로 나누어 반환하는 메소드
	 * {2},{2, 1} -> {2}과 {2, 1}로 나누어준다.
	 * @param s 나누어야할 문자열
	 * @return 집합별로 나누어진 배열
	 */
	public String[] splitStr(String s) {
		ArrayList<String> split = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ',')
				if (s.charAt(i - 1) == '}' && s.charAt(i + 1) == '{') {
					split.add(s.substring(0, i));
					s = s.substring(i + 1);
					i = -1;
				}
		}
		split.add(s);
		return split.toArray(new String[split.size()]);
	}
}