package fiuba.algo3.map;

public interface Pervadable {

	boolean canPut(Occupant newOccupant);

	void put(Occupant newOccupant);

	boolean canDraw();

	void draw();

}
