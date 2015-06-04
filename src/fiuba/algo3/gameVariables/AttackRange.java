package fiuba.algo3.gameVariables;

/**
 * Created by mporto on 04/06/15.
 */
public class AttackRange {
    int groundRange, airRange;

    public AttackRange(int groundRange, int airRange) {
        this.groundRange = groundRange;
        this.airRange = airRange;
    }

    public int getGroundRange() {
        return groundRange;
    }

    public int getAirRange() {
        return airRange;
    }
}
