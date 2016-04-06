package edu.personal.gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RopeIntranet {

	class Wire {
		private int first;
		private int second;

		public Wire(int first, int second) {
			this.first = first;
			this.second = second;
		}

		public int getFirst() {
			return this.first;
		}

		public int getSecond() {
			return this.second;
		}

		public boolean intersects(Wire other) {
			return (first - other.first) * (second - other.second) < 0;
		}
	}

	public int numOfIntersections(List<Wire> wires) {
		int count = 0;
		for (int i = 0; i < wires.size() - 1; i++) {
			Wire source = wires.get(i);
			for (int j = i + 1; j < wires.size(); j++) {
				if (source.intersects(wires.get(j)))
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		RopeIntranet solution = new RopeIntranet();
		Scanner scanner = null;

		try {
			scanner = new Scanner(new File("rope-intranet-large.in"));
			int T = scanner.nextInt();

			for (int i = 0; i < T; i++) {
				int N = scanner.nextInt();
				List<Wire> wires = new ArrayList<>();
				for (int j = 0; j < N; j++) {
					Wire wire = solution.new Wire(scanner.nextInt(), scanner.nextInt());
					wires.add(wire);
				}

				System.out.println(String.format("Case #%d: %d", i + 1, solution.numOfIntersections(wires)));
				wires.clear();
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
