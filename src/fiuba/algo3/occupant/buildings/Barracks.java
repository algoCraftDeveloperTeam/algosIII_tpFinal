package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.InsufficientAvailablePopulationException;
import fiuba.algo3.exceptions.InsufficientResourcesException;
import fiuba.algo3.exceptions.SubtractedResourcesGreaterThanStoragedException;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.occupant.units.UnitInTraining;
import fiuba.algo3.player.Player;

import java.util.LinkedList;

/**
 * Created by mporto on 30/05/15.
 */
public class Barracks extends UnitCreator{

    public Barracks(Player player, Coordinates coordinate) {
    	super(player, coordinate);
        this.constructionCost = new Cost(150, 0);
        this.constructionTime = 12;
        this.life = new Life(1000, 0);
        this.trainingQueue = new LinkedList<UnitInTraining>();
    }

    @Override
    public void trainUnit()
            throws InsufficientAvailablePopulationException, InsufficientResourcesException,
            SubtractedResourcesGreaterThanStoragedException {
        Marine aMarineToBeTrained = new Marine();
        this.chargeUnitRequirementsToOwner(aMarineToBeTrained);
        UnitInTraining aMarineInTraining = new UnitInTraining(aMarineToBeTrained);
        this.trainingQueue.add(aMarineInTraining);
    }

}
