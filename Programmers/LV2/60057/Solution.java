import java.util.ArrayList;
import java.util.List;

class Solution {
	public int solution(String s) {
		if (s.length() == 1) {
			return 1;
		}
		int answer = Integer.MAX_VALUE;
		int limit = s.length() / 2;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 1; i <= limit; i++) {
			List<String> splitString = splitString(s, i);
			String prevBlock = splitString.get(0);
			int size = 1;
			for (int j = 1; j < splitString.size(); j++) {
				String currentBlock = splitString.get(j);
				if (currentBlock.equals(prevBlock)) {
					size++;
				} else {
					if (size > 1) {
						stringBuilder.append(size);
					}
					stringBuilder.append(prevBlock);
					prevBlock = currentBlock;
					size = 1;
				}
			}
			if (size > 1) {
				stringBuilder.append(size);
			}
			stringBuilder.append(prevBlock);
			answer = Math.min(answer, stringBuilder.length());
			stringBuilder.setLength(0);
		}
		return answer;
	}

	private List<String> splitString(String s, int size) {
		List<String> results = new ArrayList<>();
		StringBuilder stringBuilder = new StringBuilder();
		char[] carr = s.toCharArray();
		for (char c : carr) {
			stringBuilder.append(c);
			if (stringBuilder.length() == size) {
				results.add(stringBuilder.toString());
				stringBuilder.setLength(0);
			}
		}
		if (stringBuilder.length() != 0) {
			results.add(stringBuilder.toString());
		}
		return results;
	}
}