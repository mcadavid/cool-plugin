package net.euler.problemNo027.test;

import net.euler.problemNo027.CoefficientProductMaximalQuadraticPrimeExpresion;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class CoefficientProductMaximalQuadraticPrimeExpresionTest {

	private CoefficientProductMaximalQuadraticPrimeExpresion productCalculator = new CoefficientProductMaximalQuadraticPrimeExpresion();

	@Test
	@Ignore
	public void testCalculateProductForCoefficientsSmallerThan1000() {

		Assert.assertEquals(-1, productCalculator.calculate(1000));

	}

	@Test
	@Ignore
	public void testCalculateProductForCoefficientsSmallerThan42() {

		Assert.assertEquals(-41, productCalculator.calculate(42));

	}

}
