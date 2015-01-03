package net.euler.problemNo031.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import net.euler.problemNo031.CalculateNumberPossibilitiesWithCoins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CalculateNumberPossibilitiesWithCoinsTest {

	private int amount;
	private int expectedNumberOfPosibilities;

	CalculateNumberPossibilitiesWithCoins calculator;

	public CalculateNumberPossibilitiesWithCoinsTest(int amount, int expectedNumberOfResponsabilities) {
		super();
		this.amount = amount;
		this.expectedNumberOfPosibilities = expectedNumberOfResponsabilities;
	}

	@Parameters
	public static Collection<Object[]> data() throws IOException {

		Object[][] cases = { { 1, 1 }, { 2, 2 }, { 3, 2 }, { 5, 4 }, { 10, 11 }, { 200, 73682 } };

		return Arrays.asList(cases);
	}

	@Before
	public void setUp() throws Exception {
		calculator = new CalculateNumberPossibilitiesWithCoins();
	}

	@Test
	public void testComputePossibilitiesForGivenPences() {
		Assert.assertEquals(expectedNumberOfPosibilities, calculator.computePossibilitiesForAmountInPences(amount));
	}

}
