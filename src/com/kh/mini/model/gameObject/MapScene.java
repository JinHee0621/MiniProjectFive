package com.kh.mini.model.gameObject;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.model.vo.GameObject;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class MapScene extends BaseScene {

	GameWindow gw;
	
	Stuff something;
	
	ImageClass backGround; //�� �̹����� �޴� �̹��� ����

	double bgX; // �� ������ �Ű� X
	double bgY;
	
	Player p;

	Monster[] mobs = new Monster[4];
	
	
	public MapScene(GameWindow gw, Player p) {
		this.p = p;
		this.gw = gw;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
	
		backGround = new ImageClass();
		backGround.Init("images\\mapImages\\Map1.png"); //��η� �޾Ƽ� �� �̹����� �ٲٰ� ����
		//changeImeage
		backGround.setPosition(64, 200);
		
		backGround.setIsOn(true);

		bgX = backGround.getX();
		bgY = backGround.getY();
		
		//(int)(Math.random() * 1000);

		mobs[0] = new Monster(p, "images\\monsterImages\\Monster_Type_Blue.png", 64, 64, 10, 1, 0.05, 1, 75);
		mobs[0].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
		mobs[0].init();

		mobs[1] = new Monster(p, "images\\monsterImages\\Monster_Type_Blue.png", 64, 64, 10, 1, 0.05, 1, 75);
		mobs[1].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
		mobs[1].init();

		mobs[2] = new Monster(p, "images\\monsterImages\\Monster_Type_Green.png", 128, 128, 17, 2, 0.03, 3, 120);
		mobs[2].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
		mobs[2].init();

		mobs[3] = new Monster(p, "images\\monsterImages\\Monster_Type_Purple.png", 100, 100, 15, 3, 0.04, 2, 90);
		mobs[3].setPosition((int) (Math.random() * 1024) + 192, (int) (Math.random() * 640) + 328);
		mobs[3].init();

		for (int i = 0; i < mobs.length; i++) {
			mobs[i].addObjs(mobs);
			// �ڱ��ڽ��� �����ϰ� ����� ������Ʈ�� ã�ƾ� �Ұ�
		}

		p.addObjs(mobs);
		p.init();

		//�ʿ��ٰ� �繰 ��ġ�Ѱ�
		something = new Stuff("images\\stuffImages\\DeskFront.png",140,85, p);
		something.init();
		something.setPosition(340, 260);
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
	
	public void monsterSpone() {

		mobs[0] = new Monster(p,"images\\monsterImages\\Monster_Type_Blue.png",64,64,10,1,0.05,1,75);
		mobs[0].setPosition((int)(Math.random() * 1024) + 192, (int)(Math.random() * 640) + 328);
		mobs[0].init();
		
		mobs[1] =  new Monster(p,"images\\monsterImages\\Monster_Type_Blue.png",64,64,10,1,0.05,1,75);
		mobs[1].setPosition((int)(Math.random() * 1024) + 192, (int)(Math.random() * 640) + 328);
		mobs[1].init();
		
		mobs[2] =  new Monster(p,"images\\monsterImages\\Monster_Type_Green.png",128,128,17,2,0.03,3,120);
		mobs[2].setPosition((int)(Math.random() * 1024) + 192, (int)(Math.random() * 640) + 328);
		mobs[2].init();
		
		mobs[3] =  new Monster(p,"images\\monsterImages\\Monster_Type_Purple.png",100,100,15,3,0.04,2,90);
		mobs[3].setPosition((int)(Math.random() * 1024) + 192, (int)(Math.random() * 640) + 328);
		mobs[3].init();
		
		for(int i = 0; i < mobs.length; i++) {
			mobs[i].addObjs(mobs);
			//�ڱ��ڽ��� �����ϰ� ����� ������Ʈ�� ã�ƾ� �Ұ�
		}
		
		p.addObjs(mobs);
	}

}
