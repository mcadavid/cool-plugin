package net.eulerproject.problemNo12.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import net.eulerproject.problemNo12.TriangleNumberDivisorCalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TriangleNumberDivisorCalculatorTest {

	private int number;
	private int expectedValue;

	public TriangleNumberDivisorCalculatorTest(int number, int expectedValue) {
		this.number = number;
		this.expectedValue = expectedValue;
	}

	@Parameters
	public static Collection<Object[]> dataForNumberOfDivisors() {

		Object[][] data = new Object[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 4 }, { 5, 4 }, { 6, 4 }, { 7, 6 }, { 2000, 128 } };

		return Arrays.asList(data);
	}

	@Test
	public void pushTest() {

		TriangleNumberDivisorCalculator calc = new TriangleNumberDivisorCalculator();

		int numberOfDivisors = calc.numberOfTheNthTriangleNumberDivisors(number);

		System.out.println("Triangle Number is : " + number + "\tExpected:" + expectedValue);

		assertEquals("Wrong number of divisors", expectedValue, numberOfDivisors);
	}

}
