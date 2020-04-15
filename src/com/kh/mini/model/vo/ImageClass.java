package com.kh.mini.model.vo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageClass {
	private BufferedImage img;
	
	private BufferedImage[] frameImg;
	
	private double x;
	private double y;
	
	private int frameX;
	private int frameY;
	
	private int maxCountX;
	private int maxCountY;
	
	private int width;
	private int height;
	
	private double magnification;
	
	boolean isRepeat;
	boolean isOn;
	private int speed;
	
	private int maxSpeed;
	
	protected AffineTransform t;
	
	private Point2D pt;
	private Point2D dp;
	
	//public void Init(BufferedImage img) {
	public void Init(String path) {		
		this.magnification = 1;		
		t = new AffineTransform();
		t.scale(magnification, magnification);
		//불러오기 처리.				
		try {
			//spriteImage = ImageIO.read(new File(name));
			img = ImageIO.read(new File(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		this.setWidth(img.getWidth());
		this.setHeight(img.getHeight());
		
		pt = new Point2D.Double(0 ,0);
		dp = new Point2D.Double(0, 0);
	}
	
	public void Init(String path, int width, int height, int maxCountX, int maxCountY, boolean isRepeat) {
		this.magnification = 1;
		this.maxCountX = maxCountX;
		this.maxCountY = maxCountY;
		this.setWidth(width);
		this.setHeight(height);
		this.isRepeat = isRepeat;
		
		t = new AffineTransform();
		t.scale(magnification, magnification);
		
		BufferedImage bigImg = null;
		try {
			bigImg = ImageIO.read(new File(path));		

		} catch(IOException e) {
			e.printStackTrace();
		}		
		
		frameImg = new BufferedImage[maxCountX * maxCountY];

		for (int i = 0; i < maxCountY; i++) {
			for (int j = 0; j < maxCountX; j++) {
				frameImg[i * maxCountX + j] = bigImg.getSubimage(j * width, i * height, width, height);
			}
		}

	}
	public void changeImage(String path) {
		
		this.magnification = 1;		
		t.scale(magnification, magnification);			
		try {
			img = ImageIO.read(new File(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		this.setWidth(img.getWidth());
		this.setHeight(img.getHeight());
	}
	
	public void changeImage(String path, int width, int height, int maxCountX, int maxCountY, boolean isRepeat) {
		
		this.magnification = 1;
		this.maxCountX = maxCountX;
		this.maxCountY = maxCountY;
		this.setWidth(width);
		this.setHeight(height);
		this.isRepeat = isRepeat;
		
		BufferedImage bigImg = null;
		try {
			bigImg = ImageIO.read(new File(path));		

		} catch(IOException e) {
			e.printStackTrace();
		}		
		
		frameImg = new BufferedImage[maxCountX * maxCountY];
		for (int i = 0; i < maxCountY; i++) {
			for (int j = 0; j < maxCountX; j++) {
				frameImg[i * maxCountX + j] = bigImg.getSubimage(j * width, i * height, width, height);
			}
		}
	}

	
	public void setPosition(double x, double y) {

		double distX = x - this.x;
		double distY = y - this.y;
		
		t.translate(distX, distY);	
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setIsOn(boolean isOn) {
		this.isOn = isOn;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public boolean isPlaing() {
		boolean isPlay = false;
		
		if(isRepeat == true) {
			return isPlay;	
		}
		
		if(frameX == maxCountX && frameY < maxCountY) {
			isPlay = true;
		}
		
		return isPlay;
	}
	
	public boolean isFrameUpdate() {
		if(isOn == false) {
			speed = 0;
			frameX = 0;
			frameY = 0;
			return false;
		}
		
		speed+=3;
		
		if(speed >= maxSpeed) {
			speed = 0;
			frameX++;
			
			if(frameX == maxCountX && frameY < maxCountY)
			{
				frameX = 0;
				frameY++;
			}
		}
		
		if(isRepeat) {						
			if(frameY == maxCountY) {
				frameX = 0;
				frameY = 0;
			}			
		}
		
		if(frameY == maxCountY) {
			return false;
		}
		return true;
	}
	
	public void render(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		if(frameImg != null) {
			g2D.drawImage(frameImg[frameY * maxCountX + frameX], t, null);
		} else {
			g2D.drawImage(img, t, null);
		}
		
	}
	
	public BufferedImage getImage() {
		return img;
	}
	
	public BufferedImage[] getFrameImage() {
		return frameImg;
	}
	
	public int getFrameX() {
		return frameX;
	}
	
	public int getFrameY() {
		return frameY;
	}
	
	public void setFrame(int frameX, int frameY) {
		this.frameX = frameX;
		this.frameY = frameY;
	}
	
	public void setMagnification(double magnification) {
		this.magnification = magnification;
		t.translate(x, y);
		t.scale(magnification, magnification);
	}
	
	public boolean isRepeat() {
		return isRepeat;
	}

	public void setRepeat(boolean isRepeat) {
		this.isRepeat = isRepeat;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
