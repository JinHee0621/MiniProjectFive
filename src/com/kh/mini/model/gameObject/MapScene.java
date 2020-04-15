package com.kh.mini.model.gameObject;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class MapScene extends BaseScene {

	GameWindow gw;
	
	ImageClass backGround;
	PointerInfo pointerInfo;
	
	double bgX;
	double bgY;
	
	Player p;

	public MapScene(GameWindow gw) {
		this.gw = gw;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
	
		backGround = new ImageClass();
		backGround.Init("images\\mapImages\\Map1.png");
		
		backGround.setPosition(64, 200);
		
		backGround.setIsOn(true);

		bgX = backGround.getX();
		bgY = backGround.getY();


	}

	
	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		pointerInfo = MouseInfo.getPointerInfo();
		if (KeyManager.Instance().onceMouseClicked(MouseEvent.BUTTON1)) {
			System.out.println("ÁÂÇ¥: " + pointerInfo.getLocation());
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		backGround.render(g);
	}

}
