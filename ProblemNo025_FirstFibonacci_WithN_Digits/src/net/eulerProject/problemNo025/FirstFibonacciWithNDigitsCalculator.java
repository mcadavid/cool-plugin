package net.eulerProject.problemNo025;

import java.math.BigInteger;

/*The Fibonacci sequence is defined by the recurrence relation:

 Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.

 Hence the first 12 terms will be:

 F1 = 1
 F2 = 1
 F3 = 2
 F4 = 3
 F5 = 5
 F6 = 8
 F7 = 13
 F8 = 21
 F9 = 34
 F10 = 55
 F11 = 89
 F12 = 144

 The 12th term, F12, is the first term to contain three digits.
 */

public class FirstFibonacciWithNDigitsCalculator {

	BigInteger fiboN = BigInteger.ZERO;
	BigInteger fiboN_1 = BigInteger.ONE;
	BigInteger fiboN_2 = BigInteger.ONE;

	public int calculateFirstWithNumberOf(int digit) {
		if (digit == 1)
			return 1;

		int fiboCounter = 2;
		while (!checkIfNumberOfDigitsEqualsThan(digit)) {
			fiboCounter++;
			calculateNextFibonacci();
		}
		return fiboCounter;

	}

	private boolean checkIfNumberOfDigitsEqualsThan(int digit) {
		return fiboN.toString().length() == digit;
	}

	private void calculateNextFibonacci() {
		fiboN = fiboN_1.add(fiboN_2);
		fiboN_2 = fiboN_1;
		fiboN_1 = fiboN;
	}
}
