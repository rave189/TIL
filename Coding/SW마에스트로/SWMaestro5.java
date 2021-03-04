package Test;

import java.util.HashMap;
import java.util.Scanner;

public class SWMaestro5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Integer, Integer> totalMole = new HashMap<>();
		for (int i = 0; i < n * n; i++) {
			int score = sc.nextInt();
			int moleCnt = sc.nextInt();
			for (int j = 0; j < moleCnt; j++) {
				int time = sc.nextInt();
				totalMole.putIfAbsent(time, score);
				totalMole.replace(time, Math.max(score, totalMole.get(time)));
			}
		}
		int answer = 0;
		for (int time : totalMole.keySet())
			answer += totalMole.get(time);
		System.out.println(answer);
	}
}