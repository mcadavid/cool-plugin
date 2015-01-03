package net.eulerproject.problemNo18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MaximalPathSum {

	List<PathNode[]> nodes;
	int maximalSum = 0;

	public MaximalPathSum(String fileName) throws IOException {
		parseEntry(fileName);
	}

	public void parseEntry(String fileName) throws IOException {

		FileReader fr = new FileReader("src/" + fileName);
		BufferedReader br = new BufferedReader(fr);
		nodes = new ArrayList<PathNode[]>();
		fillCollectionWithNodes(br, nodes);
		fr.close();

	}

	private void fillCollectionWithNodes(BufferedReader br, Collection<PathNode[]> nodeCollection) throws IOException {
		String s;
		while ((s = br.readLine()) != null) {
			String[] nodeContent = s.split(" ");
			PathNode[] nodes = new PathNode[nodeContent.length];
			for (int i = 0; i < nodeContent.length; i++) {
				nodes[i] = new PathNode();
				nodes[i].value = Integer.valueOf(nodeContent[i]);
			}
			nodeCollection.add(nodes);
		}
	}

	public int calculate(int level, int pos, int currentLength) {

		PathNode nextLeft = null;
		PathNode nextDown = null;

		if (level + 1 < nodes.size()) {
			nextLeft = pos - 1 >= 0 ? nodes.get(level + 1)[pos - 1] : null;
			nextDown = pos < nodes.get(level + 1).length ? nodes.get(level + 1)[pos] : null;
		}

		PathNode current = nodes.get(level)[pos];

		current.currentLength = currentLength + current.value;

		int totalLength = current.currentLength;

		if (nextLeft != null) {

			totalLength = current.currentLength + nextLeft.maxLengthOfPathBeginingHere;

			if (totalLength > maximalSum) {
				maximalSum = totalLength;
			}

			if (!nextLeft.alreadyTracked) {
				calculate(level + 1, pos - 1, current.currentLength);
			}
		}
		if (nextDown != null) {

			totalLength = current.currentLength + nextDown.maxLengthOfPathBeginingHere;

			if (totalLength > maximalSum) {
				maximalSum = totalLength;
			}

			if (!nextDown.alreadyTracked) {
				calculate(level + 1, pos, current.currentLength);
			}
		}

		if (nextDown == null && nextLeft == null && totalLength > maximalSum) {
			maximalSum = totalLength;
		}

		current.maxLengthOfPathBeginingHere = current.value + max(nextDown, nextLeft);
		current.alreadyTracked = true;

		return maximalSum;
	}

	private int max(PathNode nextDown, PathNode nextLeft) {

		int down = nextDown != null ? nextDown.maxLengthOfPathBeginingHere : 0;
		int left = nextLeft != null ? nextLeft.maxLengthOfPathBeginingHere : 0;

		return Math.max(down, left);
	}

	public int calculate() {

		PathNode[] firstRow = nodes.get(0);
		for (int i = 0; i < firstRow.length; i++) {
			calculate(0, i, 0);
		}
		return maximalSum;
	}
}
