import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	public String solution(String s) {
		List<Integer> numbers = Arrays.stream(s.split(" "))
			.map(tmp -> Integer.parseInt(tmp))
			.collect(Collectors.toList());
		Collections.sort(numbers);
		return numbers.get(0) + " " + numbers.get(numbers.size() - 1);
	}
}