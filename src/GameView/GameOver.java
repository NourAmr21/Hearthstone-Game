package GameView;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameOver extends JFrame{

	JPanel gameoverp=new JPanel();
	JTextArea gameover=new JTextArea();
	
	public GameOver(String x) {
		
		this.setBounds(200, 200, 400, 400);
		this.setVisible(true);
		this.setLayout(null);
	    this.setTitle("GameOver");
	    
	    
	    gameoverp =new JPanel();
		gameoverp.setVisible(true);
		gameoverp.setBounds(0, 0, 800, 500);
		gameoverp.setLayout(new BorderLayout());
		this.add(gameoverp);
		
		
	 gameover=new JTextArea();
	 gameover.setVisible(true);
	 gameover.setText(x);
	 
	 gameoverp.add(gameover,BorderLayout.CENTER);
	 
	 gameover.revalidate();
	 gameover.repaint();
	 
	 gameoverp.revalidate();
	 gameoverp.repaint();
	 
	 this.revalidate();
	 this.repaint();
		
		
		
	}
	
	
	
	
	
}
