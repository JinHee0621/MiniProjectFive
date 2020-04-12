package com.kh.mini.Model.vo.GameObject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.kh.mini.Model.vo.Manager.GameScene;
import com.kh.mini.Model.vo.Manager.ImageClass;

public class Player extends GameObject  implements Runnable{

	private ImageClass img;
	CameraClass cam;
	
	private boolean checkGetAttack = false;
	boolean checkDoAttack = false;
	private GameObject[] objs;

	private boolean playerFront = true;
	private boolean playerRight = false;
	private boolean playerLeft = false;
	private boolean playerUp = false;
	
	private double distanceMin = 5000;
	
	private double playerMovSpeed = 0.5;
	
	private Attack attack;

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
		
		this.makeCenterRect(x, y, 70, 70);
	}
	
	public void addObjs(GameObject[] mobs) {
		this.objs = mobs;
	}
	@Override
	public void update() {
		this.makeCenterRect(x, y, 70, 70);
		img.setMaxSpeed(50);
		
		int nearlist = 0;
		for(int i = 0; i < GameScene.monsterLength; i++) {
			if(objs[i] != null  && distanceMin > this.getDistacne(objs[i])) {
				distanceMin = this.getDistacne(objs[i]);
				nearlist = i;
			}
		}
		
		distanceMin = 5000;
		playerMov();
		img.isFrameUpdate();
		if(objs[nearlist] != null && this.isCollisionRectToRect(objs[nearlist]) == false) {
		} else {
			if (objs[nearlist] != null && !checkGetAttack) {
				checkGetAttack = true;
				new Thread(this).start();
				if (objs[nearlist] != null && (objs[nearlist].getX() < this.getX())) {
					this.setPosition(x + 8, y + 8);
				} else {
					this.setPosition(x - 8, y - 8);
				}
			}
		}
	}

	public void playerMov() {
		
		if (key.onceKeyDown(KeyEvent.VK_Z) && !checkDoAttack) {
			checkDoAttack = true;
			attack = new Attack(this);
			attack.targetMobs(objs);
			new Thread(this).start();
		}

		if (key.stayKeyDown(KeyEvent.VK_LEFT)) {
			x -= playerMovSpeed;

			if (checkGetAttack)
				img.changeImage("images\\charImages\\MainCharSideL_Flash.png", 90, 150, 11, 1, true);
			else
				img.changeImage("images\\charImages\\MainCharSideL.png", 90, 150, 11, 1, true);
			playerFront = false;
			playerRight = false;
			playerLeft = true;
			playerUp = false;
		}
		if (key.stayKeyDown(KeyEvent.VK_RIGHT)) {
			x += playerMovSpeed;

			if (checkGetAttack)
				img.changeImage("images\\charImages\\MainCharSideR_Flash.png", 90, 150, 11, 1, true);
			else
				img.changeImage("images\\charImages\\MainCharSideR.png", 90, 150, 11, 1, true);

			playerFront = false;
			playerRight = true;
			playerLeft = false;
			playerUp = false;
		}
		if (key.stayKeyDown(KeyEvent.VK_DOWN)) {
			y += playerMovSpeed;

			if (checkGetAttack)
				img.changeImage("images\\charImages\\MainCharFront_Flash.png", 75, 140, 11, 1, true);
			else
				img.changeImage("images\\charImages\\MainCharFront.png", 75, 140, 11, 1, true);

			playerFront = true;
			playerRight = false;
			playerLeft = false;
			playerUp = false;

		}
		if (key.stayKeyDown(KeyEvent.VK_UP)) {
			y -= playerMovSpeed;

			if (checkGetAttack)
				img.changeImage("images\\charImages\\MainCharUp_Flash.png", 75, 140, 11, 1, true);
			else
				img.changeImage("images\\charImages\\MainCharUp.png", 75, 140, 11, 1, true);
			playerFront = false;
			playerRight = false;
			playerLeft = false;
			playerUp = true;
		}
	}
	
	
	public boolean isPlayerUp() {
		return playerUp;
	}

	public void setPlayerUp(boolean playerUp) {
		this.playerUp = playerUp;
	}

	public boolean isPlayerFront() {
		return playerFront;
	}

	public void setPlayerFront(boolean playerFront) {
		this.playerFront = playerFront;
	}

	public boolean isPlayerRight() {
		return playerRight;
	}

	public void setPlayerRight(boolean playerRight) {
		this.playerRight = playerRight;
	}

	public boolean isPlayerLeft() {
		return playerLeft;
	}

	public void setPlayerLeft(boolean playerLeft) {
		this.playerLeft = playerLeft;
	}

	public double getPlayerMovSpeed() {
		return playerMovSpeed;
	}

	public void setPlayerMovSpeed(double playerMovSpeed) {
		this.playerMovSpeed = playerMovSpeed;
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
		
		if(checkDoAttack) {
			try {
				attack.setPosition(getX(), getY());
				attack.setCam(cam);
				Thread.sleep(1000);
				checkDoAttack = false;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Attack getAttack() {
		return attack;
	}

	public void setAttack(Attack attack) {
		this.attack = attack;
	}
	
	
	public boolean isCheckDoAttack() {
		return checkDoAttack;
	}

	public void setCheckDoAttack(boolean checkDoAttack) {
		this.checkDoAttack = checkDoAttack;
	}
}
