import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(bufferedReader.readLine());
		int num2 = Integer.parseInt(bufferedReader.readLine());
		if (num1 > 0) {
			if (num2 > 0) {
				System.out.println(1);
			} else {
				System.out.println(4);
			}
		} else {
			if (num2 > 0) {
				System.out.println(2);
			} else {
				System.out.println(3);
			}
		}
	}
}