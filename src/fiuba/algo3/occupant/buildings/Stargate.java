package fiuba.algo3.occupant.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.player.Player;

public class Stargate extends Building{

    public Stargate(Player player, Coordinates coordinate) {
    	super(player, coordinate);
        this.requiredBuildings.add(Access.class);
        this.constructionCost = new Cost(150, 150);
        this.constructionTime = 10;
        this.life = new Life(600, 600);
    }
}