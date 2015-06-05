package fiuba.algo3.occupant.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;
import fiuba.algo3.occupant.units.UnitInTraining;
import fiuba.algo3.occupant.units.Zealot;

public class Access extends Building implements UnitCreator{

    public Access(Player player) {
    	super(player);
        this.constructionCost = new Cost(150, 0);
        this.constructionTime = 8;
        this.life = new Life(500, 500);
    }

    @Override
    public UnitInTraining trainUnit(){
        Zealot aZealotToBeTrained = new Zealot();
        UnitInTraining aZealotInTraining = new UnitInTraining(aZealotToBeTrained);
        return aZealotInTraining;
    }

    @Override
    public boolean allowBuildStargate(){
        return true;
    }
}