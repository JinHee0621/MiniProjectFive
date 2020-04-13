package com.kh.mini.model.gameObject;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class TitleScene extends BaseScene {

	ImageClass bg;

	ImageClass loginButton;
	
	PointerInfo pointerInfo;
	
	GameWindow gw;
	
	public TitleScene(GameWindow gw) {
		this.gw = gw;
	}
	
	@Override
	public void init() {
		//�̹����� �ʱ�ȭ �ϰ� ��ġ�� ���Ѵ�.
		bg = new ImageClass();
		bg.Init("images\\titleImages\\mainpage2.png");
		bg.setIsOn(true);
		bg.setPosition(0, 0);
		
		loginButton = new ImageClass();
		loginButton.Init("images\\titleImages\\login.png");
		loginButton.setIsOn(true);
		loginButton.setPosition(198, 465);
	}

	
	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		pointerInfo	= MouseInfo.getPointerInfo();
		//���콺 Ŭ����ǥ�� ��´�.
		
		if(KeyManager.Instance().onceMouseClicked(MouseEvent.BUTTON1)) {
			if((pointerInfo.getLocation().x >= 200 && pointerInfo.getLocation().x <= 560 ) && (pointerInfo.getLocation().y >= 470 &&pointerInfo.getLocation().y <= 600 )) {
				gw.startLogin();
				//�α��� �̹������� ���콺�� Ŭ���ϸ� GameWindow Ŭ������ startLogin�� �����Ѵ�.
			}
		}
	}

	@Override
	public void render(Graphics g) {
		//�̹��� ���
		bg.render(g);
		loginButton.render(g);
	}
	
}
