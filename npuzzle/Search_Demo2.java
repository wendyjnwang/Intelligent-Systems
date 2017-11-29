package npuzzle;

import search.GoalTest;
import search.Node;
import search.GraphSearch;
import search.IterativeDeepeningTreeSearch;
import search.TreeSearch;
import search.DepthFirstFrontier;
import search.BreadthFirstFrontier;
import search.BestFirstFrontier;
import search.AStartFunction;
import search.NodeFunction;

public class Search_Demo2 {
	public static void main(String[] args) {
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});

		GoalTest goalTest = new TilesGoalTest(); 
			
		BestFirstFrontier bsTreeFrontier= new BestFirstFrontier(new AStartFunction(new MisplacedTilesHeuristicFunction()));
		BestFirstFrontier bsGraphFrontier= new BestFirstFrontier(new AStartFunction(new MisplacedTilesHeuristicFunction()));
		TreeSearch aStartTreeSearch = new TreeSearch(bsTreeFrontier);
		GraphSearch aStarGraphSearch = new GraphSearch(bsGraphFrontier);
		
		System.out.println("This is a demonstration of AStar Tree Search");                                                             		
		Node solution = aStartTreeSearch.findSolution(initialConfiguration, goalTest);
		System.out.println("Max nodes Generated : " + aStartTreeSearch.getNumNodesGenerated());
		System.out.println("Max nodes Stored : " + bsTreeFrontier.getMaxNodesStored());                  
//		new NPuzzlePrinting().printSolution(solution);
        System.out.println();                                                                  		                               
		
		System.out.println("This is a demonstration of AStar Graph Search");                                                             		
		Node solution2 = aStarGraphSearch.findSolution(initialConfiguration, goalTest);
		System.out.println("Max nodes Generated : " + aStarGraphSearch.getNumNodesGenerated());
		System.out.println("Max nodes Stored : " + bsGraphFrontier.getMaxNodesStored());                  
//		new NPuzzlePrinting().printSolution(solution2);
		System.out.println();                                                    		                               
		                                                           		                               
	}
}
