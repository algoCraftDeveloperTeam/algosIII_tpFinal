package fiuba.algo3.view.sideMenu;

import javax.swing.*;

public class InfoArea extends JComponent{

	private static final long serialVersionUID = 1L;
	private JLabel infoLabel;
	private JLabel lifeLabel;
	private JLabel shieldLabel;

	public InfoArea(){
		infoLabel = new JLabel("");
		lifeLabel = new JLabel("");
		shieldLabel = new JLabel("");
		add(infoLabel);
		add(lifeLabel);
		add(shieldLabel);
	}

	public void setInfo(String data){
		String[] parts = data.split("[.]");
		infoLabel.setText(parts[0]);
		lifeLabel.setText(parts[1]);
		shieldLabel.setText(parts[2]);
	}
}