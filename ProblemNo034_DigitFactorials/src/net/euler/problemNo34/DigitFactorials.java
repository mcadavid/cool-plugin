package net.euler.problemNo34;

public class DigitFactorials {

	public int calculateSumOfAllDigitFactorials() {

		int factorials[] = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
		int sum = 6;
		int bigsum = 0;
		int factorial = 3;

		while (factorial < 10000000) {
			sum = 0;
			char[] digits = (factorial + "").toCharArray();

			for (int j : digits) {
				sum += factorials[j - 48];
			}
			if (sum == factorial) {
				System.out.println("the sum of factorial digits of " + factorial + " is " + sum);
				bigsum += sum;
			}
			factorial++;

		}
		return bigsum;
	}
}
