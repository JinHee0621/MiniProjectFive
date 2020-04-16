package com.kh.mini.model.gameObject.maps;

import java.awt.Graphics;

import com.kh.mini.model.gameObject.BaseScene;
import com.kh.mini.model.gameObject.GameScene;
import com.kh.mini.model.gameObject.Monster;
import com.kh.mini.model.gameObject.Player;
import com.kh.mini.model.gameObject.Stuff;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class Start3F extends BaseScene {
	GameWindow gw;
	GameScene gs;
	
	ImageClass backGround;

	double bgX;
	double bgY;
	
	Player p;

	public Monster[] mobs = new Monster[2];
	
	private boolean firstIn = true;
	
	private boolean popItem = false;

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

		p.setFightToMobs(false);
		
	}
	
	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		
		p.update();
		if (!p.isFightToMobs()) {
			//상단문
			if (p.getX() >= 640 && p.getX()  + 75 <= 768 && p.getY() < 252) {
					p.setPosition(664, 698);
					gs.changeMap(7);
					p.setPlayerMapPos(7);
			}
			//하단문
			if (p.getX() >= 640 && p.getX() + 75 <= 768 && p.getY() + 140 > 838) {
					p.setPosition(664, 252);
					gs.changeMap(4);
					p.setPlayerMapPos(4);
			}
			//좌단문
			if (p.getX() < 194 && p.getY() + 140 <= 711 && p.getY() + 140 >= 584) {
					p.setPosition(1110, 500);
					gs.changeMap(6);
					p.setPlayerMapPos(6);
			}
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		backGround.render(g);
		
		p.render(g);

		if(p.isCheckDoAttack()) {
			p.getAttack().render(g);
		}		
	}
}