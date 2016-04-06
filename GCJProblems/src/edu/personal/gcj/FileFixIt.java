package edu.personal.gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileFixIt {

	public int numOfCommands(List<String> existing, List<String> toBeCreated) {
		int count = 0;
		for (String makeDir : toBeCreated) {
			int fromIndex = 0;
			while ((fromIndex = makeDir.indexOf("/", fromIndex + 1)) != -1) {
				String target = makeDir.substring(0, fromIndex);
				if (!exists(target, existing)) {
					count++;
					existing.add(target);
				}
			}
			if (!exists(makeDir, existing)) {
				count++;
				existing.add(makeDir);
			}

		}
		return count;
	}

	private boolean exists(String target, List<String> existing) {
		return existing.contains(target);
	}

	public static void main(String[] args) {
		FileFixIt solution = new FileFixIt();
		Scanner scanner = null;

		try {
			scanner = new Scanner(new File("file-fixit-large.in"));
			int T = scanner.nextInt();
			List<String> source = new ArrayList<>();
			List<String> target = new ArrayList<>();
			for (int i = 0; i < T; i++) {
				int N = scanner.nextInt();
				int M = scanner.nextInt();
				for (int j = 0; j < N; j++)
					source.add(scanner.next());
				for (int j = 0; j < M; j++)
					target.add(scanner.next());
				System.out.println(String.format("Case #%d: %d", i + 1, solution.numOfCommands(source, target)));
				source.clear();
				target.clear();
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
