class Solution {
	public int[] solution(int n) {

		int[] answer = new int[(n + 1) * n / 2];
		int[][] arr = new int[n][n];

		boolean flag1 = false;
		boolean flag2 = false;

		int cnt = 1;
		int x = -1;
		int y = 0;

		while (n > 0) {
			if (!flag1) {
				for (int i = 0; i < n; i++) {
					arr[++x][y] = cnt++;
				}
				flag1 = true;
			} else if (!flag2) {
				for (int i = 0; i < n; i++) {
					arr[x][++y] = cnt++;
				}
				flag2 = true;
			} else {
				for (int i = 0; i < n; i++) {
					arr[--x][--y] = cnt++;
				}
				flag1 = false;
				flag2 = false;
			}
			n--;
		}
		int index = 0;
		Loop1:
		for (int[] a : arr) {
			for (int num : a) {
				if (num == 0) {
					continue Loop1;
				}
				answer[index++] = num;
			}
		}
		return answer;
	}
}