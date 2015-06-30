package fiuba.algo3.model.exceptions;

/**
 * Created by nsueiro on 09/06/15.
 */
public class EmptyTileException extends Exception{
	public String getMessage(){
		return "There's nothing in that tile";
	}
}
