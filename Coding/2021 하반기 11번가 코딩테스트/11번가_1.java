package Street11Test;

public class Main1 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {1000000000, 999999999};
		System.out.println(s.solution(A));

	}
	static class Solution {
		/**
		 * N개의 수로 이루어진 배열 A가 있다.
		 * 이 배열에서 가장 큰 짝수와 가장 큰 홀수의 합을 반환하는 문제
		 * @param A 배열
		 * @return 가장 큰 짝수와 가장 큰 홀수의 합
		 */
	    public int solution(int[] A) {
	    	int maxOdd = 0;
	    	int maxEven = 0;
	    	for(int value : A) {
	    		if(value%2 == 0)
	    			maxEven = Math.max(maxEven, value);
	    		else
	    			maxOdd = Math.max(maxOdd, value);
	    	}
	    	return maxOdd+maxEven;
	    }
	}
}
