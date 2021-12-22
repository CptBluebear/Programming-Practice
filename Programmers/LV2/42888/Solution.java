import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	List<String> log = new ArrayList<>();
	Map<String, String> userInfo = new HashMap<>();
	Map<String, Boolean> flags = new HashMap<>();

	public String[] solution(String[] record) {
		for (String rec : record) {
			String[] data = rec.split(" ");
			if (data[0].equals("Enter") || data[0].equals("Change")) {
				userInfo.put(data[1], data[2]);
			}
			flags.put(data[1], true);
			if (data[0].equals("Enter") || data[0].equals("Leave")) {
				log.add(data[1]);
			}
		}
		String[] result = new String[log.size()];
		for (int i = 0; i < result.length; i++) {
			String uid = log.get(i);
			if (flags.get(uid)) {
				result[i] = String.format("%s님이 들어왔습니다.", userInfo.get(uid));
				flags.put(uid, false);
			} else {
				result[i] = String.format("%s님이 나갔습니다.", userInfo.get(uid));
				flags.put(uid, true);
			}
		}
		return result;
	}
}