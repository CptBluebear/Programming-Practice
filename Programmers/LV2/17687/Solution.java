import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

	private static final String[] numbers =
		{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

	public String solution(int n, int t, int m, int p) {
		StringBuilder stringBuilder = new StringBuilder();
		Queue<String> queue = new LinkedList<>();
		int personCount = 0;
		int currentNumber = 0;
		if (m == p) {
			p = 0;
		}
		while (t != 0) {
			if (queue.isEmpty()) {
				generateQueue(queue, currentNumber++, n);
			}
			String tmp = queue.poll();
			if (++personCount % m == p) {
				stringBuilder.append(tmp);
				t--;
			}
		}
		return stringBuilder.toString();
	}

	private void generateQueue(Queue<String> queue, int currentNumber, int n) {
		List<String> tmp = new ArrayList<>();
		do {
			tmp.add(numbers[currentNumber % n]);
			currentNumber /= n;
		} while (currentNumber != 0);
		Collections.reverse(tmp);
		queue.addAll(tmp);
	}
}