package mars;

import search.GoalTest;
import search.State;

public class RobotGoalTest2 implements GoalTest{

	@Override
	public boolean isGoal(State state) {
		Robot robotState = (Robot)state;
		int planetWidth = robotState.planet.width();
		int planetHeight = robotState.planet.height();
		int visitableTiles = 0;
		int i = 0;
		while (i <= planetHeight) {
			int j = 0;
			while (j <= planetWidth) {
				if (robotState.planet.isAccessible(i, j)) {
					visitableTiles += 1;
				}
				j +=1;
			}
			i +=1;		
		}
		int visitedTiles = robotState.getVisitedTiles().size();
		if (visitedTiles == visitableTiles)
			return true;
		else 
			return false;
	}

}
