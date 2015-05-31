package fiuba.algo3.map;

public class Earth extends Tile implements Buildable{

	private int building;

	public Earth(){
		building = 0;
	}

	public boolean canBuild(int i){
		if (building == 0){
			return true;
		} else{
			return false;
		}
	}

}