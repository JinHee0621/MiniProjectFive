package com.kh.mini.model.gameObject.maps;

import java.awt.Graphics;

import com.kh.mini.model.gameObject.BaseScene;
import com.kh.mini.model.gameObject.GameScene;
import com.kh.mini.model.gameObject.Monster;
import com.kh.mini.model.gameObject.Player;
import com.kh.mini.model.gameObject.Stuff;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class StartDesk2F extends BaseScene {

	GameWindow gw;
	
	GameScene gs;
	
	Stuff something;
	
	ImageClass backGround;

	double bgX;
	double bgY;
	
	Player p;
	public Monster[] mobs = new Monster[4];
	
	
	public StartDesk2F(GameWindow gw,GameScene gs ,Player p) {
		this.p = p;
		this.gs = gs;
		this.gw = gw;
	}
	
	@Override
	public void init() {
	
		backGround = new ImageClass();
		backGround.Init("images\\mapImages\\2FStartDesk.png");
		backGround.setPosition(64, 200);
		
		backGround.setIsOn(true);

		bgX = backGround.getX();
		bgY = backGround.getY();
		//최초지점은 설정.
		//문을 넘어간 경우 다음맵에서 setPosition은 ?
		//상단문pass 664, 698
		//하단문pass 664, 252
		//좌단문pass 1139, 500
		//우단문pass 194,500
		p.setFightToMobs(false);
	}
	
	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		//something.update();		
		p.update();
		if (!p.isFightToMobs()) {
			if (p.getX() >= 640 && p.getX()  + 75 <= 768 && p.getY() < 252) {
				p.setPosition(664, 698);
				gs.changeMap(3);
				p.setPlayerMapPos(3);
			}
			if (p.getX()  < 194 && p.getY() + 140 <= 711 && p.getY() + 140 >= 584) {
				p.setPosition(1139, 500);
				gs.changeMap(1);
				p.setPlayerMapPos(1);
			}
			// 우단
			if (p.getX()  + 90 > 1213 && p.getY() + 140 <= 711 && p.getY() + 140 >= 584) {
				p.setPosition(194, 500);
				gs.changeMap(2);
				p.setPlayerMapPos(2);
			}
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		backGround.render(g);
		//something.render(g);
		
		p.render(g);
		
		if(p.isCheckDoAttack()) {
			p.getAttack().render(g);
		}		
	}
//	public void monsterSpone() {
//
//	}
}
