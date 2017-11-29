package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SearchTesting {
	public static Node findSolution(State initialConfiguration, GoalTest goalTest) {
		BreadthFirstFrontier frontier = new BreadthFirstFrontier();
//		DepthFirstFrontier frontier = new DepthFirstFrontier();
	
		frontier.addNode(new Node(null, null, initialConfiguration));
		while (!frontier.isEmpty()){
			Node node = frontier.removeNode();
			if (goalTest.isGoal(node.state))
				return node;
			else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					frontier.addNode(new Node(node, action, newState));
				}
			}
		}
		frontier.clearContents();
		return null;
	}
}
