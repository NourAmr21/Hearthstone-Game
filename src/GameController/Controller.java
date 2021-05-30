package GameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.CurseOfWeakness;
import model.cards.spells.DivineSpirit;
import model.cards.spells.Flamestrike;
import model.cards.spells.HolyNova;
import model.cards.spells.KillCommand;
import model.cards.spells.LevelUp;
import model.cards.spells.MultiShot;
import model.cards.spells.Polymorph;
import model.cards.spells.Pyroblast;
import model.cards.spells.SealOfChampions;
import model.cards.spells.ShadowWordDeath;
import model.cards.spells.SiphonSoul;
import model.cards.spells.Spell;
import model.cards.spells.TwistingNether;
import model.heroes.*;
import engine.Game;
import engine.GameListener;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import GameView.ExceptionmessageWindow;
import GameView.FirstWindow;
import GameView.GameOver;
import GameView.GameView;
import GameView.SecondWindow;

import model.heroes.Hero;

public class Controller implements ActionListener, GameListener{

	private Game model;
	private GameView view;
	private ExceptionmessageWindow messagewindow;

	
	private ArrayList<JButton> currField;
	private ArrayList<JButton> oppField;
	private ArrayList<JButton> currHand;
	
	
	private JButton select;
	private JButton select2;
	private JButton oppbutton;
	private JButton herobutton;
	
	
	private Minion attacker;
	private Minion target;
	private Minion m;
	private Hero y;
	private Hero targetHero;
	
	
	Card c;
	
