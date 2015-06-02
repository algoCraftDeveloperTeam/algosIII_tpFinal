package fiuba.algo3.map;

public class StateOcupied implements OccupantState{

	public boolean canOccupy(){
		return false;
	}

	public boolean canQuit(){
		return true;
	}

}