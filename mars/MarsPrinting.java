package mars;


import search.Action;
import search.Printing;
import search.State;



public class MarsPrinting extends Printing  {

	public void print(Action action) {
		System.out.print("move ");
		System.out.print(((Movement)action).name());
	}
	public void print(State state) {
		Robot robot =(Robot)state;
		System.out.print("At Position");
		System.out.print(robot.robotColumn + ","); 
		System.out.print(robot.robotRow);
		
		}
}
