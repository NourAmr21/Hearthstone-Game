package GameView;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;

public class FirstWindow extends JFrame implements ActionListener {
	
	private JPanel herochoice;
	private JButton B1 ;
	private JButton B2;
	private JButton B3;
	private JButton B4;
	private JButton B5;
	private ArrayList<JButton> buttons;
	private JButton start;
	public static  Hero p1;

	




	public FirstWindow() {
		
		
        buttons=new ArrayList<JButton>();
		this.setBounds(200, 200, 800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("WELCOME TO HEARTHSTONE .. CURRENT HERO PLEASE CHOOSE YOUR HERO");
		this.setLayout(null);
		
	
        
		
		herochoice=new JPanel();
		herochoice.setVisible(true);
		herochoice.setBounds(0, 0, 800, 600);
		herochoice.setLayout(null);
		this.add(herochoice);
		
		B1=new JButton();
		B1.setBounds(0,10, 160, 200);
		B1.setText("Hunter");
		herochoice.add(B1);
		buttons.add(B1);
		B1.addActionListener(this);
		
		
		
		B2=new JButton();
		B2.setBounds(160, 10, 160, 200);
		B2.setText("Mage");
		herochoice.add(B2);
		buttons.add(B2);
		B2.addActionListener(this);
		
		
		B3=new JButton();
		B3.setBounds(320, 10, 160, 200);
		B3.setText("Paladin");
		herochoice.add(B3);
		buttons.add(B3);
		B3.addActionListener(this);
		
		
		B4=new JButton();
		B4.setBounds(480, 10,160, 200);
		B4.setText("Priest");
		herochoice.add(B4);
		buttons.add(B4);
		B4.addActionListener(this);
		
		
		B5=new JButton();
		B5.setBounds(640 , 10, 160, 200);
		B5.setText("Warlock");
		herochoice.add(B5);
		buttons.add(B5);
		B5.addActionListener(this);
		
		
		this.revalidate();
		this.repaint();
		
	}
	
	
	
	
	public JButton getStart() {
		
		return start;
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		
		
	   	JButton selected=(JButton)(e.getSource());
	   	
		   		
		   		if(selected.getActionCommand().equals("Hunter")){
		   			
		   			try {
						 p1=new Hunter();
						 
						
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
		   		if(selected.getActionCommand().equals("Mage")){
		   		
		   			try {
						 p1=new Mage();
					
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
		   		if(selected.getActionCommand().equals("Priest")){
		   			try {
						 p1=new Priest();
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
					    this.repaint(); 
					    */
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
		   		if(selected.getActionCommand().equals("Paladin")){
		   			try {
						 p1=new Paladin();
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
					    this.repaint();
					    */
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
						 p1=new Warlock();
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
		 
		  	
		   this.setVisible(false);
		   new SecondWindow();
	}	
		
		     
       public static Hero getP1() {
	
    	   return p1;
	     }




	public static void main(String[]args){
	
		new FirstWindow();
      }
	



}
