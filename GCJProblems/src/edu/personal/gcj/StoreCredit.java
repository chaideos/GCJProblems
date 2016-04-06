package edu.personal.gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StoreCredit {

	public String itemString(int C, int[] items, int caseNum) {
		int first = 0, second = 0;
		boolean selected = false;
		for (int i = 0; i < items.length - 1 && !selected; i++) {
			for (int j = i + 1; j < items.length; j++) {
				if (items[i] + items[j] == C) {
					first = i + 1;
					second = j + 1;
					selected = true;
					break;
				}
			}
		}
		return String.format("Case #%d: %d %d", caseNum + 1, first, second);
	}

	public static void main(String[] args) {
		StoreCredit solution = new StoreCredit();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("store-credit-large.in"));
			int N = scanner.nextInt();
			for (int i = 0; i < N; i++) {
				int credit = scanner.nextInt();
				int numOfItems = scanner.nextInt();
				int[] items = new int[numOfItems];
				for (int j = 0; j < numOfItems; j++) {
					items[j] = scanner.nextInt();
				}
				System.out.println(solution.itemString(credit, items, i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

}
