package fiuba.algo3.map;

public class StateNotOcupied implements OccupantState{

	public boolean canOccupy(){
		return true;
	}

	public boolean canQuit(){
		return false;
	}

}