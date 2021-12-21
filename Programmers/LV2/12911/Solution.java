class Solution {
	public int solution(int n) {
		int current = countNumber(n);
		while (current != countNumber(++n));
		return n;
	}

	private int countNumber(int n) {
		int result = 0;
		while (n != 0) {
			if (n % 2 == 1) {
				result++;
			}
			n /= 2;
		}
		return result;
	}
}