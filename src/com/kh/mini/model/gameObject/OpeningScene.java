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

public class OpeningScene extends BaseScene {
	ImageClass bg;
	PointerInfo pointerInfo;
	GameWindow gw;
	String user;

	int cnt = 0;

	public OpeningScene(GameWindow gw) {
		this.gw = gw;
	}

	@Override
	public void init() {
		// �̹����� �ʱ�ȭ �ϰ� ��ġ�� ���Ѵ�.

		// ��� �̹��� Ŭ���� ���� �Ҵ�
		bg = new ImageClass();
		bg.Init("images\\titleImages\\start1.png");
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
				bg.changeImage("images\\titleImages\\start2.png");
				break;
			case 2:
				bg.changeImage("images\\titleImages\\start3.png");
				break;
			case 3:
				bg.changeImage("images\\titleImages\\start4.png");
				break;
			case 4:
				bg.changeImage("images\\titleImages\\start5.png");
				break;
			case 5:
				gw.dispose();
				gw = new GameWindow(1,user);
				break;
			default:
				cnt--;
			}
		}
//		for (int i = 0; i < 5; i++) {
//			if ((KeyManager.Instance().onceMouseClicked(MouseEvent.BUTTON1))
//					&& ((pointerInfo.getLocation().x >= 217 && pointerInfo.getLocation().x <= 1625)
//							&& (pointerInfo.getLocation().y >= 32 && pointerInfo.getLocation().y <= 922))) {
//				cnt += 1;
//
//				switch (cnt) {
//				case 1:
//					bg.changeImage("images\\titleImages\\start2.png");
//					break;
//				case 2:
//					bg.changeImage("images\\titleImages\\start3.png");
//					break;
//				case 3:
//					bg.changeImage("images\\titleImages\\start4.png");
//					break;
//				case 4:
//					bg.changeImage("images\\titleImages\\start5.png");
//					break;
//				case 5:
//					gw.dispose();
//					gw = new GameWindow(1,user);
//					break;
//				default:
//					cnt--;
//				}
//
//			}

	}

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