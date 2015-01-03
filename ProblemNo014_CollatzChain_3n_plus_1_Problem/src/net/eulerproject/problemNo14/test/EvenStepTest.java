package net.eulerproject.problemNo14.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import net.eulerproject.problemNo14.EvenStep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class EvenStepTest {

	long nextStep;
	long assertResult;

	public EvenStepTest(long nextStep, long assertResult) {
		this.nextStep = nextStep;
		this.assertResult = assertResult;
	}

	@Parameters
	public static Collection<Object[]> dataForCollatzSeries() {

		Object[][] cases = { { 2, 1 }, { 4, 2 }, { 8, 4 }, { 6, 3 } };

		return Arrays.asList(cases);
	}

	@Test
	public void test() {
		long result = new EvenStep(nextStep).calculate();
		assertEquals(assertResult, result);
	}
}