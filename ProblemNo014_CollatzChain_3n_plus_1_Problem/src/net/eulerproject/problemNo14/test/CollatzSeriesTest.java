package net.eulerproject.problemNo14.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import net.eulerproject.problemNo14.CollatzSeries;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CollatzSeriesTest {

	long startingPoint;
	long expectedSeriesLength;

	public CollatzSeriesTest(int startingPoint, int expectedSeriesLength) {
		super();
		this.startingPoint = startingPoint;
		this.expectedSeriesLength = expectedSeriesLength;
	}

	@Parameters
	public static Collection<Object[]> dataForCollatzSeries() {

		Object[][] cases = { { 13, 10 }, { 1, 1 }, { 2, 2 }, { 4, 3 }, { 8, 4 }, { 16, 5 }, { 7, 17 } };

		return Arrays.asList(cases);
	}

	@Test
	public void test() {
		long length = new CollatzSeries(this.startingPoint).calculate();
		assertEquals(this.expectedSeriesLength, length);
	}
}
