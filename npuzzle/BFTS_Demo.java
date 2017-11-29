package npuzzle;

import java.util.Arrays;

import search.BreadthFirstTreeSearch;
import search.SearchTesting;
import search.GoalTest;
import search.Node;

public class BFTS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on 8-puzzle");
		System.out.println();

		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		
		GoalTest goalTest = new TilesGoalTest();
		Node solution = SearchTesting.findSolution(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSolution(solution);

	}
}
