public static int solution(int k, int[] score) {
		int answer = score.length;
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int[] arr = new int[score.length];
		for (int i = 1; i < score.length; i++) {
			arr[i] = Math.abs(score[i] - score[i - 1]);
			if (hash.containsKey(arr[i]))
				hash.replace(arr[i], hash.get(arr[i]) + 1);
			else
				hash.put(arr[i], 1);
		}
		for (int i = 1; i < arr.length; i++) {
			int count = hash.get(arr[i]);
			if (count >= k) {
				if (arr[i] == 0 && arr[i - 1] == 0) {
				} else if (arr[i] == 0 || arr[i - 1] == 0)
					answer--;
				else
					answer -= 2;
				arr[i] = 0;
				arr[i - 1] = 0;
			}
		}
		if (arr[1] == 0)
			answer--;
		return answer;
	}
