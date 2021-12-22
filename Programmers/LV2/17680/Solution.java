import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return cities.length * 5;
		}
		int answer = 0;
		int cnt = 0;
		List<String> cache = new ArrayList<>();
		Queue<String> cityQueue = new LinkedList<>(Arrays.asList(cities));
		while (cnt < cacheSize && !cityQueue.isEmpty()) {
			String city = cityQueue.poll().toLowerCase();
			if (cache.contains(city)) {
				cache.remove(city);
				answer += 1;
			} else {
				answer += 5;
				cnt++;
			}
			cache.add(city);
		}
		while (!cityQueue.isEmpty()) {
			String city = cityQueue.poll().toLowerCase();
			if (cache.contains(city)) {
				cache.remove(city);
				answer += 1;
			} else {
				cache.remove(0);
				answer += 5;
			}
			cache.add(city);
		}
		return answer;
	}
}