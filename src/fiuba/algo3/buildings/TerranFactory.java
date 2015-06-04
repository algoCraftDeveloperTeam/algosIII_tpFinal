
package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;
import fiuba.algo3.units.Goliath;
import fiuba.algo3.units.UnitInTraining;

/**
 * Created by nsueiro on 01/06/15.
 */
public class TerranFactory extends Building implements UnitCreator{
    public TerranFactory(Player player){
        super(player);
        this.constructionTime = 12;
        this.constructionCost = new Cost(200, 100);
        this.life = new Life(1250, 0);
    }

    @Override
    public boolean verifyRequiredBuilding(){
        return this.owner.allowTerranFactory();
    }

    @Override
    public boolean allowBuildStarPort(){
        return true;
    }

    @Override
    public UnitInTraining trainUnit(){
        Goliath aGoliathToBeTrained = new Goliath();
        UnitInTraining aGoliathInTraining = new UnitInTraining(aGoliathToBeTrained);
        return aGoliathInTraining;
    }
}
