package net.eulerproject.problemNo20;

import java.math.BigInteger;

import net.eulerproject.problemNo16.SumOfDigits;

public class FactorialDigitSum {

	private int factorialOf;

	public FactorialDigitSum(int n) {
		this.factorialOf = n;

	}

	public int calculate() {

		BigInteger calculate = factorial(new BigInteger(factorialOf + ""));
		return new SumOfDigits(calculate).calculate();
	}

	public BigInteger factorial(BigInteger n) {
		if (n.compareTo(BigInteger.ZERO) < 0)
			throw new RuntimeException("Underflow error in factorial");
		else if (n.compareTo(new BigInteger("200")) > 0)
			throw new RuntimeException("Overflow error in factorial");
		else if (n.compareTo(BigInteger.ZERO) == 0)
			return BigInteger.ONE;
		else
			return n.multiply(factorial(n.add(new BigInteger("-1"))));
	}

}
