package tour;


import search.GoalTest;
import search.Node;
import search.GraphSearch;
import search.IterativeDeepeningTreeSearch;
import search.TreeSearch;
import search.DepthFirstFrontier;
import search.BreadthFirstFrontier;


public class Search_demo_dummy {
	public static void main(String[] args) {	
	Cities romania = SetUpRomania.getRomaniaMap();
	City startCity = romania.getState("Bucharest");	
	GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);

	BreadthFirstFrontier bfTreeFrontier = new BreadthFirstFrontier();
	DepthFirstFrontier dfTreeFrontier = new DepthFirstFrontier();
	BreadthFirstFrontier bfGraphFrontier = new BreadthFirstFrontier();		
	DepthFirstFrontier dfGraphFrontier = new DepthFirstFrontier();  		
	TreeSearch bfTreeSearch = new TreeSearch(bfTreeFrontier);
	TreeSearch dfTreeSearch = new TreeSearch(dfTreeFrontier);
	GraphSearch bfGraphSearch = new GraphSearch(bfGraphFrontier);
	GraphSearch dfGraphSearch = new GraphSearch(dfGraphFrontier);
	IterativeDeepeningTreeSearch irdSearch = new IterativeDeepeningTreeSearch();
		
	

//	System.out.println("This is a demonstration of breadth-first tree search");                                                             		
////	long startTime = System.currentTimeMillis();
//	Node solution = bfTreeSearch.findSolution(new TourState(startCity), goalTest);
////	long estimatedTime = System.currentTimeMillis() - startTime;
//	System.out.println("Max nodes Generated : " + bfTreeSearch.getNumNodesGenerated());
//	System.out.println("Max nodes Stored : " + bfTreeFrontier.getMaxNodesStored());                  
////	System.out.println( "Time Elapsed: "+ estimatedTime + " Milliseconds ");    
////	new TourPrinting().printSolution(solution);
//    System.out.println();                                                                  		                               
	
//	System.out.println("This is a demonstration of breadth-first Graph search");                                    
//	Node solution2 = bfGraphSearch.findSolution(new TourState(startCity), goalTest);                           
//	System.out.println("Max nodes Generated : " +bfGraphSearch.getNumNodesGenerated());                                                                   
//	System.out.println("Max nodes Stored : " +bfGraphFrontier.getMaxNodesStored());           		
////	new TourPrinting().printSolution(solution2);
//    System.out.println();                                                                  		                               
//	
	System.out.println("This is a demonstration of depth-first tree search");                                    
 	System.out.println();                                                                  		                               
	Node solution3 = dfTreeSearch.findSolution(new TourState(startCity), goalTest);                           
	System.out.println("Max nodes Generated : "+dfTreeSearch.getNumNodesGenerated());                                                                   
	System.out.println("Max nodes Stored : " +dfTreeFrontier.getMaxNodesStored());            
	System.out.println();                                                                  		                               

//	System.out.println("This is a demonstration of depth-first Graph search");                                    
//	Node solution4 = dfGraphSearch.findSolution(new TourState(startCity), goalTest);    
//	System.out.println("Max nodes Generated : " +dfGraphSearch.getNumNodesGenerated());                                                                   
//	System.out.println("Max nodes Stored : " +dfGraphFrontier.getMaxNodesStored());   	
//	System.out.println();                                                                  		                               
////	new TourPrinting().printSolution(solution4);

//	System.out.println("This is a demonstration of Iterative Deepening search");                                    		
//	Node solution5 = irdSearch.findSolution(new TourState(startCity), goalTest);
//	System.out.println("Max nodes Generated : " +irdSearch.getNumNodesGenerated());                                                                   
//	System.out.println("Max nodes Stored : " +irdSearch.getMaxNodesStored());		
//    System.out.println();                                                                  		                               
	
	}
}	

