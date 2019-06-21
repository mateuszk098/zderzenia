package projektV5;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Frame extends JFrame
{	
	JMenu menu=new JMenu("Menu");
	JMenu submenu=new JMenu("Ustawienia Jezykowe");
	JMenuItem submenuItem1=new JMenuItem("Jezyk Polski");
	JMenuItem submenuItem2=new JMenuItem("Jezyk Angielski");
	JMenuItem menuItem3=new JMenuItem("Wyjscie");
	JMenuItem menuItem2=new JMenuItem("Nowe Zderzenie");
	JMenuBar menuBar=new JMenuBar();
	
	JButton BkolorTla=new JButton("Kolor Tla");
	JButton BkolorKulki1=new JButton("Kolor Kulki 1");
	JButton BkolorKulki2=new JButton("Kolor Kulki 2");
	JButton Bstart=new JButton("Start");
	JButton Bstop=new JButton("Stop");
	JButton Bwykres=new JButton("Wykres V(t)");
	JButton Bakceptuj=new JButton("Akceptuj");
	JButton Bprzyklad=new JButton("Przyklad");
	
	JRadioButton rBsprezyste=new JRadioButton("Sprezyste");
	JRadioButton rBniesprezyste=new JRadioButton("Niesprezyste");
	ButtonGroup buttonGroup=new ButtonGroup();
	
	JLabel LRodzajZderzenia=new JLabel("Rodzaj Zderzenia");
	JLabel liczbaZderzen=new JLabel("Liczba Zderzen");
	
	static JTextField liczbaZderzenField=new JTextField("0");
	
	JPanel panelKolory=new JPanel();
	JPanel panelCentralny=new JPanel();
	JPanel panelStartStop=new JPanel(new GridLayout(8,1));
	JWyborPanel panelDane=new JWyborPanel();
	
	PanelRysowania panelRysujacy=new PanelRysowania();
	
	String aktualny="Sprezyste";
	static String Language="PL";
	
	Frame()
	{
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(1020,540);
		this.setTitle("Symulator Zderzen Sprezystych i Niesprezystych");
		this.setJMenuBar(createMenu());
		
		BkolorTla.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(Language=="PL") 
				{
					Color kolor=JColorChooser.showDialog(null,"Wybierz Kolor", Color.BLACK);
					panelRysujacy.setBackground(kolor);
				}
				
				if(Language=="EN") 
				{
					Color kolor=JColorChooser.showDialog(null,"Choose Color", Color.BLACK);
					panelRysujacy.setBackground(kolor);
				}
			}
		});
		
		BkolorKulki1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{			
				panelRysujacy.kolorKulki1();				
			}
		});
		
		BkolorKulki2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				panelRysujacy.kolorKulki2();	
			}
		});
		
		Bwykres.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{			        
		        Bwykres.setEnabled(false);
		        final WykresFrame wykres=new WykresFrame();	 
		        final WykresKulka2 wykres2=new WykresKulka2();
		        
		        SwingWorker worker=new SwingWorker()
		        {
		            protected Object doInBackground() throws Exception
		            {
		            	wykres.go();
		            	wykres2.go();
		                return null;
		            }

		            protected void done()
		            {
		            	Bwykres.setEnabled(true);
		            }
		        };
		        worker.execute();        
			}
		});
		
		Bakceptuj.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{			
				if(JWyborPanel.predkoscKulka1x.getText().isEmpty() ||
					JWyborPanel.predkoscKulka1y.getText().isEmpty() ||
					JWyborPanel.predkoscKulka2x.getText().isEmpty() ||
					JWyborPanel.predkoscKulka2y.getText().isEmpty() ||
					JWyborPanel.polozenieKulka1x.getText().isEmpty() ||
					JWyborPanel.polozenieKulka1y.getText().isEmpty() ||
					JWyborPanel.polozenieKulka2x.getText().isEmpty() ||
					JWyborPanel.polozenieKulka2y.getText().isEmpty() ||						
					JWyborPanel.masaKulka1.getText().isEmpty() ||
					JWyborPanel.masaKulka2.getText().isEmpty())				
				{
					JOptionPane.showMessageDialog(null,"Należy uzupełnić wartości");
				}
				else
				{
					panelRysujacy.przedZderzeniem();
				}
			}
		});
		
		Bprzyklad.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{			
				panelRysujacy.przykladoweWartosci();
			}
		});
		
		Bstart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelRysujacy.startZderzenia();
			}
		});
		
		Bstop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelRysujacy.stopZderzenia();
			}
		});
		
		panelKolory.add(BkolorTla);
		panelKolory.add(BkolorKulki1);
		panelKolory.add(BkolorKulki2);
		this.add(panelKolory,BorderLayout.PAGE_END);
		
		buttonGroup.add(rBsprezyste);
		buttonGroup.add(rBniesprezyste);
		buttonGroup.clearSelection();
		//rBsprezyste.setSelected(true);
		//rBsprezyste.requestFocus();
		
		rBsprezyste.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelRysujacy.setZderzenie("Sprezyste");	
			}
		});
		
		rBniesprezyste.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panelRysujacy.setZderzenie("Niesprezyste");		
			}
		});
		
		panelStartStop.add(LRodzajZderzenia);
		panelStartStop.add(rBsprezyste);
		panelStartStop.add(rBniesprezyste);
		panelStartStop.add(Bstart);
		panelStartStop.add(Bstop);
		panelStartStop.add(Bwykres);
		panelStartStop.add(liczbaZderzen);
		
		liczbaZderzen.setHorizontalAlignment(JLabel.CENTER);
		liczbaZderzenField.setHorizontalAlignment(JTextField.CENTER);
		
		panelStartStop.add(liczbaZderzenField);
		this.add(panelStartStop,BorderLayout.LINE_START);
		
		panelDane.add(new JLabel(""));
		panelDane.add(Bprzyklad);
		panelDane.add(new JLabel(""));
		panelDane.add(Bakceptuj);
		this.add(panelDane,BorderLayout.LINE_END);

		this.add(panelRysujacy,BorderLayout.CENTER);
	}
	
	public void SetTitle(String NowyTytul)
	{
		this.setTitle(NowyTytul);
	}
	
	public JMenuBar createMenu()
	{
		menuBar.add(menu);
		
		submenu.setMnemonic(KeyEvent.VK_S);
		
		submenuItem1.setActionCommand("Jezyk Polski");
		submenuItem1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(Language=="EN") 
				{
					Language="PL";
					BkolorTla.setText("Kolor Tla");
					BkolorKulki1.setText("Kolor Kulki 1");
					BkolorKulki2.setText("Kolor Kulki 2");
					Bakceptuj.setText("Akceptuj");
					Bwykres.setText("Wykres V(t)");
					rBsprezyste.setText("Sprezyste");
					rBniesprezyste.setText("Niesprezyste");
					LRodzajZderzenia.setText("Rodzaj Zderzenia");
					
					JWyborPanel.LKulka1.setText("       KULKA 1");
					JWyborPanel.LPredkoscKulka1.setText(" Predkosc (m/s) ");
					//JWyborPanel.LSkladowePredkosciKulka1.setText("  X     Y    ");
					JWyborPanel.LPolozenieKulka1.setText("     Polozenie");
					//JWyborPanel.LSkladowePolozeniaKulki1.setText("Ball 1");
					JWyborPanel.LMasaKulki1.setText("      Masa (kg)");
					
					JWyborPanel.LKulka2.setText("       KULKA 1");
					JWyborPanel.LPredkoscKulka2.setText(" Predkosc (m/s) ");
					//JWyborPanel.LSkladowePredkosciKulka2.setText("  X     Y    ");
					JWyborPanel.LPolozenieKulka2.setText("     Polozenie");
					//JWyborPanel.LSkladowePolozeniaKulki2.setText("Ball 1");
					JWyborPanel.LMasaKulki2.setText("      Masa (kg)");
					
					SetTitle("Symulator Zderzen Sprezystych i Niesprezystych");
					
					submenu.setText("Ustawienia Jezykowe");
					submenuItem1.setText("Jezyk Polski");
					submenuItem2.setText("Jezyk Angielski");
					menuItem2.setText("Nowe Zderzenie");
					menuItem3.setText("Wyjscie");
				}
				
			}
		});
		submenuItem2.setActionCommand("Jezyk Angielski");
		submenuItem2.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				if(Language=="PL") 
				{
					Language="EN";
					BkolorTla.setText("Background Color");
					BkolorKulki1.setText("Ball 1 Color");
					BkolorKulki2.setText("Ball 2 Color");
					Bakceptuj.setText("Accept");
					Bwykres.setText("Chart V(t)");
					rBsprezyste.setText("Elastic");
					rBniesprezyste.setText("Inelastic");
					LRodzajZderzenia.setText("Type of Collision");
					
					JWyborPanel.LKulka1.setText("       BALL 1 ");
					JWyborPanel.LPredkoscKulka1.setText(" Velocity (m/s) ");
					//JWyborPanel.LSkladowePredkosciKulka1.setText("  X     Y    ");
					JWyborPanel.LPolozenieKulka1.setText("      Position");
					//JWyborPanel.LSkladowePolozeniaKulki1.setText("Ball 1");
					JWyborPanel.LMasaKulki1.setText("      Mass (kg)");
					
					JWyborPanel.LKulka2.setText("       BALL 2 ");
					JWyborPanel.LPredkoscKulka2.setText(" Velocity (m/s) ");
					//JWyborPanel.LSkladowePredkosciKulka2.setText("  X     Y    ");
					JWyborPanel.LPolozenieKulka2.setText("      Position");
					//JWyborPanel.LSkladowePolozeniaKulki2.setText("Ball 1");
					JWyborPanel.LMasaKulki2.setText("      Mass (kg)");
					
					SetTitle("Simulation of Elastic and Inelastic Collisions");
					
					submenu.setText("Language Settings");
					submenuItem1.setText("Polish");
					submenuItem2.setText("English");
					menuItem2.setText("New Collisoin");
					menuItem3.setText("Exit");
				}
			}
		});
				
		submenu.add(submenuItem1);
		submenu.add(submenuItem2);
	
		menu.add(submenu);
		
		menuItem2.setActionCommand("Nowe zderzenie");
		menuItem2.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				panelRysujacy.noweZderzenie();
			}
		});
		menu.add(menuItem2);
		
		menuItem3.setActionCommand("Zakoncz");
		menuItem3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		menu.add(menuItem3);
		
		return menuBar;
	}
	
	public static void main (String[] args) throws Exception
	{
		Frame frame=new Frame();
		frame.setVisible(true);
	}
}