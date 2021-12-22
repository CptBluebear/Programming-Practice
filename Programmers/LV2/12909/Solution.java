class Solution {
	boolean solution(String s) {
		int pivot = -1;
		int cnt = 0;
		while (++pivot != s.length()) {
			if (s.charAt(pivot) == '(') {
				cnt++;
			} else {
				if (cnt == 0) {
					return false;
				} else {
					cnt--;
				}
			}
		}
		if (cnt != 0) {
			return false;
		}
		return true;
	}
}