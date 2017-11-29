package search;

public class IterativeDeepeningTreeSearch implements Search {
	public Frontier frontier = new DepthFirstFrontier();
	int numNodesGenerated = 1 ;
	int limit = 0;
	boolean solutionFound = false;
	
	public int getMaxNodesStored() {
		return this.frontier.getMaxNodesStored();
	}
	@Override
	public Node findSolution(State initialConfiguration, GoalTest goalTest) {
		Node root = new SmartNode(null, null, initialConfiguration,0);
		
		frontier.addNode(root);		
		while (!solutionFound) {
			frontier.addNode(root);					
			while (!frontier.isEmpty()) {
				Node node = frontier.removeNode();
				SmartNode convertedNode = (SmartNode)node;
				int currentDepth = convertedNode.depth;
				if (goalTest.isGoal(node.state)) {
					solutionFound = true;
					return node;
				}
				else {
					int childDepth = currentDepth +1;
					if (childDepth <= limit) {			
						for (Action action : node.state.getApplicableActions()) {
							State newState = node.state.getActionResult(action);
							frontier.addNode(new SmartNode(node, action, newState,childDepth));
							numNodesGenerated++;
						}
					}
				}
			}
			limit ++;
			frontier.clearContents();
//numNodesGenerated = 1;
//			return null;
		}
		return null;	
	}

	@Override
	public int getNumNodesGenerated() {
		return numNodesGenerated;
	}

}
