package edu.personal.gcj;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StandingOvation {

	// We calculate for every level how many people we need to invite so that
	// all the people with that shyness level start clapping
	// AFter inviting a set of friends, we include them and the people upto
	// shyness level k-1 and then make a determination whether that count is
	// greater than k or not
	public int minPeopleToInvite(String audienceShyness, int maxShyness) {
		int minInviteCount = 0;
		int[] shyPeople = new int[maxShyness + 1];
		for (int i = 0; i < shyPeople.length; i++) {
			shyPeople[i] = new Integer("" + audienceShyness.charAt(i));
		}
		int applaudingCount = shyPeople[0];
		for (int i = 1; i <= maxShyness; i++) {
			if (applaudingCount < i) {
				minInviteCount++;
				applaudingCount++;
			}
			applaudingCount += shyPeople[i];
		}
		return minInviteCount;
	}

	public static void main(String s[]) {
		StandingOvation solution = new StandingOvation();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("standing-ovation-large.in"));
			int T = scanner.nextInt();
			for (int i = 0; i < T; i++) {
				int Smax = scanner.nextInt();
				String shyString = scanner.next();
				System.out.println(String.format("Case #%d: %d", i + 1, solution.minPeopleToInvite(shyString, Smax)));

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
