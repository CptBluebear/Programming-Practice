import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		int caseNum = Integer.parseInt(bufferedReader.readLine());
		for (int i = 1; i <= caseNum; i++) {
			String[] data = bufferedReader.readLine().split(" ");
			stringBuilder.append("Case #")
				.append(i)
				.append(": ")
				.append(Integer.parseInt(data[0]) + Integer.parseInt(data[1]))
				.append("\n");
		}
		System.out.print(stringBuilder.toString());
	}
}