import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] data = bufferedReader.readLine().split(" ");
		BigInteger num1 = new BigInteger(data[0]);
		BigInteger num2 = new BigInteger(data[1]);
		System.out.println(num1.add(num2));
	}
}