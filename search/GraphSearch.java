package search;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class GraphSearch implements Search{
	Frontier frontier;
	int numNodesGenerated = 1 ;
	
	public GraphSearch(Frontier ft) {
		this.frontier = ft;
	}
	@Override
	public Node findSolution(State initialConfiguration, GoalTest goalTest) {
		Node root = new Node(null, null, initialConfiguration);
		frontier.addNode(root);		
		Set<State> explored = new HashSet <State>();
		
		while (!frontier.isEmpty()) {
			Node node = frontier.removeNode();
			if (goalTest.isGoal(node.state)) {
				return node;
			}
			else {
				boolean visited = false;				
				for (State state : explored) {
					if (state.equals(node.state)) {
						visited = true; 
						break;
					}		
				}				
				if (!visited) {
					explored.add(node.state);
					for (Action action : node.state.getApplicableActions()) {
						State newState = node.state.getActionResult(action);
						boolean newVisited = false;
						for (State state : explored) {
							if (state.equals(newState)) {
								newVisited = true; 
								break;
							}		
						}
					
						if (!newVisited) {
							Node newNode = new Node(node,action,newState);
							frontier.addNode(newNode);
							numNodesGenerated++;					
					}
				}
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
