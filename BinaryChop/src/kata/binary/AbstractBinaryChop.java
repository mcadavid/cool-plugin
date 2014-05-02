package kata.binary;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryChop {

	abstract int chop(int value, int[] source);

	protected List<Integer> convertIntArrayToList(int[] array) {
		List<Integer> newList = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			newList.add(array[i]);
		}
		return newList;
	}
}
