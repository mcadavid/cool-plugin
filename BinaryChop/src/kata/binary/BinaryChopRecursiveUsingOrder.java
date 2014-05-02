package kata.binary;

public class BinaryChopRecursiveUsingOrder {

	private int[] list = null;

	public int chop(int valueToSearch, int[] list) {
		this.list = list;

		if (list == null || list.length == 0) {
			return -1;
		}

		return isContainedInArray(valueToSearch, 0, 0, list.length - 1, -1);

	}

	private int isContainedInArray(int value, int index, int left, int right, int foundIndex) {

		if (left <= right && value != list[index]) {
			index = (right + left) / 2;

			if (value < list[index]) {
				foundIndex = isContainedInArray(value, index, left, index - 1, foundIndex);
			} else {
				foundIndex = isContainedInArray(value, index, index + 1, right, foundIndex);
			}
		}

		if (value == list[index]) {
			return index;
		} else if (foundIndex != -1) {
			return foundIndex;
		} else {
			return -1;
		}
	}
}
