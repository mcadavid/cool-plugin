package net.eulerproject.problemNo19;

public class NumberOfSundays {

	public NumberOfSundays(int i, int j) {

	}

	public static int calculate() {

		int[] firstOfMonthDays = { 1, 32, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335 };

		int[] firstOfMonthDaysLeap = { 1, 32, 61, 92, 122, 153, 183, 214, 245, 275, 306, 336 };

		int counter = 0;
		for (int year = 1901; year < 2001; year++) {

			if (!isLeapYear(year)) {
				for (int i = 0; i < firstOfMonthDays.length; i++) {

					if (firstOfMonthDays[i] % 7 == moduloWhatIsYear(year)) {
						counter++;
						int month = i + 1;
						System.out.println("First of " + month + "-th month was a sunday of year " + year);
					}
				}
			} else {
				for (int i = 0; i < firstOfMonthDaysLeap.length; i++) {

					if (firstOfMonthDaysLeap[i] % 7 == moduloWhatIsYear(year)) {
						counter++;
						int month = i + 1;
						System.out.println("First of " + month + "-th month was a sunday of year " + year);
					}
				}
			}
		}
		System.out.println();
		return counter;
	}

	private static int moduloWhatIsYear(int year) {

		switch ((year - 1901) % 28) {
		case 0:
			return 6;
		case 6:
			return 6;
		case 17:
			return 6;
		case 23:
			return 6;
		case 1:
			return 5;
		case 7:
			return 5;
		case 12:
			return 5;
		case 18:
			return 5;
		case 2:
			return 4;
		case 13:
			return 4;
		case 19:
			return 4;
		case 24:
			return 4;
		case 3:
			return 3;
		case 8:
			return 3;
		case 14:
			return 3;
		case 25:
			return 3;
		case 9:
			return 2;
		case 15:
			return 2;
		case 20:
			return 2;
		case 26:
			return 2;
		case 4:
			return 1;
		case 10:
			return 1;
		case 21:
			return 1;
		case 27:
			return 1;
		case 5:
			return 0;
		case 11:
			return 0;
		case 16:
			return 0;
		default:
			return 0;

		}

	}

	private static boolean isLeapYear(int year) {
		return (year % 4 == 0);
	}

	public static void main(String[] args) {

		System.out.println("The number of sundays is " + calculate());
	}

}
