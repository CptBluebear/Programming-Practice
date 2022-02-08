import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int caseNum = Integer.parseInt(bufferedReader.readLine());
		String[] data = bufferedReader.readLine().split(" ");
		int[] numbers = new int[caseNum];
		for (int i = 0; i < caseNum; i++) {
			numbers[i] = Integer.parseInt(data[i]);
		}
		for (int i = 0; i < caseNum; i++) {
			while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
				numbers[stack.pop()] = numbers[i];
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			numbers[stack.pop()] = -1;
		}
		for (int i : numbers) {
			stringBuilder.append(i).append(" ");
		}
		System.out.println(stringBuilder.toString());
	}
}