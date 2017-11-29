package mars;
import search.Node;
import search.NodeFunction;;
public class UnvisitedTilesHeuristicFunction implements NodeFunction{

	@Override
	/* The heuristic function is to count how many tiles are unvisited. 
	   The less tiles unvisited, the lower its heuristic. 
	 */
	public int computeCost(Node node) {
		Robot robotState = (Robot)node.state;
		int totalTiles = robotState.planet.height() * robotState.planet.width();
		return (totalTiles - robotState.getVisitedTiles().size());		
		
	}
}
