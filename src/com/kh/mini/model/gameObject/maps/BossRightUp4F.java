package com.kh.mini.model.gameObject.maps;

import java.awt.Graphics;

import com.kh.mini.model.gameObject.BaseScene;
import com.kh.mini.model.gameObject.BossMonster;
import com.kh.mini.model.gameObject.GameScene;
import com.kh.mini.model.gameObject.Monster;
import com.kh.mini.model.gameObject.Player;
import com.kh.mini.model.gameObject.Stuff;
import com.kh.mini.model.gameObject.UiScene;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class BossRightUp4F extends BaseScene {
	GameWindow gw;
	GameScene gs;
	
	ImageClass backGround;

	double bgX;
	double bgY;
	
	Player p;
	public Monster[] mobs = new Monster[1];
	
	private boolean firstIn = true;
	
	private boolean popItem = false;
	
	
	public BossRightUp4F(GameWindow gw,GameScene gs, Player p) {
		this.p = p;
		this.gs = gs;
		this.gw = gw;
	}
	
	@Override
	public void init() {
		GameScene.monsterLength = mobs.length;
		backGround = new ImageClass();
		backGround.Init("images\\mapImages\\4FBossRightUp.png");
		backGround.setPosition(64, 200);
		
		backGround.setIsOn(true);

		bgX = backGround.getX();
		bgY = backGround.getY();
		
		//boolean변수 필요
		if (p.firstIn4fRightUp) {
			//여기서 보스몬스터
			mobs[0] = new BossMonster(p, "images\\monsterImages\\Monster_Type_Boss.png", 280, 224, 10, 7, 0.03, 7, 200, -80, -30);
			mobs[0].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[0].init();
			p.setFightToMobs(true);
			p.addObjs(mobs);
			p.getUiScene().bossMonsterCheck(mobs[0]);
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
						gs.uiScene.resetMeetBoss();
						GameScene.monsterLength--;
					}
				}
			}
		}
		
		if(!p.isFightToMobs()) {
			//13우측하단라인
			if (p.getX() >= 320 && p.getX() + 75 <= 1216 && p.getY() + 140 > 838) {
					p.setPosition(p.getX(), 252);
					gs.changeMap(11);
					p.setPlayerMapPos(11);
					UiScene.miniMap.changeImage("images\\miniMapImages\\11.4FRightDown.png");
			}
			//13좌단라인
			if (p.getX() < 194 && p.getY() + 140 <= 712 && p.getY() >= 456) {
					p.setPosition(1110, p.getY());
					gs.changeMap(12);
					p.setPlayerMapPos(12);
					UiScene.miniMap.changeImage("images\\miniMapImages\\12.4FLeftUp.png");
			}
			//13우측상단문
			if (p.getX() + 75 > 1200 && p.getY() + 140 <= 711 && p.getY() + 140 >= 584) {
				sound.bgmStop();
				p.setPlayerMapPos(14);	
				//엔딩신으로
			}
		}
		if(GameScene.monsterLength == 0) {
			p.setFightToMobs(false);
			gs.popItem = false;
			gs.popBossItem();
			p.firstIn4fRightUp = false;
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