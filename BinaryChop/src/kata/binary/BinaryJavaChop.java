package kata.binary;

import java.util.Arrays;

public class BinaryJavaChop extends AbstractBinaryChop {
	@Override
	public int chop(int value, int[] source) {
		if (source == null) {
			return -1;
		}
		int index = Arrays.binarySearch(source, value);
		if (index < 0) {
			index = -1;
		}
		return index;
	}

}
