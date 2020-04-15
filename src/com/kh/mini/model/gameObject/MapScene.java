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
	
	Stuff something;
	
	ImageClass backGround; //맵 이미지를 받는 이미지 변수

	double bgX; // 요 변수는 신경 X
	double bgY;
	
	Player p;

	public MapScene(GameWindow gw, Player p) {
		this.p = p;
		this.gw = gw;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
	
		backGround = new ImageClass();
		backGround.Init("images\\mapImages\\Map1.png"); //경로로 받아서 맵 이미지를 바꾸고 있음
		//changeImeage
		backGround.setPosition(64, 200);
		
		backGround.setIsOn(true);

		bgX = backGround.getX();
		bgY = backGround.getY();
		
		//맵에다가 사물 배치한것
		something = new Stuff("images\\stuffImages\\DeskFront.png",140,85, p);
		something.init();
		something.setPosition(340, 460);
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
	}

}
