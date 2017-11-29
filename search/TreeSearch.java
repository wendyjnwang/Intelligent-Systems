package search;

import java.util.Collections;
import java.util.Set;

import tour.City;

public class TreeSearch implements Search {
	Frontier frontier;
	int numNodesGenerated = 1 ;
	
	public TreeSearch(Frontier ft) {
		this.frontier = ft;
	}
	@Override
	public Node findSolution(State initialConfiguration, GoalTest goalTest) {
		Node root = new Node(null, null, initialConfiguration);
		frontier.addNode(root);		
		while (!frontier.isEmpty()) {
			Node node = frontier.removeNode();
			if (goalTest.isGoal(node.state)) 
				return node;
			else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					frontier.addNode(new Node(node, action, newState));
					numNodesGenerated++;
				}
			}
		}
		frontier.clearContents();
		return null;
	}
	@Override
	public int getNumNodesGenerated() {
		
		return numNodesGenerated;
	}	
}
