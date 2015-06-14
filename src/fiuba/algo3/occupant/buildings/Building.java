package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.exceptions.KeyDoesNotExistsException;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Damage;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.Damageable;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mporto on 30/05/15.
 */
public abstract class Building implements Occupant, Damageable {

    Cost constructionCost;
    int constructionTime;
    Life life;
    Player owner;
    Coordinates position;
    List<Class<?>> requiredBuildings;

    public Building(Player player, int coordX, int coordY) {
        this.owner = player;
        requiredBuildings = new ArrayList<Class<?>>();
        this.owner = player;
        this.position = new Coordinates(coordX, coordY);
    }
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
    public List<Class<?>> getRequiredBuildings(){
        return requiredBuildings;
    }
    public void setPosition(int x, int y, AlgoCraftMap map) throws KeyDoesNotExistsException, CannotOccupyTileException{
        Coordinates destination = new Coordinates(x, y);
        map.put(this, destination);
        this.position = destination;
    }
    public void receiveDamage(Damage damage){
        life.receiveAttack(damage.getGroundDamage());
    }

    public Coordinates getPosition(){
        return position;
    }
}
