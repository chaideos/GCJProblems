package edu.personal.gcj;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TheLastWord {

	public String lastWord(String inputStr) {
		String start = "" + inputStr.charAt(0);
		for (int i = 1; i < inputStr.length(); i++) {
			String after = start + inputStr.charAt(i);
			String before = inputStr.charAt(i) + start;
			if (after.compareTo(before) > 0)
				start = after;
			else
				start = before;
		}
		return start;
	}

	public static void main(String s[]) {
		TheLastWord solution = new TheLastWord();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("A-large.in"));
			int T = scanner.nextInt();
			for (int i = 0; i < T; i++) {

				System.out.println(String.format("Case #%d: %s", i + 1, solution.lastWord(scanner.next())));

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
