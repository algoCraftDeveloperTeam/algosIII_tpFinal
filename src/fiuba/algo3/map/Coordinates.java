package fiuba.algo3.map;

public class Coordinates{

	private int x;
	private int y;

	public Coordinates(int valueX, int valueY){
		x = valueX;
		y = valueY;
	}

	@Override
	public int hashCode(){
		return (y + ((1/2) * (x + y) * (x + y + 1)));
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof Coordinates){
			Coordinates other = (Coordinates) o;
			return (x == other.x && y == other.y);
		}
		return false;
	}

}