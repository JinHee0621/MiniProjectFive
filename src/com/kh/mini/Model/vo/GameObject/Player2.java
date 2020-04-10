package com.kh.mini.Model.vo.GameObject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.kh.mini.Manager.ImageClass;
import com.kh.mini.Manager.KeyManager;

public class Player2 extends GameObject {

	private ImageClass img;
	CameraClass cam;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		img = new ImageClass();
		
		img.Init("images\\charImages\\Sprite-Mainup2.png", 70, 150, 11, 1, true);
		
		img.setMagnification(1.0);
		x = 0;
		y = 0;
		img.setPosition(x, y);
		
		img.setIsOn(true);
		img.setMaxSpeed(1000);
		
		this.makeCenterRect(x, y, 70, 150);
	/*	System.out.println("L : " + left);
		System.out.println("R : " + right);
		System.out.println("T : " + top);
		System.out.println("B : " + bottom);*/
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		img.isFrameUpdate();
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		img.setPosition(x - cam.getX(), y - cam.getY());
		img.render(g);
	}

	public ImageClass getImage() {
		return img;
	}
	
	public void setCam(CameraClass cam) {
		this.cam = cam;
	}
}
