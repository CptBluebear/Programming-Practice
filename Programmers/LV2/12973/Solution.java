import java.util.Stack;

class Solution {
	public int solution(String s) {
		if (s.length() == 1) {
			return 0;
		}
		char[] carr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		stack.push(carr[0]);
		Character prev = carr[0];
		for (int i = 1; i < carr.length; i++) {
			Character current = carr[i];
			if (prev == current) {
				stack.pop();
				if (stack.isEmpty()) {
					if (++i == carr.length) {
						break;
					}
					stack.push(carr[i]);
				}
				prev = stack.peek();
			} else {
				stack.push(current);
				prev = current;
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}
}