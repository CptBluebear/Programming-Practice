import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {

	Set<Integer> set = new HashSet<>();

	public int solution(String numbers) {
		combination("", numbers);
		int answer = 0;
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			if (isPrimary(iterator.next())) {
				answer++;
			}
		}
		return answer;
	}

	private void combination(String comb, String other) {
		if (!comb.equals("")) {
			set.add(Integer.parseInt(comb));
		}
		for (int i = 0; i < other.length(); i++) {
			combination(comb + other.charAt(i), other.substring(0, i) + other.substring(i + 1));
		}
	}

	private boolean isPrimary(int num) {
		if (num <= 1) {
			return false;
		}
		int max = (int)Math.sqrt(num) + 1;
		for (int i = 2; i < max; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}