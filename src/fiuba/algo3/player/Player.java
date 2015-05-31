package fiuba.algo3.player;

import fiuba.algo3.gameVariables.PlayerResources;

/**
 * Created by nsueiro on 29/05/15.
 */
public class Player {
    PlayerResources resources = new PlayerResources(200, 0);

    public int getGasStorage(){
        return resources.getGasStorage();
    }

    public int getMineralStorage(){
        return resources.getMineralStorage();
    }

    public void addGas(int n){
        resources.addGas(n);
    }

    public void addMinerals(int n){
        resources.addMinerals(n);
    }
}
