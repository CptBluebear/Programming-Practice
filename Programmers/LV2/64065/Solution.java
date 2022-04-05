import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;

class Solution {
	public int[] solution(String s) {
		String[] data = s.substring(2, s.length() - 2).split("\\}\\,\\{");
		Arrays.sort(data, Comparator.comparingInt(String::length));
		LinkedHashSet<Integer> set = new LinkedHashSet<>();

		for (String arr : data) {
			String[] tmp = arr.split("\\,");
			for (String t : tmp) {
				set.add(Integer.parseInt(t));
			}
		}

		int[] answer = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		int cnt = 0;
		while (iterator.hasNext()) {
			answer[cnt++] = iterator.next();
		}
		return answer;
	}
}