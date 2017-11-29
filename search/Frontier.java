package search;

interface Frontier {
	public void addNode (Node newNode);
	
	public void clearContents();
	
	public boolean isEmpty ();
	
	public Node removeNode ();
	
	public int getMaxNodesStored();
		
}

