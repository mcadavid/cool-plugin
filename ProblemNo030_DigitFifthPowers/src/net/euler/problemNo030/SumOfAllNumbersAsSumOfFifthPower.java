package net.euler.problemNo030;

public class SumOfAllNumbersAsSumOfFifthPower {

	public int calculateSum() {

		int[] fifthPowers = { 0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049 };
		int bigSum = 0;

		for (int i = 2; i < 999999; i++) {
			String inte = i + "";
			int sum = 0;

			for (int j = 0; j < inte.length(); j++) {
				int digit = new Integer(inte.substring(j, j + 1));
				sum += fifthPowers[digit];
			}

			if (sum == i) {

				bigSum += sum;
			}
		}
		return bigSum;
	}

}
