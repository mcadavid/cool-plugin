package net.eulerproject.problemNo18.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;
import net.eulerproject.problemNo18.MaximalPathSum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class MaximalPathSumTest {

	private MaximalPathSum maximalPathSum;
	private int expectedSumValue;

	@Parameters
	public static Collection<Object[]> data() throws IOException {

		Object[][] cases = { { new MaximalPathSum("test2.txt"), 23 }, { new MaximalPathSum("test3.txt"), 104 },
				{ new MaximalPathSum("test1.txt"), 1074 } };

		return Arrays.asList(cases);
	}

	/**
	 * 75<br>
	 * 95 64<br>
	 * 17 47 82<br>
	 * 18 35 87 10<br>
	 * 20 04 82 47 65<br>
	 * 19 01 23 75 03 34<br>
	 * 88 02 77 73 07 63 67<br>
	 * 99 65 04 28 06 16 70 92<br>
	 * 41 41 26 56 83 40 80 70 33<br>
	 * 41 48 72 33 47 32 37 16 94 29<br>
	 * 53 71 44 65 25 43 91 52 97 51 14<br>
	 * 70 11 33 28 77 73 17 78 39 68 17 57<br>
	 * 91 71 52 38 17 14 91 43 58 50 27 29 48<br>
	 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31<br>
	 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23<br>
	 */
	public MaximalPathSumTest(MaximalPathSum maximalPathSum, int expectedSumValue) {
		this.maximalPathSum = maximalPathSum;
		this.expectedSumValue = expectedSumValue;
	}

	@Test
	public void test() {
		Assert.assertEquals(this.expectedSumValue, maximalPathSum.calculate());
	}

}
