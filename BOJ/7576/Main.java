import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int[][] map;
	static int[][] moveSet = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int width;
	static int height;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] initData = reader.readLine().split(" ");
		width = Integer.parseInt(initData[0]);
		height = Integer.parseInt(initData[1]);
		map = new int[height][width];
		List<Integer[]> start = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			String[] data = reader.readLine().split(" ");
			for (int j = 0; j < width; j++) {
				int num = Integer.parseInt(data[j]);
				if (num == 1) {
					start.add(new Integer[] {i, j});
				}
				map[i][j] = Integer.parseInt(data[j]);
			}
		}
		System.out.println(func(start));
	}

	public static int func(List<Integer[]> start) {
		Queue<Integer[]> queue = new LinkedList<>();
		for (Integer[] s : start) {
			queue.offer(s);
		}
		while (!queue.isEmpty()) {
			Integer[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			for (int[] move : moveSet) {
				int nextX = x + move[0];
				int nextY = y + move[1];
				if (isPossible(nextX, nextY)) {
					map[nextX][nextY] = map[x][y] + 1;
					queue.add(new Integer[] {nextX, nextY});
				}
			}
		}
		int result = Integer.MIN_VALUE;
		for (int[] tmp : map) {
			for (int value : tmp) {
				if (value == 0) {
					return -1;
				}
				result = Math.max(result, value);
			}
		}
		return result - 1;
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || height - 1 < x || y < 0 || width - 1 < y) {
			return false;
		}
		return map[x][y] == 0;
	}
}
