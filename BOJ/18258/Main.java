import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		int back = 0;
		int caseNum = Integer.parseInt(bufferedReader.readLine());
		while (caseNum-- > 0) {
			String[] command = bufferedReader.readLine().split(" ");
			switch (command[0]) {
				case "push":
					int value = Integer.parseInt(command[1]);
					queue.offer(value);
					back = value;
					break;
				case "pop":
					if (queue.isEmpty()) {
						stringBuilder.append("-1\n");
					} else {
						stringBuilder.append(queue.poll()).append("\n");
					}
					break;
				case "size":
					stringBuilder.append(queue.size()).append("\n");
					break;
				case "empty":
					if (queue.isEmpty()) {
						stringBuilder.append("1\n");
					} else {
						stringBuilder.append("0\n");
					}
					break;
				case "front":
					if (queue.isEmpty()) {
						stringBuilder.append("-1\n");
					} else {
						stringBuilder.append(queue.peek()).append("\n");
					}
					break;
				case "back":
					if (queue.isEmpty()) {
						stringBuilder.append("-1\n");
					} else {
						stringBuilder.append(back).append("\n");
					}
			}
		}
		System.out.print(stringBuilder.toString());
	}
}