import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	private static final BigInteger R = BigInteger.valueOf(31);
	private static final BigInteger M = BigInteger.valueOf(1234567891);
	private static BigInteger R_V = BigInteger.valueOf(1);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		BigInteger answer = BigInteger.valueOf(0);
		char[] data = sc.nextLine().toCharArray();
		for (int i = 0; i < data.length; i++) {
			answer = answer.add(BigInteger.valueOf(data[i] - 96).multiply(R_V));
			R_V = R_V.multiply(R).mod(M);
		}
		System.out.println(answer.mod(M));
	}
}