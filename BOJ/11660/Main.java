import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] initData = reader.readLine().split(" ");
		int size = Integer.parseInt(initData[0]);
		int caseNum = Integer.parseInt(initData[1]);
		int[][] numbers = new int[size][size];
		int[][] sumArr = new int[size + 1][size + 1];
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < size; i++) {
			String[] data = reader.readLine().split(" ");
			for (int j = 0; j < size; j++) {
				numbers[i][j] = Integer.parseInt(data[j]);
			}
		}

		for (int i = 1; i < size + 1; i++) {
			for (int j = 1; j < size + 1; j++) {
				sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + numbers[i - 1][j - 1];
			}
		}

		while (caseNum-- > 0) {
			String[] data = reader.readLine().split(" ");
			int x1 = Integer.parseInt(data[0]);
			int y1 = Integer.parseInt(data[1]);
			int x2 = Integer.parseInt(data[2]);
			int y2 = Integer.parseInt(data[3]);

			int result = sumArr[x2][y2] - sumArr[x2][y1 - 1] - sumArr[x1 - 1][y2] + sumArr[x1 - 1][y1 - 1];
			stringBuilder.append(result).append("\n");
		}

		System.out.println(stringBuilder.toString());
	}
}
