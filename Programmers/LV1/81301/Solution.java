import java.util.HashMap;
import java.util.Map;

class Solution {

	Map<String, Integer> numberMap = new HashMap<>();
	String[] numberString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	public Solution() {
		for (int i = 0; i < numberString.length; i++) {
			numberMap.put(numberString[i], i);
		}
	}

	public int solution(String s) {
		StringBuilder buffer = new StringBuilder();
		StringBuilder stringBuilder = new StringBuilder();
		String[] arr = s.split("");
		for (String c : arr) {
			if (checkInteger(c)) {
				if (buffer.length() != 0) {
					stringBuilder.append(numberMap.get(buffer.toString()));
					buffer.setLength(0);
				}
				stringBuilder.append(c);
			} else {
				buffer.append(c);
				if (numberMap.get(buffer.toString()) != null) {
					stringBuilder.append(numberMap.get(buffer.toString()));
					buffer.setLength(0);
				}
			}
		}

		return Integer.parseInt(stringBuilder.toString());
	}

	private boolean checkInteger(String c) {
		try {
			Integer.parseInt(c);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}