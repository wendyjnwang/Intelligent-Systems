package mars;

public class Tile{
	public final int x; 
	public final int y;
	public Tile(int x, int y) {
		this.x = x; 
		this.y = y;
	}
	public int hashCode() {
	    return this.x*31  + this.y * 17;
	}

	public boolean equals(Object o) {
		Tile other = (Tile) o;
		return this.x == other.x && this.y == other.y;
	}	
}
