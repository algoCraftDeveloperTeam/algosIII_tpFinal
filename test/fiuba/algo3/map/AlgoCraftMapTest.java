package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.occupant.units.Marine;

public class AlgoCraftMapTest{

	@Test
	public void setUp(){
        AlgoCraftMap map = new AlgoCraftMap(20);	// creamos varios mapas para la cobertura, ya que en la generacion se utilizan funciones random
		Coordinates coord = new Coordinates(2,2);
		Occupant marine = new Marine();
		Assert.assertTrue(map.put(marine,coord));
	}

	@Test
	public void setUp2(){
        AlgoCraftMap map = new AlgoCraftMap(20);	// creamos varios mapas para la cobertura, ya que en la generacion se utilizan funciones random
		Coordinates coord = new Coordinates(2,2);
		Occupant marine1 = new Marine();
		Occupant marine2 = new Marine();
		map.put(marine1,coord);
		Assert.assertFalse(map.put(marine2,coord));
	}

}
