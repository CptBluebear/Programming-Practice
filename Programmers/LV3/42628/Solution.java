import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int[] solution(String[] operations) {

		Queue<Integer> queue1 = new PriorityQueue<>();
		Queue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());

		for (String op : operations) {
			String[] data = op.split(" ");
			switch (data[0]) {
				case "I":
					int value = Integer.parseInt(data[1]);
					queue1.offer(value);
					queue2.offer(value);
					break;
				case "D":
					if (queue1.isEmpty()) {
						break;
					}
					if (data[1].equals("1")) {
						queue1.remove(queue2.poll());
					} else {
						queue2.remove(queue1.poll());
					}
					break;
			}
		}
		if (queue1.isEmpty()) {
			return new int[] {0, 0};
		} else {
			return new int[] {queue2.peek(), queue1.peek()};
		}
	}
}