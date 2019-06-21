package projektV5;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class JWyborPanel extends JPanel
{
	double v1x,v1y,v2x,v2y;
	
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
	
	static JLabel LKulka1=new JLabel("       KULKA 1");
	static JLabel LPredkoscKulka1=new JLabel(" Predkosc (m/s) ");
	static JLabel LSkladowePredkosciKulka1=new JLabel("     Vx          Vy	");
	static JLabel LPolozenieKulka1=new JLabel("     Polozenie");
	static JLabel LSkladowePolozeniaKulki1=new JLabel("      X          Y");
	static JLabel LMasaKulki1=new JLabel("      Masa (kg)");
	
	static JLabel LKulka2=new JLabel("       KULKA 2");
	static JLabel LPredkoscKulka2=new JLabel(" Predkosc (m/s) ");
	static JLabel LSkladowePredkosciKulka2=new JLabel("     Vx          Vy	");
	static JLabel LPolozenieKulka2=new JLabel("     Polozenie");
	static JLabel LSkladowePolozeniaKulki2=new JLabel("      X          Y");
	static JLabel LMasaKulki2=new JLabel("      Masa (kg)");
	
	JWyborPanel()
	{	
		this.setLayout(new GridLayout(22,1));

		this.add(LKulka1);
		this.add(LPredkoscKulka1);
		this.add(LSkladowePredkosciKulka1);
		panelPredkosci1.add(predkoscKulka1x);
		panelPredkosci1.add(predkoscKulka1y);
		this.add(panelPredkosci1);
		this.add(LPolozenieKulka1);
		this.add(LSkladowePolozeniaKulki1);
		panelPolozenie1.add(polozenieKulka1x);
		panelPolozenie1.add(polozenieKulka1y);
		this.add(panelPolozenie1);
		this.add(LMasaKulki1);
		panelMasa1.add(masaKulka1);
		this.add(panelMasa1);	
				
		this.add(LKulka2);
		this.add(LPredkoscKulka2);
		this.add(LSkladowePredkosciKulka2);
		this.add(panelPredkosci2);
		panelPredkosci2.add(predkoscKulka2x);
		panelPredkosci2.add(predkoscKulka2y);
		this.add(LPolozenieKulka2);
		this.add(LSkladowePolozeniaKulki2);
		panelPolozenie2.add(polozenieKulka2x);
		panelPolozenie2.add(polozenieKulka2y);
		this.add(panelPolozenie2);
		this.add(LMasaKulki2);
		panelMasa2.add(masaKulka2);
		this.add(panelMasa2);
		
		predkoscKulka1x.setHorizontalAlignment(JTextField.CENTER);
		predkoscKulka1y.setHorizontalAlignment(JTextField.CENTER);
		predkoscKulka2x.setHorizontalAlignment(JTextField.CENTER);
		predkoscKulka2y.setHorizontalAlignment(JTextField.CENTER);
		polozenieKulka1x.setHorizontalAlignment(JTextField.CENTER);
		polozenieKulka1y.setHorizontalAlignment(JTextField.CENTER);
		polozenieKulka2x.setHorizontalAlignment(JTextField.CENTER);
		polozenieKulka2y.setHorizontalAlignment(JTextField.CENTER);
		masaKulka1.setHorizontalAlignment(JTextField.CENTER);
		masaKulka2.setHorizontalAlignment(JTextField.CENTER);
	}
}