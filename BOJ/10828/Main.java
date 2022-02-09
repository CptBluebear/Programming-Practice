import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		StringBuilder stringBuilder = new StringBuilder();
		int commandNum = sc.nextInt();
		String command;
		while (commandNum-- > 0) {
			command = sc.next();
			switch (command) {
				case "push":
					stack.push(sc.nextInt());
					break;
				case "pop":
					if(stack.isEmpty()) {
						stringBuilder.append("-1\n");
					} else {
						stringBuilder.append(stack.pop() + "\n");
					}
					break;
				case "size":
					stringBuilder.append(stack.size() + "\n");
					break;
				case "empty":
					if(stack.isEmpty()) {
						stringBuilder.append("1\n");
					} else {
						stringBuilder.append("0\n");
					}
					break;
				case "top":
					if(stack.isEmpty()) {
						stringBuilder.append("-1\n");
					} else {
						stringBuilder.append(stack.peek() + "\n");
					}
					break;
			}
		}
		System.out.print(stringBuilder.toString());
	}
}