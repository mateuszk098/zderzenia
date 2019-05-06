package projekt;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Kulka implements Runnable{
	
	private int SrodekX;
	private int SrodekY;
	private int Promien;
	private Color kolor=Color.RED;
	private int vx = 0;
	private int vy = 0;

	//private BufferedImage[] animation = null;
	private int currentFrame = 0;
	private boolean active = true;

	public Kulka(boolean displayAnimation) {
		
	}
	
	public int getX() {
        return SrodekX;
    }

    public void setX(int xPos) {
        this.SrodekX = xPos;
    }

    public void setY(int yPos) {
        this.SrodekY = yPos;
    }

    public int getY() {
        return SrodekY;
    }
    
    public int getR() {
    	return Promien;
    }
    
    public void setR(int r) {
        this.Promien = r;
    }
    
    public Color getColor() {
        return kolor;
    }

    public void setColor(Color color) {
        this.kolor = color;
    }
    
    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }
    
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval(SrodekX, SrodekY, getR(), getR());
        
    }


	public void run() {
		
		
	}

}
