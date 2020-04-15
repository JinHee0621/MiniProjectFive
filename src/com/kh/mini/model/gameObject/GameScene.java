package com.kh.mini.model.gameObject;

import java.awt.Graphics;

import com.kh.mini.controller.SoundManager;
import com.kh.mini.model.dao.JoinDao;
import com.kh.mini.model.vo.CameraClass;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class GameScene extends BaseScene {

	private JoinDao jd= new JoinDao();
	
	GameWindow gw;
	
	UiScene uiScene;
	
	MapScene mapScene;
	
	ImageClass img;
	ImageClass img2;
	
	CameraClass cam;
	
	double bgX;
	double bgY;
	
	Player p;

	public static int monsterLength = 4;
	
	Monster[] mobs = new Monster[4];
	
	private GameItem item;
	
	private boolean popItem = false;
	
	private String user;

	public GameScene(GameWindow gw) {
		this.gw = gw;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		
		cam = new CameraClass();
		cam.init();
		
		p = new Player();
		p.setUser(user);
		p.setCam(cam);

		//(int)(Math.random() * 1000);
		
		mobs[0] = new Monster(p,"images\\monsterImages\\Monster_Type_Blue.png",64,64,10,1,0.05,1);
		mobs[0].setPosition((int)(Math.random() * 1024) + 192, (int)(Math.random() * 640) + 328);
		mobs[0].setCam(cam);
		mobs[0].init();
		
		mobs[1] =  new Monster(p,"images\\monsterImages\\Monster_Type_Blue.png",64,64,10,1,0.05,1);
		mobs[1].setPosition((int)(Math.random() * 1024) + 192, (int)(Math.random() * 640) + 328);
		mobs[1].setCam(cam);
		mobs[1].init();
		
		mobs[2] =  new Monster(p,"images\\monsterImages\\Monster_Type_Green.png",128,128,17,2,0.03,3);
		mobs[2].setPosition((int)(Math.random() * 1024) + 192, (int)(Math.random() * 640) + 328);
		mobs[2].setCam(cam);
		mobs[2].init();
		
		mobs[3] =  new Monster(p,"images\\monsterImages\\Monster_Type_Purple.png",100,100,15,3,0.04,2);
		mobs[3].setPosition((int)(Math.random() * 1024) + 192, (int)(Math.random() * 640) + 328);
		mobs[3].setCam(cam);
		mobs[3].init();
		
		System.out.println("0. " + mobs[0].getX() + " , " + mobs[0].getY());
		System.out.println("1. " +mobs[1].getX() + " , " + mobs[1].getY());
		System.out.println("2. " +mobs[2].getX() + " , " + mobs[2].getY());
		System.out.println("3. " +mobs[3].getX() + " , " + mobs[3].getY());
		
		for(int i = 0; i < mobs.length; i++) {
			mobs[i].addObjs(mobs);
			//자기자신을 제외하고 가까운 오브젝트를 찾아야 할것
		}

		p.addObjs(mobs);
		p.init();
		
		uiScene = new UiScene(p);
		uiScene.init();
		
		mapScene = new MapScene(gw);
		mapScene.init();
		
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
		mapScene.update();
		p.update();
		for (int i = 0; i < mobs.length; i++) {
			if (mobs[i] != null) {
				mobs[i].update();
				if (p.isCheckDoAttack()) {
					mobs[i].checkAttack(p.getAttack());
				}
				if (mobs[i].getMonsterHp() <= 0) {
	
					System.out.println(i + "번 몬스터가 주금");
					p.setScore(p.getScore() + mobs[i].getGivScore());
					
					mobs[i] = null;
					uiScene.update();
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
		
		if(p.getPlayerClean() <= 0) {
			//sound.bgmStop();s\
			sound.sfxSelect("gameOver");
			jd.scoreSave(p.getUser(), p.getScore());
			p = null;
			gw.setVisible(false);
			gw.dispose();
			gw.showGameOver();
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		mapScene.render(g);
		
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
	}

	public void popItem() {
		if (!popItem) {
			item = new GameItem("images\\ItemImage\\HandCleaner.png",this,p,64,64,10);
			item.init();
			popItem = true;
		}
	}
	
	public void eatItem() {
		popItem = false;
		item = null;
		monsterLength = 4;
		
		mobs[0] = new Monster(p,"images\\monsterImages\\Monster_Type_Blue.png",64,64,10,1,0.05,1);
		mobs[0].setPosition((int)(Math.random() * 1024) + 192, (int)(Math.random() * 640) + 328);
		mobs[0].setCam(cam);
		mobs[0].init();
		
		mobs[1] =  new Monster(p,"images\\monsterImages\\Monster_Type_Blue.png",64,64,10,1,0.05,1);
		mobs[1].setPosition((int)(Math.random() * 1024) + 192, (int)(Math.random() * 640) + 328);
		mobs[1].setCam(cam);
		mobs[1].init();
		
		mobs[2] =  new Monster(p,"images\\monsterImages\\Monster_Type_Green.png",128,128,17,2,0.03,3);
		mobs[2].setPosition((int)(Math.random() * 1024) + 192, (int)(Math.random() * 640) + 328);
		mobs[2].setCam(cam);
		mobs[2].init();
		
		mobs[3] =  new Monster(p,"images\\monsterImages\\Monster_Type_Purple.png",100,100,15,3,0.04,2);
		mobs[3].setPosition((int)(Math.random() * 1024) + 192, (int)(Math.random() * 640) + 328);
		mobs[3].setCam(cam);
		mobs[3].init();
		
		for(int i = 0; i < mobs.length; i++) {
			mobs[i].addObjs(mobs);
			//자기자신을 제외하고 가까운 오브젝트를 찾아야 할것
		}
		
		p.addObjs(mobs);
	}
	

	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}

}
