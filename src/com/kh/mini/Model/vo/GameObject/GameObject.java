package com.kh.mini.Model.vo.GameObject;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import com.kh.mini.Manager.KeyManager;

public abstract class GameObject {

	protected double left;
	protected double top;
	protected double right;
	protected double bottom;
	
	protected double x;
	protected double y;
	
	protected double radius;
	protected static final KeyManager key = KeyManager.Instance();
	
	public abstract void init();
	public abstract void update();
	public abstract void release();
	public abstract void render(Graphics g);
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setRect(double left, double top, double right, double bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;		
	}
	
	public void makeCenterRect(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		
		int halfWidth = width / 2;
		int halfHeight = height / 2;
		
		radius = Math.abs((halfWidth * halfWidth) + (halfHeight * halfHeight));
		
		setRect(x - halfWidth, y - halfHeight, x + halfWidth, y + halfHeight);
	}
	
	public void makeCirCle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		
		setRect((int)(x - radius), (int)(y - radius), (int)(x + radius), (int)(y + radius));
	}
	//---------------------------------
	public boolean isCollisionRectToRect(GameObject other) {
		
		if(left > other.right || right < other.left) {
			return false;
		}
		
		if(top > other.bottom || bottom < other.top) {
			return false;
		}
		return true;
	}
	// -------------------------------------
	public boolean isCollisionCirToRect(GameObject other) {		
		if(isCollisionCirToCir(other)) {
			if(isCollisionRectToRect(other)) {
				return true;
			}
		}		
		return false;
	}
	//----------------------------------------------------
	public boolean isCollisionCirToCir(GameObject other) {
		if(getDistacne(other) < radius + other.radius) {
			return true;
		}		
		return false;
	}
	
	public double getDistacne(GameObject other) {		
		double x = this.x - other.getX();
		double y = this.y - other.getY();
		
		double dist = Math.sqrt((x * x) + (y * y));
		
		return dist;
	}
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;

	}
}
