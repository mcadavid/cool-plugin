package net.eulerproject.problemNo23;

import java.util.ArrayList;
import java.util.List;

public class SemiAbundantNumber {

	public final static int KNOWN_LIMIT = 28123;
	private List<Integer> abundantNumbers = new ArrayList<>();

	public void calculateSumNonOfSemiAbundantNumbers(int limit) {
		calculateAllBelowLimit(limit);

		int sumOfNonSemiAbundantNumber = 0;
		int sumOfSemiAbundantNumber = 0;

		for (int i = 1; i <= limit; i++) {

			boolean numberIsSemiAbundant = false;
			int limitForSearch = Math.min(i, abundantNumbers.size());
			for (int j = 0; j < limitForSearch; j++) {

				int abundantNumber = abundantNumbers.get(j);
				int diff = i - abundantNumber;
				if (abundantNumber < i && isAbundant(diff)) {
					numberIsSemiAbundant = true;

					sumOfSemiAbundantNumber += i;
					break;
				}
			}
			if (!numberIsSemiAbundant) {
				sumOfNonSemiAbundantNumber += i;
			}
		}

		System.out.println(sumOfNonSemiAbundantNumber + " is the sum of non-semi abundant numbers");
		System.out.println(sumOfSemiAbundantNumber + " is the sum of semi abundant numbers");
		int testSum = sumOfNonSemiAbundantNumber + sumOfSemiAbundantNumber;
		System.out.println((limit * (limit + 1) / 2) + " = " + testSum);
	}

	public void calculateAllBelowLimit(int limit) {
		for (int i = 1; i <= limit; i++) {
			if (isAbundant(i)) {
				abundantNumbers.add(i);
			}
		}
	}

	// all prime numbers are non-abundant
	private boolean isAbundant(int i) {
		int sumOfDivisors = calculateSumOfDivisors(i);
		if (sumOfDivisors > i) {
			return true;
		}
		return false;

	}

	private int calculateSumOfDivisors(int number) {
		int sumOfDivisors = 1;
		// the number itself is not included (of course, otherwise would be
		// every number abundant)
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				sumOfDivisors += i;
			}
		}

		return sumOfDivisors;
	}

	public static void main(String[] args) {

		new SemiAbundantNumber().calculateSumNonOfSemiAbundantNumbers(KNOWN_LIMIT);
	}
}
