package fiuba.algo3.gameVariables;

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

    public void addGas(int n){
        this.gasStorage += n;
    }

    public void addMinerals(int n){
        this.mineralStorage += n;
    }
}
