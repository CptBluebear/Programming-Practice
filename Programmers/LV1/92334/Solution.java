import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		Map<String, Set<String>> reportLog = new HashMap<>();
		Map<String, Integer> mailCount = new HashMap<>();
		for (String id : id_list) {
			reportLog.put(id, new HashSet<>());
		}
		for (String id : id_list) {
			mailCount.put(id, 0);
		}
		for (String r : report) {
			String[] log = r.split(" ");
			reportLog.get(log[1]).add(log[0]);
		}
		for (String id : reportLog.keySet()) {
			Set<String> set = reportLog.get(id);
			if (set.size() >= k) {
				for (String s : set) {
					mailCount.put(s, mailCount.get(s) + 1);
				}
			}
		}
		for (int i = 0; i < id_list.length; i++) {
			answer[i] = mailCount.get(id_list[i]);
		}
		return answer;
	}
}