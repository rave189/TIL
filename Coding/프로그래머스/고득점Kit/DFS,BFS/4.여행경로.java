package Programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[][] tickets = //{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] result = s.solution(tickets);
		for(int i=0; i<result.length; i++)
			System.out.print(result[i]+" ");
	}
}

class Solution {
	boolean[] check;
	ArrayList<String> result = new ArrayList<String>();
	
	/**
	 * �װ��� ������ ��� �迭�� �־��� ��
	 * ICN���� ����Ͽ� ��� �װ����� �̿��Ͽ� ���� ��θ� ¥���� �Ѵ�.
	 * �� �� ���װ�θ� ���ϴ� ����
	 * ���� ��ΰ� ���� ���� ��� ���ĺ��� �ռ��� ���� ��θ� ��ȯ�Ѵ�.
	 * @param tickets �װ��� ������ ��� �迭
	 * @return ��� �װ����� �̿��� ���� ���
	 */
	public String[] solution(String[][] tickets) {
		check = new boolean[tickets.length];
		Search("ICN", tickets);
		return result.toArray(new String[result.size()]);
	}
	
	public boolean Search(String next, String[][] tickets) {
		PriorityQueue<Point> sortList = new PriorityQueue<Point>();
		result.add(next);
		if(AllVisit())
			return true;
		for(int i=0; i<tickets.length; i++)
			if(!check[i] && next.compareTo(tickets[i][0]) == 0)
				sortList.add(new Point(tickets[i][1], i));
		
		while(!sortList.isEmpty()) {
			Point cur = sortList.poll();
			check[cur.index] = true;
			boolean done = Search(cur.value, tickets);
			if(done)
				return true;
			check[cur.index] = false;
		}
		result.remove(result.size()-1);
		return false;
	}
	
	public boolean AllVisit() {
		for(int i=0; i<check.length; i++)
			if(!check[i])
				return false;
		return true;
	}
}

class Point implements Comparable<Point>{
	String value;
	int index;
	
	public Point(String _value, int _index) {
		this.value = _value;
		this.index = _index;
	}

	@Override
	public int compareTo(Point o) {
		return value.compareTo(o.value);
	}
}