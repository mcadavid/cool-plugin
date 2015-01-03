package net.eulerproject.problem022;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamesValueCalculator {

	private Map<String, Integer> values = new HashMap<>();

	public NamesValueCalculator() {
		super();
		init();
		System.out.println("The value of all names is " + calculateAll());
	}

	public int calculateAll() {
		int value = 0;
		Path namesFile = Paths.get("./", "names.txt");

		try {
			List<String> namesList = Files.readAllLines(namesFile, StandardCharsets.ISO_8859_1);
			String names = namesList.get(0);
			String[] namesArray = names.split(",");

			Arrays.sort(namesArray);
			for (int i = 0; i < namesArray.length; i++) {
				value += calculate(namesArray[i], i + 1);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		return value;
	}

	private int calculate(String name, int position) {
		String nameUpper = name.toUpperCase();
		nameUpper = nameUpper.replace("\"", "");
		char[] nc = nameUpper.toCharArray();
		int value = 0;
		for (int i = 0; i < nc.length; i++) {
			value += values.get(nc[i] + "");
		}
		value = value * position;
		return value;
	}

	private void init() {
		char[] ls = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for (int i = 0; i < ls.length; i++) {
			values.put(ls[i] + "", i + 1);
		}

	}

	public static void main(String[] args) {
		System.out.println(("The value is " + new NamesValueCalculator().calculateAll()));
	}

}
