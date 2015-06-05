package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Damage;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.gameVariables.Position;
import fiuba.algo3.occupant.Damageable;
import fiuba.algo3.occupant.Occupant;

/**
 * Created by mporto on 28/05/15.
 */
public class Unit implements Occupant, Damageable{

    static int sizeForTransport;
    int fieldOfVision;
    static Cost trainingCost;
    int trainingTime;
    static int unitSize;
    Life life;
    // TO DO: this is temporary, the units should be initialized with a position.
    Position position = new Position(0, 0);

    public int getVitality() {
        return life.getVitality();
    }

    public static int getSizeForTransport() {
        return sizeForTransport;
    }

    public int getTrainingTime() {
        return trainingTime;
    }

    public static Cost getTrainingCost() {
        return trainingCost;
    }

    public int getShield() {
        return life.getShield();
    }

    public Position getPosition() {
        return position;
    }

    public void receiveDamage(Damage damage) {
        // In the meantime the attackedUnit will always receive groundDamage.
        life.receiveAttack(damage.getGroundDamage());
    }

    public void move(int x, int y) {
        position.move(x, y);
    }

    public boolean canOccupyEarth(){
        return true;
    }

    public boolean canOccupyGas(){
        return false;
    }

    public boolean canOccupyMineral(){
        return false;
    }
}
