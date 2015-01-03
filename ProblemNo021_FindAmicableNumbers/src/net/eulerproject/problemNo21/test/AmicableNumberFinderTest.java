package net.eulerproject.problemNo21.test;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;
import net.eulerproject.problemNo21.AmicableNumberFinder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class AmicableNumberFinderTest {

	private int n;
	private int expected;

	public AmicableNumberFinderTest(int n, int expected) {
		this.n = n;
		this.expected = expected;

	}

	@Parameters
	public static Collection<Object[]> data() {

		Object[][] cases = { { 10, 0 }, { 20, 0 }, { 100, 0 }, { 500, 504 }, { 10000, 31626 } };

		return Arrays.asList(cases);
	}

	@Test
	public void test() {
		System.out.println();
		Assert.assertEquals(expected, new AmicableNumberFinder(n).calculate());
	}

}
