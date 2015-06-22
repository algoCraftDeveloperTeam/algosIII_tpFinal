package fiuba.algo3;

import fiuba.algo3.AlgoCraftView;
import fiuba.algo3.game.Game;

public class AlgoCraftMain{

	public static void main(String[] args) {
		Game game = new Game();
		AlgoCraftView ventana = new AlgoCraftView(game);
	}

}