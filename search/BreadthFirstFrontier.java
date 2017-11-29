package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFrontier implements Frontier{
	Queue<Node> frontier = new LinkedList<Node>();
	int maxNodes = 0;
	@Override
	public void addNode(Node newNode) {
		this.frontier.add(newNode);		
		int currentNodesCount = this.frontier.size();
		if (currentNodesCount > maxNodes )
			maxNodes = currentNodesCount;
	}

	@Override
	public void clearContents() {
		this.frontier.clear();
	}

	@Override
	public boolean isEmpty() {
		return this.frontier.isEmpty();
	}

	@Override
	public Node removeNode() {
		return this.frontier.remove();
		
	}

	@Override
	public int getMaxNodesStored() {
		return maxNodes;
	}
	
}