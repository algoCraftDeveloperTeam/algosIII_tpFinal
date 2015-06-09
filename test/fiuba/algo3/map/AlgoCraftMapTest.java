package fiuba.algo3.map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.occupant.units.Zealot;
import fiuba.algo3.CannotOccupyTileException;
import fiuba.algo3.KeyDoesNotExistsException;

public class AlgoCraftMapTest{

	AlgoCraftMap algoCraftMap;

	@Before
	public void setUp(){
		algoCraftMap = new AlgoCraftMap(20);
	}

	@Test
	public void testMapCanPutOccupant() throws CannotOccupyTileException, KeyDoesNotExistsException{
		Coordinates coord = new Coordinates(2,2);
		Occupant marine = new Marine();
		algoCraftMap.put(marine,coord);
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testMapCanPutOccupantOnOccupiedTile() throws CannotOccupyTileException, KeyDoesNotExistsException{
		Coordinates coord = new Coordinates(2,2);
		Occupant marine = new Marine();
		Occupant zealot = new Zealot();
		algoCraftMap.put(marine,coord);
		algoCraftMap.put(zealot,coord);
	}

	@Test (expected = KeyDoesNotExistsException.class)
	public void testMapCanPutOccupantOnInvalidCoordinates() throws CannotOccupyTileException, KeyDoesNotExistsException{
		Coordinates coord = new Coordinates(40,2);
		Occupant marine = new Marine();
		algoCraftMap.put(marine,coord);
	}

}
