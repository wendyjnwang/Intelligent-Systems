package search;

public class SmartNode extends Node {

	public final int depth;
	public SmartNode(Node parent, Action action, State state, int depth) {
		super(parent, action, state);
		this.depth = depth;	
		}

}
