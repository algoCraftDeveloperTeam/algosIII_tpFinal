package fiuba.algo3.buildings;

import fiuba.algo3.resources.Resource;

/**
 * Created by nsueiro on 29/05/15.
 */
public abstract class ResourceGetter {
    public int inStorage;

    public ResourceGetter(){
        inStorage = 0;
    }

    public int getInStorage(){
        return this.inStorage;
    }

    public void addToStorage(int n){
        this.inStorage += n;
    }

    public abstract Resource collectResources();

}
