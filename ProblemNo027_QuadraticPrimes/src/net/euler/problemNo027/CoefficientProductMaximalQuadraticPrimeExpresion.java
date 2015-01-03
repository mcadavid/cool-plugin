package net.euler.problemNo027;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.eulerproject.utils.PrimeNumbersUtils;

public class CoefficientProductMaximalQuadraticPrimeExpresion {

	public int calculate(int coefficientLimit) {

		int maximalNumberOfPrimesForLimit = 1;
		int finalA = 0, finalB = 0;

		for (int a = -1 * coefficientLimit + 1; a < coefficientLimit; a++) {
			List<BigInteger> allPrimes = PrimeNumbersUtils.getListOfAllPrimeNumbers();
			for (BigInteger bigInteger : allPrimes) {

				int b = bigInteger.intValue();
				if (b > coefficientLimit) {
					break;
				}
				int numberOfPrimes = numberOfPrimes(a, b);

				if (maximalNumberOfPrimesForLimit < numberOfPrimes) {

					maximalNumberOfPrimesForLimit = numberOfPrimes;
					finalA = a;
					finalB = b;
					System.out.println("a = " + finalA + ", b = " + finalB + " length = " + maximalNumberOfPrimesForLimit);
				}
			}
		}
		System.out.println("The final one: a = " + finalA + ", b = " + finalB + " length = " + maximalNumberOfPrimesForLimit);
		return finalA * finalB;
	}

	private int numberOfPrimes(int a, int b) {
		int n = 1;
		int p = n * n + a * n + b;

		Set<Integer> primes = new HashSet<>();
		while (isAPrime(p)) {
			primes.add(p);
			p = n * n + a * n + b;
			n++;
		}
		return primes.size();
	}

	private boolean isAPrime(int p) {
		return PrimeNumbersUtils.checkIfNumberIsPrime(new BigInteger(p + ""));
	}

}
