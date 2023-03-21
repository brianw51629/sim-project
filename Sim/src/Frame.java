import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements KeyListener, ActionListener{
	ArrayList<Cell> cells = new ArrayList<Cell>();
	// instance variables - "global" variables
	  
	int x = 0;
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0;i<cells.size();i++) {
			
			(cells.get(i)).paint(g);
		
			
			
			
			
			
		}
		
		
		for(int i =0;i<cells.size();i++) {
			for(int j = 0;j<cells.size();j++) {
				
				cells.get(i).intersect(cells.get(j));
				
			}
			
		}
		
		
		
		
	}
	
	
	public Frame() {
		//Name of title bar of the GUI
		JFrame f = new JFrame("Sim");
		
		//makes sure that the program stops when the window is close
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //don't delete
		
		//GUI dimensions - width - height
		f.setSize(800,600);
		
		//create 100 cells
		
		for(int i=0;i<101;i++) {
			cells.add(new Cell());
		}
		
		
		
		
		f.add(this);
		f.addKeyListener(this);
		
		t = new Timer(16, this);
		 t.start();
		f.setVisible(true);
		
	}
	
	
	
	
	Timer t;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		 cells.add(new Cell(350,250));
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
}
