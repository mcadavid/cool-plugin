package net.eulerproject.problemNo10;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SumOfFirstNthPrimeNumbersTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("---");
	}

	@Test
	public void testCalculate() {
		SumOfFirstNthPrimeNumbers sumCalculator = new SumOfFirstNthPrimeNumbers();
		long sum = sumCalculator.calculate(6);
		assertEquals(10, sum);
	}
	
	@Test
	public void testCalculate2() {
		SumOfFirstNthPrimeNumbers sumCalculator = new SumOfFirstNthPrimeNumbers();
		long sum = sumCalculator.calculate(7);
		assertEquals(10, sum);
	}
	
	@Test
	public void testCalculate3() {
		SumOfFirstNthPrimeNumbers sumCalculator = new SumOfFirstNthPrimeNumbers();
		long sum = sumCalculator.calculate(8);
		assertEquals(17, sum);
	}
	
	@Test
	public void testCalculate4() {
		SumOfFirstNthPrimeNumbers sumCalculator = new SumOfFirstNthPrimeNumbers();
		long sum = sumCalculator.calculate(12);
		assertEquals(28, sum);
	}
	
	@Test
	public void testCalculate4_1() {
		SumOfFirstNthPrimeNumbers sumCalculator = new SumOfFirstNthPrimeNumbers();
		long sum = sumCalculator.calculate(14);
		assertEquals(41, sum);
	}
	
	@Test
	public void testCalculate5() {
		SumOfFirstNthPrimeNumbers sumCalculator = new SumOfFirstNthPrimeNumbers();
		long sum = sumCalculator.calculate(2000000);
		System.out.println(sum);
	}

}
