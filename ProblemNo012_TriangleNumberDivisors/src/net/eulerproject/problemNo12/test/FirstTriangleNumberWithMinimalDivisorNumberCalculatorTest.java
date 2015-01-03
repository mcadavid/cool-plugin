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
public class FirstTriangleNumberWithMinimalDivisorNumberCalculatorTest {

	private int numberOfDivisors;
	private int expectedValue;
	private int startingValue;

	public FirstTriangleNumberWithMinimalDivisorNumberCalculatorTest(int number, int expectedValue, int startingValue) {
		this.numberOfDivisors = number;
		this.expectedValue = expectedValue;
		this.startingValue = startingValue;
	}

	@Parameters
	public static Collection<Object[]> dataForTriangleNumber() {

		Object[][] data = new Object[][] { { 1, 1, 1 }, { 2, 3, 2 }, { 4, 6, 3 }, { 5, 28, 2 }, { 100, 73920, 380 }, { 200, 2031120, 2010 },
				{ 300, 2162160, 2070 }, { 350, 17907120, 5984 }, { 400, 17907120, 5984 }, { 450, 17907120, 5984 }, { 480, 76576500, 8000 },
				{ 485, 76576500, 6000 }, { 490, 76576500, 6000 }, { 491, 76576500, 6000 } };

		return Arrays.asList(data);
	}

	public void testFirstTriangleNumberWithNumberOfDivisorsEqual() {
		TriangleNumberDivisorCalculator calc = new TriangleNumberDivisorCalculator();

		int firstTriangleNumber = calc.firstTriangleNumberWithNumberOfDivisorsEqual(numberOfDivisors);

		System.out.println("Parameterized Number is : " + firstTriangleNumber + "\tExpected:" + expectedValue);

		assertEquals("Wrong triangle number", expectedValue, firstTriangleNumber);
	}

	@Test
	public void testFirstTriangleNumberWithNumberOfDivisorsEqualWithStartingValue() {
		TriangleNumberDivisorCalculator calc = new TriangleNumberDivisorCalculator();

		int firstTriangleNumber = calc.firstTriangleNumberWithNumberOfDivisorsEqual(numberOfDivisors, startingValue);

		System.out.println("Parameterized Number is : " + firstTriangleNumber + "\tExpected:" + expectedValue);

		assertEquals("Wrong triangle number", expectedValue, firstTriangleNumber);
	}

}
