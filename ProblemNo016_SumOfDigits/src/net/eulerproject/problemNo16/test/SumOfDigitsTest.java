package net.eulerproject.problemNo16.test;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import net.eulerproject.problemNo16.SumOfDigits;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SumOfDigitsTest {

	int sum;
	private BigInteger bigint;

	@Parameters
	public static Collection<Object[]> data() {

		Object[][] cases = { { new BigInteger("123"), 6 }, { new BigInteger("11111111"), 8 }, { new BigInteger("1000000000000"), 1 },
				{ new BigInteger("3"), 3 }, { pow(), 1366 } };

		return Arrays.asList(cases);
	}

	public SumOfDigitsTest(BigInteger bigint, int sum) {
		super();
		this.bigint = bigint;
		this.sum = sum;
	}

	@Test
	public void testCalculate() {

		int sumOfDigits = new SumOfDigits(this.bigint).calculate();

		assertEquals(sum, sumOfDigits);
	}

	private static BigInteger pow() {
		return new BigInteger("2").pow(1000);
	}

}
