package fiuba.algo3.model.occupant.units;

import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Life;

/**
 * Created by mporto on 02/06/15.
 */
public class HighTemplar extends CombatUnit{



    public HighTemplar() {
        sizeForTransport = 2;
        fieldOfVision = 7;
        trainingTime = 7;
        unitSize = 2;
        life = new Life(40, 40);
        trainingCost = new Cost(50, 150);
	    info = "Tierra: en estos paramos se pueden construir todo tipo de edificios,\nexceptuando los de recoleccion de recursos, \ntodas las unidades pueden caminar sobre ellos.";
    }
}
