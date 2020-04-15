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
	
	ImageClass backGround; //�� �̹����� �޴� �̹��� ����

	double bgX; // �� ������ �Ű� X
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
		backGround.Init("images\\mapImages\\Map1.png"); //��η� �޾Ƽ� �� �̹����� �ٲٰ� ����
		//changeImeage
		backGround.setPosition(64, 200);
		
		backGround.setIsOn(true);

		bgX = backGround.getX();
		bgY = backGround.getY();
		
		//�ʿ��ٰ� �繰 ��ġ�Ѱ�
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
