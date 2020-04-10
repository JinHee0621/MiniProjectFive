package com.kh.mini.Manager;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.kh.mini.Model.vo.GameObject.CameraClass;
import com.kh.mini.Model.vo.GameObject.Player;
import com.kh.mini.Model.vo.GameObject.Player2;
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
	Player2 p2;
	
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
		p.init();
		
		p2 = new Player2();
		p2.setCam(cam);
		p2.init();
		
		p.setP2(p2);
		
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		p.release();
		p2.release();
	}

	@Override
	public void update() {
		p.update();
		p2.update();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//bg.setPosition(bgX - cam.getX(), bgY - cam.getY());
		
		//bg2.setPosition(500, 500);
		
		//bg.render(g);
		//bg2.render(g);
		
		p.render(g);
		p2.render(g);

	}
	
	
	public void setCamera(int x, int y, int w, int h) {
		cam.makeCenterRect(x, y, w, h);
	}

	public void setBgPosition(int x, int y) {
		bg.setPosition(x, y);
		bg2.setPosition(x, y);
	}

}
