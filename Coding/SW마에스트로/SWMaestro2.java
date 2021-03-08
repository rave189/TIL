package Test;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWMaestro2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder answer = new StringBuilder();
		int p = sc.nextInt();
		int n = sc.nextInt();
		int h = sc.nextInt();
		HashMap<Integer, PriorityQueue<Integer>> total = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int pc = sc.nextInt();
			int time = sc.nextInt();
			total.putIfAbsent(pc, new PriorityQueue<Integer>());
			total.get(pc).add(time);
		}
		for (int pc = 1; pc <= p; pc++) {
			int result = 0;
			PriorityQueue<Integer> wantTime = total.get(pc);
			while (!wantTime.isEmpty()) {
				int time = wantTime.poll();
				if (time > h)
					break;
				if (result + time <= h)
					result += time;
				else
					result = Math.max(result, time);
			}
			answer.append(pc + " " + result * 1000 + "\n");
		}
		System.out.println(answer);
	}
}