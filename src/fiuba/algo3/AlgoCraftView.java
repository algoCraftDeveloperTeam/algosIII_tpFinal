package fiuba.algo3;

import javax.swing.JLabel;
import javax.swing.JFrame;
import fiuba.algo3.game.AlgoCraftModel;

public class AlgoCraftView extends JFrame{
	
	private JLabel texto1;

	public AlgoCraftView(AlgoCraftModel algoCraftModel) {
		setBounds(500,250,300,250);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		texto1=new JLabel("Nacho y Manu putos :D");
		texto1.setBounds(100,100,200,40);
		add(texto1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}