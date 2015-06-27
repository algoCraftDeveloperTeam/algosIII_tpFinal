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
	protected JLabel playerName;

	public PassTurnButton(AlgoCraftModel algoCraftModel, JLabel actualPlayerName) {
		gameModel = algoCraftModel;
		playerName = actualPlayerName;
		playerName.setText(gameModel.getActivePlayer().getName());
		setVisible(true);
		setEnabled(true);
		setText("Pass Turn");
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
    	System.out.println("cambio de turno");
    	gameModel.endTurn();
		playerName.setText(gameModel.getActivePlayer().getName());
    }
}