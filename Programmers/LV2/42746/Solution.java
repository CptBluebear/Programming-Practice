import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	public String solution(int[] numbers) {
		List<String> list = Arrays.stream(numbers).mapToObj(x -> Integer.toString(x)).collect(Collectors.toList());
		list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
		if (list.get(0).equals("0")) {
			return "0";
		}
		return String.join("", list);
	}
}