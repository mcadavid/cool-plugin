package kata.binary;

import java.util.Arrays;

public class BinaryRecursiveChop {

	public int chop(int valueToSearch, int[] list) {
		if (list == null || list.length == 0) {
			return -1;
		}

		return isContainedInArray(valueToSearch, list, 0);

	}

	private int isContainedInArray(int value, int[] list, int index) {
		if (list.length == 1) {
			if (list[0] == value) {
				return index;
			}
		} else if (list.length == 2) {
			if (list[0] == value) {
				return index;
			} else if (list[1] == value) {
				return index + 1;
			}
		} else {
			int middle = list.length / 2 + 1;
			int indexWasFound = isContainedInArray(value, Arrays.copyOfRange(list, 0, middle), index);
			if (indexWasFound == -1) {
				indexWasFound = isContainedInArray(value, Arrays.copyOfRange(list, middle, list.length), middle);
			}
			return indexWasFound;
		}

		return -1;
	}

}
