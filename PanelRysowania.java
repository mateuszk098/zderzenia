package projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

import org.jfree.data.gantt.Task;

public class PanelRysowania extends JPanel implements Runnable
{
	static Kulka Kulka1=new Kulka(50,50,25);
	static Kulka Kulka2=new Kulka(50,50,25);

	Thread animacja;
	
	boolean aktywna=true;
	double deltaX,deltaY,odleglosc;
	int widthX,heightY;
	String zderzenie;
	
	public PanelRysowania() 
	{
		this.setBackground(Color.white);
		
		this.widthX=getWidth();
		this.heightY=getHeight();
		
		Kulka1.setX(100);
		Kulka1.setY(200);
		Kulka1.setVX(0);
		Kulka1.setVY(0);
		Kulka1.setM(0);
		
		Kulka2.setX(700);
		Kulka2.setY(200);
		Kulka2.setVX(0);
		Kulka2.setVY(0);
		Kulka2.setM(0);
		
		animacja=new Thread(this);
		animacja.start();
	}
	
	void przedZderzeniem() 
	{
		Kulka1.setX(Double.parseDouble(JWyborPanel.polozenieKulka1x.getText()));
		Kulka1.setY(Double.parseDouble(JWyborPanel.polozenieKulka1y.getText()));
		
		Kulka1.setVX(Double.parseDouble(JWyborPanel.predkoscKulka1x.getText()));
		Kulka1.setVY(Double.parseDouble(JWyborPanel.predkoscKulka1y.getText()));
		
		Kulka1.setM(Double.parseDouble(JWyborPanel.masaKulka1.getText()));
		
		Kulka2.setX(Double.parseDouble(JWyborPanel.polozenieKulka2x.getText()));
		Kulka2.setY(Double.parseDouble(JWyborPanel.polozenieKulka2y.getText()));
		
		Kulka2.setVX(Double.parseDouble(JWyborPanel.predkoscKulka2x.getText()));
		Kulka2.setVY(Double.parseDouble(JWyborPanel.predkoscKulka2y.getText()));	
		
		Kulka2.setM(Double.parseDouble(JWyborPanel.masaKulka2.getText()));
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);	
		Kulka1.draw(g);
		Kulka2.draw(g);	
	}
	
	public void kolizjaSprezysta()
	{
		deltaX=Math.abs(Kulka1.getX()-Kulka2.getX());
        deltaY=Math.abs(Kulka1.getY()-Kulka2.getY());
        odleglosc=Math.sqrt(deltaX*deltaX+deltaY*deltaY);
        
        if(odleglosc<Kulka1.getR()+Kulka2.getR()) //Math.sqrt(Kulka1.getR()*Kulka1.getR()+Kulka2.getR()*Kulka2.getR())
        {   
        	//zmienna pomocnicza
        	double L=1/Math.sqrt( (Kulka2.getX()-Kulka1.getX() )*(Kulka2.getX()-Kulka1.getX() ) + (Kulka2.getY()-Kulka1.getY() )*(Kulka2.getY()-Kulka1.getY() )  );//zmienna pomocnicza
        	
        	//predkosci normalne przed zderzeniem
        	double Vn1=L*( Kulka1.getVX()*( Kulka2.getX()-Kulka1.getX() )+Kulka1.getVY()*( Kulka2.getY()-Kulka1.getY() ));
        	double Vn2=L*( Kulka2.getVX()*( Kulka2.getX()-Kulka1.getX() )+Kulka2.getVY()*( Kulka2.getY()-Kulka1.getY() ));
        	
        	//predkosci styczne przed zderzeniem
        	double Vs1=L*( Kulka1.getVX()*(Kulka1.getY()-Kulka2.getY()) + Kulka1.getVY()*(Kulka2.getX()-Kulka1.getX()) );
        	double Vs2=L*( Kulka2.getVX()*(Kulka1.getY()-Kulka2.getY()) + Kulka2.getVY()*(Kulka2.getX()-Kulka1.getX()) );
        	
        	//predkosci normalne po zderzeniu
        	double Un1= ( (Kulka1.getM()-Kulka2.getM())*Vn1 + 2*Vn2*Kulka2.getM() )/( Kulka1.getM()+Kulka2.getM() );
        	double Un2= ( (Kulka2.getM()-Kulka1.getM())*Vn2 + 2*Vn1*Kulka1.getM() )/( Kulka1.getM()+Kulka2.getM() );
        	
        	
        	
        	double newVX1=L*( ( Kulka2.getX()-Kulka1.getX() )*Un1+( -Kulka2.getY()+Kulka1.getY() )*Vs1 );
        	double newVY1=L*( ( Kulka2.getY()-Kulka1.getY() )*Un1+( Kulka2.getX()-Kulka1.getX() )*Vs1 );
        	
        	double newVX2=L*( ( Kulka2.getX()-Kulka1.getX() )*Un2+( -Kulka2.getY()+Kulka1.getY() )*Vs2 );
        	double newVY2=L*( ( Kulka2.getY()-Kulka1.getY() )*Un2+( Kulka2.getX()-Kulka1.getX() )*Vs2 );
        	
            Kulka1.setVX(newVX1);
            Kulka1.setVY(newVY1);
            
            Kulka2.setVX(newVX2);
            Kulka2.setVY(newVY2);
            
            /*double newVX1=(Kulka1.getVX()*(Kulka1.getM()-Kulka2.getM())+2*Kulka2.getM()*Kulka2.getVX())/(Kulka1.getM()+Kulka2.getM());
        	double newVX2=(Kulka2.getVX()*(Kulka2.getM()-Kulka1.getM())+2*Kulka1.getM()*Kulka1.getVX())/(Kulka1.getM()+Kulka2.getM());
        	double newVY1=0;
        	double newVY2=0;
        	
            Kulka1.setVX(newVX1);
            Kulka1.setVY(newVY1);
            
            Kulka2.setVX(newVX2);
            Kulka2.setVY(newVY2);*/
        }
	}
	
	 
    public void kolizjaNiesprezysta()
    {
    	deltaX=Math.abs(Kulka1.getX()-Kulka2.getX());
        deltaY=Math.abs(Kulka1.getY()-Kulka2.getY());
        odleglosc=Math.sqrt(deltaX*deltaX+deltaY*deltaY);
            
        if(odleglosc<Kulka1.getR()+Kulka2.getR()) 
        {     		
            	
            double newVX=(Kulka1.getVX()*Kulka1.getM()+Kulka2.getVX()*Kulka2.getM())/(Kulka1.getM()+Kulka2.getM());
            double newVY=(Kulka1.getVY()*Kulka1.getM()+Kulka2.getVY()*Kulka2.getM())/(Kulka1.getM()+Kulka2.getM());
            //double newVY1=(Kulka1.getVY()*Kulka1.getM()+Kulka2.getVY()*Kulka2.getM())/(Kulka1.getM()+Kulka2.getM());
            //double newVY2=(Kulka1.getVY()*Kulka1.getM()+Kulka2.getVY()*Kulka2.getM())/(Kulka1.getM()+Kulka2.getM());
                	
            Kulka1.setVX(newVX);
            Kulka1.setVY(newVY);
            Kulka2.setVX(newVX);
            Kulka2.setVY(newVY);
            	
            /*if(Kulka1.getVY()==0 && Kulka2.getVY()==0)
            {
            	double newVX1=(Kulka1.getVX()*Kulka1.getM()+Kulka2.getVX()*Kulka2.getM())/(Kulka1.getM()+Kulka2.getM());
                double newVX2=(Kulka1.getVX()*Kulka1.getM()+Kulka2.getVX()*Kulka2.getM())/(Kulka1.getM()+Kulka2.getM());
                	
                Kulka1.setVX(newVX1);             
                Kulka2.setVX(newVX2);
            }
            	
            else if(Kulka1.getVX()==0 && Kulka2.getVX()==0)
            {
            	double newVY1=(Kulka1.getVY()*Kulka1.getM()+Kulka2.getVY()*Kulka2.getM())/(Kulka1.getM()+Kulka2.getM());
                double newVY2=(Kulka1.getVY()*Kulka1.getM()+Kulka2.getVY()*Kulka2.getM())/(Kulka1.getM()+Kulka2.getM());
                	
                Kulka1.setVY(newVY1);              
                Kulka2.setVY(newVY2);
            }*/
        }	
    }
	
	public void run() 
	{
		while(aktywna) 
		{
			if(getZderzenie()=="Sprezyste")
			{
				Kulka1.WarunkiSprezyste();
				Kulka2.WarunkiSprezyste();
			}
			else if(getZderzenie()=="Niesprezyste")
			{
				Kulka1.WarunkiNiesprezyste();
				Kulka2.WarunkiNiesprezyste();
			}
			
			wyborZderzenia();
			repaint();
			
			try 
			{
                Thread.sleep(20);
            } 
			catch (InterruptedException ex) 
			{
            }
		}	
	}
	
	public void noweZderzenie() 
	{
		Kulka1.setX(100);
		Kulka1.setY(200);
		Kulka1.setVX(0);
		Kulka1.setVY(0);
		Kulka1.setM(0);
		
		Kulka2.setX(700);
		Kulka2.setY(200);
		Kulka2.setVX(0);
		Kulka2.setVY(0);
		Kulka2.setM(0);
	}
	
	public void stopZderzenia()
	{
		if(!aktywna)return;
		aktywna=false;
		
		try 
		{
			animacja.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void startZderzenia()
	{
		if(aktywna)return;
		aktywna=true;
		animacja=new Thread(this);
		animacja.start();	
	}
	
	public void setZderzenie(String zderzenie)
	{
		this.zderzenie=zderzenie;
	}
	
	public String getZderzenie()
	{
		return zderzenie;
	}
	
	public void wyborZderzenia()
	{
		if(getZderzenie()=="Sprezyste")
		{
			kolizjaSprezysta();
		}
		else if(getZderzenie()=="Niesprezyste")
		{
			kolizjaNiesprezysta();
		}
	}
	
	public int getWidthX()
	{
		return widthX;
	}
	
	public int getHeightY()
	{
		return heightY;
	}
	
	public void kolorKulki1()
	{
		if(Frame.Language=="PL") 
		{
			Color kolor1=JColorChooser.showDialog(null,"Wybierz Kolor",Color.BLACK);
			Kulka1.setBallColor(kolor1);
		}
		if(Frame.Language=="EN") 
		{
			Color kolor1=JColorChooser.showDialog(null,"Choose Color",Color.BLACK);
			Kulka1.setBallColor(kolor1);
		}	
	}
	
	public void kolorKulki2()
	{
		if(Frame.Language=="PL") 
		{
			Color kolor2=JColorChooser.showDialog(null,"Wybierz Kolor",Color.BLACK);
			Kulka2.setBallColor(kolor2);
		}
		if(Frame.Language=="EN") 
		{
			Color kolor2=JColorChooser.showDialog(null,"Choose Color",Color.BLACK);
			Kulka2.setBallColor(kolor2);
		}
	}
}