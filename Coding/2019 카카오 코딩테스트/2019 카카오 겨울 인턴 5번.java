package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2019년 카카오 겨울 인턴 문제
 * 징검다리를 건너려고 할 때 최대 몇명의 니니즈가 징검다리를 건널 수 있는지 구하는 문제
 * 징검다리는 다음과 같은 규칙으로 건넌다.
 * 1.징검다리는 일렬로 놓여 있고 각 징검다리의 디딤돌에는 모두 숫자가 적혀 있으며 디딤돌의 숫자는 한 번 밟을 때마다 1씩 줄어듭니다.
 * 1.디딤돌의 숫자가 0이 되면 더 이상 밟을 수 없으며 이때는 그 다음 디딤돌로 한번에 여러 칸을 건너 뛸 수 있습니다.
 * 3.단, 다음으로 밟을 수 있는 디딤돌이 여러 개인 경우 무조건 가장 가까운 디딤돌로만 건너뛸 수 있습니다.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		System.out.println(s.solution(stones, k));
	}
}

class Solution {
	/**
	 * 입력 범위
	 * 니니즈 친구들은 무제한
	 * stones 배열의 크기는 20만 이하인 자연수
	 * stones 각 원소의 값은 2억 이하인 자연수
	 * k는 1이상 stones의 길이 이하인 자연수
	 * @param stones 징검다리의 각 원소의 값
	 * @param k 최대로 건너뛸 수 있는 징검다리의 수
	 * @return 최대로 건널 수 있는 니니즈 친구들의 수
	 */
	public int solution(int[] stones, int k) {
		int left = 1;
		int right = 200000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			int zeroCnt = 0;
			boolean isPossible = true;
			for (int value : stones) {
				if (value - mid <= 0) {
					zeroCnt++;
					if (zeroCnt == k)
						isPossible = false;
				} else
					zeroCnt = 0;
			}
			if (isPossible)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left;
	}
}