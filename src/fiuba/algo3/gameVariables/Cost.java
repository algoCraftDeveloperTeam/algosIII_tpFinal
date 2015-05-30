package fiuba.algo3.gameVariables;

/**
 * Created by mporto on 30/05/15.
 */
public class Cost {
    int mineralCost, gasCost;

    public Cost(int mineralCost, int gasCost) {
        this.mineralCost = mineralCost;
        this.gasCost = gasCost;
    }

    public int getMineralCost() {
        return mineralCost;
    }

    public int getGasCost() {
        return gasCost;
    }
}
