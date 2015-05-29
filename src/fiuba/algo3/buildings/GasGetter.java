package fiuba.algo3.buildings;

import fiuba.algo3.resources.Gas;

/**
 * Created by nsueiro on 29/05/15.
 */
public class GasGetter extends ResourceGetter{

    @Override
    public Gas collectResources(){
        Gas retValue = new Gas(this.inStorage);
        this.inStorage = 0;
        return retValue;
    }
}
