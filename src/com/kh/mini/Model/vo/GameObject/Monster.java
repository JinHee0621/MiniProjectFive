package com.kh.mini.Model.vo.GameObject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.kh.mini.Manager.GameScene;
import com.kh.mini.Manager.ImageClass;
import com.kh.mini.Manager.KeyManager;

public class Monster extends GameObject implements Runnable{
	private ImageClass img;
	
	private String imgPath;
	
	private int imgSizeX;
	private int imgSizeY;
	private int frameCount;
	
	private int patternType = 0;
	
	CameraClass cam;
	
	Player target;
	
	Attack attack;
	
	private double distanceMin = 5000;
	
	private GameObject[] objs;
	
	private Thread mobPattern; 
	
	private boolean checkPattern = false;
	
	private boolean getDamage = false;
	
	private double mobSpeed= 0.5;
	
	private double firstSpeed = 0.05;
	
	private int nearest;
	
	//---�����Ķ����-------------------
	
	private int monsterHp = 5;
	
	
	public Monster(Player target, String path, int imgSizeX, int imgSizeY, int frameCount, int patternType , double mobSpeed) {
		this.target = target;
		this.imgPath = path;
		this.imgSizeX = imgSizeX;
		this.imgSizeY = imgSizeY;
		this.frameCount = frameCount;
		this.patternType = patternType;
		this.mobSpeed = mobSpeed;
		firstSpeed = mobSpeed;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		img = new ImageClass();
		img.Init(imgPath, imgSizeX, imgSizeY, frameCount, 1, true);
		
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
	
	public void checkAttack(Attack attack) {
		this.attack = attack;
	}
	
	@Override
	public void update() {

		if (monsterHp > 0) {
			this.makeCenterRect(x, y, 80, 80);
			img.isFrameUpdate();

			for (int i = 0; i <GameScene.monsterLength; i++) {
				if (objs[i] != null && (this.getDistacne(objs[i]) != 0 && distanceMin > this.getDistacne(objs[i]))) {
					distanceMin = this.getDistacne(objs[i]);
					nearest = i;
				}
			}

			distanceMin = 5000;
			if (!checkPattern) {
				mobPattern = new Thread(this);
				mobPattern.start();
				checkPattern = true;
			}

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

			if (objs[nearest] != null && this.isCollisionRectToRect(objs[nearest]) == false) {
			} else {
				if (objs[nearest] instanceof Monster) {
					if (this.getX() < objs[nearest].getX()) {
						this.setPosition(x - (Math.random() * 5 / 15), y - (Math.random() * 5 / 15));
					} else {
						this.setPosition(x + (Math.random() * 5 / 15), y + (Math.random() * 5 / 15));
					}
				}
			}

			if (attack != null) {
				if (this.isCollisionRectToRect(attack) == false) {
				} else {
					if (!getDamage) {
						mobPattern = new Thread(this);
						getDamage = true;
						monsterHp -= 4;
						mobPattern.start();
					}
					if (this.getX() < attack.getX()) {
						this.setPosition(x - (Math.random() * 50), y - (Math.random() * 50));
					} else {
						this.setPosition(x + (Math.random() * 50), y + (Math.random() * 50));
					}
				}
			}
		} else {
			mobSpeed = 0;
			this.makeCenterRect(x, y, 0, 0);
		}
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if (monsterHp > 0) {
			img.setPosition(this.getX(), this.getY());
			img.render(g);
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
		try {
			if (getDamage) {
				mobSpeed = 0;
				Thread.sleep(5000);
				mobSpeed = firstSpeed;
				getDamage = false;
				checkPattern = false;
			} else if(checkPattern && monsterHp > 0){
				Thread.sleep(500);
				int doPattern = (int) (Math.random() * 100) + 1;
				if (doPattern >= 50) {
					switch (patternType) {
					case 2:
						mobSpeed = 0;
						Thread.sleep(500);
						mobSpeed = 4;
						break;

					case 3:
						for (int i = 0; i < 25; i++) {
							mobSpeed += 0.025;
							Thread.sleep(100);
						}
						Thread.sleep(500);
						mobSpeed = 0;
						Thread.sleep(500);
						break;
					default:
						break;
					}

					Thread.sleep(100);
					mobSpeed = firstSpeed;
				}
				checkPattern = false;
			}
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

	public int getMonsterHp() {
		return monsterHp;
	}

	public void setMonsterHp(int monsterHp) {
		this.monsterHp = monsterHp;
	}
}
