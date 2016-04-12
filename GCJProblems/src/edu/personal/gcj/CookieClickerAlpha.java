package edu.personal.gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Solution to 2014 Qualification Round Problem Magic Trick
public class CookieClickerAlpha {

	public double minSecs(double C, double F, double X) {
		double farmBuyTime = 0.0;
		double minSecs = Double.MAX_VALUE;
		int numOfFarms = 0;
		double cookiesPerSec = (F * numOfFarms) + 2.0;
		double timeToWin = X / cookiesPerSec;
		while (minSecs > timeToWin) {
			minSecs = timeToWin;
			numOfFarms++;
			farmBuyTime += C / cookiesPerSec;
			cookiesPerSec = (F * numOfFarms) + 2.0;
			timeToWin = farmBuyTime + (X / cookiesPerSec);
		}
		return minSecs;
	}

	public static void main(String[] args) {
		CookieClickerAlpha solution = new CookieClickerAlpha();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("cookie-clicker-large.in"));
			int T = scanner.nextInt();
			for (int i = 0; i < T; i++) {
				double C = scanner.nextDouble();
				double F = scanner.nextDouble();
				double X = scanner.nextDouble();
				double numOfSecs = solution.minSecs(C, F, X);
				System.out.println(String.format("Case #%d: %.7f", i + 1, numOfSecs));
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
