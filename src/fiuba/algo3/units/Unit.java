package fiuba.algo3.units;

import fiuba.algo3.gameVariables.Cost;

/**
 * Created by mporto on 28/05/15.
 */
public class Unit {

    int sizeForTransport;
    int fieldOfVision;
    Cost trainingCost;
    int trainingTime;
    // TO DO: add damage atribute.
    int unitSize;
    // TO DO: add attack_range.
    int life;

    public int getLife() {
        return life;
    }

    public int getSizeForTransport() {
        return sizeForTransport;
    }

    public int getTrainingTime() {
        return trainingTime;
    }

    public Cost getTrainingCost() {
        return trainingCost;
    }
}
