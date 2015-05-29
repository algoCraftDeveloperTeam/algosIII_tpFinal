package fiuba.algo3.resources;

import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 29/05/15.
 */
public class Gas implements Resource{
    int quantity;

    public Gas(int n){
        quantity = n;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void addResources(Player player){
        //To be implemented
    }
}
