import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(reader.readLine());
		map = new char[size][];
		for (int i = 0; i < size; i++) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(func(0, size - 1, 0, size - 1));
	}

	public static String func(int xStart, int xEnd, int yStart, int yEnd) {
		char data = map[xStart][yStart];
		if (xStart == xEnd && yStart == yEnd) {
			return Character.toString(data);
		}

		int xMid = (xStart + xEnd) / 2;
		int yMid = (yStart + yEnd) / 2;
		for (int i = xStart; i <= xEnd; i++) {
			for (int j = yStart; j <= yEnd; j++) {
				if (data != map[i][j]) {
					String res = "(" +
						func(xStart, xMid, yStart, yMid) +
						func(xStart, xMid, yMid + 1, yEnd) +
						func(xMid + 1, xEnd, yStart, yMid) +
						func(xMid + 1, xEnd, yMid + 1, yEnd) +
						")";
					return res;
				}
			}
		}
		return Character.toString(data);
	}
}