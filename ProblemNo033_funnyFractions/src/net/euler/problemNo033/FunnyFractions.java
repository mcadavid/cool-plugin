package net.euler.problemNo033;

import java.math.BigInteger;

public class FunnyFractions {

	public static void main(String[] args) {
		int numProdukt = 4;
		int denProdukt = 8;

		for (int i = 11; i < 100; i++) {
			for (int j = i; j < 100; j++) {
				BigInteger gcd = BigInteger.valueOf(i).gcd(BigInteger.valueOf(j));
				if (gcd.compareTo(BigInteger.ONE) > 0 && i != j && i % 10 != 0 && j % 10 != 0) {

					int a = i / 10;
					int b = i % 10;
					int c = j / 10;
					int d = j % 10;

					if (b == c) {
						int nummerator = (i) / gcd.intValue();
						int denominator = (j) / gcd.intValue();

						if (nummerator < 10 && denominator < 10) {

							if ((b == c && nummerator == a && denominator == d)) {

								System.out.println(i + "/" + j + " = " + nummerator + "/" + denominator + "(* gcd = " + gcd.intValue() + " *)");

								numProdukt *= i;
								denProdukt *= j;

							}
						}
					}
				}
			}
		}

		BigInteger numProdBig = BigInteger.valueOf(numProdukt);
		BigInteger denProdBig = BigInteger.valueOf(denProdukt);

		BigInteger endGcd = numProdBig.gcd(denProdBig);
		System.out.println(denProdBig.divide(endGcd));
	}
}
