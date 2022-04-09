import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static int[][] map;
	static Map<Integer, Integer> result = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(reader.readLine());
		map = new int[size][size];
		for (int i = 0; i < size; i++) {
			String[] data = reader.readLine().split(" ");
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(data[j]);
			}
		}
		func(0, size - 1, 0, size - 1);
		System.out.println(result.getOrDefault(-1, 0));
		System.out.println(result.getOrDefault(0, 0));
		System.out.println(result.getOrDefault(1, 0));
	}

	public static void func(int xStart, int xEnd, int yStart, int yEnd) {
		int data = map[xStart][yStart];
		if (xStart == xEnd && yStart == yEnd) {
			result.put(data, result.getOrDefault(data, 0) + 1);
			return;
		}

		int gap = (xEnd - xStart + 1) / 3;
		if (!checkMap(xStart, xEnd, yStart, yEnd)) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					func(xStart + gap * i, xStart + gap * (i + 1) - 1,
						yStart + gap * j, yStart + gap * (j + 1) - 1);
				}
			}
			return;
		}

		result.put(data, result.getOrDefault(data, 0) + 1);
		return;
	}

	public static boolean checkMap(int xStart, int xEnd, int yStart, int yEnd) {
		int data = map[xStart][yStart];
		for (int i = xStart; i <= xEnd; i++) {
			for (int j = yStart; j <= yEnd; j++) {
				if (data != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}