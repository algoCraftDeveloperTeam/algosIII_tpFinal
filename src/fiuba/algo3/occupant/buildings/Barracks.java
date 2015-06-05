package fiuba.algo3.occupant.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.occupant.units.UnitInTraining;

/**
 * Created by mporto on 30/05/15.
 */
public class Barracks extends Building implements UnitCreator{

    public Barracks(Player player) {
    	super(player);
        this.constructionCost = new Cost(150, 0);
        this.constructionTime = 12;
        this.life = new Life(1000, 0);
    }

    @Override
    public UnitInTraining trainUnit() {
        Marine aMarineToBeTrained = new Marine();
        UnitInTraining aMarineInTraining = new UnitInTraining(aMarineToBeTrained);
        return aMarineInTraining;
    }

    @Override
    public boolean allowBuildTerranFactory(){
        return true;
    }

}
