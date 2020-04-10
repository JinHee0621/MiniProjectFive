package com.kh.mini.Model.vo.GameObject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.kh.mini.Manager.ImageClass;

public class Player extends GameObject  implements Runnable{

	private ImageClass img;
	CameraClass cam;
	
	boolean checkGetAttack = false;
	
	private GameObject[] objs;

	private boolean playerFront = true;
	private boolean playerRight = false;
	private boolean playerLeft = false;
	private boolean playerUp = false;
	
	private double distanceMin = 5000;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		img = new ImageClass();
		
		img.Init("images\\charImages\\MainCharSideR.png", 90, 150, 11, 1, true);
		
		img.setMagnification(1.0);
		
		x = 200;
		y = 200;
		
		img.setPosition(x, y);
		img.setIsOn(true);
		img.setMaxSpeed(50);
		
		System.out.println("Player Pos = " + x + ", " + y);
		
		this.makeCenterRect(x, y, 70, 70);
	}
	
	public void addObjs(GameObject[] mobs) {
/*		for(int i = 0; i < mobs.length; i++) {
			this.mobs[i] = mobs[i];
		}*/
		this.objs = mobs;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.makeCenterRect(x, y, 70, 70);
		img.isFrameUpdate();
		int nearlist = 0;
		
		for(int i = 0; i < objs.length; i++) {
			if(distanceMin > this.getDistacne(objs[i])) {
				distanceMin = this.getDistacne(objs[i]);
				nearlist = i;
			}
		}
		
		distanceMin = 5000;
		
		if(this.isCollisionRectToRect(objs[nearlist]) == false) {
			if(key.stayKeyDown(KeyEvent.VK_LEFT)) {
				x -= 0.5;
				
				if(checkGetAttack)img.changeImage("images\\charImages\\MainCharSideL_Flash.png", 90, 150, 11, 1, true);
				else img.changeImage("images\\charImages\\MainCharSideL.png", 90, 150, 11, 1, true);
				
				playerFront = false;
				playerRight = false;
				playerLeft = true;
				playerUp = false;
			}
			if(key.stayKeyDown(KeyEvent.VK_RIGHT)) {
				x += 0.5;
				if(checkGetAttack)  img.changeImage("images\\charImages\\MainCharSideR_Flash.png", 90, 150, 11, 1, true);
				else img.changeImage("images\\charImages\\MainCharSideR.png", 90, 150, 11, 1, true);
				
				playerFront = false;
				playerRight = true;
				playerLeft = false;
				playerUp = false;
			}
			if(key.stayKeyDown(KeyEvent.VK_DOWN)) {
				y += 0.5;
				if(checkGetAttack) img.changeImage("images\\charImages\\MainCharFront_Flash.png", 75, 140, 11, 1, true);
				else img.changeImage("images\\charImages\\MainCharFront.png", 75, 140, 11, 1, true);
				
				playerFront = true;
				playerRight = false;
				playerLeft = false;
				playerUp = false;
				
			}
			if(key.stayKeyDown(KeyEvent.VK_UP)) {
				y -= 0.5;
				if(checkGetAttack) img.changeImage("images\\charImages\\MainCharUp_Flash.png", 75, 140, 11, 1, true);
				else img.changeImage("images\\charImages\\MainCharUp.png", 75, 140, 11, 1, true);
				
				playerFront = false;
				playerRight = false;
				playerLeft = false;
				playerUp = true;
			}
		} else {
			if (!checkGetAttack) {
				System.out.println(nearlist);
				checkGetAttack = true;
				new Thread(this).start();
				if (objs[nearlist].getX() < this.getX()) {
					this.setPosition(x + 8, y + 8);
				} else {
					this.setPosition(x - 8, y - 8);
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
		// TODO Auto-generated method stub
		if (checkGetAttack) {
			try {
				if(playerFront) img.changeImage("images\\charImages\\MainCharFront_Flash.png", 75, 140, 11, 1, true);
				if(playerRight) img.changeImage("images\\charImages\\MainCharSideR_Flash.png", 90, 150, 11, 1, true);
				if(playerLeft) img.changeImage("images\\charImages\\MainCharSideL_Flash.png", 90, 150, 11, 1, true);
				if(playerUp) img.changeImage("images\\charImages\\MainCharUp_Flash.png", 75, 140, 11, 1, true);
				Thread.sleep(1500);
				if(playerFront) img.changeImage("images\\charImages\\MainCharFront.png", 75, 140, 11, 1, true);
				if(playerRight) img.changeImage("images\\charImages\\MainCharSideR.png", 90, 150, 11, 1, true);
				if(playerLeft) img.changeImage("images\\charImages\\MainCharSideL.png", 90, 150, 11, 1, true);
				if(playerUp) img.changeImage("images\\charImages\\MainCharUp.png", 75, 140, 11, 1, true);
				checkGetAttack = false;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
