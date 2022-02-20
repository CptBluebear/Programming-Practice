class Solution {

	private int zero = 0;
	private int one = 0;

	public int[] solution(int[][] arr) {
		func(arr, 0, arr.length - 1, 0, arr.length - 1);
		int[] answer = {zero, one};
		return answer;
	}

	private void func(int[][] arr, int hStart, int hEnd, int wStart, int wEnd) {
		if (hStart == hEnd) {
			if (arr[hStart][wStart] == 0) {
				zero++;
			} else {
				one++;
			}
		} else {
			if (isSame(arr, hStart, hEnd, wStart, wEnd)) {
				if (arr[hStart][wStart] == 0) {
					zero++;
				} else {
					one++;
				}
			} else {
				int hMid = (hStart + hEnd) / 2;
				int wMid = (wStart + wEnd) / 2;
				func(arr, hStart, hMid, wStart, wMid);
				func(arr, hMid + 1, hEnd, wStart, wMid);
				func(arr, hStart, hMid, wMid + 1, wEnd);
				func(arr, hMid + 1, hEnd, wMid + 1, wEnd);
			}
		}
	}

	private boolean isSame(int[][] arr, int hStart, int hEnd, int wStart, int wEnd) {
		int num = arr[hStart][wStart];
		for (int i = hStart; i <= hEnd; i++) {
			for (int j = wStart; j <= wEnd; j++) {
				if (num != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}