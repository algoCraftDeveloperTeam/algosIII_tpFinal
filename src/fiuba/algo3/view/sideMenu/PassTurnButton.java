package fiuba.algo3.view.sideMenu;

import fiuba.algo3.model.game.AlgoCraftModel;
import fiuba.algo3.view.map.MapView;
import fiuba.algo3.view.player.PlayerData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
            JOptionPane.showMessageDialog(mapView, "GameOver." + gameModel.getActivePlayer().getName() + " is the winner!");
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