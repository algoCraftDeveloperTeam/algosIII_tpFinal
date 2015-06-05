package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;

public class AlgoCraftMapTest{

	@Test
	public void setUp(){
        AlgoCraftMap map1 = new AlgoCraftMap(20);
        AlgoCraftMap map2 = new AlgoCraftMap(20);
        AlgoCraftMap map3 = new AlgoCraftMap(20);
        AlgoCraftMap map4 = new AlgoCraftMap(20);
        AlgoCraftMap map5 = new AlgoCraftMap(20);	// creamos varios mapas para la cobertura, ya que en la generacion se utilizan funciones random
	}

}
