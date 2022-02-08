import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int nodeNum;
	static int edgeNum;
	static boolean[][] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] initData = bufferedReader.readLine().split(" ");
		int answer = 0;
		nodeNum = Integer.parseInt(initData[0]);
		edgeNum = Integer.parseInt(initData[1]);
		graph = new boolean[nodeNum + 1][nodeNum + 1];
		visited = new boolean[nodeNum + 1];
		for (int i = 0; i < edgeNum; i++) {
			String[] data = bufferedReader.readLine().split(" ");
			int node1 = Integer.parseInt(data[0]);
			int node2 = Integer.parseInt(data[1]);
			graph[node1][node2] = true;
			graph[node2][node1] = true;
		}
		for (int i = 1; i <= nodeNum; i++) {
			if (!visited[i]) {
				func(i);
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static void func(int num) {
		visited[num] = true;
		for (int i = 1; i <= nodeNum; i++) {
			if (graph[num][i] && !visited[i]) {
				func(i);
			}
		}
	}
}