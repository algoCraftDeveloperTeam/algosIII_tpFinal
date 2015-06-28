package fiuba.algo3.occupant.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Damage;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.player.Player;

/**
 * Created by mporto on 31/05/15.
 */
public class SupplyDepot extends PopulationStorage{

    public SupplyDepot(Player player, Coordinates coordinate) {
        super(player, coordinate);
        this.constructionTime = 6;
        this.constructionCost = new Cost(100, 0);
        this.life = new Life(500, 0);
    }

    @Override
    public void receiveDamage(Damage damage){
        this.life.receiveAttack(damage.getGroundDamage());
        if(this.life.getVitality() < 0){
            this.owner.addAvailablePopulation(-5);
            this.owner.removeBuilding(this);
        }
    }
}
