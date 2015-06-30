
package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.exceptions.InsufficientAvailablePopulationException;
import fiuba.algo3.model.exceptions.InsufficientResourcesException;
import fiuba.algo3.model.exceptions.SubtractedResourcesGreaterThanStoragedException;
import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.occupant.units.Goliath;
import fiuba.algo3.model.occupant.units.UnitInTraining;
import fiuba.algo3.model.player.Player;

import java.util.LinkedList;

/**
 * Created by nsueiro on 01/06/15.
 */
public class TerranFactory extends UnitCreator {


    public TerranFactory(Player player, Coordinates coordinate) {
        super(player, coordinate);
        this.requiredBuildings.add(Barracks.class);
        this.constructionTime = 12;
        this.constructionCost = new Cost(200, 100);
        this.life = new Life(1250, 0);
        this.trainingQueue = new LinkedList<UnitInTraining>();
        this.info = "Tierra: en estos paramos se pueden construir todo tipo de edificios,\nexceptuando los de recoleccion de recursos, \ntodas las unidades pueden caminar sobre ellos.";
    }

    @Override
    public void trainUnit() throws SubtractedResourcesGreaterThanStoragedException, InsufficientAvailablePopulationException, InsufficientResourcesException {
        Goliath aGoliathToBeTrained = new Goliath();
        this.chargeUnitRequirementsToOwner(aGoliathToBeTrained);
        UnitInTraining aGoliathInTraining = new UnitInTraining(aGoliathToBeTrained);
        this.trainingQueue.add(aGoliathInTraining);
    }
}