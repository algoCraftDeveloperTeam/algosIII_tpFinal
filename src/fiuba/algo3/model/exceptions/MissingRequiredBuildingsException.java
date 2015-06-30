package fiuba.algo3.model.exceptions;

/**
 * Created by mporto on 08/06/15.
 */
public class MissingRequiredBuildingsException extends Exception{
	public String getMessage(){
		return "You don't have the required buildings";
	}
}
