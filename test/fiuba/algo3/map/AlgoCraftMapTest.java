package fiuba.algo3.map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.occupant.units.Zealot;

public class AlgoCraftMapTest{

	AlgoCraftMap algoCraftMap;

	@Before
	public void setUp(){
		algoCraftMap = new AlgoCraftMap(20);
	}

	@Test
	public void testMapCanPutOccupant(){
		Coordinates coord = new Coordinates(2,2);
		Occupant marine = new Marine();
		Assert.assertTrue(algoCraftMap.put(marine,coord));
	}

	@Test
	public void testMapCanPutOccupantOnOccupiedTile(){
		Coordinates coord = new Coordinates(2,2);
		Occupant marine = new Marine();
		Occupant zealot = new Zealot();
		algoCraftMap.put(marine,coord);
		Assert.assertFalse(algoCraftMap.put(zealot,coord));
	}

	@Test
	public void testMapCanPutOccupantOnInvalidCoordinates(){
		Coordinates coord = new Coordinates(40,2);
		Occupant marine = new Marine();
		Assert.assertFalse(algoCraftMap.put(marine,coord));
	}

}