    public Controller() {
		
		currField=new ArrayList<JButton>();
		oppField=new ArrayList<JButton>();
		currHand=new ArrayList<JButton>();
		
		view=new GameView();
		
	
		
		
		try {
			
			model=new Game(FirstWindow.p1,SecondWindow.p2);
			
			
		} catch (FullHandException e) {
			 new ExceptionmessageWindow(e.getMessage()+e.getBurned().toString());
			/*JLabel full=new JLabel();
			full.setBounds(0, 0, 200, 60);
			full.setVisible(true);
			full.setText(e.getMessage());
		    view.getExceptionmessage().add(full);
		    view.getData().setText("The data of the burned card :"+ e.getBurned().toString());
		    
		    full.revalidate();
		    full.repaint();
		    
		    view.revalidate();
		    view.repaint();*/
			
		} catch (CloneNotSupportedException e) {
			 new ExceptionmessageWindow(e.getMessage());
			/*JLabel clone=new JLabel();
			clone.setBounds(0, 0, 200, 60);
			clone.setVisible(true);
			clone.setText(e.getMessage());
		    view.getExceptionmessage().add(clone);
		    
		    clone.revalidate();
		    clone.repaint();
		    
		    view.revalidate();
		    view.repaint();*/
		}
		
		model.setListener(this);
		
        for(int i=0;i<view.getButtons().size();i++){
        	view.getButtons().get(i).addActionListener(this);
        }
		
        
        
        
      //  view.endturn.addActionListener(this);
	  //  view.heropower.addActionListener(this);
	    view.getAttack().addActionListener(this);
	
		view.getData().setText(
				
			"My Name:"+model.getCurrentHero().getName()+
			"\nCurrentHP:"+model.getCurrentHero().getCurrentHP()+
			"\nCurrent Mana Crystals:"+model.getCurrentHero().getCurrentManaCrystals()
			+"\nTotal Mana Crystals:"+model.getCurrentHero().getTotalManaCrystals()+
			"\nCards in Deck:"+model.getCurrentHero().getDeck().size()+
			"\nOpponentName:"+model.getOpponent().getName()+
			"\nCurrentHP:"+model.getOpponent().getCurrentHP()+
			"\nCurrent Mana Crystals:"+model.getOpponent().getCurrentManaCrystals()
			+"\nTotal Mana Crystals:"+model.getOpponent().getTotalManaCrystals()+
			"\nCards in Deck:"+model.getOpponent().getDeck().size());
		
		
		view.getData().revalidate();
		view.getData().repaint();
		//view.add(view.data,BorderLayout.EAST);
	//	view.pack();
		view.revalidate();
		view.repaint();
		
		Hero h=model.getCurrentHero();
		
      /*  if(h.getDeck().get(0)!=null) {
        	JButton b=new JButton();
            currDeck.add(b);
            b.revalidate();
            b.repaint();
            
        }*/
		
		
		for(int i=0; i < h.getField().size() ; i++){
			
			JButton b=new JButton();
			b.addActionListener(this);
		    currField.add(b);
			b.setText(h.getField().get(i).toString());
			view.getCurrentfield().add(b);
			b.revalidate();
			b.repaint();
			view.revalidate();
			view.repaint();
		}
		
		for(int i=0;i<h.getHand().size();i++){
			
			JButton b=new JButton();
			view.getCurrenthand().add(b);
			b.setText(h.getHand().get(i).toString());
			b.addActionListener(this);
			currHand.add(b);
			b.revalidate();
			b.repaint();
			view.revalidate();
			view.repaint();
		}
		
		
      
		
		
		Hero x=model.getOpponent();
		for(int i=0;i<x.getField().size();i++){
			JButton b=new JButton();
			b.addActionListener(this);
		    oppField.add(b);
			b.setText(x.getField().get(i).toString());
			view.getOpponentfield().add(b);
			b.revalidate();
			b.repaint();
			view.revalidate();
			view.repaint();
		}
		
		
		
		
		view.revalidate();
		view.repaint();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton b=(JButton)(e.getSource());
		
		
		 if(currField.contains(b)){
			
			select=b;
			attacker=(Minion)(model.getCurrentHero().getField().get(currField.indexOf(select)));
		}
		
		 if(oppField.contains(b)){
			 
				 select2=b;
				 target=(Minion)(model.getOpponent().getField().get(oppField.indexOf(select2)));
			 }
			 
		 
		
		 if(currHand.contains(b)&& model.getCurrentHero().getHand().get(currHand.indexOf(b)) instanceof Minion){
			
			
			
			m=(Minion)(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
			
			
			
			
			try {
				
				model.getCurrentHero().playMinion(m);
				
				
				
			} catch (NotYourTurnException e1) {
				new ExceptionmessageWindow(e1.getMessage());
				
		
			} catch (NotEnoughManaException e1) {
			
				    new ExceptionmessageWindow(e1.getMessage());
				  
			   
			   
			    
			    
			} catch (FullFieldException e1) {
				new ExceptionmessageWindow(e1.getMessage());
				
			}
			
			finally {
				
				//currField.add(b);
				 
				//currHand.remove(b);
				
				onCurrFieldUpdated();
				onCurrHandUpdated();
				 
				

				
			}
			
			
		}
      
		
		if(b.getActionCommand().equals("Opponent Hero")){
        	
			// oppbutton=b;
			 targetHero=model.getOpponent();
        }
		
		if(b.getActionCommand().equals("My Hero")) {
			
			herobutton=b;
			targetHero=model.getCurrentHero();
		}
		
 
 
   
   if(b.getActionCommand().equals("Opponent Hero")&& currField.contains(select)){
	  
	   try {

		   model.getCurrentHero().attackWithMinion(attacker, targetHero);
		   
	} catch (CannotAttackException e1) {
		new ExceptionmessageWindow(e1.getMessage());
		
	    
	} catch (NotYourTurnException e1) {
		new ExceptionmessageWindow(e1.getMessage());
		
	} catch (TauntBypassException e1) {
		new ExceptionmessageWindow(e1.getMessage());
		
	} catch (NotSummonedException e1) {
		new ExceptionmessageWindow(e1.getMessage());
		
	} catch (InvalidTargetException e1) {
		new ExceptionmessageWindow(e1.getMessage());
		
	}
	   
	 finally {
		 onCurrFieldUpdated();
		
		  
		   onOpponentUpdated();
		 
		   onGameOver();
	 }
	  
   }
   
    if(currField.contains(select) && oppField.contains(b)){
    	
    //	Minion attacker=(Minion)(model.getCurrentHero().getField().get(currField.indexOf(select)));
    //	Minion target=(Minion)(model.getOpponent().getField().get(oppField.indexOf(b)));
    	
    	try {
    		
			model.getCurrentHero().attackWithMinion(attacker,target);
			onCurrFieldUpdated();
		    
	    	onOpponentUpdated();
		} 
    	
    	
    	catch (CannotAttackException e1) {
    		new ExceptionmessageWindow(e1.getMessage());
			
			
		} catch (NotYourTurnException e1) {
			new ExceptionmessageWindow(e1.getMessage());
			
		} catch (TauntBypassException e1) {
			new ExceptionmessageWindow(e1.getMessage());
			
		} catch (InvalidTargetException e1) {
			new ExceptionmessageWindow(e1.getMessage());
			
		} catch (NotSummonedException e1) {
			new ExceptionmessageWindow(e1.getMessage());
			
		}
    	
    	
    	
   
    
    }
   
       if(b.getActionCommand().equals("Draw Card")) {
    	
    	try {
			
    	      c= model.getCurrentHero().drawCard();
    	      
    		
    		
		
    	} catch (FullHandException e1) {
    		new ExceptionmessageWindow(e1.getMessage()+e1.getBurned().toString());
    	
		
    	} catch (CloneNotSupportedException e1) {
    		new ExceptionmessageWindow(e1.getMessage());
   

		}
    	
    	  onCurrHandUpdated();
		  onCurrFieldUpdated();
	      onDataUpdated();
    	
    }
    
    
    
    
		if(b.getActionCommand().equals(" END MY TURN ")){
				
			try {
			
				model.endTurn();
						
			} 
			
			catch (FullHandException e1) {
				new ExceptionmessageWindow(e1.getMessage()+e1.getBurned().toString());
				
			} catch (CloneNotSupportedException e1) {
				new ExceptionmessageWindow(e1.getMessage());
				
			}
			
			onEndTurn();
			
			
			onDataUpdated();
		}
		
        if(b.getActionCommand().equals("Use Hero Power")){
        	
        	try {
        		
        		if(model.getCurrentHero() instanceof Mage && oppField.contains(select2)){
        			
        			target=(Minion)(model.getOpponent().getField().get(oppField.indexOf(select2)));
        			
        			((Mage)(model.getCurrentHero())).useHeroPower(target);
        			
        			
        			onCurrFieldUpdated();
        			onOpponentUpdated();
        			
        		}
        	
        		if(model.getCurrentHero() instanceof Mage && targetHero.equals(model.getOpponent())){
        		
        			((Mage)(model.getCurrentHero())).useHeroPower(targetHero);
        		
        			onCurrFieldUpdated();
        		    onOpponentUpdated();
        			onGameOver();
        			onDataUpdated();
        	}
        		
                if(model.getCurrentHero() instanceof Priest && currField.contains(select)){
        			target=(Minion)(model.getCurrentHero().getField().get(currField.indexOf(select)));
        			((Priest)(model.getCurrentHero())).useHeroPower(target);
        			
        			
        			onCurrFieldUpdated();
            		onOpponentUpdated();
            		onDataUpdated();
        			
        		}
                
                if(model.getCurrentHero() instanceof Priest && herobutton.getActionCommand().equals("My Hero")){
        			
        			((Priest)(model.getCurrentHero())).useHeroPower((Hero) targetHero);
        			
        			onCurrFieldUpdated();
            		onOpponentUpdated();
        			onGameOver();
        			onDataUpdated();
        			
        		}
              
                if(model.getCurrentHero() instanceof Priest && oppField.contains(select2)){
        			target=(Minion)(model.getOpponent().getField().get(oppField.indexOf(select2)));
        			((Priest)(model.getCurrentHero())).useHeroPower(target);
        			
        			
        			onCurrFieldUpdated();
            		onOpponentUpdated();
            		onDataUpdated();
        			
        		}
             
                if(model.getCurrentHero() instanceof Priest && targetHero.equals(model.getOpponent())){
            		
                	((Priest)(model.getCurrentHero())).useHeroPower(targetHero);
            		
            		onCurrFieldUpdated();
            		onOpponentUpdated();
            		onGameOver();
            		onDataUpdated();
            	}
                 if(model.getCurrentHero() instanceof Hunter){
        			
        			((Hunter)(model.getCurrentHero())).useHeroPower();
            		onGameOver();
            		onDataUpdated();
        			
        		}
                 if(model.getCurrentHero() instanceof Warlock){
         			
         			((Warlock)(model.getCurrentHero())).useHeroPower();
         			onGameOver();
         			onDataUpdated();
         		
         		}
                 if(model.getCurrentHero() instanceof Paladin){
         			
         			((Paladin)(model.getCurrentHero())).useHeroPower();
         			onCurrFieldUpdated();
         			onGameOver();
         			onDataUpdated();
         			
         		}
				
				onCurrFieldUpdated();
				onCurrHandUpdated();
				onOpponentUpdated();
				onDataUpdated();
				
				
			} catch (NotEnoughManaException e1) {
				new ExceptionmessageWindow(e1.getMessage());             
			
			} catch (HeroPowerAlreadyUsedException e1) {
				new ExceptionmessageWindow(e1.getMessage());
			
			} catch (NotYourTurnException e1) {
				new ExceptionmessageWindow(e1.getMessage());             
				
			} catch (FullHandException e1) {
				new ExceptionmessageWindow(e1.getMessage()+e1.getBurned().toString());          
	
			} catch (FullFieldException e1) {
				new ExceptionmessageWindow(e1.getMessage());
			
			} catch (CloneNotSupportedException e1) {
				new ExceptionmessageWindow(e1.getMessage());			
			
			}
        }
        
     
        //spells b3d t3deel =)
        


      
        	
        	
      if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b)) instanceof LevelUp){
        
        	try {
				
        		model.getCurrentHero().castSpell((LevelUp)(model.getCurrentHero().getHand().get(currHand.indexOf(b))));
        		//model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
				
        		onCurrFieldUpdated();
				onCurrHandUpdated();
				onOpponentUpdated();
				
				
			} catch (NotYourTurnException e1) {
				new ExceptionmessageWindow(e1.getMessage());				
				
			    
			} catch (NotEnoughManaException e1) {
				new ExceptionmessageWindow(e1.getMessage());

			}
        }
        if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b))instanceof CurseOfWeakness){
        	try {
				model.getCurrentHero().castSpell((CurseOfWeakness)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),model.getOpponent().getField());
			//	model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
				onCurrFieldUpdated();
				onCurrHandUpdated();
				onOpponentUpdated();
			} 
        	
        	catch (NotYourTurnException e1) {
        		new ExceptionmessageWindow(e1.getMessage());		
			
			} catch (NotEnoughManaException e1) {
				new ExceptionmessageWindow(e1.getMessage());
				
			}
        } 
        
        if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b))instanceof Flamestrike){
        
        	try {
			
        		model.getCurrentHero().castSpell((Flamestrike)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),model.getOpponent().getField());
			//	model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
				onCurrFieldUpdated();
				onCurrHandUpdated();
				onOpponentUpdated();
				
			} catch (NotYourTurnException e1) {
				new ExceptionmessageWindow(e1.getMessage());
				
			} catch (NotEnoughManaException e1) {
				new ExceptionmessageWindow(e1.getMessage());
			
			}
        } 
      
        if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b))instanceof HolyNova){
        	
        	try {
				
        		model.getCurrentHero().castSpell((HolyNova)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),model.getOpponent().getField());
        	//	model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
				onCurrFieldUpdated();
				onCurrHandUpdated();
				onOpponentUpdated();
			} catch (NotYourTurnException e1) {
				new ExceptionmessageWindow(e1.getMessage());	
				
			} catch (NotEnoughManaException e1) {
				new ExceptionmessageWindow(e1.getMessage());
				
			}
        } 
        
 
        if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b))instanceof MultiShot){
        	
        	try {
				
        		model.getCurrentHero().castSpell((MultiShot)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),model.getOpponent().getField());
        	//	model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
				onCurrFieldUpdated();
				onCurrHandUpdated();
				onOpponentUpdated();
			} catch (NotYourTurnException e1) {
				new ExceptionmessageWindow(e1.getMessage());
				
			    
			} catch (NotEnoughManaException e1) {
				new ExceptionmessageWindow(e1.getMessage());
				
			
			}
        } 
        
  if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b))instanceof TwistingNether){
        	
        	try {
				
        		model.getCurrentHero().castSpell((TwistingNether)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),model.getOpponent().getField());
        		//model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
				onCurrFieldUpdated();
				onCurrHandUpdated();
				onOpponentUpdated();
				
			} catch (NotYourTurnException e1) {
				new ExceptionmessageWindow(e1.getMessage());
			
			} catch (NotEnoughManaException e1) {
				new ExceptionmessageWindow(e1.getMessage());
				
			}
        } 
  
  if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b))instanceof DivineSpirit && oppField.contains(select)){
  	try {
			try {
				target=(Minion)(model.getOpponent().getField().get(oppField.indexOf(select2)));
				model.getCurrentHero().castSpell((DivineSpirit)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),target);
				//model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
			} 
			catch (InvalidTargetException e1) {
				new ExceptionmessageWindow(e1.getMessage());
				
			}
			onCurrFieldUpdated();
			onCurrHandUpdated();
			onOpponentUpdated();
		} 
  	
  	catch (NotYourTurnException e1) {
  		new ExceptionmessageWindow(e1.getMessage());
	
		} 
  	
  	catch (NotEnoughManaException e1) {
  		new ExceptionmessageWindow(e1.getMessage());
	
		}
  }
  
  if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b))instanceof Polymorph){
  
	  try {
  		
  		target=(Minion)(model.getOpponent().getField().get(oppField.indexOf(select2)));
			
  		try {
				model.getCurrentHero().castSpell((Polymorph)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),target);
				//model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
				
			} catch (InvalidTargetException e1) {
				new ExceptionmessageWindow(e1.getMessage());	
			
			}
			onCurrFieldUpdated();
			onCurrHandUpdated();
			onOpponentUpdated();
		} 
  	
  	catch (NotYourTurnException e1) {
  		new ExceptionmessageWindow(e1.getMessage());
			
		    
		} 
  	
  	catch (NotEnoughManaException e1) {
  		new ExceptionmessageWindow(e1.getMessage());
		
		}
  }
  
  if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b))instanceof SealOfChampions){
  	
	  try {target=(Minion)(model.getOpponent().getField().get(oppField.indexOf(select2)));
			try {
				model.getCurrentHero().castSpell((SealOfChampions)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),target);
			//	model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
			//	m=null;
			} 
			
			catch (InvalidTargetException e1) {
				new ExceptionmessageWindow(e1.getMessage());	
			
			}
			onCurrFieldUpdated();
			onCurrHandUpdated();
			onOpponentUpdated();
		} 
  	
  	catch (NotYourTurnException e1) {
  		new ExceptionmessageWindow(e1.getMessage());
	
		} 
  	
  	catch (NotEnoughManaException e1) {
  		new ExceptionmessageWindow(e1.getMessage());
		
		}
  }
  
  if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b))instanceof ShadowWordDeath){
  	try {target=(Minion)(model.getOpponent().getField().get(oppField.indexOf(select2)));
			try {
				model.getCurrentHero().castSpell((ShadowWordDeath)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),target);
			//	model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
			//	m=null;
			} 
			
			catch (InvalidTargetException e1) {
				new ExceptionmessageWindow(e1.getMessage());		
		
			}
			onCurrFieldUpdated();
			onCurrHandUpdated();
			onOpponentUpdated();
		} 
  	
  	catch (NotYourTurnException e1) {
  		new ExceptionmessageWindow(e1.getMessage());	
			
		} 
  	
  	catch (NotEnoughManaException e1) {
  		new ExceptionmessageWindow(e1.getMessage());
			
		}
  }
  
  
  
 
  if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b))instanceof KillCommand){
  	
  	try {
  		if(targetHero.equals(model.getOpponent()))
			model.getCurrentHero().castSpell((KillCommand)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),model.getOpponent());
  		else{
  			model.getCurrentHero().castSpell((KillCommand)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),target);
  			target=(Minion)(model.getOpponent().getField().get(oppField.indexOf(select2)));}
			//model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
			onCurrFieldUpdated();
			onCurrHandUpdated();
			onOpponentUpdated();
		} 
  	
  	catch (NotYourTurnException e1) {
  		new ExceptionmessageWindow(e1.getMessage());	
			
		} 
  	
  	catch (NotEnoughManaException e1) {
  		new ExceptionmessageWindow(e1.getMessage());
			
		} catch (InvalidTargetException e1) {
		// TODO Auto-generated catch block
			new ExceptionmessageWindow(e1.getMessage());
	}
  }
  
