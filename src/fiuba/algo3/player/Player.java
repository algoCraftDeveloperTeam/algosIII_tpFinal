package fiuba.algo3.player;

/**
 * Created by nsueiro on 29/05/15.
 */
public class Player {
    int gasStorage = 0;
    int mineralStorage = 0;

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
