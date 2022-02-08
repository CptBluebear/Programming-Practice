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
			int num1 = Integer.parseInt(data[0]);
			int num2 = Integer.parseInt(data[1]);
			stringBuilder.append("Case #")
				.append(i)
				.append(": ")
				.append(num1)
				.append(" + ")
				.append(num2)
				.append(" = ")
				.append(num1 + num2)
				.append("\n");
		}
		System.out.print(stringBuilder.toString());
	}
}