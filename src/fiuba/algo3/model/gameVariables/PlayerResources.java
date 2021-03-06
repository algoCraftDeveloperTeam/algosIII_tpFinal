package fiuba.algo3.model.gameVariables;

import fiuba.algo3.model.exceptions.SubtractedResourcesGreaterThanStoragedException;

/**
 * Created by nsueiro on 30/05/15.
 */
public class PlayerResources {
    int gasStorage, mineralStorage;

    public PlayerResources(int startingMineral, int startingGas){
        this.mineralStorage = startingMineral;
        this.gasStorage = startingGas;

    }

    public int getGasStorage(){
        return this.gasStorage;
    }

    public int getMineralStorage(){
        return this.mineralStorage;
    }

    public void addGas(int i){
        this.gasStorage += i;
    }

    public void addMinerals(int i){
        this.mineralStorage += i;
    }

    public void subtractGas(int i) {
        this.gasStorage -= i;
    }

    public void subtractMinerals(int i) {
        this.mineralStorage -= i;
    }

    public void subtractResources(Cost resources) throws SubtractedResourcesGreaterThanStoragedException {
        if(this.mineralStorage - resources.getMineralCost() < 0 || this.gasStorage - resources.getGasCost() < 0)
            throw new SubtractedResourcesGreaterThanStoragedException();
        this.mineralStorage -= resources.getMineralCost();
        this.gasStorage -= resources.getGasCost();
    }
}
