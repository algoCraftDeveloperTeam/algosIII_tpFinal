package fiuba.algo3.map;

public class StateNotOcupied implements BuildState{

	public boolean canBuild(){
		return true;
	}

	public boolean canDestroy(){
		return false;
	}

}