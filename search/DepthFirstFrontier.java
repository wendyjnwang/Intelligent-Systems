package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier{
	Stack<Node> frontier = new Stack<Node>();
	int maxNodes = 0;
	@Override
	public void addNode(Node newNode) {
		this.frontier.push(newNode);
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
		return this.frontier.empty();
	}

	@Override
	public Node removeNode() {
		return this.frontier.pop();
		
	}

	@Override
	public int getMaxNodesStored() {
		return maxNodes;
	}
	
}