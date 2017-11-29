package mars;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import npuzzle.MisplacedTilesHeuristicFunction;
import npuzzle.TilesGoalTest;
import search.AStartFunction;
import search.BestFirstFrontier;
import search.BreadthFirstFrontier;
import search.DepthFirstFrontier;
import search.GoalTest;
import search.GraphSearch;
import search.IterativeDeepeningTreeSearch;
import search.TreeSearch;
import tour.City;
import search.Node;

public class Search_Demo {

	public static void main(String[] args) {
	
		Planet planet = new Planet();
		Set<Tile> visitedTiles = new LinkedHashSet<Tile>();		
		visitedTiles.add(new Tile(4,4));
		Robot initialConfiguration = new Robot(planet,4,4,0,visitedTiles);
		GoalTest goalTest = new RobotGoalTest(); 
		
		BestFirstFrontier bsTreeFrontier= new BestFirstFrontier(new AStartFunction(new UnvisitedTilesHeuristicFunction()));
		BestFirstFrontier bsGraphFrontier= new BestFirstFrontier(new AStartFunction(new UnvisitedTilesHeuristicFunction()));
		TreeSearch aStartTreeSearch = new TreeSearch(bsTreeFrontier);
		GraphSearch aStarGraphSearch = new GraphSearch(bsGraphFrontier);
		
		System.out.println("This is a demonstration of AStar Tree Search");                                                             		
		Node solution = aStartTreeSearch.findSolution(initialConfiguration, goalTest);
		System.out.println("Max nodes Generated : " + aStartTreeSearch.getNumNodesGenerated());
		System.out.println("Max nodes Stored : " + bsTreeFrontier.getMaxNodesStored());                  
		new MarsPrinting().printSolution(solution);
		System.out.println("Visited different grid squares: " + ((Robot)solution.state).getVisitedTiles().size());		
	    System.out.println();                                                                  		                               
		
		System.out.println("This is a demonstration of AStar Graph Search");                                                             		
		Node solution2 = aStarGraphSearch.findSolution(initialConfiguration, goalTest);
		System.out.println("Max nodes Generated : " + aStarGraphSearch.getNumNodesGenerated());
		System.out.println("Max nodes Stored : " + bsGraphFrontier.getMaxNodesStored());                  
		new MarsPrinting().printSolution(solution2);
		System.out.println("Visited different grid squares: " + ((Robot)solution2.state).getVisitedTiles().size());				
		System.out.println();                                                    		                               
		                                    			   	
		
}
	
}
