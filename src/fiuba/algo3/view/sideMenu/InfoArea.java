package fiuba.algo3.view.sideMenu;

import javax.swing.*;

public class InfoArea{

	private JLabel infoLabel;
	private JLabel lifeLabel;
	private JLabel shieldLabel;

	public InfoArea(){
		infoLabel = new JLabel("info");
		lifeLabel = new JLabel("life");
		shieldLabel = new JLabel("shield");
	}

	public void setInfo(String data){
		//ErrorMessages.sendMessage(data);
		String[] parts = data.split("[.]");
		infoLabel.setText(parts[0]);
		lifeLabel.setText(parts[1]);
		shieldLabel.setText(parts[2]);
	}

	public JLabel getInfo(){
		return infoLabel;
	}
	
	public JLabel getLife(){
		return lifeLabel;
	}
	
	public JLabel getShield(){
		return shieldLabel;
	}
}