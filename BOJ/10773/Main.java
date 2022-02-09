import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int caseNum = sc.nextInt();
		while (caseNum-- > 0) {
			int num = sc.nextInt();
			if (num == 0) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}
		int answer = 0;
		for (int i : stack) {
			answer += i;
		}
		System.out.println(answer);
	}
}