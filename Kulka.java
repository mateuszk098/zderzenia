package projektV5;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;

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
		Ellipse2D oval=new Ellipse2D.Double(getX()-getR(),getY()-getR(),2*getR(),2*getR());	
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fill(oval);
	}
	
	public void WarunkiSprezyste()
	{
		setX(getX()+getVX());
		
		if(getX()-getR()<0)
		{
			setX(getR());
			setVX(-getVX());
		}
		if(getX()+getR()>780)
		{
			setVX(-getVX());
		}
		
		setY(getY()+getVY());
		
		if(getY()-getR()<0)
		{
			setY(getR());
			setVY(-getVY());
		}
		if(getY()+getR()>460)
		{
			setY(460-getR());
            setVY(-getVY());
		}
	}
	
	public void WarunkiNiesprezyste()
	{
		setX(getX()+getVX());
		
		if(getX()-getR()<0)
		{
			setX(getR());
			setVX(0);
		}
		if(getX()+getR()>780)
		{
			setVX(0);
		}
		
		setY(getY()+getVY());
		
		if(getY()-getR()<0)
		{
			setY(getR());
			setVY(0);
		}
		if(getY()+getR()>460)
		{
			setY(460-getR());
            setVY(0);
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