package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;

public class TemplarArchives extends Building{


    public TemplarArchives(Player player, Coordinates coordinate) {
        super(player, coordinate);
        this.requiredBuildings.add(Stargate.class);
        this.constructionCost = new Cost(150, 200);
        this.constructionTime = 9;
        this.life = new Life(500, 500);
    	this.info = "Tierra: en estos paramos se pueden construir todo tipo de edificios,\nexceptuando los de recoleccion de recursos, \ntodas las unidades pueden caminar sobre ellos.";
    }
}