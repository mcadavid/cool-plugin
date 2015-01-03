package net.euler.problemNo029;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class DistinctPowersCounter {

	public int count(int limit) {

		Set<BigInteger> powers = new HashSet<>();

		if (limit < 2)
			throw new WrongParameterRange();

		for (int i = 2; i <= limit; i++) {
			for (int j = 2; j <= limit; j++) {
				BigInteger b = new BigInteger(j + "");
				powers.add(b.pow(i));
			}
		}
		return powers.size();
	}

}
