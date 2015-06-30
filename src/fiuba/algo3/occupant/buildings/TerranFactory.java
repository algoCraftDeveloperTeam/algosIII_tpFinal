
package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.InsufficientAvailablePopulationException;
import fiuba.algo3.exceptions.InsufficientResourcesException;
import fiuba.algo3.exceptions.SubtractedResourcesGreaterThanStoragedException;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.units.Goliath;
import fiuba.algo3.occupant.units.UnitInTraining;
import fiuba.algo3.player.Player;

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
    }

    @Override
    public void trainUnit() throws SubtractedResourcesGreaterThanStoragedException, InsufficientAvailablePopulationException, InsufficientResourcesException {
        Goliath aGoliathToBeTrained = new Goliath();
        this.chargeUnitRequirementsToOwner(aGoliathToBeTrained);
        UnitInTraining aGoliathInTraining = new UnitInTraining(aGoliathToBeTrained);
        this.trainingQueue.add(aGoliathInTraining);
    }
}