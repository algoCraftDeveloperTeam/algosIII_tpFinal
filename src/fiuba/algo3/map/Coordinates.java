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

	public int distance(Coordinates c){
		int distanceX = x - c.x;
		int distanceY = y - c.y;
		int distance = (int) Math.sqrt(Math.pow(distanceX,2) + Math.pow(distanceY,2));
		return distance;
	}

}