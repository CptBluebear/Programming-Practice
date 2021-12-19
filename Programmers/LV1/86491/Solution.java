class Solution {
	public int solution(int[][] sizes) {
		for (int[] size : sizes) {
			if (size[0] < size[1]) {
				int tmp = size[0];
				size[0] = size[1];
				size[1] = tmp;
			}
		}
		int max1 = 0;
		int max2 = 0;
		for (int[] size : sizes) {
			max1 = Math.max(size[0], max1);
			max2 = Math.max(size[1], max2);
		}
		return max1 * max2;
	}
}