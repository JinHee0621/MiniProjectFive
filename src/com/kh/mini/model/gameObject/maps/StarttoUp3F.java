package com.kh.mini.model.gameObject.maps;

import java.awt.Graphics;

import com.kh.mini.model.gameObject.BaseScene;
import com.kh.mini.model.gameObject.GameScene;
import com.kh.mini.model.gameObject.Monster;
import com.kh.mini.model.gameObject.Player;
import com.kh.mini.model.gameObject.UiScene;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class StarttoUp3F extends BaseScene {
	GameWindow gw;
	GameScene gs;
	
	ImageClass backGround;

	double bgX;
	double bgY;
	
	Player p;

	public Monster[] mobs = new Monster[3];
	
	private boolean firstIn = true;
	
	private boolean popItem = false;

	//private GameItem item;
	
	public StarttoUp3F(GameWindow gw, GameScene gs,Player p) {
		this.p = p;
		this.gs = gs;
		this.gw = gw;
	}
	
	@Override
	public void init() {
		GameScene.monsterLength = mobs.length;
		backGround = new ImageClass();
		backGround.Init("images\\mapImages\\3FStarttoUp.png");
		backGround.setPosition(64, 200);
		
		backGround.setIsOn(true);

		bgX = backGround.getX();
		bgY = backGround.getY();

		if (p.firstIn3fUp) {

			mobs[0] =  new Monster(p, "images\\monsterImages\\Monster_Person.png", 100, 150, 11, 6, 0.03, 6, 90);
			mobs[0].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[0].init();

			mobs[1] = new Monster(p, "images\\monsterImages\\Monster_Type_Black.png", 128, 128, 15, 4, 0.05, 4, 120);
			mobs[1].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[1].init();
			
			mobs[2] = new Monster(p, "images\\monsterImages\\Monster_Type_Black.png", 128, 128, 15, 4, 0.05, 4, 120);
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
		if (p.isFightToMobs()) {
			for (int i = 0; i < mobs.length; i++) {
				if (mobs[i] != null) {
					mobs[i].addObjs(mobs);
					mobs[i].update();
					if (p.isCheckDoAttack()) {
						mobs[i].checkAttack(p.getAttack());
					}
					if (mobs[i].getMonsterHp() <= 0) {

						System.out.println(i + "번 몬스터가 주금");
						p.setScore(p.getScore() + mobs[i].getGivScore());

						mobs[i] = null;
						gs.uiScene.update();
						GameScene.monsterLength--;
					}
				}
			}
		}
		if (!p.isFightToMobs()) {
			//하단문
			if (p.getX() >= 640 && p.getX() + 75 <= 768 && p.getY() + 140 > 838) {
					p.setPosition(664, 252);
					gs.changeMap(5);
					p.setPlayerMapPos(5);
					UiScene.miniMap.changeImage("images\\miniMapImages\\5.3FDesk.png");
			}
			//좌단문
			if (p.getX() < 194 && p.getY() + 140 <= 711 && p.getY() + 140 >= 584) {
					p.setPosition(1110, 500);
					gs.changeMap(8);
					p.setPlayerMapPos(8);
					UiScene.miniMap.changeImage("images\\miniMapImages\\8.3FIntersection.png");
			}
		}
		
		if(GameScene.monsterLength == 0) {
			p.setFightToMobs(false);
			gs.popItem = false;
			gs.popItem();
			p.firstIn3fUp = false;
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