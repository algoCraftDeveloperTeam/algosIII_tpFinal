package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

/**
 * Created by mporto on 30/05/15.
 */
public abstract class Building {
    Cost constructionCost;
    int constructionTime;
    Life life;
    Player owner;
    public Building(Player player) {
        this.owner = player;
    }
    public Building(){
        
    }
    public boolean isEarthBuildable(){
    	return true;
    }
    public boolean isGasBuildable(){
    	return false;
    }
    public boolean isMineralBuildable(){
    	return false;
    }
    public int getConstructionTime(){
        return constructionTime;
    }
    public Cost getConstructionCost(){
        return constructionCost;
    }
    public int getVitality(){
        return life.getVitality();
    }
    public int getShield(){
        return life.getShield();
    }
    public Player getOwner() {
        return owner;
    }
    public boolean verifyRequiredBuilding(){
        return true;
    }
    public boolean allowBuildTerranFactory(){
        return false;
    }
    public boolean allowBuildStarPort(){
        return false;
    }
    public boolean allowBuildStargate(){
        return false;
    }
    public boolean allowBuildTemplarArchives(){
        return false;
    }

}
