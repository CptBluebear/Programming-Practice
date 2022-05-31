import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] initValue = reader.readLine().split(" ");
		int size = Integer.parseInt(initValue[0]);
		int caseNum = Integer.parseInt(initValue[1]);

		int[] array = new int[size];
		int[] sum = new int[size + 1];
		String[] data = reader.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			int num = Integer.parseInt(data[i]);
			array[i] = num;
			sum[i + 1] = sum[i] + num;
		}

		StringBuilder stringBuilder = new StringBuilder();

		while (caseNum-- > 0) {
			String[] section = reader.readLine().split(" ");
			int result = sum[Integer.parseInt(section[1])] - sum[Integer.parseInt(section[0]) - 1];
			stringBuilder.append(result).append("\n");
		}

		System.out.println(stringBuilder.toString());
	}
}