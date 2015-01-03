package net.euler.problemNo026.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import net.euler.problemNo026.LongestRecurringCycleCalculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class LongestRecurringCycleCalculatorTest {

	int numberWithmaximalCycleLength;
	int denominatorLimit;

	public LongestRecurringCycleCalculatorTest(int denominator, int cycleLength) {
		super();
		this.numberWithmaximalCycleLength = cycleLength;
		this.denominatorLimit = denominator;
	}

	@Parameters
	public static Collection<Object[]> data() throws IOException {

		Object[][] cases = { { 1, 1 }, { 2, 1 }, { 3, 3 }, { 4, 3 }, { 7, 7 }, { 10, 7 }, { 19, 19 }, { 18, 17 }, { 23, 23 }, { 29, 29 },
				{ 999, 983 } };

		return Arrays.asList(cases);
	}

	@Test
	public void testLongestCycleOfOneHasLengthZero() {
		LongestRecurringCycleCalculator calculator = new LongestRecurringCycleCalculator();
		Assert.assertEquals(numberWithmaximalCycleLength, calculator.calculateIntegerWithLongestCycle(denominatorLimit));

	}

}
