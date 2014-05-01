package kata.binary.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import kata.binary.BinaryRecursiveChop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BinaryChopRecursiveTest {

	private int[] source;
	private int what;
	private int expectedIndex;

	public BinaryChopRecursiveTest(int[] source, int what, int index) {
		super();
		this.source = source;
		this.what = what;
		this.expectedIndex = index;
	}

	@Parameters(name = "{index}: binaryChop({1})={2}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { null, 1, -1 }, { new int[5], 1, -1 }, { new int[] { 3 }, 1, -1 }, //
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
				{ new int[] { 1, 3, 5, 7 }, 8, -1 } });

	}

	@Test
	public void testBinaryIsCalled() {
		assertEquals(expectedIndex, new BinaryRecursiveChop().chop(what, source));
	}

}
