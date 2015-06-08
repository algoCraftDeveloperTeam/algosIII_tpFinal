package fiuba.algo3.occupant.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Damage;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.gameVariables.Position;
import fiuba.algo3.occupant.Damageable;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.player.Player;

/**
 * Created by mporto on 30/05/15.
 */
public abstract class Building implements Occupant, Damageable {

    Cost constructionCost;
    int constructionTime;
    Life life;
    Player owner;
    Position position;

    public Building(Player player) {
        this.owner = player;
        this.position = new Position(0, 0);
    }
    /*
    public Building(){
        
    }
    */
    public boolean canOccupyEarth(){
    	return true;
    }
    public boolean canOccupyGas(){
    	return false;
    }
    public boolean canOccupyMineral(){
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
    public void setPosition(int x, int y){
        position.move(x, y);
    }
    public void receiveDamage(Damage damage){
        life.receiveAttack(damage.getGroundDamage());
    }

    public Position getPosition(){
        return position;
    }
}
