package net.euler.problemNo028.test;

import net.euler.problemNo028.SumOfDiagonalsOfANumberSpiralCalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumOfDiagonalsOfANumberSpiralCalculatorTest {
	SumOfDiagonalsOfANumberSpiralCalculator calculator;

	@Before
	public void setUp() throws Exception {
		calculator = new SumOfDiagonalsOfANumberSpiralCalculator();
	}

	@Test
	public void testSumOfDiagonalesIsOneWithAnOneByOneSqare() {
		SumOfDiagonalsOfANumberSpiralCalculator calculator = new SumOfDiagonalsOfANumberSpiralCalculator();
		Assert.assertEquals(1, calculator.calculate(1));
	}

	@Test
	public void testSumOfDiagonalesIsOneWithAn3x3Sqare() {
		SumOfDiagonalsOfANumberSpiralCalculator calculator = new SumOfDiagonalsOfANumberSpiralCalculator();
		Assert.assertEquals(25, calculator.calculate(3));
	}

	@Test
	public void testSumOfDiagonalesIsOneWithAn5x5Sqare() {
		SumOfDiagonalsOfANumberSpiralCalculator calculator = new SumOfDiagonalsOfANumberSpiralCalculator();
		Assert.assertEquals(101, calculator.calculate(5));
	}

	@Test
	public void testSumOfDiagonalesIsOneWithAn1001x1001qare() {
		SumOfDiagonalsOfANumberSpiralCalculator calculator = new SumOfDiagonalsOfANumberSpiralCalculator();
		Assert.assertEquals(669171001, calculator.calculate(1001));
	}

}
