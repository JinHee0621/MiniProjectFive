package com.kh.mini.model.gameObject.maps;

import java.awt.Graphics;

import com.kh.mini.model.gameObject.BaseScene;
import com.kh.mini.model.gameObject.Monster;
import com.kh.mini.model.gameObject.Player;
import com.kh.mini.model.gameObject.Stuff;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class StartDesk2F extends BaseScene {

	GameWindow gw;
	
	Stuff something;
	
	ImageClass backGround;

	double bgX;
	double bgY;
	
	Player p;

	public Monster[] mobs = new Monster[4];
	
	
	public StartDesk2F(GameWindow gw, Player p) {
		this.p = p;
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

		p.init();
		p.setPosition(664, 252);
		//���������� ����.
		//���� �Ѿ ��� �����ʿ��� setPosition�� ?
		//��ܹ�pass 664, 698
		//�ϴܹ�pass 664, 252
		//�´ܹ�pass 1139, 500
		//��ܹ�pass 194,500

	}
	
	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		something.update();		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		backGround.render(g);
		something.render(g);
		
		p.render(g);
		
		for (int i = 0; i < mobs.length; i++) {
			if(mobs[i] != null) mobs[i].render(g);
		}

		if(p.isCheckDoAttack()) {
			p.getAttack().render(g);
		}		
	}
//	public void monsterSpone() {
//
//	}
}
