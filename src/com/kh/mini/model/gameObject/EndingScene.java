package com.kh.mini.model.gameObject;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class EndingScene extends BaseScene {

	ImageClass bg;

	PointerInfo pointerInfo;

	GameWindow gw;

	String user;

	int cnt = 0;

	public EndingScene(GameWindow gw, String user) {
		this.gw = gw;
		this.user = user;
	}

	@Override
	public void init() {
		sound.bgmSelect("ending");
		bg = new ImageClass(); // 이미지 클래스 할당
		bg.Init("images\\titleImages\\finish1.png");
		bg.setIsOn(true);
		bg.setPosition(0, 0);

	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {

		pointerInfo = MouseInfo.getPointerInfo();
		if ((KeyManager.Instance().onceMouseClicked(MouseEvent.BUTTON1))
				&& ((pointerInfo.getLocation().x >= 217 && pointerInfo.getLocation().x <= 1625)
						&& (pointerInfo.getLocation().y >= 32 && pointerInfo.getLocation().y <= 922))) {
			cnt += 1;

			switch (cnt) {
			case 1:
				bg.changeImage("images\\titleImages\\finish2.png");
				break;
			case 2:
				bg.changeImage("images\\titleImages\\finish3.png");
				break;
			case 3:
				bg.changeImage("images\\titleImages\\credit.png");
				break;
			case 4:
				gw.dispose();
				sound.bgmStop();
				gw = new GameWindow(0, null);
				break;
			default:
				cnt--;
				break;
			}
		}

	}
	// if((pointerInfo.getLocation().x >= 217 && pointerInfo.getLocation().x <= 1625
	// ) &&
	// (pointerInfo.getLocation().y >= 32 &&pointerInfo.getLocation().y <= 922 )) {
	// bg.changeImage("images\\titleImages\\finish2.png");

	@Override
	public void render(Graphics g) {
		bg.render(g);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}