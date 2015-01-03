package net.eulerproject.problemNo14.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import net.eulerproject.problemNo14.OddStep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class OddStepTest {

	long nextStep;
	long assertResult;

	public OddStepTest(long nextStep, long assertResult) {
		this.nextStep = nextStep;
		this.assertResult = assertResult;
	}

	@Parameters
	public static Collection<Object[]> dataForCollatzSeries() {

		Object[][] cases = { { 2, 7 }, { 4, 13 }, { 8, 25 }, { 6, 19 } };

		return Arrays.asList(cases);
	}

	@Test
	public void test() {
		long result = new OddStep(nextStep).calculate();
		assertEquals(assertResult, result);
	}
}
