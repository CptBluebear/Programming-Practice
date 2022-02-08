import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(bufferedReader.readLine());
		StringBuilder stringBuilder = new StringBuilder();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
			if (Math.abs(o1) == Math.abs(o2)) {
				return o1 - o2;
			}
			return Math.abs(o1) - Math.abs(o2);
		});
		while (caseNum-- > 0) {
			int value = Integer.parseInt(bufferedReader.readLine());
			if (value == 0) {
				if (!priorityQueue.isEmpty()) {
					stringBuilder.append(priorityQueue.poll()).append("\n");
				} else {
					stringBuilder.append("0\n");
				}
			} else {
				priorityQueue.offer(value);
			}
		}
		System.out.print(stringBuilder.toString());
	}
}