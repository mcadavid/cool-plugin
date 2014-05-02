package kata.binary;

public class BinaryIterativeChop {

	public int chop(int value, int[] list) {
		if (list == null || list.length == 0) {
			return -1;
		}

		return searchList(value, list);
	}

	private int searchList(int value, int[] list) {
		int x = 0, left, right = 0;
		left = 0;
		right = list.length - 1;

		while (left <= right && value != list[x]) {
			x = (left + right) / 2;
			if (value < list[x]) {
				right = x - 1;
			} else {
				left = x + 1;
			}
		}

		if (value == list[x]) {
			return x;
		} else {
			return -1;
		}
	}
}
