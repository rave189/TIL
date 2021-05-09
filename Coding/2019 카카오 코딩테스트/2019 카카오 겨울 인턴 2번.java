package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 2019 īī�� �ܿ� ���� ����
 * Ʃ���� (a1, a2, a3, ... an)�� ���� ��Ÿ�� �� �ִ�.
 * �ߺ��Ǵ� ���Ұ� ���� Ʃ���� �־����ٸ� ������ ���� ���� ��ȣ�� �̿��� ǥ���� �� �ִ٤�
 * {{a1}, {a1, a2}, {a1, a2, a3}, ... {a1, a2, a3, a4, ..., an}}
 * Ư�� Ʃ���� ǥ���ϴ� ������ �־��� ��, Ʃ���� ���ϴ� ����
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
	 * ������ ���ڿ��� �־��� ��, ������ ����Ű�� Ʃ���� ���Ѵ�.
	 * @param s ����
	 * @return Ʃ��
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
	 * ���ڷ� �־��� s�� ���պ��� ������ ��ȯ�ϴ� �޼ҵ�
	 * {2},{2, 1} -> {2}�� {2, 1}�� �������ش�.
	 * @param s ��������� ���ڿ�
	 * @return ���պ��� �������� �迭
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