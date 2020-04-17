package com.kh.mini.model.gameObject;

import com.kh.mini.model.vo.GameObject;

public class BossMonster extends Monster implements Runnable{
	
	Monster SponeMonster;
	private Thread mobPattern; 
	
	public BossMonster(Player target, String path, int imgSizeX, int imgSizeY, int frameCount, int patternType,
			double mobSpeed, int monsterType, int monsterRect, int monsterBoundX, int monsterBoundY) {
		super(target, path, imgSizeX, imgSizeY, frameCount, patternType, mobSpeed, monsterType, monsterRect, monsterBoundX,monsterBoundY);
		super.isBoss = true;
		this.monsterHp = 20;
		// TODO Auto-generated constructor stub
	}
	@Override
	
	public void update() {
		if (monsterHp > 0 && !isShopMaster) {
			this.makeCenterRect(x, y, monsterRect, monsterRect);
			super.getImage().isFrameUpdate();

			for (int i = 0; i <GameScene.monsterLength; i++) {
				if (super.getObjs()[i] != null && (this.getDistacne(super.getObjs()[i]) != 0 && distanceMin > this.getDistacne(super.getObjs()[i]))) {
					distanceMin = this.getDistacne(super.getObjs()[i]);
					nearest = i;
				}
			}

			distanceMin = 5000;
			
			if (!checkPattern) {
				mobPattern = new Thread(this);
				mobPattern.start();
				checkPattern = true;
			}
			
			
			if (x + super.getImage().getWidth() > 1216) {
				x = 1216 - super.getImage().getWidth();
			}
			if (x < 192) {
				x = 192;
			}
			if (y < 328) {
				y = 328;
			}
			if (y + super.getImage().getHeight() > 840) {
				y = 840 - super.getImage().getHeight();
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

			if (super.getObjs()[nearest] != null && this.isCollisionRectToRect(super.getObjs()[nearest]) == false) {
			} else {
				if (super.getObjs()[nearest] instanceof Monster) {
					if (this.getX() < super.getObjs()[nearest].getX()) {
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
						sound.sfxSelect("MonsterHit_"+super.getMonsterType());

						getDamage = true;
						monsterHp -= attack.getAttackPower();
						target.getUiScene().update();
						System.out.println("데미지를 입음" + this.monsterHp);
						mobPattern = new Thread(this);
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
				target.setWhatTypeKillYou(super.getMonsterType());
			}
		}
		else {
			mobSpeed = 0;
			this.makeCenterRect(x, y, 0, 0);
		}
	}
	
	
	@Override
	public void run() {
		try {
			System.out.println("보스몬스터 패턴");
			if (getDamage) {
				mobSpeed = 0;
				Thread.sleep(500);
				getDamage = false;
		
				mobSpeed = firstSpeed;
				checkPattern = false;
			} else if(checkPattern && monsterHp > 0 && !getDamage){
				Thread.sleep(500);
				int doPattern = (int) (Math.random() * 100) + 1;
				int patternType = (int) (Math.random() * 7) + 1;
				
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
						mobSpeed = 5;
						Thread.sleep(100);
						mobSpeed = 0;
						Thread.sleep(4000);
						break;
					case 4:
						for (int i = 0; i < 4; i++) {
							this.setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
							Thread.sleep(100);
						}
						Thread.sleep(10000);
						break;
					case 5:
						mobSpeed = 0.25;
						Thread.sleep(2500);
						monsterHp += 1;
						break;		
					case 6:
						mobSpeed = 5;
						Thread.sleep(300);
						mobSpeed = 4;
						Thread.sleep(200);
						mobSpeed = 2;
						Thread.sleep(200);
						mobSpeed = 1;
						Thread.sleep(1500);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
