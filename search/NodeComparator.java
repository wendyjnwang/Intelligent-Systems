package search;
import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		if (o1.cost < o2.cost)
			return -1; 
		if (o1.cost > o2.cost)
			return 1; 
		return 0;
	}

}
