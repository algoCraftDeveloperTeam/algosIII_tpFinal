package fiuba.algo3.buildings;


import fiuba.algo3.player.Player;

/**
 * Created by mporto on 30/05/15.
 */
public class BuildingInConstruction {
    private Building buildingInConstruction;
    private int remainingTurnsToBeFinished;

    public BuildingInConstruction(Building building) {
        this.buildingInConstruction = building;
        this.remainingTurnsToBeFinished = building.getConstructionTime();
        Player owner = building.getOwner();
        owner.substractMinerals(building.getConstructionCost().getMineralCost());
        owner.substractGas(building.getConstructionCost().getGasCost());
    }

    public int getRemainingTurns() {
        return remainingTurnsToBeFinished;
    }

    public void passTurn() {
        remainingTurnsToBeFinished--;
    }

    public Building getBuildingInConstruction() {
        return buildingInConstruction;
    }

    public boolean isReady() {
        return remainingTurnsToBeFinished == 0;
    }
}
