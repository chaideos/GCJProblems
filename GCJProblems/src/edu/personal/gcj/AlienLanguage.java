package edu.personal.gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AlienLanguage {

	// The trick to solve this problem is to
	// 1. Parse the tokens under the '(' and then compare them
	// character by character with the words already present in the
	// dictionary.
	public int matchesCount(String word, List<String> words, int L) {
		int i = 0, k = 0;
		List<Character> tokens = new ArrayList<>();
		while (i < word.length() && k < L) {
			char ch = word.charAt(i);
			if (ch == '(') {
				int endIndex = word.indexOf(")", i + 1);
				for (int j = i + 1; j < endIndex; j++) {
					tokens.add(word.charAt(j));
				}
				i = endIndex;
			} else {
				tokens.add(ch);
			}
			Iterator<String> iterator = words.iterator();
			while (iterator.hasNext()) {
				char wordChar = iterator.next().charAt(k);
				if (!tokens.contains(wordChar)) {
					iterator.remove();
				}
			}
			tokens.clear();
			i++;
			k++;
		}
		return words.size();
	}

	public static void main(String[] args) {
		AlienLanguage solution = new AlienLanguage();
		List<String> existingWords = new ArrayList<>();
		List<String> dictionary = new ArrayList<>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("alien-language-large.in"));
			int L = scanner.nextInt();
			int D = scanner.nextInt();
			int N = scanner.nextInt();
			for (int i = 0; i < D; i++)
				dictionary.add(scanner.next());

			for (int i = 0; i < N; i++) {
				existingWords = new ArrayList<>(dictionary);
				System.out.println(
						String.format("Case #%d: %d", i + 1, solution.matchesCount(scanner.next(), existingWords, L)));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

}
