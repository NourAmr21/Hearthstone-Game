package GameView;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameView extends JFrame {

	
	 

	 
	private	JPanel    currentplayer;
	  private	JPanel    opponent;
	  private   JPanel    extrabuttons;
	  private   JTextArea data;
	  private   JPanel    currenthand;
	  private   JPanel    currentfield;
	  private   JPanel    opponentfield;
	 
	  private JLabel exceptionmessage;
	  
	  private ArrayList<JButton> buttons;

	  private JButton Endturn;
	  private JButton drawcard;
	  private JButton Useheropower;
	  private JButton opponenthero;
	  private JButton myhero;
	  private JButton closeexception;
	  
	  private JButton attack;
	 
	 


		public GameView() {
			
			buttons=new ArrayList<JButton>();
			 
			this.setBounds(200, 200, 1400, 600);
			this.setTitle("HERE WE GO");
			this.setVisible(true);
			this.setLayout(null);
			//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		   
			
			currentplayer = new JPanel();
			currentplayer.setVisible(true);
			currentplayer.setBounds(0,300, 1400, 300);
			currentplayer.setLayout(null);

			
			currenthand =new JPanel();
			currenthand.setVisible(true);
			currenthand.setBounds(0, 0, 700, 300);
			currenthand.setLayout(new GridLayout(10,1));
			
			currentplayer.add(currenthand );
			
			currentfield =new JPanel();
			currentfield.setVisible(true);
			currentfield.setBounds(700, 0, 700, 300);
			currentfield.setLayout(new GridLayout(7,1));
			
			currentplayer.add(currentfield );
			
			
		
			
			JLabel test=new JLabel("currentfield");
			currentfield.add(test);
			
			
			JLabel x =new JLabel("currenthand");
			currenthand.add(x);
			this.add(currentplayer);
			
			
			currentplayer.revalidate();
			currentplayer.repaint();
			
			
			opponent = new JPanel();
			opponent.setVisible(true);
			opponent.setBounds(0, 0, 1200, 250);
			opponent.setLayout(null);
		
			opponentfield = new JPanel();
			opponentfield.setVisible(true);
			opponentfield.setBounds(0, 0, 1100, 250);
			opponentfield.setLayout(new GridLayout(7,1));
			opponent.add(opponentfield);
			
			JLabel hello =new JLabel("opponentfield");
			opponentfield.add(hello);
			this.add(opponent);
			
			opponenthero=new JButton("Opponent Hero");
			opponenthero.setActionCommand("Opponent Hero");
			opponenthero.setBounds(1100, 10, 100, 200);
			buttons.add(opponenthero);
			opponenthero.revalidate();
			opponenthero.repaint();
			opponent.add(opponenthero);
			
			
			
			
			opponent.revalidate();
			opponent.repaint();
			
			
			data = new JTextArea();
			data.setVisible(true);
			data.setBounds(1200, 0, 200, 300);
		
		
			data.setText(" Information =) ");
			this.add(data);
			
			
			
			data.revalidate();
			data.repaint();
			
			
			extrabuttons =new JPanel();
			extrabuttons.setVisible(true);
			extrabuttons.setBounds(0,250, 600, 50);
			extrabuttons.setLayout(new FlowLayout());
			this.add(extrabuttons);
			
		    drawcard = new JButton();
			drawcard.setVisible(true);
			drawcard.setText("Draw Card");
			drawcard.setActionCommand("Draw Card");
			extrabuttons.add(drawcard );
			buttons.add(drawcard);
			
			drawcard.revalidate();
			drawcard.repaint();
			
			
			Endturn = new JButton();
			Endturn.setVisible(true);
			Endturn.setText(" END MY TURN ");
			Endturn.setActionCommand(" END MY TURN ");
			extrabuttons.add( Endturn );
			buttons.add(Endturn);
			
			Endturn.revalidate();
			Endturn.repaint();
			
			Useheropower = new JButton();
	        Useheropower.setVisible(true);
			Useheropower.setText("Use Hero Power");
			Useheropower.setActionCommand("Use Hero Power");
			extrabuttons.add( Useheropower );
			buttons.add(Useheropower);
			
			Useheropower.revalidate();
			Useheropower.repaint();
			
			
			
			myhero = new JButton();
	        myhero.setVisible(true);
			myhero.setText("My Hero");
			myhero.setActionCommand("My Hero");
			extrabuttons.add( myhero );
			buttons.add(myhero);
			
			myhero.revalidate();
			myhero.repaint();
			
			extrabuttons.revalidate();
			extrabuttons.repaint();
			
			attack = new JButton();
			getAttack().setVisible(true);
			getAttack().setText("Attack ");
			extrabuttons.add( getAttack() );
			buttons.add(getAttack());
			
			getAttack().revalidate();
			getAttack().repaint();
			
			extrabuttons.revalidate();
			extrabuttons.repaint();
			
			
			
			
			this.revalidate();
			this.repaint();
			
		}
		





		public void setCurrentfield(JPanel currentfield) {
			this.currentfield = currentfield;
		}






		public void setOpponentfield(JPanel opponentfield) {
			this.opponentfield = opponentfield;
		}






		public JPanel getCurrentfield() {
			return currentfield;
		}
		
		public JPanel getCurrenthand() {
			return currenthand;
		}

		public JPanel getOpponentfield() {
			return opponentfield;
		}
		
		public JButton getUseheropower() {
			return Useheropower;
		}

		public JButton getEndturn() {
			return Endturn;
		}

		 public JTextArea getData() {
				return data;
			}
		 
		
		 public JLabel getExceptionmessage() {
			return exceptionmessage;
		}

		public ArrayList<JButton> getButtons(){
		    	return buttons;
		    }






		public JButton getAttack() {
			return attack;
		}

     
		

		

}
