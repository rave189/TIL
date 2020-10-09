public static int[] solution(int N) {
		int[] answer = new int[2];
		int max = 0;
		for (int i = 2; i < 10; i++) {
			int num = multiply(N, i, "");
			if (num >= max) {
				max = num;
				answer[0] = i;
				answer[1] = num;
			}
		}
		return answer;
	}

	public static int multiply(int N, int k, String s) {
		if (N > 1)
			return multiply(N / k, k, s + (N % k));
		else {
			int result = 1;
			for (int i = s.length() - 1; i >= 0; i--) {
				char ch = s.charAt(i);
				if (ch != '0')
					result *= Integer.parseInt(s.substring(i, i + 1));
			}
			return result;
		}
	}
