import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(bufferedReader.readLine());
		int[] value = new int[caseNum];
		String[] data = bufferedReader.readLine().split(" ");
		int answer = 0;
		int tmp = 0;
		for (int i = 0; i < caseNum; i++) {
			value[i] = Integer.parseInt(data[i]);
		}
		Arrays.sort(value);
		for (int v : value) {
			tmp += v;
			answer += tmp;
		}
		System.out.println(answer);
	}
}