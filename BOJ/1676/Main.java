import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(reader.readLine());
		if (num == 0) {
			System.out.println(0);
			return;
		}
		BigInteger integer = BigInteger.valueOf(num);
		for (int i = num - 1; i > 0; i--) {
			integer = integer.multiply(BigInteger.valueOf(i));
		}
		char[] data = integer.toString().toCharArray();
		int result = 0;
		for (int i = data.length - 1; i >= 0; i--) {
			if (data[i] == '0') {
				result++;
			} else {
				break;
			}
		}
		System.out.println(result);
	}
}