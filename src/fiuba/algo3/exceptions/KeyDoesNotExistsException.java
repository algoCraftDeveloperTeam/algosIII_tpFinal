package fiuba.algo3.exceptions;

/**
 * Created by nsueiro on 09/06/15.
 */
public class KeyDoesNotExistsException extends Exception {
	public String getMessage(){
		return "That tile in map does not exist";
	}
}
