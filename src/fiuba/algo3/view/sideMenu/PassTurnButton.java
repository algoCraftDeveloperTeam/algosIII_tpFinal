package fiuba.algo3.view.sideMenu;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

import fiuba.algo3.model.game.AlgoCraftModel;
import fiuba.algo3.view.map.MapView;
import fiuba.algo3.view.player.PlayerData;

public class PassTurnButton extends JButton implements ActionListener{

	protected AlgoCraftModel gameModel;
	protected MapView mapView;
	protected List<PlayerData> playerLabels;
	protected List<ActionButton> actionButtons;

	public PassTurnButton(AlgoCraftModel algoCraftModel, List<PlayerData> playerData, List<ActionButton> buttons) {
		gameModel = algoCraftModel;
		playerLabels = playerData;
		actionButtons = buttons;
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
		if(gameModel.isGameEnded()){
            JOptionPane.showMessageDialog(mapView, "Game ended.");
            System.exit(0);
        }
    	mapView.refreshTiles();
    	for(ActionButton button: actionButtons){
    		button.setEnabled(false);
    	}
    	for(PlayerData data : playerLabels){
    		data.refreshLabel();
    	}
    }
}