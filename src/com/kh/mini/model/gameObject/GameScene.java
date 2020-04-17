package com.kh.mini.model.gameObject;

import java.awt.Graphics;

import com.kh.mini.controller.SoundManager;
import com.kh.mini.model.dao.JoinDao;
import com.kh.mini.model.gameObject.maps.MapScene;
import com.kh.mini.model.vo.CameraClass;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;
import com.kh.mini.model.gameObject.maps.*;

public class GameScene extends BaseScene {

	private JoinDao jd = new JoinDao();

	GameWindow gw;

	public UiScene uiScene;

	MapScene mapScene;

	StartDesk2F map2f_1;
	DesktoLeft2F map2f_2;
	DesktoRight2F map2f_3;
	DesktoUp12F map2f_4;
	DesktoUp22F map2f_5;
	Start3F map3f_1;
	StarttoLeft3F map3f_2;
	StarttoUp3F map3f_3;
	Intersection3F map3f_4;
	IntersectiontoUp3F map3f_5;
	BossLeftDown4F map4f_1;
	BossRightDown4F map4f_2;
	BossLeftUp4F map4f_3;
	BossRightUp4F map4f_4;

	ImageClass img;
	ImageClass img2;

	CameraClass cam;

	double bgX;
	double bgY;

	Player p;

	public static int monsterLength = 4;

	Monster[] mobs = new Monster[4];

	private boolean startStage2F = false;

	private boolean startStage3F = false;

	private boolean startStage4F = false;

	private String user;

	public boolean popItem = false;

	public GameItem item;

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
		p.init();
		uiScene = new UiScene(p);
		uiScene.init();

		changeMap(p.getPlayerMapPos());

		p.addUI(uiScene);
	}

	public void changeMap(int mapNumber) {
		switch (mapNumber) {
		case 0:
			map2f_1 = new StartDesk2F(gw, this, p);
			map2f_1.init();
			if (!startStage2F) {
				sound.bgmSelect("stage2_normal");
				startStage2F = true;
			}
			break;
		case 1:
			map2f_2 = new DesktoLeft2F(gw, this, p);
			map2f_2.init();
			break;
		case 2:
			map2f_3 = new DesktoRight2F(gw, this, p);
			map2f_3.init();
			break;
		case 3:
			map2f_4 = new DesktoUp12F(gw, this, p);
			map2f_4.init();
			break;
		case 4:
			map2f_5 = new DesktoUp22F(gw, this, p);
			map2f_5.init();
			break;
		case 5:
			map3f_1 = new Start3F(gw, this, p);
			map3f_1.init();
			break;
		case 6:
			map3f_2 = new StarttoLeft3F(gw, this, p);
			map3f_2.init();
			break;
		case 7:
			map3f_3 = new StarttoUp3F(gw, this, p);
			map3f_3.init();
			break;
		case 8:
			map3f_4 = new Intersection3F(gw, this, p);
			map3f_4.init();
			break;
		case 9:
			map3f_5 = new IntersectiontoUp3F(gw, this, p);
			map3f_5.init();
			break;
		case 10:
			map4f_1 = new BossLeftDown4F(gw, this, p);
			map4f_1.init();
			break;
		case 11:
			map4f_2 = new BossRightDown4F(gw, this, p);
			map4f_2.init();
			break;
		case 12:
			map4f_3 = new BossLeftUp4F(gw, this, p);
			map4f_3.init();
			break;
		case 13:
			map4f_4 = new BossRightUp4F(gw, this, p);
			map4f_4.init();
			break;

		}
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		// p.update();

		switch (p.getPlayerMapPos()) {
		case 0:
			map2f_1.update();
			break;
		case 1:
			map2f_2.update();
			break;
		case 2:
			map2f_3.update();
			break;
		case 3:
			map2f_4.update();
			break;
		case 4:
			map2f_5.update();
			break;
		case 5:
			map3f_1.update();
			break;
		case 6:
			map3f_2.update();
			break;
		case 7:
			map3f_3.update();
			break;
		case 8:
			map3f_4.update();
			break;
		case 9:
			map3f_5.update();
			break;
		case 10:
			map4f_1.update();
			break;
		case 11:
			map4f_2.update();
			break;
		case 12:
			map4f_3.update();
			break;
		case 13:
			map4f_4.update();
			break;

		}

		if (p.isCheckDoAttack()) {
			p.getAttack().update();
		}

		if (p.getPlayerClean() <= 0) {
			sound.bgmStop();
			sound.sfxSelect("gameOver");
			jd.scoreSave(p.getUser(), p.getScore());
			int mobType = p.getWhatTypeKillYou();
			p = null;
			gw.setVisible(false);
			gw.dispose();
			gw.showGameOver(mobType);
		}
		
		if (p.getPlayerMapPos() == 14) {
			sound.bgmStop();
			jd.scoreSave(p.getUser(), p.getScore());
			gw.setVisible(false);
			gw.dispose();
			gw.startEnding(p.getUser());
		}

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		switch (p.getPlayerMapPos()) {
		case 0:
			map2f_1.render(g);
			break;
		case 1:
			map2f_2.render(g);
			break;
		case 2:
			map2f_3.render(g);
			break;
		case 3:
			map2f_4.render(g);
			break;
		case 4:
			map2f_5.render(g);
			break;
		case 5:
			map3f_1.render(g);
			break;
		case 6:
			map3f_2.render(g);
			break;
		case 7:
			map3f_3.render(g);
			break;
		case 8:
			map3f_4.render(g);
			break;
		case 9:
			map3f_5.render(g);
			break;
		case 10:
			map4f_1.render(g);
			break;
		case 11:
			map4f_2.render(g);
			break;
		case 12:
			map4f_3.render(g);
			break;
		case 13:
			map4f_4.render(g);
			break;
		}
		
		//mapScene.render(g);
		uiScene.render(g);
		
		if(popItem) {
			item.render(g);
			item.update();
		} 
		
	}
	
	public void popItem() {
		if (!popItem) {
			int ItemType = (int) (Math.random() * 3);
			item = new GameItem(p, ItemType, this);
			item.init();
			popItem = true;
		}
	}
	
	public void popBossItem() {
		if (!popItem) {
			int ItemType = (int) (Math.random() * 7);
			item = new GameItem(p, ItemType, this);
			item.init();
			popItem = true;
		}
	}
	public void eatItem() {
		item = null;
	}
	
	public void setCamera(int x, int y, int w, int h) {
		cam.makeCenterRect(x, y, w, h);
	}

	public void setBgPosition(int x, int y) {
	}

	

	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}

}
