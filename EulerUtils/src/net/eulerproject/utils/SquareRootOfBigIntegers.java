package net.eulerproject.utils;

import java.math.BigInteger;

public class SquareRootOfBigIntegers {

	public static BigInteger calculateSquareRoot(BigInteger n) {

		BigInteger G = new BigInteger((n.shiftRight((n.bitLength() + 1) / 2)).toString());
		BigInteger LastG = null;
		BigInteger One = BigInteger.ONE;

		while (true) {
			LastG = G;
			G = n.divide(G).add(G).shiftRight(1);

			int i = G.compareTo(LastG);

			if (i == 0) {
				return G;
			} else if (i < 0) {
				if (LastG.subtract(G).compareTo(One) == 0) {
					if (G.multiply(G).compareTo(n) < 0 && LastG.multiply(LastG).compareTo(n) > 0) {
						return G;
					}
				} else {
					if (G.subtract(LastG).compareTo(One) == 0) {
						if (LastG.multiply(LastG).compareTo(n) < 0 && G.multiply(G).compareTo(n) > 0) {
							return LastG;
						}
					}
				}
			}

		}

	}

}
