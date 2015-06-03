package fiuba.algo3.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;

/**
 * Created by mporto on 28/05/15.
 */
public class Unit {

    static int sizeForTransport;
    int fieldOfVision;
    static Cost trainingCost;
    int trainingTime;
    // TO DO: add damage atribute.
    static int unitSize;
    // TO DO: add attack_range.
    Life life;

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

    public boolean canOccupy(){
        return false;
    }

    public boolean canQuit(){
        return true;
    }

}
