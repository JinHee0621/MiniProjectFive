package com.kh.mini.model.gameObject;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.Finish;
import com.kh.mini.view.GameWindow;
import com.kh.mini.view.Join;

public class TitleScene extends BaseScene {

	ImageClass bg;

	ImageClass loginButton;
	
	ImageClass joinButton;
	
	ImageClass finishButton;
	
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
		
		joinButton = new ImageClass();
		joinButton.Init("images\\titleImages\\join.png");
		joinButton.setIsOn(true);
		joinButton.setPosition(198, 615);
		
		finishButton = new ImageClass();
		finishButton.Init("images\\titleImages\\finish.png");
		finishButton.setIsOn(true);
		finishButton.setPosition(198, 765);
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
			System.out.println(pointerInfo.getLocation());
			if((pointerInfo.getLocation().x >= 450 && pointerInfo.getLocation().x <= 820 ) && (pointerInfo.getLocation().y >= 500 &&pointerInfo.getLocation().y <= 670 )) {
				gw.startLogin();
				//�α��� �̹������� ���콺�� Ŭ���ϸ� GameWindow Ŭ������ startLogin�� �����Ѵ�.
			}
			
			if((pointerInfo.getLocation().x >= 450 && pointerInfo.getLocation().x <= 820 ) && (pointerInfo.getLocation().y >= 680 &&pointerInfo.getLocation().y <= 810 )) {
				//���⼭�� ȸ�������� ������ ��
				new Join(gw);
			}
			
			if((pointerInfo.getLocation().x >= 450 && pointerInfo.getLocation().x <= 820 ) && (pointerInfo.getLocation().y >= 820 &&pointerInfo.getLocation().y <= 950 )) {
				//���⼭�� ������ �����
				new Finish(gw);
			}
		}
	}

	@Override
	public void render(Graphics g) {
		//�̹��� ���
		bg.render(g);
		loginButton.render(g);
		joinButton.render(g);
		finishButton.render(g);
	}
	
}