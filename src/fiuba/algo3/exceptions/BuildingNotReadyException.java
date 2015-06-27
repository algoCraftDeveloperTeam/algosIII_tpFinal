package fiuba.algo3.exceptions;

/**
 * Created by nsueiro on 17/06/15.
 */
public class BuildingNotReadyException extends Exception {
	public String getMessage(){
		return "The building is not ready yet";
	}
}
