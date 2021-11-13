package Street11Test;

public class Main1 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {1000000000, 999999999};
		System.out.println(s.solution(A));

	}
	static class Solution {
		/**
		 * N���� ���� �̷���� �迭 A�� �ִ�.
		 * �� �迭���� ���� ū ¦���� ���� ū Ȧ���� ���� ��ȯ�ϴ� ����
		 * @param A �迭
		 * @return ���� ū ¦���� ���� ū Ȧ���� ��
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
