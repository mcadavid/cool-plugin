package net.eulerProject.problemNo024.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import net.eulerProject.problemNo024.LexicographicalOrderOfPermutations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class LexicographicalOrderOfPermutationsTest {

	private int permut;
	private int numberOf;
	private String value;

	@Parameters
	public static Collection<Object[]> data() throws IOException {

		// 0123 0132 0213 0231 0312 0321 -- first iterations of 4 elements
		// 012 021 102 120 201 210
		Object[][] cases = { { 3, 3, "102" }, { 4, 3, "0213" }, { 4, 6, "0321" }, { 10, 1000000, "2783915460" } };

		return Arrays.asList(cases);
	}

	public LexicographicalOrderOfPermutationsTest(int permut, int numberOf, String value) {
		this.permut = permut;
		this.numberOf = numberOf;
		this.value = value;

	}

	@Test
	public void testThirdPermutationWhenNumberIsThree() {
		System.out.println("***********");
		String permutation = new LexicographicalOrderOfPermutations(permut).getPermutation(numberOf);
		assertEquals(value, permutation);

	}

}
