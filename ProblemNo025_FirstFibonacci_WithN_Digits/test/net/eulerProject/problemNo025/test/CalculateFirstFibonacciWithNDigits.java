package net.eulerProject.problemNo025.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import net.eulerProject.problemNo025.FirstFibonacciWithNDigitsCalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CalculateFirstFibonacciWithNDigits {

	private FirstFibonacciWithNDigitsCalculator calculator;
	private int numberOfDigits;
	private int fibonacciPosition;

	public CalculateFirstFibonacciWithNDigits(int numberOfDigits, int fibonacciPosition) {
		super();
		this.numberOfDigits = numberOfDigits;
		this.fibonacciPosition = fibonacciPosition;
	}

	@Parameters
	public static Collection<Object[]> data() throws IOException {

		Object[][] cases = { { 1, 1 }, { 2, 7 }, { 3, 12 }, { 4, 17 }, { 1000, 4782 } };

		return Arrays.asList(cases);
	}

	@Before
	public void setUp() {
		calculator = new FirstFibonacciWithNDigitsCalculator();
	}

	@Test
	public void testCalculatateFirstFibonacci() {
		Assert.assertEquals(fibonacciPosition, calculator.calculateFirstWithNumberOf(numberOfDigits));
	}

}
