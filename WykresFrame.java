package projekt;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class WykresFrame extends JFrame implements KeyListener
{
	WykresFrame()
	{
		this.setSize(600,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Wykres zależności prędkości od czasu");
		
		this.addKeyListener(new KeyListener() 
		{
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE);
					setVisible(false);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
