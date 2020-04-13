package com.kh.mini.model.gameObject;

import java.awt.Graphics;

import com.kh.mini.model.vo.GameObject;
import com.kh.mini.model.vo.ImageClass;

public class GameItem  extends GameObject {

	private Player player;
	
	private ImageClass img;
	
	private String imgPath;
	
	public GameItem(String imgPath) {
		this.imgPath = imgPath;
	}
	
	@Override
	public void init() {
		img = new ImageClass();
		
		img.Init(imgPath);
		
		img.setMagnification(1.0);
		
		x = 200;
		y = 200;
		
		img.setPosition(x, y);
		this.makeCenterRect(x, y, 70, 70);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
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
