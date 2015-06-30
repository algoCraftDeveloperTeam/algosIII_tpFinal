package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Damage;
import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;

/**
 * Created by mporto on 31/05/15.
 */
public class Pylon extends PopulationStorage{

    public Pylon(Player player, Coordinates coordinate) {
        super(player, coordinate);
        this.constructionTime = 5;
        this.constructionCost = new Cost(100, 0);
        this.life = new Life(250, 250);
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
