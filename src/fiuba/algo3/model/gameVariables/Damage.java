package fiuba.algo3.model.gameVariables;

/**
 * Created by mporto on 04/06/15.
 */
public class Damage {
    int groundDamage, airDamage;

    public Damage(int groundDamage, int airDamage) {
        this.groundDamage = groundDamage;
        this.airDamage = airDamage;
    }

    public int getGroundDamage() {
        return groundDamage;
    }

    public int getAirDamage() {
        return airDamage;
    }
}
