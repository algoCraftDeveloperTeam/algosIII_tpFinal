package fiuba.algo3.model.exceptions;

/**
 * Created by mporto on 27/06/15.
 */
public class InsufficientAvailablePopulationException extends Exception{
	public String getMessage(){
		return "There is too much population";
	}
}
