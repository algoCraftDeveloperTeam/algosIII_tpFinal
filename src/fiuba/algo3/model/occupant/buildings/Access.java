package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.exceptions.InsufficientAvailablePopulationException;
import fiuba.algo3.model.exceptions.InsufficientResourcesException;
import fiuba.algo3.model.exceptions.SubtractedResourcesGreaterThanStoragedException;
import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.occupant.units.UnitInTraining;
import fiuba.algo3.model.occupant.units.Zealot;
import fiuba.algo3.model.player.Player;

import java.util.LinkedList;
import java.util.Queue;

public class Access extends UnitCreator{


    private Queue<UnitInTraining> trainingQueue;

    public Access(Player player, Coordinates coordinate) {
        super(player, coordinate);
        this.constructionCost = new Cost(150, 0);
        this.constructionTime = 8;
        this.life = new Life(500, 500);
        this.trainingQueue = new LinkedList<UnitInTraining>();
        this.info = "Access";
    }

    @Override
    public void trainUnit() throws InsufficientAvailablePopulationException,
            InsufficientResourcesException, SubtractedResourcesGreaterThanStoragedException {
        Zealot aZealotToBeTrained = new Zealot();
        this.owner.canTrain(aZealotToBeTrained);
        this.chargeUnitRequirementsToOwner(aZealotToBeTrained);
        UnitInTraining aZealotInTraining = new UnitInTraining(aZealotToBeTrained);
        this.trainingQueue.add(aZealotInTraining);
    }
}