package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.InsufficientAvailablePopulationException;
import fiuba.algo3.exceptions.InsufficientResourcesException;
import fiuba.algo3.exceptions.SubtractedResourcesGreaterThanStoragedException;
import fiuba.algo3.exceptions.UnitNotReadyException;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.units.Unit;
import fiuba.algo3.occupant.units.UnitInTraining;
import fiuba.algo3.player.Player;

import java.util.Queue;

/**
 * Created by nsueiro on 03/06/15.
 */
public abstract class UnitCreator extends Building{

    Queue<UnitInTraining> trainingQueue;

    public UnitCreator(Player player, Coordinates coordinate) {
        super(player, coordinate);
    }

    public abstract void trainUnit() throws InsufficientAvailablePopulationException, InsufficientResourcesException, SubtractedResourcesGreaterThanStoragedException;

    public void getUnitInTraining() throws UnitNotReadyException {
        Unit current = this.trainingQueue.peek().getUnitBeingTrained();
        this.trainingQueue.remove();
        this.owner.addUnit(current, this.position);
    }

    @Override
    public boolean canCreate() {
        return true;
    }

    protected void chargeUnitRequirementsToOwner(Unit unit)
            throws SubtractedResourcesGreaterThanStoragedException, InsufficientAvailablePopulationException,
            InsufficientResourcesException {
       this.owner.chargeUnitRequirements(unit);
    }

    protected void addUsedPopulationToOwner(int i){
        this.owner.addUsedPopulation(i);
    }
}
