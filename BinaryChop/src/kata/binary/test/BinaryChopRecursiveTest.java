package kata.binary.test;

import static org.junit.Assert.assertEquals;
import kata.binary.BinaryRecursiveChop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinaryChopRecursiveTest extends AbstractBinaryChopTest {

	public BinaryChopRecursiveTest(int[] source, int what, int index) {
		super(source, what, index);
	}

	@Test
	public void testBinaryIsCalled() {
		assertEquals(expectedIndex, new BinaryRecursiveChop().chop(what, source));
	}

}
