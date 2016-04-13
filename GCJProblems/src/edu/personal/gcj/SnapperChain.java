package edu.personal.gcj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class SnapperChain {

	// The logic here is that we divide the snapsCount by every bit or index
	// which is a snapper device
	// By representing the state of the snapper devices as a binary string, we
	// can see that after every nth odd snap of the bit, the snapper device is
	// on and off for an nth even snap
	public boolean isLightOn(int devicesCount, int snapsCount) {
		boolean isOn = true;
		int[] snapperSet = new int[devicesCount];
		for (int i = 0; i < devicesCount; i++) {
			snapperSet[i] = 0;
		}
		for (int i = 0; i < devicesCount; i++) {
			snapperSet[i] = (snapsCount / (int) (Math.pow(2, i))) % 2;
		}

		for (int i = 0; i < snapperSet.length && isOn; i++) {
			isOn &= snapperSet[i] == 1;
		}
		return isOn;
	}

	public static void main(String s[]) {
		SnapperChain solution = new SnapperChain();
		Writer out = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("snapper-chain-large.in"));
			out = new FileWriter(new File("answer.out"));
			int T = scanner.nextInt();
			for (int i = 0; i < T; i++) {
				int N = scanner.nextInt();
				int K = scanner.nextInt();
				String state = solution.isLightOn(N, K) ? "ON" : "OFF";
				// Always check the no. of test cases, for test cases > 1000
				// make sure you directly write into a file rather than printing
				// using System.out to save time while upload
				out.write(String.format("Case #%d: %s\n", i + 1, state));
				// Always flush otherwise you might have certain output from the
				// buffer not written into the file
				out.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
