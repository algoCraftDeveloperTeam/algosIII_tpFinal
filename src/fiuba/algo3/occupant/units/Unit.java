package fiuba.algo3.occupant.units;

import fiuba.algo3.EmptyTileException;
import fiuba.algo3.KeyDoesNotExistsException;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Damage;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.gameVariables.Position;
import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.Damageable;
import fiuba.algo3.occupant.Occupant;
import sun.invoke.empty.Empty;

/**
 * Created by mporto on 28/05/15.
 */
public class Unit implements Occupant, Damageable {

    static int sizeForTransport;
    static Cost trainingCost;
    static int unitSize;
    int fieldOfVision;
    int trainingTime;
    Life life;
    // TO DO: this is temporary, the units should be initialized with a position.
    Coordinates position = new Coordinates(0, 0);

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

    public Position getPosition() {
        return position;
    }

    public void receiveDamage(Damage damage) {
        // In the meantime the attackedUnit will always receive groundDamage.
        life.receiveAttack(damage.getGroundDamage());
    }

    public void move(int x, int y, AlgoCraftMap map) {
        try {
            Coordinates destination = new Coordinates(x, y);
            map.move(this.position, destination);
        } catch (KeyDoesNotExistsException, EmptyTileException)



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
}
