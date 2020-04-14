package com.kh.mini.model.gameObject;

import java.awt.Graphics;

import com.kh.mini.model.vo.GameObject;
import com.kh.mini.model.vo.ImageClass;

public class GameItem  extends GameObject {

	private Player player;
	
	private ImageClass img;
	
	private String imgPath;
	private int imgX;
	private int imgY;
	private int imgFrame;
	
	
	private GameScene gameScene;
	
	public GameItem(String imgPath, GameScene gameScene, Player player, int imgX, int imgY, int imgFrame) {
		this.imgPath = imgPath;
		this.gameScene = gameScene;
		this.player = player;
		this.imgX = imgX;
		this.imgY = imgY;
		this.imgFrame = imgFrame;
	}
	
	@Override
	public void init() {
		img = new ImageClass();
		//img.Init("images\\charImages\\MainCharSideR.png", 90, 150, 11, 1, true);
		img.Init(imgPath,imgX,imgY,imgFrame,1,true);
		
		img.setMagnification(1.0);
		img.setIsOn(true);
		img.setMaxSpeed(100);
		x = 800;
		y = 500;
		
		img.setPosition(x, y);
		this.makeCenterRect(x, y, 70, 70);
	}

	@Override
	public void update() {
		this.makeCenterRect(x, y, 70, 70);
		img.isFrameUpdate();
		
		if (player != null && this.isCollisionRectToRect(player) == false) {
		} else {
			gameScene.eatItem();
			player.setPlayerClean(10);
		}
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		img.setPosition(this.getX(), this.getY());
		img.render(g);
	}

}
