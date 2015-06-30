package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.exceptions.InsufficientAvailablePopulationException;
import fiuba.algo3.model.exceptions.InsufficientResourcesException;
import fiuba.algo3.model.exceptions.SubtractedResourcesGreaterThanStoragedException;
import fiuba.algo3.model.exceptions.UnitNotReadyException;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.occupant.units.Unit;
import fiuba.algo3.model.occupant.units.UnitInTraining;
import fiuba.algo3.model.player.Player;

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

    /*
    public void getUnitInTraining() throws UnitNotReadyException {
        Unit current = this.trainingQueue.peek().getUnitBeingTrained();
        this.trainingQueue.remove();
        this.owner.addUnit(current, this.position);
    }
    */
    @Override
    public boolean canCreate() {
        return true;
    }

    protected void chargeUnitRequirementsToOwner(Unit unit)
            throws SubtractedResourcesGreaterThanStoragedException, InsufficientAvailablePopulationException,
            InsufficientResourcesException {
       this.owner.chargeUnitRequirements(unit);
    }

    /*
    protected void addUsedPopulationToOwner(int i){
        this.owner.addUsedPopulation(i);
    }
    */
    @Override
    public void passTurn() {
        super.passTurn();
        if(this.trainingQueue.isEmpty()) return;
        UnitInTraining firstUnit = this.trainingQueue.peek();
        firstUnit.passTurn();
        if(firstUnit.isReady()){
            try {
                this.trainingQueue.remove();
                Unit trainedUnit = firstUnit.getUnitBeingTrained();
                this.owner.addUnit(trainedUnit, this.position);
            } catch (UnitNotReadyException e){}
        }
    }
}
