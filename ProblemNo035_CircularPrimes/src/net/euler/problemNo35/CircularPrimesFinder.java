package net.euler.problemNo35;

import net.eulerproject.utils.PrimeNumbersUtils;

public class CircularPrimesFinder {

	public static void main(String[] args) {
		int numberOfPrimes = 13;
		for (int i = 101; i < 1000000; i = i + 2) {

			String rot = String.valueOf(i);
			if (rot.contains("0") || rot.contains("2") || rot.contains("4") || rot.contains("6") || rot.contains("8")) {
				continue;
			}

			if (PrimeNumbersUtils.isPrime(i)) {

				boolean isCircularPrime = true;

				for (int j = 0; j < rot.length(); j++) {
					rot = rot.substring(1) + rot.charAt(0);
					if (!PrimeNumbersUtils.isPrime(Integer.parseInt(rot))) {
						isCircularPrime = false;
						break;
					}
				}
				if (isCircularPrime) {
					numberOfPrimes++;
				}

			}
		}

		System.out.println(numberOfPrimes);

	}
}
