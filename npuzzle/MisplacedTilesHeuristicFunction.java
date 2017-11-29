package npuzzle;

import search.Node;
import search.NodeFunction;;

public class MisplacedTilesHeuristicFunction implements NodeFunction{

	@Override
	public int computeCost(Node node) {
		int outOfPositionCount = 0;
		Tiles tileState = (Tiles)node.state;
		int width = tileState.getWidth();
		for (int row = 0; row <= width -1;row ++)
			for (int column = 0; column <= width -1; column ++)
				if (row == (width-1)&& column == (width-1)) {
					if (tileState.getTile(row, column) != Tiles.EMPTY_TILE)
//						outOfPositionCount++;
						continue;
				}
				else if (tileState.getTile(row, column) != row * width + column + 1)
					outOfPositionCount++;
					
		return outOfPositionCount;
	}

}
