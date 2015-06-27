package fiuba.algo3.exceptions;

/**
 * Created by nsueiro on 09/06/15.
 */
public class DestinationIsOccupiedException extends Exception {
	public String getMessage(){
		return "The tile is already occupied";
	}
}
