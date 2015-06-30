package fiuba.algo3.map;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.exceptions.EmptyTileException;
import fiuba.algo3.exceptions.KeyDoesNotExistsException;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.occupant.units.Unit;
import fiuba.algo3.occupant.units.Zealot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoCraftMapTest{

	private AlgoCraftMap algoCraftMap;

	@Before
	public void setUp(){
		algoCraftMap = (new AlgoCraftMap(1)).testMap();
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
		Coordinates coord = new Coordinates(-1,-1);
		Occupant marine = new Marine();
		algoCraftMap.put(marine,coord);
	}

	@Test
	public void testMapLocateUnits(){
		Coordinates centralCoord = new Coordinates(5,5);
		Unit marine1 = new Marine();
		Unit marine2 = new Marine();
		Unit marine3 = new Marine();
		Unit marine4 = new Marine();
		Unit marine5 = new Marine();
		Unit marine6 = new Marine();
		Unit marine7 = new Marine();
		Unit marine8 = new Marine();
		Unit marine9 = new Marine();
		Unit marine10 = new Marine();
		algoCraftMap.locate(marine1,centralCoord);
		algoCraftMap.locate(marine2,centralCoord);
		algoCraftMap.locate(marine3,centralCoord);
		algoCraftMap.locate(marine4,centralCoord);
		algoCraftMap.locate(marine5,centralCoord);
		algoCraftMap.locate(marine6,centralCoord);
		algoCraftMap.locate(marine7,centralCoord);
		algoCraftMap.locate(marine8,centralCoord);
		algoCraftMap.locate(marine9,centralCoord);
		algoCraftMap.locate(marine10,centralCoord);
		Assert.assertTrue(marine1.getPosition().equals(new Coordinates(4,4)));
		Assert.assertTrue(marine2.getPosition().equals(new Coordinates(5,4)));
		Assert.assertTrue(marine3.getPosition().equals(new Coordinates(6,4)));
		Assert.assertTrue(marine4.getPosition().equals(new Coordinates(4,5)));
		Assert.assertTrue(marine5.getPosition().equals(new Coordinates(5,5)));
		Assert.assertTrue(marine6.getPosition().equals(new Coordinates(6,5)));
		Assert.assertTrue(marine7.getPosition().equals(new Coordinates(4,6)));
		Assert.assertTrue(marine8.getPosition().equals(new Coordinates(5,6)));
		Assert.assertTrue(marine9.getPosition().equals(new Coordinates(6,6)));
		Assert.assertTrue(marine10.getPosition().equals(new Coordinates(3,3)));
	}

	@Test
	public void testIsOccupiedReturnsFalseWhenNotOccupied() {
		Assert.assertFalse(this.algoCraftMap.isOccupied(new Coordinates(0, 0)));
	}

	@Test
	public void testIsOccupiedReturnsTrueWhenOccupied() throws CannotOccupyTileException, KeyDoesNotExistsException {
		this.algoCraftMap.put(new Marine(), new Coordinates(0, 0));
		Assert.assertTrue(this.algoCraftMap.isOccupied(new Coordinates(0, 0)));
	}

	@Test
	public void testGetOccupantReturnsNullWhenNotOccupied() throws EmptyTileException {
		Assert.assertNull(this.algoCraftMap.getOccupant(new Coordinates(0, 0)));
	}

	@Test
	public void testGetOccupantReturnsOccupant() throws CannotOccupyTileException, KeyDoesNotExistsException, EmptyTileException {
		Occupant marine = new Marine();
		this.algoCraftMap.put(marine, new Coordinates(0, 0));
		Assert.assertSame(marine, this.algoCraftMap.getOccupant(new Coordinates(0, 0)));
	}

	@Test
	public void testGetDimention() throws Exception {
		Assert.assertEquals(20, algoCraftMap.getDimention());
	}

	@Test
	public void testGetTile() throws Exception {
		Assert.assertEquals(Earth.class, algoCraftMap.getTile(new Coordinates(1, 1)).getClass());
	}
}
