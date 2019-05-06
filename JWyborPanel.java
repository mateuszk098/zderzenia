package projekt;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class JWyborPanel extends JPanel
{
	JPanel panelPredkosci1=new JPanel(new GridLayout(1,2));
	JPanel panelPredkosci2=new JPanel(new GridLayout(1,2));
	
	JPanel panelPolozenie1=new JPanel(new GridLayout(1,2));
	JPanel panelPolozenie2=new JPanel(new GridLayout(1,2));
	
	JPanel panelMasa1=new JPanel(new GridLayout(1,1));
	JPanel panelMasa2=new JPanel(new GridLayout(1,1));
	
	static JTextField predkoscKulka1x=new JTextField();
	static JTextField predkoscKulka1y=new JTextField();
	
	static JTextField predkoscKulka2x=new JTextField();
	static JTextField predkoscKulka2y=new JTextField();
	
	static JTextField polozenieKulka1x=new JTextField();
	static JTextField polozenieKulka1y=new JTextField();
	
	static JTextField polozenieKulka2x=new JTextField();
	static JTextField polozenieKulka2y=new JTextField();	
	
	static JTextField masaKulka1=new JTextField();
	static JTextField masaKulka2=new JTextField();
	
	JWyborPanel()
	{	
		this.setLayout(new GridLayout(19,1));
 
		this.add(new JLabel("       KULKA 1"));
		this.add(new JLabel(" Predkosc (m/s) "));
		this.add(new JLabel("  X-owa  Y-owa"));
		panelPredkosci1.add(predkoscKulka1x);
		panelPredkosci1.add(predkoscKulka1y);
		this.add(panelPredkosci1);
		this.add(new JLabel("     Polozenie"));
		this.add(new JLabel("      X          Y"));
		panelPolozenie1.add(polozenieKulka1x);
		panelPolozenie1.add(polozenieKulka1y);
		this.add(panelPolozenie1);
		this.add(new JLabel("      Masa (kg)"));
		panelMasa1.add(masaKulka1);
		this.add(panelMasa1);	
		
		this.add(new JLabel("----------------------"));
		
		this.add(new JLabel("       KULKA 2"));
		this.add(new JLabel(" Predkosc (m/s) "));
		this.add(new JLabel("  X-owa  Y-owa"));
		this.add(panelPredkosci2);
		panelPredkosci2.add(predkoscKulka2x);
		panelPredkosci2.add(predkoscKulka2y);
		this.add(new JLabel("     Polozenie"));
		this.add(new JLabel("      X          Y"));
		panelPolozenie2.add(polozenieKulka2x);
		panelPolozenie2.add(polozenieKulka2y);
		this.add(panelPolozenie2);
		this.add(new JLabel("      Masa (kg)"));
		panelMasa2.add(masaKulka2);
		this.add(panelMasa2);
		
		//test
	}
}
