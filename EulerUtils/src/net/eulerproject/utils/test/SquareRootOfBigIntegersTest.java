package net.eulerproject.utils.test;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import net.eulerproject.utils.SquareRootOfBigIntegers;

import org.junit.Test;

public class SquareRootOfBigIntegersTest {

	@Test
	public void testCalculateSquareRoot() {
		BigInteger sqrt = SquareRootOfBigIntegers.calculateSquareRoot(new BigInteger("4"));
		assertEquals(new BigInteger("2"), sqrt);

		sqrt = SquareRootOfBigIntegers.calculateSquareRoot(new BigInteger("8"));
		assertEquals(new BigInteger("2"), sqrt);

		sqrt = SquareRootOfBigIntegers.calculateSquareRoot(new BigInteger("9"));
		assertEquals(new BigInteger("3"), sqrt);

		sqrt = SquareRootOfBigIntegers.calculateSquareRoot(new BigInteger("16"));
		assertEquals(new BigInteger("4"), sqrt);

		sqrt = SquareRootOfBigIntegers.calculateSquareRoot(new BigInteger("20"));
		assertEquals(new BigInteger("4"), sqrt);

		sqrt = SquareRootOfBigIntegers.calculateSquareRoot(new BigInteger("101"));
		assertEquals(new BigInteger("10"), sqrt);
	}

}
