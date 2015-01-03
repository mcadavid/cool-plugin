package net.euler.problemNo032;

public class PandigitalCalculator {
	public static void main(String[] args) {
		for (int i = 1; i < 9999; i++) {
			for (int j = i; j < 9999; j++) {
				int produkt = i * j;
				if (isPan(i, j, produkt)) {
					System.out.println(i + " x " + j + " = " + produkt);
				}
			}
		}
	}

	private static boolean isPan(int... numbers) {
		String digits[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String all = "";
		for (int i : numbers) {
			all += i + "";
		}

		if (all.length() != 9 || all.contains("0")) {
			return false;
		}

		String replaceFirst = all;
		for (String digit : digits) {
			replaceFirst = replaceFirst.replaceFirst(digit, "0");
		}

		if (Integer.valueOf(replaceFirst) == 0) {
			return true;
		}

		return false;
	}

}
