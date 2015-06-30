package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;

/**
 * Created by nsueiro on 01/06/15.
 */
public class StarPort extends Building {
    public StarPort(Player player, Coordinates coordinate){
        super(player, coordinate);
        this.requiredBuildings.add(TerranFactory.class);
        this.constructionCost = new Cost(150, 100);
        this.life = new Life(1300, 0);
        this.constructionTime = 10;
    }
}
