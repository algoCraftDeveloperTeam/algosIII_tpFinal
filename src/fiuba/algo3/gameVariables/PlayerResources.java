package fiuba.algo3.gameVariables;

/**
 * Created by nsueiro on 30/05/15.
 */
public class PlayerResources {
    int gasStorage, mineralStorage;

    public PlayerResources(){
        gasStorage = 0;
        mineralStorage = 0;
    }

    public int getGasStorage(){
        return gasStorage;
    }

    public int getMineralStorage(){
        return mineralStorage;
    }

    public void addGas(int n){
        gasStorage += n;
    }

    public void addMinerals(int n){
        mineralStorage += n;
    }
}
