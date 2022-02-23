import java.math.BigInteger;

class Solution {
	public long solution(int w, int h) {
		BigInteger i1 = BigInteger.valueOf(w);
		BigInteger i2 = BigInteger.valueOf(h);

		return (i1.multiply(i2).subtract(i1.add(i2).subtract(gcd(w, h)))).longValue();
	}

	public BigInteger gcd(int num1, int num2) {
		BigInteger i1 = BigInteger.valueOf(Math.max(num1, num2));
		BigInteger i2 = BigInteger.valueOf(Math.min(num1, num2));

		BigInteger zero = BigInteger.valueOf(0);
		while (!i1.mod(i2).equals(zero)) {
			BigInteger tmp = i1.mod(i2);
			i1 = i2;
			i2 = tmp;
		}
		return i2;
	}
}