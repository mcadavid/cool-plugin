package kata.binary;

import java.util.Arrays;

public class BinaryChopRecursive extends AbstractBinaryChop {

	private int[] list = null;

	@Override
	public int chop(int valueToSearch, int[] list) {
		this.list = list;

		if (list == null || list.length == 0) {
			return -1;
		}

		return isContainedInArray(valueToSearch, 0, 0, list.length - 1, -1);

	}

	private int isContainedInArray(int value, int index, int left, int right, int foundIndex) {

		index = (right + left) / 2;
		if (left > right) {
			return -1;
		}
		if (value == list[index]) {
			return index;
		}

		int[] newArray = Arrays.copyOfRange(list, left, index);

		if (convertIntArrayToList(newArray).contains(value)) {
			return isContainedInArray(value, index, left, index - 1, foundIndex);
		} else {
			return isContainedInArray(value, index, index + 1, right, foundIndex);
		}

	}

}
