package net.euler.problemNo026;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LongestRecurringCycleCalculator {

	private static final BigInteger ZERO = BigInteger.ZERO;
	private static final BigInteger TEN = BigInteger.TEN;

	List<BigInteger> oldRemainderList = new ArrayList<>();

	public int calculateIntegerWithLongestCycle(int denominator) {

		int maxLenght = 0;
		int numberWithLongestCycle = 1;
		for (int j = 2; j <= denominator; j++) {

			int calculateCycleLength = calculateCycleLength(j);
			System.out.println();
			if (maxLenght < calculateCycleLength) {
				maxLenght = calculateCycleLength;
				numberWithLongestCycle = j;
			}
		}
		return numberWithLongestCycle;
	}

	private int calculateCycleLength(int i) {
		BigInteger remainder = TEN.remainder(new BigInteger(i + ""));
		oldRemainderList = new ArrayList<>();
		oldRemainderList.add(new BigInteger(remainder.toString()));

		while (remainder.compareTo(ZERO) > 0) {
			remainder = remainder.multiply(TEN).remainder(new BigInteger(i + ""));
			if (oldRemainderList.contains(remainder)) {
				return oldRemainderList.size() - calculatePositionOfRemainder(remainder);
			}
			oldRemainderList.add(new BigInteger(remainder.toString()));
		}
		return 0;
	}

	private int calculatePositionOfRemainder(BigInteger remainder) {
		for (int i = 0; i < oldRemainderList.size(); i++) {
			if (oldRemainderList.get(i).equals(remainder)) {
				return i;
			}
		}
		return -1;
	}

}
