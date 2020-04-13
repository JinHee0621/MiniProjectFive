package com.kh.mini.model.gameObject;

import java.awt.Graphics;

import com.kh.mini.model.vo.CameraClass;
import com.kh.mini.model.vo.ImageClass;

public class GameScene extends BaseScene {

	UiScene uiScene;
	
	ImageClass img;
	ImageClass img2;
	
	CameraClass cam;
	
	ImageClass bg;
	ImageClass bg2;
	
	ImageClass bg3;
	
	double bgX;
	double bgY;
	
	Player p;

	public static int monsterLength = 4;
	
	Monster[] mobs = new Monster[4];
	
	private GameItem item;
	
	private boolean popItem = false;
	

	@Override
	public void init() {
		// TODO Auto-generated method stub
		cam = new CameraClass();
		cam.init();
		
	
		bg = new ImageClass();
		bg.Init("images\\mapImages\\MapSample.png");
		
		bg2 = new ImageClass();
		bg2.Init("images\\monsterImages\\Sprite-Mon5.png");
		
		bg.setIsOn(true);
		
		bg2.setIsOn(true);
		
		bgX = bg.getX();
		bgY = bg.getY();
		
		p = new Player();

		p.setCam(cam);

		//(int)(Math.random() * 1000);
		
		mobs[0] = new Monster(p,"images\\monsterImages\\Monster_Type_Blue.png",64,64,10,1,0.05);
		mobs[0].setPosition((int)(Math.random() * 1000), (int)(Math.random() * 1000));
		mobs[0].setCam(cam);
		mobs[0].init();
		
		mobs[1] =  new Monster(p,"images\\monsterImages\\Monster_Type_Blue.png",64,64,10,1,0.05);
		mobs[1].setPosition((int)(Math.random() * 1000), (int)(Math.random() * 1000));
		mobs[1].setCam(cam);
		mobs[1].init();
		
		mobs[2] =  new Monster(p,"images\\monsterImages\\Monster_Type_Green.png",128,128,17,2,0.03);
		mobs[2].setPosition((int)(Math.random() * 1000), (int)(Math.random() * 1000));
		mobs[2].setCam(cam);
		mobs[2].init();
		
		mobs[3] =  new Monster(p,"images\\monsterImages\\Monster_Type_Purple.png",100,100,15,3,0.04);
		mobs[3].setPosition((int)(Math.random() * 1000), (int)(Math.random() * 1000));
		mobs[3].setCam(cam);
		mobs[3].init();
		
		for(int i = 0; i < mobs.length; i++) {
			mobs[i].addObjs(mobs);
			//자기자신을 제외하고 가까운 오브젝트를 찾아야 할것
		}

		p.addObjs(mobs);
		p.init();
		
		uiScene = new UiScene(p);
		uiScene.init();
		
		p.addUI(uiScene);
	}

	
	@Override
	public void release() {
		// TODO Auto-generated method stub
		p.release();
		for (int i = 0; i < monsterLength; i++) {
			mobs[i].release();
		}
		if (p.isCheckDoAttack()) {
			p.getAttack().release();
		}
	}

	@Override
	public void update() {
		p.update();
		for (int i = 0; i < mobs.length; i++) {
			if (mobs[i] != null) {
				mobs[i].update();
				if (p.isCheckDoAttack()) {
					mobs[i].checkAttack(p.getAttack());
				}
				if (mobs[i].getMonsterHp() <= 0) {
					mobs[i] = null;
					System.out.println(i + "번 몬스터가 주금");
					monsterLength--;
				} 
				
				if(monsterLength == 0) {
					popItem();
				}
			}
		}
		if (p.isCheckDoAttack()) {
			p.getAttack().update();
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		p.render(g);
		
		if(p.isCheckDoAttack()) {
			p.getAttack().render(g);
		}

		for (int i = 0; i < mobs.length; i++) {
			if(mobs[i] != null) mobs[i].render(g);
		}
		
		uiScene.render(g);
		
		if(popItem) {
			item.render(g);
			item.update();
		} 
	}
	
	
	public void setCamera(int x, int y, int w, int h) {
		cam.makeCenterRect(x, y, w, h);
	}

	public void setBgPosition(int x, int y) {
		bg.setPosition(x, y);
		bg2.setPosition(x, y);
	}

	public void popItem() {
		if (!popItem) {
			item = new GameItem("images\\ItemImage\\HandCleaner.png",this,p);
			item.init();
			popItem = true;
		}
	}
	
	public void eatItem() {
		popItem = false;
		item = null;
		monsterLength = 4;
		
		mobs[0] = new Monster(p,"images\\monsterImages\\Monster_Type_Blue.png",64,64,10,1,0.05);
		mobs[0].setPosition((int)(Math.random() * 1000), (int)(Math.random() * 1000));
		mobs[0].setCam(cam);
		mobs[0].init();
		
		mobs[1] =  new Monster(p,"images\\monsterImages\\Monster_Type_Blue.png",64,64,10,1,0.05);
		mobs[1].setPosition((int)(Math.random() * 1000), (int)(Math.random() * 1000));
		mobs[1].setCam(cam);
		mobs[1].init();
		
		mobs[2] =  new Monster(p,"images\\monsterImages\\Monster_Type_Green.png",128,128,17,2,0.03);
		mobs[2].setPosition((int)(Math.random() * 1000), (int)(Math.random() * 1000));
		mobs[2].setCam(cam);
		mobs[2].init();
		
		mobs[3] =  new Monster(p,"images\\monsterImages\\Monster_Type_Purple.png",100,100,15,3,0.04);
		mobs[3].setPosition((int)(Math.random() * 1000), (int)(Math.random() * 1000));
		mobs[3].setCam(cam);
		mobs[3].init();
		
		for(int i = 0; i < mobs.length; i++) {
			mobs[i].addObjs(mobs);
			//자기자신을 제외하고 가까운 오브젝트를 찾아야 할것
		}
		
		p.addObjs(mobs);
	}
}
