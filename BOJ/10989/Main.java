import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		int caseNum = Integer.parseInt(bufferedReader.readLine());
		int[] arr = new int[caseNum];
		for (int i = 0; i < caseNum; i++) {
			arr[i] = Integer.parseInt(bufferedReader.readLine());
		}
		Arrays.sort(arr);
		for (int i : arr) {
			stringBuilder.append(i).append("\n");
		}
		System.out.print(stringBuilder.toString());
	}
}