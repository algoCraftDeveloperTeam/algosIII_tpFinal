package fiuba.algo3.gameVariables;

/**
 * Created by mporto on 30/05/15.
 */
public class Life {
    int vitality, shield, maxShieldValue;

    public Life(int vitality, int shield) {
        this.vitality = vitality;
        this.shield = shield;
        this.maxShieldValue = shield;
    }

    public int getVitality() {
        return vitality;
    }
}
