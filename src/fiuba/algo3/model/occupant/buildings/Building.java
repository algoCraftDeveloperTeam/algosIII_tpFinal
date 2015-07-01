package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.exceptions.KeyDoesNotExistsException;
import fiuba.algo3.model.game.TurnAware;
import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Damage;
import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.occupant.Damageable;
import fiuba.algo3.model.occupant.Occupant;
import fiuba.algo3.model.occupant.units.CombatUnit;
import fiuba.algo3.model.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mporto on 30/05/15.
 */
public abstract class Building implements Occupant, Damageable, TurnAware{

    String info;

    Cost constructionCost;
    int constructionTime;
    Life life;
    Player owner;
    Coordinates position;
    List<Class<?>> requiredBuildings;

    public Building(Player player, Coordinates coordinate) {
        info = "This is a Test";
        this.owner = player;
        requiredBuildings = new ArrayList<Class<?>>();
        this.owner = player;
        this.position = coordinate;
    }
    @Override
    public boolean canOccupyEarth(){
    	return true;
    }

    @Override
    public boolean canOccupyGas(){
    	return false;
    }

    @Override
    public boolean canOccupyMineral(){
    	return false;
    }

    @Override
    public boolean canCreate() {
        return false;
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public boolean canMove() {
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
    public String getInfo(){
        return info + ".Life: " +  String.valueOf(getVitality()) + ".Shield: " + String.valueOf(getShield());
    }
    @Override
    public Player getOwner() {
        return owner;
    }
    public List<Class<?>> getRequiredBuildings(){
        return requiredBuildings;
    }
    public void setPosition(AlgoCraftMap map, Coordinates coordinates) throws KeyDoesNotExistsException, CannotOccupyTileException{
        map.put(this, coordinates);
        this.position = coordinates;
    }
    public void receiveDamage(Damage damage){

        this.life.receiveAttack(damage.getGroundDamage());
        if(this.life.getVitality() < 0){
            this.owner.removeBuilding(this);
        }
    }

    public Coordinates getPosition(){
        return position;
    }

    @Override
    public void passTurn(){
        this.life.regenerateShield();
    }

    @Override
    public boolean isWithinRange(CombatUnit attacker) {
         Coordinates unitPosition = attacker.getPosition();
        int distance = this.position.distance(unitPosition);
        // In the meantime this will only check with the unit's ground attack range.
        return !(distance > attacker.getGroundAttackRange());
    }

    public void applyEffect(){
        
    }

    @Override
    public boolean canTransport(){
        return false;
    }
}
