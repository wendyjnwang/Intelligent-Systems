package tour;

import search.GoalTest;
import search.Node;
import search.GraphSearch;
import search.IterativeDeepeningTreeSearch;
import search.TreeSearch;
import search.DepthFirstFrontier;
import npuzzle.MisplacedTilesHeuristicFunction;
import npuzzle.NPuzzlePrinting;
import search.AStartFunction;
import search.BestFirstFrontier;
import search.BreadthFirstFrontier;


public class Search_Demo2 {
	public static void main(String[] args) {	
	Cities romania = SetUpRomania.getRomaniaMap();
	City startCity = romania.getState("Bucharest");	
	GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);


	BestFirstFrontier bsTreeFrontier= new BestFirstFrontier(new AStartFunction(new TourHeuristicFunction(romania.getAllCities(),startCity)));
	BestFirstFrontier bsGraphFrontier= new BestFirstFrontier(new AStartFunction(new TourHeuristicFunction(romania.getAllCities(),startCity)));
	TreeSearch aStartTreeSearch = new TreeSearch(bsTreeFrontier);
	GraphSearch aStarGraphSearch = new GraphSearch(bsGraphFrontier);

	
//	System.out.println("This is a demonstration of AStar Tree Search");                                                             		
//	Node solution = aStartTreeSearch.findSolution(new TourState(startCity), goalTest);
//	System.out.println("Max nodes Generated : " + aStartTreeSearch.getNumNodesGenerated());
//	System.out.println("Max nodes Stored : " + bsTreeFrontier.getMaxNodesStored());                  
//	new TourPrinting().printSolution(solution);
//	System.out.println();           		

	System.out.println("This is a demonstration of AStar Graph Search");                                                             		
	Node solution2 = aStarGraphSearch.findSolution(new TourState(startCity), goalTest);
	System.out.println("Max nodes Generated : " + aStarGraphSearch.getNumNodesGenerated());
	System.out.println("Max nodes Stored : " + bsGraphFrontier.getMaxNodesStored());                  
	new TourPrinting().printSolution(solution2);
    System.out.println();           	
	  
                                                               		                               
	
	}
}	
