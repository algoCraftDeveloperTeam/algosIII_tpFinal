package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import fiuba.algo3.map.Tile;
import fiuba.algo3.game.AlgoCraftModel;

public class PassTurnButton extends JButton implements ActionListener{

	protected AlgoCraftModel gameModel;
	protected MapView mapView;
	protected List<PlayerData> playerLabels;

	public PassTurnButton(AlgoCraftModel algoCraftModel, List<PlayerData> playerData) {
		gameModel = algoCraftModel;
		playerLabels = playerData;
		setVisible(true);
		setEnabled(true);
		setText("Pass Turn");
		addActionListener(this);
	}

	public void setMap(MapView map){
		mapView = map;
	}

	public void actionPerformed(ActionEvent e) {
    	gameModel.endTurn();
    	mapView.refreshTiles();
    	for(PlayerData data : playerLabels){
    		data.refreshLabel();
    	}
    }
}