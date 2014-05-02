package kata.binary.test;

import static org.junit.Assert.assertEquals;
import kata.binary.BinaryNewListsIterativeChop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinaryNewListsIterativeChopTest extends AbstractBinaryChopTest {

	public BinaryNewListsIterativeChopTest(int[] source, int value, int expectedIndex) {
		super(source, value, expectedIndex);
	}

	@Test
	public void test() {
		assertEquals(expectedIndex, new BinaryNewListsIterativeChop().chop(value, source));
	}
}
