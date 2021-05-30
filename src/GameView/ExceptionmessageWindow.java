package GameView;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExceptionmessageWindow extends JFrame implements ActionListener {
	
	
	private JPanel exception;
	private JLabel exceptionmessage;
	private JButton closeexception;
	
	public ExceptionmessageWindow(String x) {
		
		
		this.setBounds(200, 200, 400, 400);
		this.setVisible(true);
		this.setLayout(null);
	    this.setTitle("Exception Message");
		
		
		exception =new JPanel();
		exception.setVisible(true);
		exception.setBounds(0, 0, 800, 500);
		exception.setLayout(new BorderLayout());
		this.add(exception);
		
		closeexception = new JButton();
		closeexception.setVisible(true);
		closeexception.setText("Close message");
		closeexception.addActionListener(this);
		exception.add(closeexception,BorderLayout.SOUTH);
		
		closeexception.revalidate();
		closeexception.repaint();
		
		exception.revalidate();
		exception.repaint();
		
		exceptionmessage = new JLabel();
		exceptionmessage.setVisible(true);
		
		exception.add(exceptionmessage , BorderLayout.CENTER);
		exceptionmessage.setText(x);
		
		exceptionmessage.revalidate();
		exceptionmessage.repaint();
		
		exception.revalidate();
		exception.repaint();
		
	}
	
	
	
	
	public JLabel getExceptionmessage() {
		return exceptionmessage;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Close message"))
			
		this.dispose();
		
	}



}
