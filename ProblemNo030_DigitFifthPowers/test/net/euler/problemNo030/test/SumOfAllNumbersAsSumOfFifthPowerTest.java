package net.euler.problemNo030.test;

import net.euler.problemNo030.SumOfAllNumbersAsSumOfFifthPower;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumOfAllNumbersAsSumOfFifthPowerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateSumCalculator() {
		SumOfAllNumbersAsSumOfFifthPower calculator = new SumOfAllNumbersAsSumOfFifthPower();
		Assert.assertEquals(443839, calculator.calculateSum());
	}
}
