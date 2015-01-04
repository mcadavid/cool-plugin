package net.euler.problemNo34;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class DigitFactorialsTest {

	private int sumExpected;
	private DigitFactorials calculator;

	public DigitFactorialsTest(int sumCalculated) {
		super();
		this.sumExpected = sumCalculated;
	}

	@Parameters
	public static Collection<Object[]> data() throws IOException {

		Object[][] cases = { { 40730 } };

		return Arrays.asList(cases);
	}

	@Before
	public void setUp() throws Exception {
		calculator = new DigitFactorials();
	}

	@Test
	public void testComputePossibilitiesForGivenPences() {
		Assert.assertEquals(sumExpected, calculator.calculateSumOfAllDigitFactorials());
	}
}
