import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	BigInteger[] dp = new BigInteger[101];

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.run();
	}

	private void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] data = reader.readLine().split(" ");
		int n = Integer.parseInt(data[0]);
		int m = Integer.parseInt(data[1]);
		dp[0] = BigInteger.valueOf(1);
		dp[1] = BigInteger.valueOf(1);
		System.out.println(fac(n).divide(fac(m).multiply(fac(n - m))));
	}

	private BigInteger fac(int num) {
		if (dp[num] != null) {
			return dp[num];
		}
		dp[num] = fac(num - 1).multiply(BigInteger.valueOf(num));
		return dp[num];
	}
}