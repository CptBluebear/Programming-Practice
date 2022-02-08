import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		int caseNum = Integer.parseInt(bufferedReader.readLine());
		while (caseNum-- > 0) {
			String[] data = bufferedReader.readLine().split(" ");
			stringBuilder.append(Integer.parseInt(data[0]) + Integer.parseInt(data[1])).append("\n");
		}
		System.out.print(stringBuilder.toString());
	}
}