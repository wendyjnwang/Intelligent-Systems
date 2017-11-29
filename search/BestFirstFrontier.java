package search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier{
	
	Comparator<Node> comparator = new NodeComparator();
	PriorityQueue<Node> frontier = new PriorityQueue<Node>(comparator);
	NodeFunction nodeFunction; 
	int maxNodes = 0;
	
	public BestFirstFrontier(NodeFunction function) {
		this.nodeFunction = function;
		}

	@Override
	public void addNode(Node newNode) {
		/* invoke the evaluation function on the node to 
		determine the node’s cost and store the cost in the node.*/
		
		newNode.cost = this.nodeFunction.computeCost(newNode);
//		System.out.print(newNode.cost);
//		System.out.println();
		frontier.add(newNode);
		int currentNodesCount = this.frontier.size();
		if (currentNodesCount > maxNodes )
			maxNodes = currentNodesCount;
		
	}

	@Override
	public void clearContents() {
		frontier.clear();
	}

	@Override
	public boolean isEmpty() {
		return frontier.isEmpty();
	}

	@Override
	public Node removeNode() {
		return frontier.remove();
	}

	@Override
	public int getMaxNodesStored() {
		return maxNodes;
	}

}
