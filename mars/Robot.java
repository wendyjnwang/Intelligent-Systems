package mars;

import java.util.LinkedHashSet;
import java.util.Set;

import search.Action;
import search.State;

public class Robot implements State{

	protected final int robotRow;
	protected final int robotColumn;	
	protected final Planet planet;
	protected int movementCount;
	protected final Set<Tile> visitedTiles;
	
	
	public Robot(Planet planet, int robotRow, int robotColumn,int movementCount,Set<Tile> visitedTile) {
		this.robotRow = robotRow;
		this.robotColumn = robotColumn;
		this.planet = planet;		
		this.movementCount = movementCount;
		this.visitedTiles = visitedTile;
	}	
	
	
	@Override
	public Set<? extends Action> getApplicableActions() {
		Set<Action> actions = new LinkedHashSet<Action>();
		for (Movement movement : Movement.values()) {
			int newRobotRow = robotRow + movement.deltaRow;
			int newRobotColumn = robotColumn + movement.deltaColumn;
			if (planet.isAccessible(newRobotRow, newRobotColumn))
				actions.add(movement);
		}
		return actions;
	}
	
	public Set<Tile> getVisitedTiles(){
		return this.visitedTiles;}

	@Override
	public State getActionResult(Action action) {
		Movement movement=(Movement)action;
		int newRobotRow = robotRow + movement.deltaRow;
		int newRobotColumn = robotColumn + movement.deltaColumn;
		int childMovement = movementCount+1;
		Set<Tile> newVisitedTiles = new LinkedHashSet<Tile>(visitedTiles);
		newVisitedTiles.add(new Tile(newRobotRow,newRobotColumn));			
		return new Robot(planet, newRobotRow, newRobotColumn,childMovement,newVisitedTiles);		
	}

	@Override
	public boolean equals(State s) {
		if (this == s)
			return true; 
		if (s == null)
			return false; 
		if (getClass()!=s.getClass())
			return false; 
		final Robot other = (Robot)s;
		if (this.robotRow == other.robotRow && this.robotColumn == other.robotColumn 
				&& this.planet.width() == other.planet.width()
				&& visitedTiles.containsAll(other.visitedTiles) 
				&& other.visitedTiles.containsAll(visitedTiles))
			return true; 
		else 
			return false;		
	}
	
	public int hashCode() {
		int result = this.robotRow * 31 + this.robotColumn *27+visitedTiles.hashCode(); 
		return result;
	}

}
