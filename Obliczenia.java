//Lukasz Kordek
package projekt;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class Obliczenia 
{
	double R=1;//promien kulek
	double x10,y10,v1x,v1y,m1,x20,y20,v2x,v2y,m2;//polozenie poczatkowe kulek i skladowe wektorow predkosci poczatkowych i masy 

	public Obliczenia()
	{
		x10=Double.parseDouble(JWyborPanel.polozenieKulka1x.getText());
		y10=Double.parseDouble(JWyborPanel.polozenieKulka1y.getText());
		v1x=Double.parseDouble(JWyborPanel.predkoscKulka1x.getText());
		v1y=Double.parseDouble(JWyborPanel.predkoscKulka1y.getText());
		m1=Double.parseDouble(JWyborPanel.masaKulka1.getText());
		
		x20=Double.parseDouble(JWyborPanel.polozenieKulka2x.getText());
		y20=Double.parseDouble(JWyborPanel.polozenieKulka2y.getText());
		v2x=Double.parseDouble(JWyborPanel.predkoscKulka2x.getText());
		v2y=Double.parseDouble(JWyborPanel.predkoscKulka2y.getText());
		m2=Double.parseDouble(JWyborPanel.masaKulka2.getText());	
	}
	
	double tz=0;//czas zderzenia
	
	//do rozwiazanie r. kwadratowego czasu do zderzenia
	double a=(v1x-v2x)*(v1x-v2x)+(v1y-v2y)*(v1y-v2y);
	double b=2*((x10-x20)*(v1x-v2x)+(y10-y20)*(v1y-v2y));
	double c=(x10-x20)*(x10-x20)+(y10-y20)*(y10-y20)-4*R*R;
	double delta=b*b-4*a*c;
	
	void policzTz() 
	{
		if(delta>0)
		{
			double t1=(-b-Math.sqrt(delta))/(2*a);
			double t2=(-b+Math.sqrt(delta))/(2*a);
			
			if(t1>0 && t2>0) 
			{
				if(t1>t2)
					tz=t2;
				else
					tz=t1;
			}
		}
	}
		
	//wspolrzedne kul w momencie zderzenia
	double x1z=x10+v1x*tz;
	double y1z=y10+v1y*tz;
	double x2z=x20+v2x*tz;
	double y2z=y20+v2y*tz;
	
	//pomocnicze
	double L=1/(Math.sqrt( (x2z-x1z)*(x2z-x1z)+(y2z-y1z)*(y2z-y1z) ));
	
	//rozbicie na styczne i normalne predkosci
	double v1s=L*(v1x*(-y2z+y1z)+v1y*(x2z-x1z));
	double v2s=L*(v2x*(-y2z+y1z)+v2y*(x2z-x1z));
	
	double v1n=L*(v1x*(x2z-x1z)+v1y*(y2z-y1z));
	double v2n=L*(v2x*(x2z-x1z)+v2y*(y2z-y1z));
	
	//skladowe normalne po zderzeniu
	double u1n=((m1-m2)*v1n+2*m2*v2n)/(m1+m2);
	double u2n=((m2-m1)*v2n+2*m1*v1n)/(m1+m2);
	
	//predkosci po zderzeniu uklad kartezjanski
	double u1x=L*(x2z-x1z)*u1n+L*(-y2z+y1z)*v1s;
	double u1y=L*(y2z-y1z)*u1n+L*(x2z-x1z)*v1s;
	double u2x=L*(x2z-x1z)*u2n+L*(-y2z+y1z)*v2s;
	double u2y=L*(y2z-y1z)*u2n+L*(x2z-x1z)*v2s;	
}