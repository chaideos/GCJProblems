package edu.personal.gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Solution to 2014 Qualification Round Problem Magic Trick
public class MagicTrick {

	public void guessMagicCard(int firstGuess, int[][] first, int secondGuess, int[][] second, int caseNum) {
		Set<Integer> firstMagicSet = new HashSet<>();
		Set<Integer> secondMagicSet = new HashSet<>();
		for (int i = 0; i < 4; i++)
			firstMagicSet.add(first[firstGuess - 1][i]);

		for (int i = 0; i < 4; i++)
			secondMagicSet.add(second[secondGuess - 1][i]);

		firstMagicSet.retainAll(secondMagicSet);
		if (firstMagicSet.size() == 0)
			System.out.println(String.format("Case #%d: Volunteer cheated!", caseNum));
		else if (firstMagicSet.size() > 1)
			System.out.println(String.format("Case #%d: Bad magician!", caseNum));
		else
			System.out.println(String.format("Case #%d: %d", caseNum, firstMagicSet.iterator().next()));
	}

	public static void main(String[] args) {
		MagicTrick solution = new MagicTrick();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("magic-trick-small.in"));
			int T = scanner.nextInt();
			for (int i = 0; i < T; i++) {
				int[][] firstArrangement = new int[4][4];
				int[][] secondArrangement = new int[4][4];
				int firstGuess = scanner.nextInt();
				for (int j = 0; j < 4; j++) {
					for (int k = 0; k < 4; k++)
						firstArrangement[j][k] = scanner.nextInt();
				}
				int secondGuess = scanner.nextInt();
				for (int j = 0; j < 4; j++) {
					for (int k = 0; k < 4; k++)
						secondArrangement[j][k] = scanner.nextInt();
				}
				solution.guessMagicCard(firstGuess, firstArrangement, secondGuess, secondArrangement, i + 1);
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
