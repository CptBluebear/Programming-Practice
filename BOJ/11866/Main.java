import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		List<String> results = new LinkedList<>();
		int n = sc.nextInt();
		int k = sc.nextInt();
		for(int i=1;i<=n;i++) {
			queue.offer(i);
		}
		int cnt = 0;
		while (!queue.isEmpty()) {
			if(++cnt % k == 0) {
				results.add(Integer.toString(queue.poll()));
			} else {
				queue.offer(queue.poll());
			}
		}
		System.out.println("<" + String.join(", ", results) + ">");
	}
}