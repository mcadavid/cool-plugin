package net.euler.problemNo031;

public class CalculateNumberPossibilitiesWithCoins {

	private int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200 };

	public int computePossibilitiesForAmountInPences(int pences) {

		int possibilities = 0;

		for (int i = 1; i < 99999; i++) {

			String inte = i + "";
			int sum = 0;
			boolean illegalInput = false;
			for (int j = 0; j < inte.length(); j++) {
				int digit = new Integer(inte.substring(j, j + 1));
				if (digit < 8 && digit > 0) {
					sum += coins[digit - 1];
				} else {
					illegalInput = true;
					break;
				}
				if (sum > pences) {
					break;
				}
			}

			if (sum == pences && !illegalInput) {
				System.out.println(i);
				possibilities++;
			}
		}
		return possibilities;

	}

}
