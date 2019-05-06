package projekt;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import projekt.WykresFrame.keyListener;

public class Frame extends JFrame implements ActionListener
{
	JMenu menu=new JMenu("Menu");
	JMenu submenu=new JMenu("Ustawienia Językowe");
	JMenuItem submenuItem1=new JMenuItem("Język Polski");
	JMenuItem submenuItem2=new JMenuItem("Język Angielski");
	JMenuItem menuItem2=new JMenuItem("Zakończ");
	JMenuItem menuItem3=new JMenuItem("Nowe Zderzenie");
	JMenuBar menuBar=new JMenuBar();
	
	JButton BkolorTla=new JButton("Kolor Tła");
	JButton BkolorKulki1=new JButton("Kolor Kulki 1");
	JButton BkolorKulki2=new JButton("Kolor Kulki 2");
	JButton Bstart=new JButton("Start");
	JButton Bstop=new JButton("Stop");
	JButton Bwykres=new JButton("Wykres v(t)");
	
	JRadioButton rBsprezyste=new JRadioButton("Sprężyste");
	JRadioButton rBniesprezyste=new JRadioButton("Niesprężyste");
	ButtonGroup buttonGroup=new ButtonGroup();
	
	JPanel panelKolory=new JPanel();
	JPanel panelCentralny=new JPanel();
	JPanel panelStartStop=new JPanel(new GridLayout(8,1));
	JWyborPanel panelDane=new JWyborPanel();
	
	Frame()
	{
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(820,540);
		this.setTitle("Symulator Zderzeń Sprężystych i Niesprężystych");
		this.setJMenuBar(createMenu());

		BkolorTla.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Color kolor = JColorChooser.showDialog(null, "Wybierz kolor", Color.BLACK);
				panelCentralny.setBackground(kolor);
			}
		});
		
		BkolorKulki1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Color kolor = JColorChooser.showDialog(null, "Wybierz kolor", Color.BLACK);

			}
		});
		
		BkolorKulki2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Color kolor = JColorChooser.showDialog(null, "Wybierz kolor", Color.BLACK);

			}
		});
		
		Bwykres.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				WykresFrame wykres=new WykresFrame();
				wykres.setVisible(true);
			}
		});
		
		panelKolory.add(BkolorTla);
		panelKolory.add(BkolorKulki1);
		panelKolory.add(BkolorKulki2);
		this.add(panelKolory,BorderLayout.PAGE_END);
		
		buttonGroup.add(rBsprezyste);
		buttonGroup.add(rBniesprezyste);
		rBsprezyste.setSelected(true);
		
		panelStartStop.add(new JLabel("Rodzaj Zderzenia"));
		panelStartStop.add(rBsprezyste);
		panelStartStop.add(rBniesprezyste);
		panelStartStop.add(Bstart);
		panelStartStop.add(Bstop);
		panelStartStop.add(Bwykres);
		this.add(panelStartStop,BorderLayout.LINE_START);
		
		this.add(panelDane,BorderLayout.LINE_END);
		
		panelCentralny.setBackground(Color.white);
		this.add(panelCentralny,BorderLayout.CENTER);
	}
	
	public JMenuBar createMenu()
	{
		menuBar.add(menu);
	
		submenu.setMnemonic(KeyEvent.VK_S);
		submenu.add(submenuItem1);
		submenu.add(submenuItem2);
		menu.add(submenu);
		
		menuItem2.setActionCommand("Zakończ");
		menuItem2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		menu.add(menuItem3);
		
		menu.add(menuItem2);
		
		return menuBar;
	}
	
	public static void main (String[] args)
	{
		Frame frame=new Frame();
		frame.setVisible(true);
	}
}
