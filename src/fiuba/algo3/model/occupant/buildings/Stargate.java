package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;

public class Stargate extends Building{

    

    public Stargate(Player player, Coordinates coordinate) {
    	super(player, coordinate);
        this.requiredBuildings.add(Access.class);
        this.constructionCost = new Cost(150, 150);
        this.constructionTime = 10;
        this.life = new Life(600, 600);
		this.info = "Tierra: en estos paramos se pueden construir todo tipo de edificios,\nexceptuando los de recoleccion de recursos, \ntodas las unidades pueden caminar sobre ellos.";
    }
}