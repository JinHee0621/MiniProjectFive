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

public class BossLeftUp4F extends BaseScene {
	GameWindow gw;
	GameScene gs;
	
	ImageClass backGround;
	
	double bgX;
	double bgY;
	
	Player p;
	public Monster[] mobs = new Monster[3];
	
	private boolean firstIn = true;
	
	private boolean popItem = false;
	
	
	public BossLeftUp4F(GameWindow gw,GameScene gs, Player p) {
		this.p = p;
		this.gs = gs;
		this.gw = gw;
	}
	
	@Override
	public void init() {
		GameScene.monsterLength = mobs.length;
		backGround = new ImageClass();
		backGround.Init("images\\mapImages\\4FBossLeftUp.png");
		backGround.setPosition(64, 200);
		
		backGround.setIsOn(true);

		bgX = backGround.getX();
		bgY = backGround.getY();
		
		
		//boolean변수 필요
		if (p.firstIn4fLeftUp) {
			mobs[0] = new Monster(p, "images\\monsterImages\\Monster_Person.png", 100, 150, 11, 6, 0.03, 6, 90);
			mobs[0].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[0].init();
			
			mobs[1] = new Monster(p, "images\\monsterImages\\Monster_Person.png", 100, 150, 11, 6, 0.03, 6, 90);
			mobs[1].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[1].init();
			
			mobs[2] = new Monster(p, "images\\monsterImages\\Monster_Person.png", 100, 150, 11, 6, 0.03, 6, 90);
			mobs[2].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[2].init();
			
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
			//12좌측하단라인
			if (p.getX() >= 192 && p.getX() + 75 <= 1088 && p.getY() + 140 > 838) {
					p.setPosition(p.getX(), 252);
					gs.changeMap(10);
					p.setPlayerMapPos(10);
					UiScene.miniMap.changeImage("images\\miniMapImages\\10.4FLeftDown.png");
			}
			//12우단라인				
			if (p.getX() + 75 > 1204 && p.getY() + 140 <= 712 && p.getY() >= 200) {
					p.setPosition(220, p.getY());
					gs.changeMap(13);
					p.setPlayerMapPos(13);
					UiScene.miniMap.changeImage("images\\miniMapImages\\13.4FRightUp.png");
			}
		}
		if(GameScene.monsterLength == 0) {
			p.setFightToMobs(false);
			gs.popItem = false;
			gs.popItem();
			p.firstIn4fLeftUp = false;
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