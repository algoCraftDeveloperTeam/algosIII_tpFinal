package fiuba.algo3;

import fiuba.algo3.AlgoCraftView;
import fiuba.algo3.game.AlgoCraftModel;

public class AlgoCraftMain{

	public static void main(String[] args) {
		AlgoCraftModel game = new AlgoCraftModel();
		AlgoCraftView ventana = new AlgoCraftView(game);
	}

}