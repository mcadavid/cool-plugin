package kata.binary.test;

import static org.junit.Assert.assertEquals;
import kata.binary.BinaryRecursiveChopFirstTry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinaryChopRecursiveTestFirstTry extends AbstractBinaryChopTest {

	public BinaryChopRecursiveTestFirstTry(int[] source, int what, int index) {
		super(source, what, index);
	}

	@Test
	public void testBinaryIsCalled() {
		assertEquals(expectedIndex, new BinaryRecursiveChopFirstTry().chop(value, source));
	}

}
