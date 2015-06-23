package fiuba.algo3.view;

import fiuba.algo3.game.AlgoCraftModel;

import java.lang.reflect.InvocationTargetException;

public class AlgoCraftMain{

	public static void main(String[] args)
			throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		AlgoCraftModel algoCraftModel = new AlgoCraftModel();
		AlgoCraftView algoCraftView = new AlgoCraftView(algoCraftModel);
	}

}