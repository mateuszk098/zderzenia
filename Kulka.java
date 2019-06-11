package projektV6;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Kulka
{
	private double x,y,r,vx,vy,m;
	Color color;
	
	public Kulka(double x,double y,double r)
	{
		this.x=x;
		this.y=y;
		this.r=r;
	}
	
	public void draw(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		Ellipse2D oval=new Ellipse2D.Double(getX()-getR()/2,getY()-getR()/2,getR(),getR());	
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fill(oval);
	}
	
	public void Warunki()
	{
		setX(getX()+getVX());
		
		if(getX()-getR()/2<0)
		{
			setX(getR()/2);
			setVX(-getVX());
		}
		else if(getX()+getR()/2>780)
		{
			setVX(-getVX());
		}
		
		setY(getY()+getVY());
		
		if(getY()-getR()/2<0)
		{
			setY(getR()/2);
			setVY(-getVY());
		}
		else if(getY()+getR()/2>440)
		{
			setY(440-getR()/2);
            setVY(-getVY());
		}
	}
	
	public double getVX() 
    {
        return vx;
    }

    public void setVX(double vx) 
    {
        this.vx=vx;
    }

    public double getVY() 
    {
        return vy;
    }

    public void setVY(double vy) 
    {
        this.vy=vy;
    }

    public double getX() 
    {
        return x;
    }

    public void setX(double x)
    {
        this.x=x;
    }

    public double getY() 
    {
        return y;
    }

    public void setY(double y) 
    {
        this.y=y;
    }

    public double getR() 
    {
        return r;
    }

    public void setR(double r) 
    {
        this.r=r;
    }
    
    public double getM()
    {
    	return m;
    }
    
    public void setM(double m)
    {
    	this.m=m;
    }
    
    public void setBallColor(Color ballColor)
    {
    	color=ballColor;
    }
}