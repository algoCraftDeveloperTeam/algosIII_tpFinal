package fiuba.algo3.model.occupant.units;

import fiuba.algo3.model.exceptions.InvalidMovementException;
import fiuba.algo3.model.exceptions.NotEnoughRoomException;
import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Damage;
import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.map.Coordinates;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mporto on 02/06/15.
 */
public class TerranTransportVessel extends Unit{
    
    int capacity;
    int usedCapacity;
    List<Unit> units;

    public TerranTransportVessel() {
        units = new ArrayList<Unit>();
        usedCapacity = 0;
        sizeForTransport = 0;
        fieldOfVision = 8;
        trainingTime = 7;
        unitSize = 2;
        life = new Life(150, 0);
        trainingCost = new Cost(100, 100);
        capacity = 8;
        info = "TerranTransportVessel";
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isWithinRange(CombatUnit attacker) {
        Coordinates unitPosition = attacker.getPosition();
        int distance = this.position.distance(unitPosition);
        // In the meantime this will only check with the unit's ground attack range.
        return !(distance > attacker.getAirAttackRange());
    }

    public void addUnit(Unit unit) throws NotEnoughRoomException {
        if(unit.getSizeForTransport() + this.usedCapacity > this.capacity){
            throw new NotEnoughRoomException();
        }
        this.units.add(unit);
        this.usedCapacity -= unit.getSizeForTransport();
        this.owner.getAlgoCraftMap().clearTile(unit.getPosition());
    }

    @Override
    public void move(AlgoCraftMap algoCraftMap, Coordinates coordinate) throws InvalidMovementException{
        super.move(algoCraftMap, coordinate);
        for(Unit unit : this.units){
            this.owner.getAlgoCraftMap().locate(unit, this.position);
        }
        units.clear();
        this.usedCapacity = 0;
    }

    @Override
    public void receiveDamage(Damage damage) {
        life.receiveAttack(damage.getAirDamage());
        if(this.life.getVitality() < 0){
            this.owner.removeUnit(this);
        }
    }

    @Override
    public boolean canTransport(){
        return true;
    }
}
