import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public String[] solution(String[] files) {
		Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int[] p1 = getSplitPoints(o1);
				int[] p2 = getSplitPoints(o2);
				String s1 = o1.substring(0, p1[0]).toLowerCase();
				String s2 = o2.substring(0, p2[0]).toLowerCase();
				int i1 = parseInteger(o1.substring(p1[0], p1[1]));
				int i2 = parseInteger(o2.substring(p2[0], p2[1]));
				if (!s1.equals(s2)) {
					return s1.compareTo(s2);
				}
				if (i1 != i2) {
					return i1 - i2;
				}
				return 0;
			}
		});
		return files;
	}

	private int[] getSplitPoints(String s) {
		int[] results = new int[2];
		results[1] = s.length();
		int index = 0;
		char[] carr = s.toCharArray();
		for (; index < s.length(); index++) {
			if (48 <= carr[index] && carr[index] <= 57) {
				results[0] = index;
				break;
			}
		}
		for (; index < s.length(); index++) {
			if (48 > carr[index] || carr[index] > 57) {
				results[1] = index;
				break;
			}
		}
		return results;
	}

	private int parseInteger(String s) {
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != '0') {
				return Integer.parseInt(s.substring(i));
			}
		}
		return 0;
	}
}