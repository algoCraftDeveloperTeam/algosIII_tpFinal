package fiuba.algo3.model.map;

import org.junit.Assert;
import org.junit.Test;

public class CoordinatesTest{

	@Test
	public void testCoord1(){
		Coordinates coord1 = new Coordinates(0,0);
		Coordinates coord2 = new Coordinates(0,0);
		Assert.assertTrue(coord1.equals(coord2));
	}

	@Test
	public void testCoord2(){
		Coordinates coord1 = new Coordinates(0,1);
		Coordinates coord2 = new Coordinates(1,0);
		Assert.assertFalse(coord1.equals(coord2));
	}

	@Test
	public void testCoord3(){
		Coordinates coord1 = new Coordinates(2,5);
		Coordinates coord2 = new Coordinates(2,5);
		Assert.assertTrue(coord1.equals(coord2));
	}

	@Test
	public void testCoord4(){
		Coordinates coord1 = new Coordinates(1,3);
		Coordinates coord2 = new Coordinates(4,6);
		Assert.assertFalse(coord1.equals(coord2));
	}

	@Test
	public void testCoord5(){
		Coordinates coord1 = new Coordinates(2,5);
		Assert.assertFalse(coord1.equals(1));
	}

}
