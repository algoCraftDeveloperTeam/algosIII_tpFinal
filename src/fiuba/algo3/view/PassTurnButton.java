package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import fiuba.algo3.map.Tile;
import fiuba.algo3.game.AlgoCraftModel;

public class PassTurnButton extends JButton implements ActionListener{

	protected AlgoCraftModel gameModel;
	protected MapView mapView;
	protected JLabel playerName;
	protected JLabel playerGas;
	protected JLabel playerMineral;

	public PassTurnButton(AlgoCraftModel algoCraftModel, JLabel actualPlayerName, JLabel actualPlayerGas, JLabel actualPlayerMineral) {
		gameModel = algoCraftModel;
		playerName = actualPlayerName;
		playerGas = actualPlayerGas;
		playerMineral = actualPlayerMineral;
		playerName.setText(gameModel.getActivePlayer().getName());
		playerGas.setText(gameModel.getActivePlayer().getGasStorage());
		playerMineral.setText(gameModel.getActivePlayer().getMineralStorage());
		setVisible(true);
		setEnabled(true);
		setText("Pass Turn");
		addActionListener(this);
	}

	public void setMap(MapView map){
		mapView = map;
	}

	public void actionPerformed(ActionEvent e) {
    	System.out.println("cambio de turno");
    	gameModel.endTurn();
    	mapView.refreshTiles();
		playerName.setText(gameModel.getActivePlayer().getName());
		playerGas.setText(gameModel.getActivePlayer().getGasStorage());
		playerMineral.setText(gameModel.getActivePlayer().getMineralStorage());
    }
}