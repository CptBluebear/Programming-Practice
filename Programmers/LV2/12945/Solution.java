import java.util.HashMap;
import java.util.Map;

class Solution {

	Map<Integer, Integer> dp = new HashMap<>();

	public Solution() {
		dp.put(0, 0);
		dp.put(1, 1);
	}

	public int solution(int n) {
		int result;
		if (dp.containsKey(n)) {
			result = dp.get(n);
		} else {
			result = (solution(n - 1) + solution(n - 2)) % 1234567;
			dp.put(n, result);
		}
		return result;
	}
}