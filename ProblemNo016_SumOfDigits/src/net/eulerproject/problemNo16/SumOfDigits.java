package net.eulerproject.problemNo16;

import java.math.BigInteger;

public class SumOfDigits {

	private BigInteger n;

	public SumOfDigits(BigInteger n) {
		this.n = n;

	}

	public int calculate() {
		int sum = 0;

		while (n.compareTo(BigInteger.ZERO) > 0) {

			BigInteger[] k = n.divideAndRemainder(BigInteger.TEN);

			n = k[0];

			sum = sum + k[1].intValue(); // this is an integer because the rest
											// is smaller than 10
		}
		return sum;
	}

}
