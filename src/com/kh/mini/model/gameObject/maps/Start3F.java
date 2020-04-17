package com.kh.mini.model.gameObject.maps;

import java.awt.Graphics;

import com.kh.mini.model.gameObject.BaseScene;
import com.kh.mini.model.gameObject.GameItem;
import com.kh.mini.model.gameObject.GameScene;
import com.kh.mini.model.gameObject.Monster;
import com.kh.mini.model.gameObject.Player;
import com.kh.mini.model.gameObject.Stuff;
import com.kh.mini.model.gameObject.UiScene;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class Start3F extends BaseScene {
	GameWindow gw;
	GameScene gs;
	
	ImageClass backGround;
	Stuff something;
	
	double bgX;
	double bgY;
	
	Player p;

	public Monster[] mobs = new Monster[1];
	
	boolean purchaseItem = false;
	
	private boolean firstIn = true;
	
	private boolean popItem = false;

	public GameItem item;
	
	public GameItem item2;
	
	//private GameItem item;
	
	public Start3F(GameWindow gw, GameScene gs,Player p) {
		this.p = p;
		this.gs = gs;
		this.gw = gw;
	}
	
	@Override
	public void init() {
		GameScene.monsterLength = mobs.length;
		backGround = new ImageClass();
		backGround.Init("images\\mapImages\\3FStart.png");
		backGround.setPosition(64, 200);
		
		backGround.setIsOn(true);

		bgX = backGround.getX();
		bgY = backGround.getY();

		something = new Stuff("images\\stuffImages\\DeskFront2.png",210,45,100,0, p);
		something.init();
		something.setPosition(950, 310);
		
		mobs[0] = new Monster(p, "images\\monsterImages\\Monster_shopMaster.png");
		mobs[0].setPosition(950, 240);
		mobs[0].init();
		
		item = new GameItem(p, 4, true, 5, 950, 550);
		item.init();
		
		item2 = new GameItem(p, 6, true, 5, 1050, 550);
		item2.init();
		
		p.setFightToMobs(false);
		
	}
	
	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		
		p.update();
		
		something.update();	
		item.update();
		item2.update();
		
		if (!p.isFightToMobs()) {
			//상단문
			if (p.getX() >= 640 && p.getX()  + 75 <= 768 && p.getY() < 252) {
					p.setPosition(664, 698);
					gs.changeMap(7);
					p.setPlayerMapPos(7);
					UiScene.miniMap.changeImage("images\\miniMapImages\\7.3FDesktoUp.png");
			}
			//하단문
			if (p.getX() >= 640 && p.getX() + 75 <= 768 && p.getY() + 140 > 838) {
					p.setPosition(664, 252);
					gs.changeMap(4);
					p.setPlayerMapPos(4);
					UiScene.miniMap.changeImage("images\\miniMapImages\\4.2FDesktoUp2.png");
			}
			//좌단문
			if (p.getX() < 194 && p.getY() + 140 <= 711 && p.getY() + 140 >= 584) {
					p.setPosition(1110, 500);
					gs.changeMap(6);
					p.setPlayerMapPos(6);
					UiScene.miniMap.changeImage("images\\miniMapImages\\6.3FDesktoLeft.png");
			}
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		backGround.render(g);
		//------
		for (int i = 0; i < mobs.length; i++) {
			if(mobs[i] != null) mobs[i].render(g);
		}
		
		something.render(g);
		//------
		p.render(g);
		
		item.render(g);
		item2.render(g);
		
		if(p.isCheckDoAttack()) {
			p.getAttack().render(g);
		}		
	}
}