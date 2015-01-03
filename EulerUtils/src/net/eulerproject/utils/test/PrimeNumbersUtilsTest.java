package net.eulerproject.utils.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.List;

import net.eulerproject.utils.PrimeNumbersUtils;

import org.junit.Test;

public class PrimeNumbersUtilsTest {

	@Test
	public void testGetListOfAllPrimeNumbers() {
		List<BigInteger> primeList = PrimeNumbersUtils.getListOfAllPrimeNumbers();
		assertFalse(primeList.isEmpty());
	}

	@Test
	public void testCheckIfNumberIsPrime() {
		assertTrue(PrimeNumbersUtils.checkIfNumberIsPrime(new BigInteger("2")));
		assertFalse(PrimeNumbersUtils.checkIfNumberIsPrime(new BigInteger("99")));
		assertTrue(PrimeNumbersUtils.checkIfNumberIsPrime(new BigInteger("7")));
		assertTrue(PrimeNumbersUtils.checkIfNumberIsPrime(new BigInteger("41")));

	}

	@Test
	public void testGetAllPrimeDivisorsOfNumber() {
		List<BigInteger> divisors = PrimeNumbersUtils.getAllPrimeDivisorsOfNumber(new BigInteger("41"));
		assertTrue(divisors.isEmpty());
		divisors = PrimeNumbersUtils.getAllPrimeDivisorsOfNumber(new BigInteger("12"));
		for (BigInteger bigInteger : divisors) {
			System.out.println(bigInteger);
		}
		assertFalse(divisors.isEmpty());
	}

}
