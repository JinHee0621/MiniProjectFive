package com.kh.mini.Model.vo.GameObject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.kh.mini.Manager.ImageClass;
import com.kh.mini.Manager.KeyManager;

public class Attack extends GameObject  implements Runnable{
	private ImageClass img;
	
	private String imgPath;

	CameraClass cam;
	
	Player parent;
	
	private GameObject[] target;
	
	private double distanceMin = 5000;
	
	private int nearest;
	
	private double rangeX;
	private double rangeY;
	
	public Attack(Player parent) {
		this.parent = parent;
		rangeX = 180;
		rangeY = 180;
		init();
		new Thread(this).start();
	}
	
	public void targetMobs(GameObject[] mobs) {
		this.target = mobs;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		img = new ImageClass();
		if(parent.isPlayerFront()) img.Init("images\\charImages\\AttackFront.png", 90, 80, 11, 1, true);
		if(parent.isPlayerUp()) img.Init("images\\charImages\\AttackUp.png", 90, 80, 11, 1, true);
		if(parent.isPlayerLeft()) img.Init("images\\charImages\\AttackSideLeft.png", 80, 90, 11, 1, true);
		if(parent.isPlayerRight()) img.Init("images\\charImages\\AttackSideRight.png", 80, 90, 11, 1, true);
		img.setMaxSpeed(100);
		img.setMagnification(1.0);
		x = this.getX();
		y = this.getY();
		img.setPosition(x, y);
		
		img.setIsOn(true);

		
		this.makeCenterRect(x, y,(int)rangeX,(int)rangeY);
	}
	
	@Override
	public void update() {
		this.makeCenterRect(x, y, (int)rangeX, (int)rangeY);
		img.setMaxSpeed(50);
		img.isFrameUpdate();
		
		if (parent.isPlayerFront())
			img.changeImage("images\\charImages\\AttackFront.png", 90, 80, 11, 1, true);
		if (parent.isPlayerUp())
			img.changeImage("images\\charImages\\AttackUp.png", 90, 80, 11, 1, true);
		if (parent.isPlayerLeft())
			img.changeImage("images\\charImages\\AttackSideLeft.png", 80, 90, 11, 1, true);
		if (parent.isPlayerRight())
			img.changeImage("images\\charImages\\AttackSideRight.png", 80, 90, 11, 1, true);
		
//		for(int i = 0 ; i < target.length; i++) {
//			if((this.getDistacne(target[i]) != 0 && distanceMin > this.getDistacne(target[i]))) {
//				distanceMin = this.getDistacne(target[i]);
//				nearest = i;
//			}
//		}
//		
//		distanceMin = 5000;
//		
//		if (this.isCollisionRectToRect(target[nearest]) == false) {
//		} else {
//			if (this.getX() < target[nearest].getX()) {
//				this.setPosition(x - (Math.random() * 5), y -  (Math.random() * 5));
//			} else {
//				this.setPosition(x +  (Math.random() * 5), y + (Math.random() * 5));
//			}
//		}
//		if (this.isCollisionRectToRect(target) == false) {
///*			if (this.getX() > target.getX()) {
//				if (this.getY() > target.getY()) {
//					this.setPosition(this.getX() - mobSpeed, this.getY() - mobSpeed);
//				} else {
//					this.setPosition(this.getX() - mobSpeed, this.getY() + mobSpeed);
//				}
//			} else {
//				if (this.getY() > target.getY()) {
//					this.setPosition(this.getX() + mobSpeed, this.getY() - mobSpeed);
//				} else {
//					this.setPosition(this.getX() + mobSpeed, this.getY() + mobSpeed);
//				}
//			}*/
//		} else {
//			if (this.getX() < target.getX()) {
//				this.setPosition(x - 2, y - 2);
//			} else {
//				this.setPosition(x + 2, y + 2);
//			}
//		}	
		
		
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub		
		if(parent.isPlayerFront()) img.setPosition(parent.getX(), parent.getY() + 125);

		if(parent.isPlayerUp()) img.setPosition(parent.getX(), parent.getY() - 75);

		if(parent.isPlayerLeft()) img.setPosition(parent.getX() - 75, parent.getY() + 55);

		if(parent.isPlayerRight()) img.setPosition(parent.getX() + 75, parent.getY() + 55);	
		
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
		// TODO Auto-generated method stub
		try {
			Thread.sleep(500);
			rangeX = 0;
			rangeY = 0;
			this.makeCenterRect(x, y, 0, 0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
}
