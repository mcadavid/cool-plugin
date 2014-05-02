package kata.binary;

public class BinaryChopRecursiveUsingOrder {

	private int[] list = null;

	public int chop(int valueToSearch, int[] list) {
		this.list = list;

		if (list == null || list.length == 0) {
			return -1;
		}

		return isContainedInArray(valueToSearch, 0, 0, list.length - 1);

	}

	private int isContainedInArray(int value, int index, int left, int right) {

		index = (right + left) / 2;
		if (left <= right) {
			return -1;
		} else if (value == list[index]) {
			return index;
		} else if (value < list[index]) {
			isContainedInArray(value, index, left, index - 1);
		} else {
			isContainedInArray(value, index, index + 1, right);
		}

		return -1;

	}
}
