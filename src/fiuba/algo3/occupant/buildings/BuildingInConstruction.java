package fiuba.algo3.occupant.buildings;


import fiuba.algo3.gameVariables.Damage;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.gameVariables.Position;
import fiuba.algo3.occupant.Damageable;
import fiuba.algo3.occupant.InsufficientResourcesException;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.player.Player;

/**
 * Created by mporto on 30/05/15.
 */
public class BuildingInConstruction implements Occupant, Damageable{
    private Building buildingInConstruction;
    private int remainingTurnsToBeFinished;
    public Life life;
    public Position position;
    private Player owner;

    public BuildingInConstruction(Building building) throws InsufficientResourcesException {
        this.buildingInConstruction = building;
        this.remainingTurnsToBeFinished = building.getConstructionTime();
        this.owner = building.getOwner();
        if (this.owner.getGasStorage() < this.buildingInConstruction.getConstructionCost().getGasCost() ||
                this.owner.getMineralStorage() < this.buildingInConstruction.getConstructionCost().getMineralCost()){
            throw new InsufficientResourcesException();
        }
        this.life = new Life(this.buildingInConstruction.getVitality(),
                this.buildingInConstruction.getShield());
        this.position = new Position(0, 0);

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

    public int getVitality(){
        return this.life.getVitality();
    }

    public int getShield(){
        return this.life.getShield();
    }

    public void setPosition(int x, int y){
        position.move(x, y);
    }

    @Override
    public void receiveDamage(Damage damage) {
        this.life.receiveAttack(damage.getGroundDamage());
    }

    @Override
    public boolean canOccupyEarth() {
        return true;
    }

    @Override
    public boolean canOccupyGas() {
        return false;
    }

    @Override
    public boolean canOccupyMineral() {
        return false;
    }

    @Override
    public Position getPosition(){
        return position;
    }
}
