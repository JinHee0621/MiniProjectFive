package com.kh.mini.model.gameObject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.model.vo.CameraClass;
import com.kh.mini.model.vo.GameObject;
import com.kh.mini.model.vo.ImageClass;

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
	
	private int bulletMovX;
	private int bulletMovY;
	
	private boolean endAttack;
	
	private boolean attackBullet;
	
	public Attack(Player parent, boolean attackBullet) {
		this.parent = parent;
		endAttack = false;
		rangeX = 150;
		rangeY = 150;
		this.attackBullet = attackBullet;
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
		if(attackBullet) {
			rangeX = 50;
			rangeY = 50;
			bulletMovX = 0;
			bulletMovY = 0;
			if(parent.isPlayerFront()) {
				bulletMovX = 0;
				bulletMovY = 1;
			}else if(parent.isPlayerUp()) {
				bulletMovX = 0;
				bulletMovY = -1;
			}else if(parent.isPlayerLeft()) {
				bulletMovX = -1;
				bulletMovY = 0;
			}else if(parent.isPlayerRight()) {
				bulletMovX = 1;
				bulletMovY = 0;
			}
			img.Init("images\\charImages\\bullet.png");
		}
		else {
			rangeX = 300;
			rangeY = 300;
			if(parent.isPlayerFront()) img.Init("images\\charImages\\AttackFront.png", 90, 80, 11, 1, true);
			if(parent.isPlayerUp()) img.Init("images\\charImages\\AttackUp.png", 90, 80, 11, 1, true);
			if(parent.isPlayerLeft()) img.Init("images\\charImages\\AttackSideLeft.png", 80, 90, 11, 1, true);
			if(parent.isPlayerRight()) img.Init("images\\charImages\\AttackSideRight.png", 80, 90, 11, 1, true);
		}
		img.setMaxSpeed(1500);
		img.setMagnification(1.0);
		
		x = this.getX();
		y = this.getY();
		
		img.setPosition(x, y);
		
		img.setIsOn(true);

		this.makeCenterRect(x, y,(int)rangeX,(int)rangeY);
	}
	
	@Override
	public void update() {
		if (!endAttack) {
			this.makeCenterRect(x, y, (int) rangeX, (int) rangeY);
			img.setMaxSpeed(50);
			img.isFrameUpdate();
			if(attackBullet) {
				for (int i = 0; i <GameScene.monsterLength; i++) {
					if (target[i] != null && (this.getDistacne(target[i]) != 0 && distanceMin > this.getDistacne(target[i]))) {
						distanceMin = this.getDistacne(target[i]);
						nearest = i;
					}
				}
				this.setPosition(x + bulletMovX, y + bulletMovY);
			} else {
				if (parent.isPlayerFront())
					img.changeImage("images\\charImages\\AttackFront.png", 90, 80, 11, 1, true);
				if (parent.isPlayerUp())
					img.changeImage("images\\charImages\\AttackUp.png", 90, 80, 11, 1, true);
				if (parent.isPlayerLeft())
					img.changeImage("images\\charImages\\AttackSideLeft.png", 80, 90, 11, 1, true);
				if (parent.isPlayerRight())
					img.changeImage("images\\charImages\\AttackSideRight.png", 80, 90, 11, 1, true);
			}
			
			if (target[nearest] != null && this.isCollisionRectToRect(target[nearest]) == false) {
				
			} else {
				if (target[nearest] instanceof Monster) {
					if (this.getX() < target[nearest].getX()) {
						this.setPosition(x - (Math.random() * 5 / 15), y - (Math.random() * 5 / 15));
					} else {
						this.setPosition(x + (Math.random() * 5 / 15), y + (Math.random() * 5 / 15));
					}
				}
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
		if(!endAttack) img.render(g);
		if(attackBullet) {
			img.setPosition(x, y+80);
		} else {
			if(parent.isPlayerFront()) img.setPosition(parent.getX(), parent.getY() + 125);

			if(parent.isPlayerUp()) img.setPosition(parent.getX(), parent.getY() - 75);

			if(parent.isPlayerLeft()) img.setPosition(parent.getX() - 75, parent.getY() + 55);

			if(parent.isPlayerRight()) img.setPosition(parent.getX() + 75, parent.getY() + 55);	
		}

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
			endAttack = true;
			img.setIsOn(false);
			Thread.sleep(600);
			rangeX = 0;
			rangeY = 0;
			this.makeCenterRect(x, y, 0, 0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
}
