package com.kh.mini.model.gameObject.maps;

import java.awt.Graphics;

import com.kh.mini.model.gameObject.BaseScene;
import com.kh.mini.model.gameObject.GameScene;
import com.kh.mini.model.gameObject.Monster;
import com.kh.mini.model.gameObject.Player;
import com.kh.mini.model.gameObject.Stuff;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class DesktoUp22F extends BaseScene {
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
	
	public DesktoUp22F(GameWindow gw, GameScene gs,Player p) {
		this.p = p;
		this.gs = gs;
		this.gw = gw;
	}
	
	@Override
	public void init() {
		GameScene.monsterLength = mobs.length;
		backGround = new ImageClass();
		backGround.Init("images\\mapImages\\2FUp1toUp2.png");
		backGround.setPosition(64, 200);
		
		backGround.setIsOn(true);

		bgX = backGround.getX();
		bgY = backGround.getY();

		if (p.firstIn2fUp) {

			mobs[0] = new Monster(p, "images\\monsterImages\\Monster_Type_Purple.png", 100, 100, 15, 3, 0.04, 2, 90);
			mobs[0].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[0].init();

			mobs[1] = new Monster(p, "images\\monsterImages\\Monster_Type_Purple.png", 100, 100, 15, 3, 0.04, 2, 90);
			mobs[1].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
			mobs[1].init();
			
			mobs[2] = new Monster(p, "images\\monsterImages\\Monster_Type_Green.png", 128, 128, 17, 2, 0.03, 3, 120);
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
			//문이동
//			 if (p.getX() >= 640 && p.getX() + 75 <= 768 && p.getY() < 252) {
//
//		         p.setPosition(664, 698);
//		      }
//		      // 하단
//		      if (p.getX() >= 640 && p.getX() + 75 <= 768 && p.getY() + 140 > 838) {
//
//		         p.setPosition(664, 252);
//		      }
//		      // 좌단
//		      if (p.getX() < 194 && p.getY() + 140 <= 711 && p.getY() + 140 >= 584) {
//
//		         p.setPosition(1110, 500);
//		      }
//		      // 우단
//		      if (p.getX() + 75 > 1200 && p.getY() + 140 <= 711 && p.getY() + 140 >= 584) {
//
//		         p.setPosition(220, 500);
//		      }
			
			if (p.getX() >= 640 && p.getX() + 75 <= 768 && p.getY() < 252) {
				
				p.setPosition(664, 698);
			}
			// 하단
			if (p.getX() >= 640 && p.getX() + 75 <= 768 && p.getY() + 140 > 838) {
				gs.changeMap(0);
				p.setPlayerMapPos(0);
				p.setPosition(664, 252);
			}
			
		}
		
		if(GameScene.monsterLength == 0) {
			p.setFightToMobs(false);
			gs.popItem = false;
			gs.popItem();
			p.firstIn2fUp = false;
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