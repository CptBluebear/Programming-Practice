import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder stringBuilder = new StringBuilder();
		String command;
		int commandNum = sc.nextInt();
		while (commandNum-- > 0) {
			command = sc.next();
			switch (command) {
				case "push":
					queue.add(sc.nextInt());
					break;
				case "pop":
					if (queue.isEmpty()) {
						stringBuilder.append(-1 + "\n");
					} else {
						stringBuilder.append(queue.poll() + "\n");
					}
					break;
				case "size":
					stringBuilder.append(queue.size() + "\n");
					break;
				case "empty":
					if (queue.isEmpty()) {
						stringBuilder.append(1 + "\n");
					} else {
						stringBuilder.append(0 + "\n");
					}
					break;
				case "front":
					if (queue.isEmpty()) {
						stringBuilder.append(-1 + "\n");
					} else {
						stringBuilder.append(queue.peek() + "\n");
					}
					break;
				case "back":
					if (queue.isEmpty()) {
						stringBuilder.append(-1 + "\n");
					} else {
						stringBuilder.append(((LinkedList)queue).get(queue.size() - 1) + "\n");
					}
					break;
			}
		}
		System.out.print(stringBuilder.toString());
	}
}