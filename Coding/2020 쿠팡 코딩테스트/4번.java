public static int solution(String depar, String hub, String dest, String[][] roads) {
		int answer = 0;
		int hubCount = Search(depar, hub, roads);
		int destCount = Search(hub, dest, roads);
		answer = hubCount * destCount;
		return answer;
	}

	public static int Search(String from, String to, String[][] roads) {
		int count = 0;
		if (from.equals(to))
			return 1;
		for (int i = 0; i < roads.length; i++)
			if (roads[i][0].equals(from))
				count += Search(roads[i][1], to, roads);
		return count;
	}
