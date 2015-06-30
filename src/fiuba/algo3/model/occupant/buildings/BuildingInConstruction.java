package fiuba.algo3.model.occupant.buildings;


import fiuba.algo3.model.exceptions.BuildingNotReadyException;
import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.exceptions.EmptyTileException;
import fiuba.algo3.model.exceptions.KeyDoesNotExistsException;
import fiuba.algo3.model.game.TurnAware;
import fiuba.algo3.model.gameVariables.Damage;
import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.occupant.Damageable;
import fiuba.algo3.model.occupant.Occupant;
import fiuba.algo3.model.occupant.units.CombatUnit;
import fiuba.algo3.model.player.Player;

/**
 * Created by mporto on 30/05/15.
 */
public class BuildingInConstruction implements Occupant, Damageable, TurnAware {
    private Building buildingInConstruction;
    private int remainingTurnsToBeFinished;
    public Life life;
    public Coordinates position;
    private Player owner;

    public BuildingInConstruction(Building building, Coordinates coordinate) {
        this.buildingInConstruction = building;
        this.remainingTurnsToBeFinished = building.getConstructionTime();
        this.owner = building.getOwner();
        this.life = new Life(this.buildingInConstruction.getVitality(),
                this.buildingInConstruction.getShield());
        this.position = coordinate;
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
        if(this.life.getVitality() < 0){
            this.owner.removeBuildingInConstruction(this);
        }
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
    public boolean canCreate() {
        return false;
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public Coordinates getPosition(){
        return this.position;
    }
    
    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public boolean isWithinRange(CombatUnit attacker) {
        Coordinates unitPosition = attacker.getPosition();
        int distance = this.position.distance(unitPosition);
        return !(distance > attacker.getGroundAttackRange());
    }
}
