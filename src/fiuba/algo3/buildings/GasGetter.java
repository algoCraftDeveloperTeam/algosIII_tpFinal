package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Cost;
/**
 * Created by nsueiro on 29/05/15.
 */
public abstract class GasGetter extends ResourceGetter{
    public GasGetter() {
        this.constructionCost = new Cost(100, 0);
    }
    @Override
    public void addToPlayerStorage(){
        owner.addGas(quantity);
    }
    @Override
    public boolean isGasBuildable(){
    	return true;
    }
    
}
