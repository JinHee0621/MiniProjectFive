package com.kh.mini.model.gameObject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.kh.mini.model.vo.CameraClass;
import com.kh.mini.model.vo.GameObject;
import com.kh.mini.model.vo.ImageClass;

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
	
	private Attack attack;

	private UiScene uiScene; //캐릭터의 체력이나 마스크 표시를 위한 UiScene
	
	private String user;
	
	private double playerMovSpeed = 1;
	private int playerClean = 10;
	private int playerMask = 5;
	private int coinCount = 0;
	private int score = 0;
	
	private boolean attackBullet = false;

	@Override
	public void init() {
		img = new ImageClass();
		
		img.Init("images\\charImages\\MainCharSideR.png", 90, 150, 11, 1, true);
		
		img.setMagnification(1.0);
		
		x = 200;
		y = 200;
		
		img.setPosition(x, y);
		img.setIsOn(true);
		img.setMaxSpeed(500);
		
		this.makeCenterRect(x, y, 70, 70);
		
		System.out.println("사용자: " + user);
	}
	
	public void addUI(UiScene uiScene) {
		this.uiScene = uiScene;
		uiScene.update();
	}
	
	public void addObjs(GameObject[] mobs) {
		this.objs = mobs;
	}
	//무기 타입을 바꾸는 코드
	public void eatGunTypeWeapon() {
		attackBullet = true;
	}
	public void eatSprayTypeWeapon() {
		attackBullet = false;
	}
	//--------------------------------
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
		cam.update();
		img.isFrameUpdate();
		
		if(objs[nearlist] != null && this.isCollisionRectToRect(objs[nearlist]) == false) {
		} else {
			if ((objs[nearlist] != null && !checkGetAttack) && objs[nearlist] instanceof Monster) {
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
		//캐릭터 문이동 제한---------------------------
		if (x >= 640 && x + 75 <= 768 && y < 252) {

			this.setPosition(664, 698);
		}
		// 하단
		if (x >= 640 && x + 75 <= 768 && y + 140 > 838) {

			this.setPosition(664, 252);
		}
		// 좌단
		if (x < 194 && y + 140 <= 711 && y + 140 >= 584) {

			this.setPosition(1139, 500);
		}
		// 우단
		if (x + 75 > 1214 && y + 140 <= 711 && y + 140 >= 584) {

			this.setPosition(194, 500);
		}
		//캐릭터 벽이동 제한---------------------------
		if (x + img.getWidth() > 1216) {
			x = 1216 - img.getWidth();
		}
		if (x < 192) {
			x = 192;
		}
		if (y < 250) {
			y = 250;
		}
		if (y + img.getHeight() > 840) {
			y = 840 - img.getHeight();
		}

	
		//---------------------------------------
		
		if (playerClean > 0) {
			if (key.onceKeyDown(KeyEvent.VK_Z) && !checkDoAttack) {
				
				sound.sfxSelect("Attack_Effect");
				
				checkDoAttack = true;
				attack = new Attack(this, attackBullet);
				attack.targetMobs(objs);
				new Thread(this).start();
				
			}
			if (key.stayKeyDown(KeyEvent.VK_LEFT)) {
				img.setIsOn(true);
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
				img.setIsOn(true);
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
				img.setIsOn(true);
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
				img.setIsOn(true);
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
			
			if(!(key.stayKeyDown(KeyEvent.VK_LEFT) || key.stayKeyDown(KeyEvent.VK_RIGHT) || key.stayKeyDown(KeyEvent.VK_DOWN) || key.stayKeyDown(KeyEvent.VK_UP))) {
				if(!checkGetAttack) img.setIsOn(false);
			}
		}
	}
	
	
	@Override
	public void release() {
	}

	@Override
	public void render(Graphics g) {
		img.setPosition(x - cam.getX(), y - cam.getY());
		img.render(g);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub	
		if (checkGetAttack) {
				sound.sfxSelect("PlayerHit");
				if(playerClean > 0 && playerMask <= 0) playerClean -= 0;
				else if(playerMask > 0) playerMask -= 1;
				uiScene.update();
			try {
				if(playerFront) img.changeImage("images\\charImages\\MainCharFront_Flash.png", 75, 140, 11, 1, true);
				if(playerRight) img.changeImage("images\\charImages\\MainCharSideR_Flash.png", 90, 150, 11, 1, true);
				if(playerLeft) img.changeImage("images\\charImages\\MainCharSideL_Flash.png", 90, 150, 11, 1, true);
				if(playerUp) img.changeImage("images\\charImages\\MainCharUp_Flash.png", 75, 140, 11, 1, true);
				img.setIsOn(true);
				Thread.sleep(1500);
				if(playerFront) img.changeImage("images\\charImages\\MainCharFront.png", 75, 140, 11, 1, true);
				if(playerRight) img.changeImage("images\\charImages\\MainCharSideR.png", 90, 150, 11, 1, true);
				if(playerLeft) img.changeImage("images\\charImages\\MainCharSideL.png", 90, 150, 11, 1, true);
				if(playerUp) img.changeImage("images\\charImages\\MainCharUp.png", 75, 140, 11, 1, true);
				checkGetAttack = false;
			} catch (InterruptedException e) {
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

	public ImageClass getImage() {
		return img;
	}
	
	public void setCam(CameraClass cam) {
		this.cam = cam;
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

	public int getPlayerClean() {
		return playerClean;
	}

	public void setPlayerClean(int playerClean) {
		this.playerClean = playerClean;
		if(this.playerClean > 10) this.playerClean = 10; 
		uiScene.update();
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
	
	
	public int getPlayerMask() {
		return playerMask;
	}

	public void setPlayerMask(int playerMask) {
		this.playerMask = playerMask;
		if(this.playerMask > 7) this.playerMask = 7;
		uiScene.update();
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getCoinCount() {
		return coinCount;
	}

	public void setCoinCount(int coinCount) {
		this.coinCount = coinCount;
		uiScene.update();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
