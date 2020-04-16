package com.kh.mini.model.gameObject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.model.vo.CameraClass;
import com.kh.mini.model.vo.GameObject;
import com.kh.mini.model.vo.ImageClass;

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
	
	//---몬스터파라미터-------------------
	
	private int monsterType = 0;

	private int monsterHp = 3;
	
	private int givScore = 0;
	
	private int monsterRect = 0;
	
	private boolean isShopMaster = false;
	
	public Monster(Player target, String path, int imgSizeX, int imgSizeY, int frameCount, int patternType , double mobSpeed, int monsterType, int monsterRect) {
		isShopMaster = false;
		this.target = target;
		this.imgPath = path;
		this.imgSizeX = imgSizeX;
		this.imgSizeY = imgSizeY;
		this.frameCount = frameCount;
		this.patternType = patternType;
		this.mobSpeed = mobSpeed;
		firstSpeed = mobSpeed;
		this.monsterType = monsterType;
		this.monsterRect = monsterRect;
		
		monsterHp *= monsterType;
		if(monsterType == 6) {
			monsterHp /= 2;
		}
		
		setGivScore(25 * monsterType);
	}

	public Monster(Player target, String path) {
		this.target = target;
		this.imgPath = path;
		this.imgSizeX = 100;
		this.imgSizeY = 150;
		mobSpeed = 0;
		monsterType = 99;
		isShopMaster = true;
		monsterHp = 5000;
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		img = new ImageClass();
		
		if(isShopMaster) {
			img.Init(imgPath);
		} else {
			img.Init(imgPath, imgSizeX, imgSizeY, frameCount, 1, true);
		}
		
		img.setMagnification(1.0);
		x = this.getX();
		y = this.getY();
		
		//img.setPosition(x, y);
		
		img.setIsOn(true);
		if(monsterType == 6) img.setMaxSpeed(50);
		else img.setMaxSpeed(100);
		
		//this.makeCenterRect(x, y,150,150);
	}
	public void addObjs(GameObject[] mobs) {
		this.objs = mobs;
	}
	
	public void checkAttack(Attack attack) {
		this.attack = attack;
	}
	
	@Override
	public void update() {

		if (monsterHp > 0 && !isShopMaster) {
			this.makeCenterRect(x, y, monsterRect, monsterRect);
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
			
			
			
			if (x + img.getWidth() > 1216) {
				x = 1216 - img.getWidth();
			}
			if (x < 192) {
				x = 192;
			}
			if (y < 328) {
				y = 328;
			}
			if (y + img.getHeight() > 840) {
				y = 840 - img.getHeight();
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
						sound.sfxSelect("MonsterHit_"+monsterType);

						getDamage = true;
						mobPattern = new Thread(this);
						monsterHp -= attack.getAttackPower();
						mobPattern.start();
					}
					if (this.getX() < attack.getX()) {
						this.setPosition(x - (Math.random() * 50), y - (Math.random() * 50));
					} else {
						this.setPosition(x + (Math.random() * 50), y + (Math.random() * 50));
					}
				}
			}
		}else if(monsterHp > 0 && isShopMaster) {
			this.makeCenterRect(x, y, monsterRect, monsterRect);
			
			if (this.isCollisionRectToRect(target) == false) {
			} else {
				target.setPlayerMask(0);
				target.setPlayerClean(0);
				target.getUiScene().update();
				target.setWhatTypeKillYou(this.monsterType);
			}
		}
		else {
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
			img.setPosition(x+8, y+8);
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
				Thread.sleep(500);
				getDamage = false;
		
				mobSpeed = firstSpeed;
				checkPattern = false;
				
			} else if(checkPattern && monsterHp > 0 && !getDamage){
				Thread.sleep(500);
				int doPattern = (int) (Math.random() * 100) + 1;
				if (doPattern >= 50) {
					switch (patternType) {
					case 2:
						for (int i = 0; i < 25; i++) {
							mobSpeed += 0.025;
							Thread.sleep(100);
						}
						Thread.sleep(500);
						mobSpeed = 0;
						Thread.sleep(500);
						break;
					case 3:
						mobSpeed = 6;
						Thread.sleep(100);
						mobSpeed = 0;
						break;
					case 4:
						for(int i = 0; i < 3; i++) {
							this.setPosition(x - (Math.random() * 150), y - (Math.random() * 150));
							Thread.sleep(500);
						}
						break;
					case 5:
						mobSpeed = 0.25;
						Thread.sleep(2500);
						monsterHp += 1;
						break;		
					case 6:
						mobSpeed = 5;
						Thread.sleep(200);
						mobSpeed = 4;
						Thread.sleep(200);
						mobSpeed = 2;
						Thread.sleep(200);
						mobSpeed = 1;
						Thread.sleep(200);
						mobSpeed = 0;
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

	public int getGivScore() {
		return givScore;
	}

	public void setGivScore(int givScore) {
		this.givScore = givScore;
	}
	
	public int getMonsterType() {
		return monsterType;
	}

	public void setMonsterType(int monsterType) {
		this.monsterType = monsterType;
	}
	
	public boolean isShopMaster() {
		return isShopMaster;
	}
	public void setShopMaster(boolean isShopMaster) {
		this.isShopMaster = isShopMaster;
	}

}
