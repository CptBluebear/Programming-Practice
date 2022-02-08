import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		int caseNum = Integer.parseInt(bufferedReader.readLine());
		while (caseNum-- > 0) {
			int value = Integer.parseInt(bufferedReader.readLine());
			if (value == 0) {
				if (priorityQueue.isEmpty()) {
					stringBuilder.append("0\n");
				} else {
					stringBuilder.append(priorityQueue.poll()).append("\n");
				}
			} else {
				priorityQueue.offer(value);
			}
		}
		System.out.print(stringBuilder.toString());
	}
}