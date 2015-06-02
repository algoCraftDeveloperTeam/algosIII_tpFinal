package fiuba.algo3.buildings;


/**
 * Created by mporto on 30/05/15.
 */
public class BuildingInConstruction {
    private Building buildingInConstruction;
    private int remainingTurnsToBeFinished;

    public BuildingInConstruction(Building b) {
        buildingInConstruction = b;
        remainingTurnsToBeFinished = b.getConstructionTime();
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
