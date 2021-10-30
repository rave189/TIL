package NHNCommerceTest;

import java.util.HashSet;
import java.util.Scanner;

/**
 * n���� ��ȣ ���� ��û�ڰ� ���´�.
 * ��ȣ�� �ߺ��� �� ����, �ߺ��� ��ȣ�� ���Խ�Ű�� �ʴ´�.
 * ��ȣ�� m�� ��ϵǴ� ������ �� ��° �մ����� ���ϴ� ����
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
