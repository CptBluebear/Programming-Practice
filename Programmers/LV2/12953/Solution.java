import java.util.HashMap;
import java.util.Map;

class Solution {

	private static final int[] PRIMARY = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
		73, 79, 83, 89, 97};

	public int solution(int[] arr) {
		int answer = 1;
		Map<Integer, Integer> results = new HashMap<>();
		for (int num : arr) {
			Map<Integer, Integer> prime = primeFactorization(num);
			for (Integer key : prime.keySet()) {
				results.put(key,
					results.getOrDefault(key, 0) > prime.get(key) ? results.getOrDefault(key, 0) : prime.get(key));
			}
		}
		for (int key : results.keySet()) {
			answer *= Math.pow(key, results.get(key));
		}
		return answer;
	}

	private Map<Integer, Integer> primeFactorization(int num) {
		Map<Integer, Integer> results = new HashMap<>();
		for (int primeNum : PRIMARY) {
			while (num % primeNum == 0) {
				results.put(primeNum, results.getOrDefault(primeNum, 0) + 1);
				num /= primeNum;
			}
			if (num == 1) {
				break;
			}
		}
		return results;
	}
}