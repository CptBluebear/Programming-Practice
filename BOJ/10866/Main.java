import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> linkedList = new LinkedList<>();
		StringBuilder stringBuilder = new StringBuilder();
		String command;
		int commandNum = sc.nextInt();
		while (commandNum-- > 0) {
			command = sc.next();
			switch (command) {
				case "push_front":
					linkedList.add(0, sc.nextInt());
					break;
				case "push_back":
					linkedList.add(sc.nextInt());
					break;
				case "pop_front":
					if (linkedList.isEmpty()) {
						stringBuilder.append("-1\n");
					} else {
						stringBuilder.append(linkedList.remove(0) + "\n");
					}
					break;
				case "pop_back":
					if (linkedList.isEmpty()) {
						stringBuilder.append("-1\n");
					} else {
						stringBuilder.append(linkedList.remove(linkedList.size() - 1) + "\n");
					}
					break;
				case "size":
					stringBuilder.append(linkedList.size() + "\n");
					break;
				case "empty":
					if (linkedList.isEmpty()) {
						stringBuilder.append("1\n");
					} else {
						stringBuilder.append("0\n");
					}
					break;
				case "front":
					if (linkedList.isEmpty()) {
						stringBuilder.append("-1\n");
					} else {
						stringBuilder.append(linkedList.get(0) + "\n");
					}
					break;
				case "back":
					if (linkedList.isEmpty()) {
						stringBuilder.append("-1\n");
					} else {
						stringBuilder.append(linkedList.get(linkedList.size() - 1) + "\n");
					}
					break;
			}
		}
		System.out.print(stringBuilder.toString());
	}
}