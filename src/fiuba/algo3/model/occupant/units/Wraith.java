package fiuba.algo3.model.occupant.units;

import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Damage;
import fiuba.algo3.model.gameVariables.Life;

/**
 * Created by mporto on 02/06/15.
 */
public class Wraith extends CombatUnit{


    public Wraith() {
        sizeForTransport = 0;
        fieldOfVision = 7;
        trainingTime = 8;
        unitSize = 2;
        life = new Life(120, 0);
        trainingCost = new Cost(150, 100);
        damage = new Damage(20, 8);
        info = "Tierra: en estos paramos se pueden construir todo tipo de edificios,\nexceptuando los de recoleccion de recursos, \ntodas las unidades pueden caminar sobre ellos.";
    }
}
