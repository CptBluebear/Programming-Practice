import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	private final static int DEFAULT_DISTANCE = 1;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.run();
	}

	private void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		String[] initData = reader.readLine().split(" ");
		int nodeNum = Integer.parseInt(initData[0]);
		int edgeNum = Integer.parseInt(initData[1]);
		int limit = Integer.parseInt(initData[2]);
		int startNode = Integer.parseInt(initData[3]);

		List<List<Integer>> graph = new ArrayList<>();
		int[] distance = new int[nodeNum + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for (int i = 0; i <= nodeNum; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < edgeNum; i++) {
			String[] data = reader.readLine().split(" ");
			int start = Integer.parseInt(data[0]);
			int end = Integer.parseInt(data[1]);
			graph.get(start).add(end);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startNode);
		distance[startNode] = 0;

		while (!queue.isEmpty()) {
			Integer current = queue.poll();

			List<Integer> nextList = graph.get(current);
			for (Integer next : nextList) {
				int cost = distance[current] + DEFAULT_DISTANCE;
				if (distance[next] > cost) {
					distance[next] = cost;
					queue.offer(next);
				}
			}
		}
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] == limit) {
				stringBuilder.append(i).append("\n");
			}
		}
		if (stringBuilder.length() == 0) {
			stringBuilder.append("-1\n");
		}
		System.out.println(stringBuilder);
	}
}