import java.util.Stack;

class Solution {
	public int solution(String s) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		char[] carr = s.toCharArray();
		Loop1:
		for (int i = 0; i < s.length(); i++) {
			stack.clear();
			int tmp = 0;
			for (int j = 0; j < s.length(); j++) {
				Character c = carr[calcIndex(i + j, s.length())];
				switch (c) {
					case '(':
					case '{':
					case '[':
						stack.add(c);
						break;
					case ')':
					case '}':
					case ']':
						if (!removeCheck(c, stack)) {
							continue Loop1;
						}
						if (stack.isEmpty()) {
							tmp++;
						}
				}
			}
			if(stack.isEmpty()) {
				answer = tmp;
			}
		}
		return answer;
	}

	private int calcIndex(int num, int arrSize) {
		return num % arrSize;
	}

	private boolean removeCheck(Character c, Stack<Character> stack) {
		if (stack.isEmpty()) {
			return false;
		}
		Character top = stack.pop();
		switch (c) {
			case ')':
				if (top == '(') {
					return true;
				}
			case '}':
				if (top == '{') {
					return true;
				}
			case ']':
				if (top == '[') {
					return true;
				}
		}
		return false;
	}
}