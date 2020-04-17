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

public class BossRightUp4F extends BaseScene {
	GameWindow gw;
	GameScene gs;
	
	ImageClass backGround;

	Stuff something;
	
	double bgX;
	double bgY;
	
	Player p;
	public Monster[] mobs = new Monster[2];
	
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
			mobs[0] = new Monster(p, "", 0, 0, 0, 0, 0, 0, 0);
			mobs[0].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 768) + 200);
			mobs[0].init();
			
			mobs[1] = new Monster(p, "", 0, 0, 0, 0, 0, 0, 0);
			mobs[1].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 768) + 200);
			mobs[1].init();
			
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
			//13우측하단라인
			if (p.getX() >= 320 && p.getX() + 75 <= 1216 && p.getY() + 140 > 966) {
					p.setPosition(p.getX(), 252);
					gs.changeMap(11);
					p.setPlayerMapPos(11);
					UiScene.miniMap.changeImage("images\\miniMapImages\\11.4FRightDown.png");
			}
			//13좌단라인
			if (p.getX() < 66 && p.getY() + 140 <= 712 && p.getY() >= 456) {
					p.setPosition(1110, p.getY());
					gs.changeMap(12);
					p.setPlayerMapPos(12);
					UiScene.miniMap.changeImage("images\\miniMapImages\\12.4FLeftUp.png");
			}
			//13우측상단문
			if (p.getX() >= 640 && p.getX() + 75 <= 768 && p.getY() + 140 > 838) {
					//엔딩신으로
			}
		}
		if(GameScene.monsterLength == 0) {
			p.setFightToMobs(false);
			gs.popItem = false;
			gs.popItem();
			p.firstIn2fLeft = false;
			GameScene.monsterLength = mobs.length;
		}
		something.update();	
		p.update();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		backGround.render(g);

		p.render(g);
		something.render(g);

		for (int i = 0; i < mobs.length; i++) {
			if(mobs[i] != null) mobs[i].render(g);
		}

		if(p.isCheckDoAttack()) {
			p.getAttack().render(g);
		}	
	}
}