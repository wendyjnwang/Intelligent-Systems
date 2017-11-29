package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public int depth = 0; 
	// totalCost keeps track of the cost of the path from the root
	public int pathCost = 0 ;
	public int cost = 0;

	
	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		if (parent == null)
			this.depth = 0; 
		else 
			this.depth = parent.depth + 1;
		if (parent == null)
			this.pathCost = 0;
		else 
			this.pathCost = parent.pathCost + action.returnCost();
	}
	
}
