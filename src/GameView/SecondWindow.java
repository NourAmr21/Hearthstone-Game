package GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameController.Controller;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;

public class SecondWindow extends JFrame implements ActionListener {

	private JPanel opponentchoice;
	private JButton B1 ;
	private JButton B2;
	private JButton B3;
	private JButton B4;
	private JButton B5;
	public static Hero p2;
	private JButton start;
	
	
	public SecondWindow() {

		this.setBounds(200, 200, 800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("WELCOME TO HEARTHSTONE .. OPPONENT PLEASE CHOOSE YOUR HERO ");
		this.setLayout(null);
	
		
		
		opponentchoice=new JPanel();
		opponentchoice.setVisible(true);
		opponentchoice.setBounds(0, 0, 800, 600);
		opponentchoice.setLayout(null);
		this.add(opponentchoice);
		
		B1=new JButton();
		B1.setBounds(0,10, 160, 200);
		B1.setText("Hunter");
		B1.addActionListener(this);
		opponentchoice.add(B1);
		
		
		
		
		B2=new JButton();
		B2.setBounds(160, 10, 160, 200);
		B2.setText("Mage");
		B2.addActionListener(this);
		opponentchoice.add(B2);
		
		
		
		
		B3=new JButton();
		B3.setBounds(320, 10, 160, 200);
		B3.setText("Paladin");
		B3.addActionListener(this);
		opponentchoice.add(B3);
		
		
		
		
		B4=new JButton();
		B4.setBounds(480, 10,160, 200);
		B4.setText("Priest");
		B4.addActionListener(this);
		opponentchoice.add(B4);
		
		
		
		
		B5=new JButton();
		B5.setBounds(640 , 10, 160, 200);
		B5.setText("Warlock");
		B5.addActionListener(this);
		opponentchoice.add(B5);
		
		
		/*start=new JButton();
		start.setBounds(280,250, 160, 100);
		start.setText("Select Hero");
		start.addActionListener(this);
		opponentchoice.add(start);*/
		
		
		
		
		this.revalidate();
		this.repaint();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//JButton b=(JButton)(e.getSource());
	   	JButton selected=(JButton)(e.getSource());
	   	
		//if(e.getSource() == start){
			
		   	//this.setVisible(false);
		   	
		  	//if(b.getActionCommand().equals("Select Hero")){
		   
		   		//System.out.print("hello world");
		   		
		   		if(selected.getActionCommand().equals("Hunter")){
		   		
		   				
		   			
		   			try {
						 p2=new Hunter();
						 
						
					} catch (IOException e1) {
						new ExceptionmessageWindow(e1.getMessage());
					/*	JLabel index =new JLabel();
						index.setBounds(0, 0, 50, 60);
						index.setVisible(true);
						index.setText(e1.getMessage());
					    this.add(index);
					    
					    index.revalidate();
					    index.repaint();
					    
					    this.revalidate();
					    this.repaint();*/
					    
					} catch (CloneNotSupportedException e1) {
						new ExceptionmessageWindow(e1.getMessage());
					/*	JLabel clone=new JLabel();
						clone.setBounds(0, 0, 50, 60);
						clone.setVisible(true);
						clone.setText(e1.getMessage());
					    this.add(clone);
					    
					    clone.revalidate();
					    clone.repaint();
					    
					    this.revalidate();
					    this.repaint();*/
					}
		   		}
		   		if(selected.getActionCommand().equals("Mage")){
		   		
		   			try {
						 p2=new Mage();
					
					} catch (IOException e1) {
						
						new ExceptionmessageWindow(e1.getMessage());
						/*JLabel index =new JLabel();
						index.setBounds(0, 0, 50, 60);
						index.setVisible(true);
						index.setText(e1.getMessage());
					    this.add(index);
					    
					    index.revalidate();
					    index.repaint();
					    
					    this.revalidate();
					    this.repaint();*/
						
					} catch (CloneNotSupportedException e1) {
						
						new ExceptionmessageWindow(e1.getMessage());
						/*JLabel clone=new JLabel();
						clone.setBounds(0, 0, 50, 60);
						clone.setVisible(true);
						clone.setText(e1.getMessage());
					    this.add(clone);
					    
					    clone.revalidate();
					    clone.repaint();
					    
					    this.revalidate();
					    this.repaint();*/
					}
		   		}
		   		if(selected.getActionCommand().equals("Priest")){
		   			try {
						 p2=new Priest();
					} catch (IOException e1) {
						new ExceptionmessageWindow(e1.getMessage());
						/*JLabel index =new JLabel();
						index.setBounds(0, 0, 50, 60);
						index.setVisible(true);
						index.setText(e1.getMessage());
					    this.add(index);
					    
					    index.revalidate();
					    index.repaint();
					    
					    this.revalidate();
					    this.repaint(); */
					    
					} catch (CloneNotSupportedException e1) {
						new ExceptionmessageWindow(e1.getMessage());
						/*JLabel clone=new JLabel();
						clone.setBounds(0, 0, 50, 60);
						clone.setVisible(true);
						clone.setText(e1.getMessage());
					    this.add(clone);
					    
					    clone.revalidate();
					    clone.repaint();
					    
					    this.revalidate();
					    this.repaint();*/
					}
		   		}
		   		if(selected.getActionCommand().equals("Paladin")){
		   			try {
						 p2=new Paladin();
					} catch (IOException e1) {
						
						new ExceptionmessageWindow(e1.getMessage());
					/*	JLabel index =new JLabel();
						index.setBounds(0, 0, 50, 60);
						index.setVisible(true);
						index.setText(e1.getMessage());
					    this.add(index);
					    
					    index.revalidate();
					    index.repaint();
					    
					    this.revalidate();
					    this.repaint();*/
					    
					} catch (CloneNotSupportedException e1) {
						
						new ExceptionmessageWindow(e1.getMessage());
						/*JLabel clone=new JLabel();
						clone.setBounds(0, 0, 50, 60);
						clone.setVisible(true);
						clone.setText(e1.getMessage());
					    this.add(clone);
					    
					    clone.revalidate();
					    clone.repaint();
					    
					    this.revalidate();
					    this.repaint();*/
					}
		   		}
		   		if(selected.getActionCommand().equals("Warlock")){
		   			try {
						 p2=new Warlock();
					} catch (IOException e1) {
						
						new ExceptionmessageWindow(e1.getMessage());
						/*JLabel index =new JLabel();
						index.setBounds(0, 0, 50, 60);
						index.setVisible(true);
						index.setText(e1.getMessage());
					    this.add(index);
					    
					    index.revalidate();
					    index.repaint();
					    
					    this.revalidate();
					    this.repaint();*/
					    
					} catch (CloneNotSupportedException e1) {
					
						new ExceptionmessageWindow(e1.getMessage());
						/*JLabel clone=new JLabel();
						clone.setBounds(0, 0, 50, 60);
						clone.setVisible(true);
						clone.setText(e1.getMessage());
					    this.add(clone);
					    
					    clone.revalidate();
					    clone.repaint();
					    
					    this.revalidate();
					    this.repaint();*/
					}
		   		}
		 
		  	
		   this.setVisible(false);
		   new Controller();
	}	
     	


	public static Hero getP2() {
		return p2;
	}


	


	
	
	
	
	
}
