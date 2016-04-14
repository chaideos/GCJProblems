package edu.personal.gcj;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpeakingInTongues {

	private final Map<Character, Character> translationMap = new HashMap<>();

	public SpeakingInTongues() {
		initMap();
	}

	private void initMap() {
		translationMap.put('a', 'y');
		translationMap.put('b', 'h');
		translationMap.put('c', 'e');
		translationMap.put('d', 's');
		translationMap.put('e', 'o');

		translationMap.put('f', 'c');
		translationMap.put('g', 'v');
		translationMap.put('h', 'x');
		translationMap.put('i', 'd');
		translationMap.put('j', 'u');

		translationMap.put('k', 'i');
		translationMap.put('l', 'g');
		translationMap.put('m', 'l');
		translationMap.put('n', 'b');
		translationMap.put('o', 'k');

		translationMap.put('p', 'r');
		translationMap.put('q', 'z');
		translationMap.put('r', 't');
		translationMap.put('s', 'n');
		translationMap.put('t', 'w');

		translationMap.put('u', 'j');
		translationMap.put('v', 'p');
		translationMap.put('w', 'f');
		translationMap.put('x', 'm');
		translationMap.put('y', 'a');

		translationMap.put('z', 'q');
	}

	public String translate(String googlereseStr) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < googlereseStr.length(); i++) {
			Character translatedChar = translationMap.get(googlereseStr.charAt(i));
			if (translatedChar != null)
				builder.append(translatedChar);
			else
				builder.append(googlereseStr.charAt(i));
		}
		return builder.toString();
	}

	public static void main(String s[]) {
		SpeakingInTongues solution = new SpeakingInTongues();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("speaking-in-tongues-small.in"));
			int T = Integer.parseInt(scanner.nextLine());
			for (int i = 0; i < T; i++) {
				String inputString = scanner.nextLine();
				System.out.println(String.format("Case #%d: %s", i + 1, solution.translate(inputString)));

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