if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b))instanceof Pyroblast){
  	
  	try {
			model.getCurrentHero().castSpell((Pyroblast)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),model.getOpponent());
		//	model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
			onCurrFieldUpdated();
			onCurrHandUpdated();
			onOpponentUpdated();
		} 
  	
  	catch (NotYourTurnException e1) {
  		new ExceptionmessageWindow(e1.getMessage());
		
		} 
  	
  	catch (NotEnoughManaException e1) {
  		new ExceptionmessageWindow(e1.getMessage());
			
		}
  }
  
  if(currHand.contains(b) && model.getCurrentHero().getHand().get(currHand.indexOf(b))instanceof SiphonSoul){
  	
  	try {
  		target=(Minion)(model.getOpponent().getField().get(oppField.indexOf(select2)));
  		model.getCurrentHero().castSpell((SiphonSoul)(model.getCurrentHero().getHand().get(currHand.indexOf(b))),target);
  	//	model.getCurrentHero().getHand().remove(model.getCurrentHero().getHand().get(currHand.indexOf(b)));
			m=null;
			
			onCurrFieldUpdated();
			onCurrHandUpdated();
			onOpponentUpdated();
			
		} 
  	
  	catch (NotYourTurnException e1) {
  		new ExceptionmessageWindow(e1.getMessage());	
		
			
		} 
  	
  	catch (NotEnoughManaException e1) {
  		new ExceptionmessageWindow(e1.getMessage());
	
		}
  }
  
  onGameOver();
  onDataUpdated();
       
	}
  
	
     public void onCurrFieldUpdated(){
		
		Hero h=model.getCurrentHero();
		view.getCurrentfield().removeAll();
		currField.removeAll(currField);
		
		for(int i=0;i<h.getField().size();i++){
			
			JButton x=new JButton(h.getField().get(i).toString());
			
			x.addActionListener(this);
			currField.add(x);
			x.revalidate();
			x.repaint();
			view.getCurrentfield().add(x);
			view.getCurrentfield().revalidate();
			view.getCurrentfield().repaint();
		}
		
		view.revalidate();
		view.repaint();
	}
	
	public void onCurrHandUpdated(){
		
		Hero h=model.getCurrentHero();
		view.getCurrenthand().removeAll();
		currHand.removeAll(currHand);
		
		for(int i=0;i<h.getHand().size();i++){
			
			JButton x=new JButton(h.getHand().get(i).toString());
			x.addActionListener(this);
			currHand.add(x);
			x.revalidate();
			x.repaint();
			view.getCurrenthand().add(x);
			view.getCurrenthand().revalidate();
			view.getCurrenthand().repaint();
			
		}
		
		view.revalidate();
		view.repaint();
	}
	
	public void onOpponentUpdated(){
   
		Hero o=model.getOpponent();
		
		view.getOpponentfield().removeAll();
		oppField.removeAll(oppField);
		
		for(int i=0;i<o.getField().size();i++){
			
			JButton x=new JButton(o.getField().get(i).toString());
			x.addActionListener(this);
			oppField.add(x);
			x.revalidate();
			x.repaint();
			view.getCurrentfield().add(x);
			view.getCurrentfield().revalidate();
			view.getCurrentfield().repaint();
		}
		view.revalidate();
		view.repaint();
	}
	
	public void onEndTurn(){
		
		currField.removeAll(currField);
		currHand.removeAll(currHand);
		oppField.removeAll(oppField);
		view.getCurrentfield().removeAll();
		view.getCurrenthand().removeAll();
		view.getOpponentfield().removeAll();
		
		Hero h=model.getCurrentHero();
		
		for(int i=0;i<h.getField().size();i++){
			
			JButton b=new JButton(h.getField().get(i).toString());
			b.addActionListener(this);
		    currField.add(b);
			view.getCurrentfield().add(b);
			b.revalidate();
			b.repaint();
			
			view.getData().setText(
			"My Name:"+model.getCurrentHero().getName()+
			"\nCurrentHP:"+model.getCurrentHero().getCurrentHP()+
			"\nCurrent Mana Crystals:"+model.getCurrentHero().getCurrentManaCrystals()
			+"\nTotal Mana Crystals:"+model.getCurrentHero().getTotalManaCrystals()+
			"\nCards in Deck:"+model.getCurrentHero().getDeck().size()+
			"\nOpponentName:"+model.getOpponent().getName()+
			"\nCurrentHP:"+model.getOpponent().getCurrentHP()+
			"\nCurrent Mana Crystals:"+model.getOpponent().getCurrentManaCrystals()
			+"\nTotal Mana Crystals:"+model.getOpponent().getTotalManaCrystals()+
			"\nCards in Deck:"+model.getOpponent().getDeck().size());
			
			view.revalidate();
			view.repaint();
		}
		
		for(int i=0;i<h.getHand().size();i++){
			
			JButton b=new JButton();
			b.addActionListener(this);
			currHand.add(b);
			b.setText(h.getHand().get(i).toString());
			view.getCurrenthand().add(b);
			b.revalidate();
			b.repaint();
			view.revalidate();
			view.repaint();
		}
		
		Hero x=model.getOpponent();
		for(int i=0;i<x.getField().size();i++){
			JButton b=new JButton();
			b.addActionListener(this);
		    oppField.add(b);
			b.setText(x.getField().get(i).toString());
			view.getOpponentfield().add(b);
			b.revalidate();
			b.repaint();
			view.revalidate();
			view.repaint();
		}
		
		view.revalidate();
		view.repaint();
	}
	
	@Override
	public void onGameOver() {
	
		JPanel gameoverp=new JPanel();
		JTextArea gameover=new JTextArea();
		
		if(model.getCurrentHero().getCurrentHP()==0){
		//	gameover.setText(model.getOpponent().getName()+"wins");
			view.setEnabled(false);
			new GameOver(model.getOpponent().getName()+"wins");
			
		}
		else if(model.getOpponent().getCurrentHP()==0) {
			view.setEnabled(false);
			new GameOver(model.getCurrentHero().getName()+"wins");
			
		}
		
		
		this.onDataUpdated();
		gameover.revalidate();
		gameover.repaint();
		gameoverp.revalidate();
		gameoverp.repaint();
		gameoverp.add(gameover);
		view.add(gameoverp);
		
		
		
		view.revalidate();
		view.repaint();

	}

	public void onDataUpdated(){
		view.getData().setText("My Name:"+model.getCurrentHero().getName()+"\nCurrentHP:"+model.getCurrentHero().getCurrentHP()+"\nCurrent Mana Crystals:"+model.getCurrentHero().getCurrentManaCrystals()
				+"\nTotal Mana Crystals:"+model.getCurrentHero().getTotalManaCrystals()+
				"\nCards in Deck:"+model.getCurrentHero().getDeck().size()+"\nOpponentName:"+model.getOpponent().getName()+"\nCurrentHP:"+model.getOpponent().getCurrentHP()+"\nCurrent Mana Crystals:"+model.getOpponent().getCurrentManaCrystals()
				+"\nTotal Mana Crystals:"+model.getOpponent().getTotalManaCrystals()+"\nCards in Deck:"+model.getOpponent().getDeck().size());
			
			
			view.getData().revalidate();
			view.getData().repaint();
			
			
		
			view.revalidate();
			view.repaint();
	}

   
    	
    	
	}
	
	
	
