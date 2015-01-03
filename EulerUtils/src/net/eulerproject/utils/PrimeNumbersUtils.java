package net.eulerproject.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersUtils {

	private static final BigInteger TWO = new BigInteger("2");
	private static List<BigInteger> allPrimeNumbers;

	public static boolean isPrime(int candidate) {

		return isPrime(new Long(candidate).longValue());

	}

	public static boolean isPrime(BigInteger candidate) {
		BigInteger j = TWO;
		while (j.compareTo(candidate) < 0) {

			// check if candidate is divided by j
			if (candidate.mod(j).equals(BigInteger.ZERO)) {
				return false;
			}
			j = j.add(BigInteger.ONE);
		}
		return true;

	}

	public static boolean isPrime(long candidate) {
		for (int j = 2; j <= Math.sqrt(candidate); j++) {
			// check if candidate is divided by j
			if (candidate % j == 0) {
				return false;
			}
		}
		return true;
	}

	public static List<BigInteger> getListOfAllPrimeNumbers() {

		if (allPrimeNumbers == null) {
			allPrimeNumbers = new ArrayList<BigInteger>();
			fillWithPrimesFromFile("primes1");
		}

		return allPrimeNumbers;
	}

	private static void fillWithPrimesFromFile(String fileName) {
		Path fileWithPrimeNumbers = Paths.get("C:/apps/Eclipse_Workspaces/euler-projekt/", "EulerUtils", fileName + ".txt");
		try {
			List<String> list = Files.readAllLines(fileWithPrimeNumbers, StandardCharsets.ISO_8859_1);

			for (String listOfNumbers : list) {
				if (listOfNumbers != null && listOfNumbers.trim().length() > 0 && !listOfNumbers.startsWith("#")) {
					listOfNumbers = listOfNumbers.trim();
					String[] primesInALine = listOfNumbers.split(" ");
					for (String aPrimeNumber : primesInALine) {
						String cuttedString = aPrimeNumber.trim();
						if (cuttedString.length() > 0) {
							try {
								allPrimeNumbers.add(new BigInteger(cuttedString));
							} catch (Throwable e) {
								System.out.println(e.toString());
							}
						}
					}
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	public static boolean checkIfNumberIsPrime(BigInteger i) {
		boolean isPrime = false;
		List<BigInteger> primes = getListOfAllPrimeNumbers();

		if (primes.contains(i)) {
			return true;
		}

		return isPrime;
	}

	public static List<BigInteger> getAllPrimeDivisorsOfNumber(BigInteger i) {
		List<BigInteger> divisors = new ArrayList<BigInteger>();

		for (BigInteger counter = BigInteger.ONE; counter.compareTo(i) < 0; counter = counter.add(BigInteger.ONE)) {
			if (i.mod(counter).equals(BigInteger.ZERO) && checkIfNumberIsPrime(counter)) {
				divisors.add(counter);
			}
		}

		return divisors;
	}

	public static List<BigInteger> getAllPrimeDivisorsOfNumberUptoLimit(BigInteger i, BigInteger limit) {
		List<BigInteger> divisors = new ArrayList<BigInteger>();

		BigInteger forLoopLimit = i;
		if (limit.compareTo(forLoopLimit) < 0) {
			forLoopLimit = new BigInteger(limit.toString());
		}

		if (i.mod(TWO).equals(BigInteger.ZERO)) {
			divisors.add(TWO);
		}

		for (BigInteger counter = new BigInteger("3"); counter.compareTo(forLoopLimit) < 0; counter = counter.add(TWO)) {

			if (i.mod(counter).equals(BigInteger.ZERO) && checkIfNumberIsPrime(counter)) {
				System.out.println(counter);
				divisors.add(counter);

			}

		}

		return divisors;
	}
}
