package npuzzle;

import search.GoalTest;
import search.Node;
import search.GraphSearch;
import search.IterativeDeepeningTreeSearch;
import search.TreeSearch;
import search.DepthFirstFrontier;
import search.BreadthFirstFrontier;

public class Search_Demo {
	public static void main(String[] args) {
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
//		Tiles initialConfiguration = new Tiles(new int[][] {
//			{ 0, 2},
//			{ 1, 3},
//		});		
		GoalTest goalTest = new TilesGoalTest(); 
		
		BreadthFirstFrontier bfTreeFrontier = new BreadthFirstFrontier();
		DepthFirstFrontier dfTreeFrontier = new DepthFirstFrontier();
		BreadthFirstFrontier bfGraphFrontier = new BreadthFirstFrontier();		
		DepthFirstFrontier dfGraphFrontier = new DepthFirstFrontier();  		
		TreeSearch bfTreeSearch = new TreeSearch(bfTreeFrontier);
		TreeSearch dfTreeSearch = new TreeSearch(dfTreeFrontier);
		GraphSearch bfGraphSearch = new GraphSearch(bfGraphFrontier);
		GraphSearch dfGraphSearch = new GraphSearch(dfGraphFrontier);
		IterativeDeepeningTreeSearch irdSearch = new IterativeDeepeningTreeSearch();
			
		
	
//		System.out.println("This is a demonstration of breadth-first tree search");                                                             		
////		long startTime = System.currentTimeMillis();
//		Node solution = bfTreeSearch.findSolution(initialConfiguration, goalTest);
////		long estimatedTime = System.currentTimeMillis() - startTime;
//		System.out.println("Max nodes Generated : " + bfTreeSearch.getNumNodesGenerated());
//		System.out.println("Max nodes Stored : " + bfTreeFrontier.getMaxNodesStored());                  
////		System.out.println( "Time Elapsed: "+ estimatedTime + " Milliseconds ");    
////		new NPuzzlePrinting().printSlution(solution);
//        System.out.println();                                                                  		                               
		
//		System.out.println("This is a demonstration of breadth-first Graph search");                                    
//		Node solution2 = bfGraphSearch.findSolution(initialConfiguration, goalTest);                           
//		System.out.println("Max nodes Generated : " +bfGraphSearch.getNumNodesGenerated());                                                                   
//		System.out.println("Max nodes Stored : " +bfGraphFrontier.getMaxNodesStored());           		
////		new NPuzzlePrinting().printSolution(solution2);
//        System.out.println();                                                                  		                               
		
//		System.out.println("This is a demonstration of depth-first tree search");                                    
//      System.out.println();                                                                  		                               
//		Node solution3 = dfTreeSearch.findSolution(initialConfiguration, goalTest);                           
//		System.out.println("Max nodes Generated : "+dfTreeSearch.getNumNodesGenerated());                                                                   
//		System.out.println("Max nodes Stored : " +dfTreeFrontier.getMaxNodesStored());            
//	    System.out.println();                                                                  		                               
	
//		System.out.println("This is a demonstration of depth-first Graph search");                                    
//		Node solution4 = dfGraphSearch.findSolution(initialConfiguration, goalTest);    
//		System.out.println("Max nodes Generated : " +dfGraphSearch.getNumNodesGenerated());                                                                   
//		System.out.println("Max nodes Stored : " +dfGraphFrontier.getMaxNodesStored());   		
////		new NPuzzlePrinting().printSolution(solution4);
//        System.out.println();                                                                  		                               

		System.out.println("This is a demonstration of Iterative Deepening search");                                    		
		Node solution5 = irdSearch.findSolution(initialConfiguration, goalTest);
		System.out.println("Max nodes Generated : " +irdSearch.getNumNodesGenerated());                                                                   
		System.out.println("Max nodes Stored : " +irdSearch.getMaxNodesStored());		
		new NPuzzlePrinting().printSolution(solution5);		
        System.out.println();                                                                  		                               
		

	}
}
