package fiuba.algo3.buildings;

import fiuba.algo3.resources.Mineral;

/**
 * Created by nsueiro on 28/05/15.
 */
public class MineralGetter extends ResourceGetter {

    @Override
    public Mineral collectResources(){
        Mineral retValue = new Mineral(this.inStorage);
        this.inStorage = 0;
        return retValue;
    }

}
