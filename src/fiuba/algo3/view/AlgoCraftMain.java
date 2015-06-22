package fiuba.algo3.view;

import fiuba.algo3.game.AlgoCraftModel;

public class AlgoCraftMain{

	public static void main(String[] args) {
		AlgoCraftModel algoCraftModel = new AlgoCraftModel();
		AlgoCraftView algoCraftView = new AlgoCraftView(algoCraftModel);
	}

}