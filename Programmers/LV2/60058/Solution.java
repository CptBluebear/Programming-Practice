import java.util.Stack;

class Solution {
	public String solution(String s) {
		if (s.length() == 0) {
			return s;
		}
		int index = 0;
		int num = 0;
		do {
			num += parse(s.charAt(index++));
		} while (num != 0);

		String u = s.substring(0, index);
		String v = s.substring(index);
		v = solution(v);

		if (isCorrect(u)) {
			return u + v;
		} else {
			return "(" + v + ")" + reverse(u.substring(1, u.length() - 1));
		}
	}

	private int parse(char c) {
		switch (c) {
			case '(':
				return 1;
			default:
				return -1;
		}
	}

	private boolean isCorrect(String s) {
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else {
				if (stack.isEmpty() || stack.peek() != '(') {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return true;
	}

	private String reverse(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stringBuilder.append(')');
			} else {
				stringBuilder.append('(');
			}
		}
		return stringBuilder.toString();
	}
}