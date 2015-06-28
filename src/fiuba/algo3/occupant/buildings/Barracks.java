package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.InsufficientAvailablePopulationException;
import fiuba.algo3.exceptions.InsufficientResourcesException;
import fiuba.algo3.exceptions.SubtractedResourcesGreaterThanStoragedException;
import fiuba.algo3.exceptions.UnitNotReadyException;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.occupant.units.Unit;
import fiuba.algo3.occupant.units.UnitInTraining;
import fiuba.algo3.player.Player;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mporto on 30/05/15.
 */
public class Barracks extends UnitCreator{

    private Queue<UnitInTraining> trainingQueue;

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
        this.owner.canTrain(aMarineToBeTrained);
        this.chargeUnitCostToOwner(aMarineToBeTrained.getTrainingCost());
        this.addUsedPopulationToOwner(aMarineToBeTrained.getUnitSize());
        UnitInTraining aMarineInTraining = new UnitInTraining(aMarineToBeTrained);
        this.trainingQueue.add(aMarineInTraining);
    }

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

    @Override
    public void getUnitInTraining() throws UnitNotReadyException {
        Unit current = this.trainingQueue.peek().getUnitBeingTrained();
        this.trainingQueue.remove();
        this.owner.addUnit(current, this.position);
    }
}
