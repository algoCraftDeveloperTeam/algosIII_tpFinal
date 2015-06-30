package fiuba.algo3.model.exceptions;

/**
 * Created by mporto on 27/06/15.
 */
public class SubtractedResourcesGreaterThanStoragedException extends Exception {
	public String getMessage(){
		return "Not enough resources";
	}
}
