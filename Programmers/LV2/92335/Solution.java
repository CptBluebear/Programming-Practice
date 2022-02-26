import java.math.BigInteger;
import java.util.Stack;

class Solution {
	public int solution(int n, int k) {
		int answer = 0;

		String[] numbers = convert(n, k).split("0");
		for (String number : numbers) {
			if (number.length() == 0) {
				continue;
			}
			BigInteger bigInteger = new BigInteger(number);
			if (bigInteger.isProbablePrime(10)) {
				answer++;
			}
		}
		return answer;
	}

	private String convert(int n, int k) {
		Stack<Integer> stack = new Stack<>();
		while (n != 0) {
			stack.push(n % k);
			n /= k;
		}
		StringBuilder stringBuilder = new StringBuilder();
		while (!stack.isEmpty()) {
			stringBuilder.append(stack.pop());
		}
		return stringBuilder.toString();
	}
}