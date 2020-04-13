package com.kh.mini.model.gameObject;

import java.awt.Graphics;

import com.kh.mini.model.vo.GameObject;
import com.kh.mini.model.vo.ImageClass;

public class GameItem  extends GameObject {

	private Player player;
	
	private ImageClass img;
	
	private String imgPath;
	
	private GameScene gameScene;
	
	public GameItem(String imgPath, GameScene gameScene, Player player) {
		this.imgPath = imgPath;
		this.gameScene = gameScene;
		this.player = player;
	}
	
	@Override
	public void init() {
		img = new ImageClass();
		
		img.Init(imgPath);
		
		img.setMagnification(1.0);
		
		x = 800;
		y = 500;
		
		img.setPosition(x, y);
		this.makeCenterRect(x, y, 70, 70);
	}

	@Override
	public void update() {
		this.makeCenterRect(x, y, 70, 70);
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
