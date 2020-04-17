package com.kh.mini.model.gameObject.maps;

import java.awt.Graphics;

import com.kh.mini.model.gameObject.BaseScene;
import com.kh.mini.model.gameObject.GameScene;
import com.kh.mini.model.gameObject.Monster;
import com.kh.mini.model.gameObject.Player;
import com.kh.mini.model.gameObject.Stuff;
import com.kh.mini.model.gameObject.UiScene;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class BossRightDown4F extends BaseScene {
	GameWindow gw;
	GameScene gs;
	
	ImageClass backGround;
	
	double bgX;
	double bgY;
	
	Player p;
	public Monster[] mobs = new Monster[6];
	
	private boolean firstIn = true;
	
	private boolean popItem = false;
	
	
	public BossRightDown4F(GameWindow gw,GameScene gs, Player p) {
		this.p = p;
		this.gs = gs;
		this.gw = gw;
	}
	
	@Override
	public void init() {
		GameScene.monsterLength = mobs.length;
		backGround = new ImageClass();
		backGround.Init("images\\mapImages\\4FBossRightDown.png");
		backGround.setPosition(64, 200);
		
		backGround.setIsOn(true);

		bgX = backGround.getX();
		bgY = backGround.getY();

		if (p.firstIn4fRightDown) {
			
			mobs[0] = new Monster(p, "images\\monsterImages\\Monster_Type_Blue.png", 64, 64, 10, 1, 0.05, 1, 75);
			mobs[0].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[0].init();
			
			mobs[1] = new Monster(p, "images\\monsterImages\\Monster_Type_Blue.png", 64, 64, 10, 1, 0.05, 1, 75);
			mobs[1].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[1].init();
			
			mobs[2] = new Monster(p, "images\\monsterImages\\Monster_Type_Blue.png", 64, 64, 10, 1, 0.05, 1, 75);
			mobs[2].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[2].init();
			
			mobs[3] = new Monster(p, "images\\monsterImages\\Monster_Type_Blue.png", 64, 64, 10, 1, 0.05, 1, 75);
			mobs[3].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[3].init();
			
			mobs[4] = new Monster(p, "images\\monsterImages\\Monster_Type_Blue.png", 64, 64, 10, 1, 0.05, 1, 75);
			mobs[4].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[4].init();
			
			mobs[5] = new Monster(p, "images\\monsterImages\\Monster_Type_Black.png", 128, 128, 15, 4, 0.05, 4, 120);
			mobs[5].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[5].init();
			
			p.setFightToMobs(true);
			p.addObjs(mobs);
		}
	}
	
	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		if(p.isFightToMobs()) {
			for(int i = 0; i < mobs.length; i++) {
				if(mobs[i] != null) {
					mobs[i].addObjs(mobs);
					mobs[i].update();
					if(p.isCheckDoAttack()) {
						mobs[i].checkAttack(p.getAttack());
					}
					if(mobs[i].getMonsterHp() <= 0) {
						
						System.out.println(i + "번 몬스터가 주금");
						p.setScore(p.getScore() + mobs[i].getGivScore());
						
						mobs[i] = null;
						gs.uiScene.update();
						GameScene.monsterLength--;
					}
				}
			}
		}
		
		if(!p.isFightToMobs()) {
			//11우측상단라인
			if (p.getX() >= 320 && p.getX()  + 75 <= 1216 && p.getY() < 252) {
					p.setPosition(p.getX(), 698);
					gs.changeMap(13);
					p.setPlayerMapPos(13);
					UiScene.miniMap.changeImage("images\\miniMapImages\\13.4FRightUp.png");
			}
			//11좌단라인
			if (p.getX() < 194 && p.getY() + 140 <= 838 && p.getY() >= 456) {
					p.setPosition(1110, p.getY());
					gs.changeMap(10);
					p.setPlayerMapPos(10);
					UiScene.miniMap.changeImage("images\\miniMapImages\\10.4FLeftDown.png");
			}
		}
		if(GameScene.monsterLength == 0) {
			p.setFightToMobs(false);
			gs.popItem = false;
			gs.popItem();
			p.firstIn4fRightDown = false;
			GameScene.monsterLength = mobs.length;
		}
		p.update();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		backGround.render(g);

		p.render(g);

		for (int i = 0; i < mobs.length; i++) {
			if(mobs[i] != null) mobs[i].render(g);
		}

		if(p.isCheckDoAttack()) {
			p.getAttack().render(g);
		}	
	}
}