import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int n, String[] words) {
		int[] count = new int[n];
		List<String> log = new ArrayList<>();
		String character = words[0].substring(0, 1);
		int turn = 0;
		for (turn = 0; turn < words.length; turn++) {
			count[turn % n]++;
			if (!words[turn].substring(0, 1).equals(character)) {
				break;
			}
			if (log.contains(words[turn])) {
				break;
			}
			character = words[turn].substring(words[turn].length() - 1);
			log.add(words[turn]);
		}
		int[] answer = {turn % n + 1, count[turn % n]};
		if (turn == words.length) {
			answer[0] = 0;
			answer[1] = 0;
		}
		return answer;
	}
}