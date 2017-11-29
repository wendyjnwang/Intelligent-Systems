package mars;

import npuzzle.Tiles;
import search.GoalTest;
import search.State;

public class RobotGoalTest implements GoalTest{

	@Override
	public boolean isGoal(State state) {
		
		Robot robot = (Robot)state;
		if (robot.movementCount == 20)
			return true;
		return false;
		
	}

}
