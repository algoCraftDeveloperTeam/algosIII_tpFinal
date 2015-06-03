package fiuba.algo3.buildings;

/**
 * Created by mporto on 30/05/15.
 */
public class NullBuilding extends Building{

	@Override
	public boolean isEarthBuildable(){
    	return false;
    }

    @Override
    public boolean canOccupy(){
    	return true;
    }

    @Override
    public boolean canQuit(){
    	return false;
    }

}