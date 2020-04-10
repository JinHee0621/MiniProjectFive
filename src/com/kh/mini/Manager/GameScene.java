package com.kh.mini.Manager;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.kh.mini.Model.vo.GameObject.CameraClass;
import com.kh.mini.Model.vo.GameObject.Monster;
import com.kh.mini.Model.vo.GameObject.Player;
import com.kh.mini.mapTool.MapTool;

public class GameScene extends BaseScene {
	
	ImageClass img;
	ImageClass img2;
	
	CameraClass cam;
	
	ImageClass bg;
	ImageClass bg2;
	
	ImageClass bg3;
	
	double bgX;
	double bgY;
	
	Player p;
	Monster[] mobs = new Monster[3];
	
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
		//p = new Player();
		p = new Player();

		p.setCam(cam);

		
		mobs[0] = new Monster(p);
		mobs[0].setPosition(800, 800);
		mobs[0].setCam(cam);
		mobs[0].init();
		
		mobs[1] = new Monster(p);
		mobs[1].setPosition(900, 100);
		mobs[1].setCam(cam);
		mobs[1].init();
		
		mobs[2] = new Monster(p);
		mobs[2].setPosition(1000, 0);
		mobs[2].setCam(cam);
		mobs[2].init();
		
		for(int i = 0; i < mobs.length; i++) {
			mobs[i].addObjs(mobs);
		}
		
		
		p.addObjs(mobs);
		p.init();
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		p.release();
		for (int i = 0; i < mobs.length; i++) {
			mobs[i].release();
		}
	}

	@Override
	public void update() {
		p.update();
		for (int i = 0; i < mobs.length; i++) {
			mobs[i].update();
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		p.render(g);
		for (int i = 0; i < mobs.length; i++) {
			mobs[i].render(g);
		}
	}
	
	
	public void setCamera(int x, int y, int w, int h) {
		cam.makeCenterRect(x, y, w, h);
	}

	public void setBgPosition(int x, int y) {
		bg.setPosition(x, y);
		bg2.setPosition(x, y);
	}

}
