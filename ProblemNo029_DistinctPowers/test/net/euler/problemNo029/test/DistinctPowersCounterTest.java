package net.euler.problemNo029.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;
import net.euler.problemNo029.DistinctPowersCounter;
import net.euler.problemNo029.WrongParameterRange;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class DistinctPowersCounterTest {

	int limit;

	int expectedNumberOfPowers;

	public DistinctPowersCounterTest(int limit, int expectedNumberOfPowers) {
		super();
		this.limit = limit;
		this.expectedNumberOfPowers = expectedNumberOfPowers;
	}

	@Parameters
	public static Collection<Object[]> data() throws IOException {

		Object[][] cases = { { 2, 1 }, { 3, 4 }, { 5, 15 }, { 100, 9183 } };

		return Arrays.asList(cases);
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = WrongParameterRange.class)
	public void testCallCountWithException() {
		DistinctPowersCounter counter = new DistinctPowersCounter();
		counter.count(1);
	}

	@Test
	public void testCountPowersFor2and2() {
		DistinctPowersCounter counter = new DistinctPowersCounter();
		Assert.assertEquals(expectedNumberOfPowers, counter.count(limit));
	}

}
