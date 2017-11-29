package search;

public class AStartFunction implements NodeFunction {

	NodeFunction heuristic;
	// Constructor accepts an NodeFunction as heuristic
	public AStartFunction(NodeFunction heuristic) {
		this.heuristic = heuristic;
		}	
	
	@Override
	public int computeCost(Node node) {
		//Return the path cost + heuristic cost 
		return node.pathCost + this.heuristic.computeCost(node);
	}

}
