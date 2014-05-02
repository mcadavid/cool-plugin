package kata.binary.test;

import java.util.Arrays;

import org.junit.runners.Parameterized.Parameters;

public abstract class AbstractBinaryChopTest {

	protected int[] source;
	protected int value;
	protected int expectedIndex;

	public AbstractBinaryChopTest(int[] source, int value, int expectedIndex) {
		this.source = source;
		this.value = value;
		this.expectedIndex = expectedIndex;
	}

	@Parameters(name = "{index}: binaryChop({1})={2}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { null, 1, -1 },//
				{ new int[5], 1, -1 },//
				{ new int[] { 3 }, 1, -1 }, //
				{ new int[] { 1, 3, 5 }, 1, 0 }, //
				{ new int[] { 1, 3, 5 }, 3, 1 },//
				{ new int[] { 1, 3, 5 }, 5, 2 }, //
				{ new int[] { 1, 3, 5 }, 0, -1 },//
				{ new int[] { 1, 3, 5 }, 2, -1 },//
				{ new int[] { 1, 3, 5 }, 4, -1 }, //
				{ new int[] { 1, 3, 5, 7 }, 1, 0 },//
				{ new int[] { 1, 3, 5, 7 }, 3, 1 },//
				{ new int[] { 1, 3, 5, 7 }, 5, 2 }, //
				{ new int[] { 1, 3, 5, 7 }, 0, -1 },//
				{ new int[] { 1, 3, 5, 7 }, 4, -1 }, //
				{ new int[] { 1, 3, 5, 7 }, 6, -1 }, //
				{ new int[] { 1, 3, 5, 7 }, 8, -1 }, //
				{ new int[] { 1, 3, 5, 7 }, 8, -1 } //
				});
	}

}
