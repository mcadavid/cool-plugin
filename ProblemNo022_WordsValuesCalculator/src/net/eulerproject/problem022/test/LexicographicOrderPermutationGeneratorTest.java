package net.eulerproject.problem022.test;

import java.util.Arrays;
import java.util.Collection;

import net.eulerproject.problem022.LexicographicOrderPermutationGenerator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class LexicographicOrderPermutationGeneratorTest {

	private int memberNr;
	private String expected;
	private int limit;

	@Parameters
	public static Collection<Object[]> data() {

		Object[][] cases = { { 10, 0, "0" }, { 20, 0, "0" }, { 100, 0, "0" }, { 500, 504, "0" }, { 10000, 31626, "0" } };

		return Arrays.asList(cases);
	}

	public LexicographicOrderPermutationGeneratorTest(int limit, int memberNr, String expected) {
		this.limit = limit;
		this.memberNr = memberNr;
		this.expected = expected;

	}

	@Test
	public void testGeneratePermutationOrderMember() {
		LexicographicOrderPermutationGenerator generator = new LexicographicOrderPermutationGenerator(limit);
		String combination = generator.generatePermutationOrderMember(memberNr);
		if (combination == null)
			combination = "0";
		Assert.assertEquals(combination, expected);
	}

}
