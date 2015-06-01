package fiuba.algo3.map;

public class StateOcupied implements BuildState{

	public boolean canBuild(){
		return false;
	}

	public boolean canDestroy(){
		return true;
	}

}