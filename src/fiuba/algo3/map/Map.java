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
		placeMineralAndGas(posXPlayer1, posYPlayer1);
		placeMineralAndGas(posXPlayer2, posYPlayer2);
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

	private void placeMineralAndGas(int posX, int posY){
		/*Random random = new Random();
		int randomColGas = -dimention;
		int randomRowGas = -dimention;
		int randomColMineral = -dimention;
		int randomRowMineral = -dimention;
		while((posX + randomColGas < 0) || (posX + randomColGas >= dimention)){
			randomColGas = random.nextInt(5) - 2;
		}
		while(((posY + randomRowGas < 0) || (posY + randomRowGas >= dimention)) || ((randomColGas == 0) && (randomRowGas == 0))){
			randomRowGas = random.nextInt(5) - 2;
		}
		while((posX + randomColMineral < 0) || (posX + randomColMineral >= dimention)){
			randomColMineral = random.nextInt(5) - 2;
		}
		while(((posY + randomRowMineral < 0) || (posY + randomRowMineral >= dimention)) || ((randomColMineral == 0) && (randomRowMineral == 0)) !! ((randomColGas == randomColMineral) && (randomRowGas == randomRowMineral))){
			randomRowMineral = random.nextInt(5) - 2;
		}
		tiles[posX + randomColGas][posY + randomRowGas] = new Gas();
		tiles[posX + randomColMineral][posY + randomRowMineral] = new Mineral();*/
	}

}
