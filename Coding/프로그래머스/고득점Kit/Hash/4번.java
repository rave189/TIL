package Programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		int[] answer = s.solution(genres, plays);
		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}
}

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Total> hash = new HashMap<>();
		Queue<String> keys = new LinkedList<String>();
		for (int i = 0; i < genres.length; i++) {
			if (hash.containsKey(genres[i])) {
				Total item = hash.get(genres[i]);
				item.total += plays[i];
				item.songList.add(new Type(i, plays[i]));
				hash.replace(genres[i], item);
			} else {
				Total item = new Total(plays[i]);
				keys.add(genres[i]);
				item.songList.add(new Type(i, plays[i]));
				hash.put(genres[i], item);
			}
		}
		PriorityQueue<Total> totalList = new PriorityQueue<Total>();
		for (String key : keys)
			totalList.add(hash.get(key));
		Queue<Integer> bestAlbum = new LinkedList<Integer>();
		while (!totalList.isEmpty()) {
			Total cur = totalList.poll();
			for (int i = 0; i < 2; i++)
				if (!cur.songList.isEmpty())
					bestAlbum.add(cur.songList.poll().index);
		}
		int[] answer = new int[bestAlbum.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = bestAlbum.poll();
		return answer;
	}
}

class Total implements Comparable<Total> {
	PriorityQueue<Type> songList = new PriorityQueue<Type>(new Comparator<Type>() {
		@Override
		public int compare(Type o1, Type o2) {
			if (o1.count > o2.count)
				return -1;
			else if (o1.count == o2.count) {
				if (o1.index < o2.index)
					return -1;
				else if (o1.index == o2.index)
					return 0;
				else
					return 1;
			} else
				return 1;
		}
	});
	int total;

	public Total(int _total) {
		this.total = _total;
	}

	@Override
	public int compareTo(Total o) {
		if (total > o.total)
			return -1;
		else if (total == o.total)
			return 0;
		else
			return 1;
	}

	public String toString() {
		return total + " " + songList.toString();
	}
}

class Type implements Comparable<Type> {
	int index;
	int count;

	public Type(int _index, int _count) {
		this.index = _index;
		this.count = _count;
	}

	@Override
	public int compareTo(Type o) {
		if (this.count > o.count)
			return -1;
		else if (this.count == o.count) {
			if (this.index < o.index)
				return -1;
			else if (this.index == o.index)
				return 0;
			else
				return 1;
		} else
			return 1;
	}

	public String toString() {
		return index + " " + count;
	}
}