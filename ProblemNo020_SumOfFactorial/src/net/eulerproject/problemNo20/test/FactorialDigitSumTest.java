package net.eulerproject.problemNo20.test;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;
import net.eulerproject.problemNo20.FactorialDigitSum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class FactorialDigitSumTest {

	private int n;
	private int expected;

	public FactorialDigitSumTest(int n, int expected) {
		this.n = n;
		this.expected = expected;

	}

	@Parameters
	public static Collection<Object[]> data() {

		Object[][] cases = { { 10, 27 }, { 3, 6 }, { 5, 3 }, { 6, 9 }, { 100, 648 } };

		return Arrays.asList(cases);
	}

	@Test
	public void test() {
		Assert.assertEquals(expected, new FactorialDigitSum(n).calculate());
	}

}
