package net.euler.problemNo031;

public class CalculateNumberPossibilitiesWithCoins {

	private int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200 };

	public int computePossibilitiesForAmountInPences(int pences) {

		int maxValues[] = { pences, pences / 2, pences / 5, pences / 10, pences / 20, pences / 50, pences / 100, pences / 200 };
		int possibilities = 0;

		for (int i1 = 0; i1 <= maxValues[0]; i1++) {
			for (int i2 = 0; i2 <= maxValues[1]; i2++) {
				for (int i3 = 0; i3 <= maxValues[2]; i3++) {
					for (int i4 = 0; i4 <= maxValues[3]; i4++) {
						for (int i5 = 0; i5 <= maxValues[4]; i5++) {
							for (int i6 = 0; i6 <= maxValues[5]; i6++) {
								for (int i7 = 0; i7 <= maxValues[6]; i7++) {
									for (int i8 = 0; i8 <= maxValues[7]; i8++) {
										int sum = i1 * coins[0] + i2 * coins[1] + i3 * coins[2] + i4 * coins[3] + i5 * coins[4] + i6 * coins[5] + i7
												* coins[6] + i8 * coins[7];
										if (sum == pences) {
											possibilities++;
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return possibilities;

	}
}
