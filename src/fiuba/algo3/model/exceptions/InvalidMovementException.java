package fiuba.algo3.model.exceptions;

/**
 * Created by nsueiro on 09/06/15.
 */
public class InvalidMovementException extends Exception{
	public String getMessage(){
		return "That movement is not valid";
	}
}
