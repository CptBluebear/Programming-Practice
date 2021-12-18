import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String[] solution(String[] strings, int n) {
    	
    	Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o2, String o1) {
				if(o1.charAt(n) == o2.charAt(n))
					return o1.compareTo(o2);
				else
					return o1.charAt(n) - o2.charAt(n);
			}	
		};
		
		Arrays.sort(strings, comparator);
		List<String> str = Arrays.asList(strings);
		Collections.reverse(str);
		strings = str.toArray(new String[str.size()]);

        return strings;
    }
}