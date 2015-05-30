package fiuba.algo3.map;

import java.util.Random;

public class Map{

	private Tile[][] tiles;
	private int dimention;
	private int posXPlayer1;
	private int posYPlayer1;
	private int posXPlayer2;
	private int posYPlayer2;

	public Map(int dim){
		dimention = dim;
		generateEarthAndSpace();
		placeBases();
	}

	private void generateEarthAndSpace(){
		tiles = new Tile[dimention][dimention];
		for(int i = 0; i < dimention; i++){
			for(int j = 0; j < dimention; j++){
				tiles[i][j] = new Earth();
			}
		}
	}

	private void placeBases(){
		Random random = new Random();
		int randomRow = random.nextInt(dimention);
		int randomCol;
		if(randomRow < (dimention / 4) || randomRow >= (dimention * 3 / 4)){
			randomCol = random.nextInt(dimention);
		} else{
			randomCol = random.nextInt(dimention / 2);
			if(randomCol >= (dimention / 4)){
				randomCol += dimention / 2;
			}
		}
		posXPlayer1 = randomCol;
		posYPlayer1 = randomRow;
		posXPlayer2 = dimention - randomCol - 1;
		posYPlayer2 = dimention - randomRow - 1;
	}

}
