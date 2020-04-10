package com.kh.mini.Model.vo.GameObject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.kh.mini.Manager.ImageClass;
import com.kh.mini.Manager.KeyManager;

public class Monster extends GameObject implements Runnable{
	private ImageClass img;
	CameraClass cam;
	
	Player target;
	
	private double distanceMin = 5000;
	
	private GameObject[] objs;
	
	private Thread mobPattern; 
	
	boolean checkPattern = false;
	
	private double mobSpeed = 0.05;
	
	public Monster(Player target) {
		this.target = target;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		img = new ImageClass();
		
		img.Init("images\\monsterImages\\Sprite-Mon5.png");
		
		img.setMagnification(1.0);
		x = this.getX();
		y = this.getY();
		img.setPosition(x, y);
		
		img.setIsOn(true);
		img.setMaxSpeed(100);
		
	
		
		this.makeCenterRect(x, y,80,80);
	}
	public void addObjs(GameObject[] mobs) {
		this.objs = mobs;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.makeCenterRect(x, y, 80, 80);
		//double movSpeed = this.getDistacne(target) / 15000;
		img.isFrameUpdate();
		if(!checkPattern) {
			mobPattern = new Thread(this);
			mobPattern.start();
			checkPattern = true;
		}
/*		int nearlist = 0;

		for(int i = 0; i < objs.length; i++) {
			if(distanceMin > this.getDistacne(objs[i])) {
				distanceMin = this.getDistacne(objs[i]);
				nearlist = i;
			}
		}
		
		distanceMin = 5000;*/
		
		if (this.isCollisionRectToRect(target) == false) {
			if (this.getX() > target.getX()) {
				if (this.getY() > target.getY()) {
					this.setPosition(this.getX() - mobSpeed, this.getY() - mobSpeed);
				} else {
					this.setPosition(this.getX() - mobSpeed, this.getY() + mobSpeed);
				}
			} else {
				if (this.getY() > target.getY()) {
					this.setPosition(this.getX() + mobSpeed, this.getY() - mobSpeed);
				} else {
					this.setPosition(this.getX() + mobSpeed, this.getY() + mobSpeed);
				}
			}
		} else {
			if (this.getX() < target.getX()) {
				this.setPosition(x - 2, y - 2);
			} else {
				this.setPosition(x + 2, y + 2);
			}
		}
		
		
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

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			int patternType = (int) (Math.random() * 3) + 1;
			switch(patternType) {
			case 1:
				mobSpeed = 3;
				break;
			default:
				break;
				
			}
			Thread.sleep(100);
			mobSpeed = 0.05;
			checkPattern = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
