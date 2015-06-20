package fiuba.algo3.occupant.buildings;


import fiuba.algo3.exceptions.BuildingNotReadyException;
import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.exceptions.EmptyTileException;
import fiuba.algo3.exceptions.KeyDoesNotExistsException;
import fiuba.algo3.game.TurnAware;
import fiuba.algo3.gameVariables.Damage;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.Damageable;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.player.Player;

/**
 * Created by mporto on 30/05/15.
 */
public class BuildingInConstruction implements Occupant, Damageable, TurnAware {
    private Building buildingInConstruction;
    private int remainingTurnsToBeFinished;
    public Life life;
    public Coordinates position;
    private Player owner;

    public BuildingInConstruction(Building building, int coordX, int coordY) {
        this.buildingInConstruction = building;
        this.remainingTurnsToBeFinished = building.getConstructionTime();
        this.owner = building.getOwner();
        this.life = new Life(this.buildingInConstruction.getVitality(),
                this.buildingInConstruction.getShield());
        this.position = new Coordinates(coordX, coordY);

        owner.substractMinerals(building.getConstructionCost().getMineralCost());
        owner.substractGas(building.getConstructionCost().getGasCost());
    }

    public int getRemainingTurns() {
        return remainingTurnsToBeFinished;
    }

    public void passTurn() {
        remainingTurnsToBeFinished--;
    }

    public Building getBuildingInConstruction() throws BuildingNotReadyException {
        if(!this.isReady()) {
            throw new BuildingNotReadyException();
        }
        return buildingInConstruction;
    }

    public boolean isReady() {
        return remainingTurnsToBeFinished == 0;
    }

    public int getVitality(){
        return this.life.getVitality();
    }

    public int getShield(){
        return this.life.getShield();
    }

    public void setPosition(int x, int y, AlgoCraftMap map) throws EmptyTileException, KeyDoesNotExistsException,
            CannotOccupyTileException {
        Coordinates destination = new Coordinates(x, y);
        map.put(this, destination);
        this.position = destination;
    }

    @Override
    public void receiveDamage(Damage damage) {
        this.life.receiveAttack(damage.getGroundDamage());
    }

    @Override
    public boolean canOccupyEarth() {
        return this.buildingInConstruction.canOccupyEarth();
    }

    @Override
    public boolean canOccupyGas() {
        return this.buildingInConstruction.canOccupyGas();
    }

    @Override
    public boolean canOccupyMineral() {
        return this.buildingInConstruction.canOccupyMineral();
    }

    @Override
    public Coordinates getPosition(){
        return this.position;
    }
}
