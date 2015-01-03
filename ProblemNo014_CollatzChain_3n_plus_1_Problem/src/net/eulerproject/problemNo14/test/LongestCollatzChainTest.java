package net.eulerproject.problemNo14.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import net.eulerproject.problemNo14.LongestCollatzChain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class LongestCollatzChainTest {

	int expectedLongestChain;
	int limit;

	public LongestCollatzChainTest(int limit, int expectedLongestChain) {
		super();
		this.expectedLongestChain = expectedLongestChain;
		this.limit = limit;
	}

	@Parameters
	public static Collection<Object[]> dataForCollatzSeries() {

		Object[][] cases = { { 2, 2 }, { 4, 3 }, { 8, 7 }, { 6, 6 }, { 100, 97 }, { 200, 171 }, { 40, 27 }, { 10000, 6171 }, { 100000, 77031 },
				{ 1000000, 837799 } };

		return Arrays.asList(cases);

	}

	@Test
	public void test() {
		long longestChain = new LongestCollatzChain(limit).calculate();

		assertEquals(expectedLongestChain, longestChain);
	}
}
