import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public int[] solution(String msg) {

		List<Integer> results = new ArrayList<>();
		Map<String, Integer> dict = new HashMap<String, Integer>() {{
			put("A", 1);
			put("B", 2);
			put("C", 3);
			put("D", 4);
			put("E", 5);
			put("F", 6);
			put("G", 7);
			put("H", 8);
			put("I", 9);
			put("J", 10);
			put("K", 11);
			put("L", 12);
			put("M", 13);
			put("N", 14);
			put("O", 15);
			put("P", 16);
			put("Q", 17);
			put("R", 18);
			put("S", 19);
			put("T", 20);
			put("U", 21);
			put("V", 22);
			put("W", 23);
			put("X", 24);
			put("Y", 25);
			put("Z", 26);
		}};
		int index = 27;
		int last = 0;

		if (msg.length() == 1) {
			return new int[] {dict.get(msg)};
		}

		for (int i = 0; i < msg.length(); i++) {
			for (int j = i + 1; j < msg.length(); j++) {
				String next = msg.substring(i, j + 1);
				if (dict.containsKey(next)) {
					continue;
				} else {
					results.add(dict.get(next.substring(0, next.length() - 1)));
					i += next.length() - 2;
					last = i;
					dict.put(next, index++);
					break;
				}
			}
		}
		results.add(dict.get(msg.substring(last + 1)));

		int[] answer = new int[results.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = results.get(i);
		}
		return answer;
	}
}