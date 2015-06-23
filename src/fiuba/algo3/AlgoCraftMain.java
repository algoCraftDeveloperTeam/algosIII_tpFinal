package fiuba.algo3;

import fiuba.algo3.game.AlgoCraftModel;
import fiuba.algo3.view.AlgoCraftView;
import fiuba.algo3.map.AlgoCraftMap;

import java.lang.reflect.InvocationTargetException;

public class AlgoCraftMain{

	public static void main(String[] args)
			throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		AlgoCraftModel algoCraftModel = new AlgoCraftModel();
		//AlgoCraftMap algoCraftMap = algoCraftModel.getAlgoCraftMap();
		//algoCraftMap.testMap();
		AlgoCraftView algoCraftView = new AlgoCraftView(algoCraftModel);
	}

}