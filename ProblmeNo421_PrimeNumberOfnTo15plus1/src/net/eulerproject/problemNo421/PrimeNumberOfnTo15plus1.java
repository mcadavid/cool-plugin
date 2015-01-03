package net.eulerproject.problemNo421;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.eulerproject.utils.PrimeNumbersUtils;

public class PrimeNumberOfnTo15plus1 {

	private BigInteger limitPrimeNumber;
	private BigInteger limitForTheNumberOfThePower;
	private static BigInteger TWO = new BigInteger("2");

	public PrimeNumberOfnTo15plus1(BigInteger limitForTheNumberOfThePower, BigInteger limitPrimeNumber) {
		this.limitPrimeNumber = limitPrimeNumber;
		this.limitForTheNumberOfThePower = limitForTheNumberOfThePower;

	}

	public BigInteger calculateSum() {
		// BigInteger result = TWO;
		// for (BigInteger i = TWO; i.compareTo(limitForTheNumberOfThePower) <=
		// 0; i = i.add(BigInteger.ONE)) {
		// result = result.add(calculateSFunction(i));
		// }
		// return result;

		return calculateSFunctionSum();
	}

	private BigInteger calculateSFunction(BigInteger n) {

		BigInteger sum = BigInteger.ZERO;
		BigInteger nPow15Plus1 = n.pow(15).add(BigInteger.ONE);
		System.out.println(n + "^15 + 1 = " + nPow15Plus1);

		List<BigInteger> primes = PrimeNumbersUtils.getAllPrimeDivisorsOfNumberUptoLimit(nPow15Plus1, limitPrimeNumber);
		for (BigInteger i : primes) {
			sum = sum.add(i);
		}

		// // loop over all numbers smaller than the limit
		// // user only odd numbers for performance
		// BigInteger limit = new BigInteger(nPow15Plus1.toString());
		// if (limit.compareTo(limitPrimeNumber) > 0) {
		// limit = new BigInteger(limitPrimeNumber.toString());
		// }
		//
		// for (BigInteger i = new BigInteger("3"); i.compareTo(limit) < 0; i =
		// i.add(TWO)) {
		//
		// // add only if i is prime and i divides n^15+1
		// if (nPow15Plus1.mod(i).equals(BigInteger.ZERO) &&
		// i.isProbablePrime(100)) {
		// sum = sum.add(i);
		// }
		// }
		System.out.println("current value of s(" + n + "," + limitPrimeNumber + ") = " + sum);
		return sum;

	}

	private BigInteger calculateSFunctionSum() {

		List<BigInteger> allPrimeNumbers = PrimeNumbersUtils.getListOfAllPrimeNumbers();
		BigInteger sum = BigInteger.ZERO;
		long counter = 1;
		while (counter <= limitForTheNumberOfThePower.longValue()) {
			// if (counter % 1 == 0) {
			//
			// System.out.println(counter + "^15 + 1 = ");
			// }
			BigInteger newPowerOf = new BigInteger(counter + "").pow(15).add(BigInteger.ONE);
			System.out.println(counter + "^15 + 1 = " + newPowerOf);

			// for (BigInteger primeNumber :
			// PrimeFactorizationForProfis.Factor(newPowerOf)) {
			// sum = sum.add(primeNumber);
			// }
			BigInteger division = new BigInteger(newPowerOf.toString());

			for (BigInteger primeNumber : allPrimeNumbers) {
				if (division.mod(primeNumber).equals(BigInteger.ZERO)) {
					System.out.print(primeNumber + "\t");
					sum = sum.add(primeNumber);

					while (division.mod(primeNumber).equals(BigInteger.ZERO)) {
						division = division.divide(primeNumber);
					}
					if (division.equals(BigInteger.ONE)) {
						break;
					}
				}
			}
			System.out.println();
			System.out.println("Sum = " + sum);
			counter++;
		}

		return sum;

	}

	private Set<BigInteger> primeFactors(BigInteger n) {
		// "Returns all the prime factors of a positive integer"
		Set<BigInteger> factors = new HashSet<>();
		BigInteger d = TWO;
		while (n.compareTo(BigInteger.ONE) > 0) {
			while (n.mod(d).equals(BigInteger.ZERO)) {
				factors.add(d);
				n = n.divide(d);
			}
			d = d.add(BigInteger.ONE);
			BigInteger squared = d.multiply(d);
			if (squared.compareTo(n) > 0) {
				if (n.compareTo(BigInteger.ONE) > 0) {
					factors.add(n);
				}
				break;
			}
		}
		return factors;
	}
}
