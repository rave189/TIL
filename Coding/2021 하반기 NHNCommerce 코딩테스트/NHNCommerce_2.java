package NHNCommerceTest;

import java.util.HashSet;
import java.util.Scanner;

/**
 * n명의 번호 가입 신청자가 들어온다.
 * 번호는 중복될 수 없고, 중복된 번호는 가입시키지 않는다.
 * 번호가 m개 등록되는 순간이 몇 번째 손님인지 구하는 문제
 * @author Rave
 *
 */
public class Main2 {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int tn = scanner.nextInt();
		for (int caseNum = 1; caseNum <= tn; caseNum++) {
			testCase(caseNum);
		}
	}

	public static void testCase(int caseNum) {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		HashSet<String> hash = new HashSet<>();
		int idx = 1;
		for (; idx <= n; idx++) {
			hash.add(scanner.next());
			if (hash.size() == m)
				System.out.println(idx);
		}
	}
}
