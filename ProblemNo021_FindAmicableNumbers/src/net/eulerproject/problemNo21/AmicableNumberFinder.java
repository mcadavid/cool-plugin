package net.eulerproject.problemNo21;

import java.util.Set;

public class AmicableNumberFinder {

	private int upperLimit;
	private Set<AmicablePair> amicableNumbers;

	class AmicablePair {
		int theSmaller;
		int theBigger;

		public AmicablePair(int oneFriend, int theOther) {
			if (oneFriend < theOther) {
				this.theSmaller = oneFriend;
				this.theBigger = theOther;
			} else {
				this.theSmaller = theOther;
				this.theBigger = oneFriend;
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			AmicablePair pairToCompare = (AmicablePair) obj;

			if (pairToCompare.theBigger == this.theBigger && pairToCompare.theSmaller == this.theSmaller) {
				return true;
			}

			return false;
		}

	}

	public AmicableNumberFinder(int n) {
		this.upperLimit = n;

	}

	public int calculate() {

		int sum = 0;
		for (int i = 1; i < this.upperLimit; i++) {

			int sumDivisors = sumDivisors(i);

			if (i != sumDivisors && isAmicable(i, sumDivisors)) {
				System.out.println("The following numbers are friends " + i + "<->" + sumDivisors);
				sum = sum + i + sumDivisors;
			}
		}
		return sum / 2;
	}

	public boolean isAmicable(int oneFriend, int theOther) {
		if (sumDivisors(oneFriend) == theOther && sumDivisors(theOther) == oneFriend) {
			return true;
		}
		return false;
	}

	private int sumDivisors(int oneFriend) {

		int sumDivisors = 0;
		for (int i = 1; i <= oneFriend / 2; i++) {

			if (oneFriend % i == 0) {
				sumDivisors = sumDivisors + i;
			}
		}
		return sumDivisors;
	}
}
