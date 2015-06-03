package fiuba.algo3.units;

public class NullUnit extends Unit{

	@Override
	public boolean canOccupy(){
		return true;
	}

	@Override
	public boolean canQuit(){
		return false;
	}

}