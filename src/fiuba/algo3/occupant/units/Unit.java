package fiuba.algo3.occupant.units;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.exceptions.EmptyTileException;
import fiuba.algo3.exceptions.InvalidMovementException;
import fiuba.algo3.exceptions.KeyDoesNotExistsException;
import fiuba.algo3.game.TurnAware;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Damage;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.Damageable;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.player.Player;

/**
 * Created by mporto on 28/05/15.
 */
public abstract class Unit implements Occupant, Damageable, TurnAware {

    static int sizeForTransport;
    static Cost trainingCost;
    static int unitSize;
    int fieldOfVision;
    int trainingTime;
    Life life;
    Coordinates position;
    Player owner;

    public static int getSizeForTransport() {
        return sizeForTransport;
    }

    public static Cost getTrainingCost() {
        return trainingCost;
    }

    public int getVitality() {
        return life.getVitality();
    }

    public int getTrainingTime() {
        return trainingTime;
    }

    public int getShield() {
        return life.getShield();
    }

    public Coordinates getPosition() {
        return position;
    }

    public void receiveDamage(Damage damage) {
        // In the meantime the attackedUnit will always receive groundDamage.
        life.receiveAttack(damage.getGroundDamage());
    }

    public void move(AlgoCraftMap map, Coordinates destination) throws InvalidMovementException{
        try {
            if (this.position.distance(destination) <= this.fieldOfVision) {
                map.move(this.position, destination);
                this.position = destination;
            }
        } catch (KeyDoesNotExistsException | EmptyTileException | CannotOccupyTileException e) {
            throw new InvalidMovementException();
        }
    }

    public void setPosition(AlgoCraftMap map, Coordinates destination) throws KeyDoesNotExistsException, CannotOccupyTileException{
        map.put(this, destination);
        this.position = destination;
    }

    public boolean canOccupyEarth() {
        return true;
    }

    public boolean canOccupyGas() {
        return false;
    }

    public boolean canOccupyMineral() {
        return false;
    }

    @Override
    public void passTurn() {
        this.life.regenerateShield();
    }

    public abstract boolean isWithinRange(CombatUnit attacker);

    public void setOwner(Player owner){
       this.owner = owner;
    }
}
