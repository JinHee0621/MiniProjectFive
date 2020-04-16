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
	
	ImageClass rankingButton;
	
	PointerInfo pointerInfo;
	
	GameWindow gw;
	
	public TitleScene(GameWindow gw) {
		this.gw = gw;
	}
	
	@Override
	public void init() {
		//이미지를 초기화 하고 위치를 정한다.
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
		
		rankingButton = new ImageClass();
		rankingButton.Init("images\\titleImages\\rankingBtn.png");
		rankingButton.setIsOn(true);
		rankingButton.setPosition(1150, 765);
		
	}

	
	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		pointerInfo	= MouseInfo.getPointerInfo();
		//마우스 클릭좌표를 얻는다.
		
		if(KeyManager.Instance().onceMouseClicked(MouseEvent.BUTTON1)) {
		
			System.out.println(pointerInfo.getLocation());
			if((pointerInfo.getLocation().x >= 450 && pointerInfo.getLocation().x <= 820 ) && (pointerInfo.getLocation().y >= 500 &&pointerInfo.getLocation().y <= 670 )) {
				sound.sfxSelect("ButtonClick1");
				gw.startLogin();
				//로그인 이미지에서 마우스를 클릭하면 GameWindow 클래스의 startLogin을 실행한다.
			}else if((pointerInfo.getLocation().x >= 450 && pointerInfo.getLocation().x <= 820 ) && (pointerInfo.getLocation().y >= 680 &&pointerInfo.getLocation().y <= 810 )) {
				//여기서는 회원가입을 실행할 것
				sound.sfxSelect("ButtonClick1");
				new Join(gw);
			}else if((pointerInfo.getLocation().x >= 450 && pointerInfo.getLocation().x <= 820 ) && (pointerInfo.getLocation().y >= 820 &&pointerInfo.getLocation().y <= 950 )) {
				//여기서는 게임이 종료됨
				sound.sfxSelect("ButtonClick1");
				new Finish(gw);
			}else if((pointerInfo.getLocation().x >= 1405 && pointerInfo.getLocation().x <= 1605 ) && (pointerInfo.getLocation().y >= 828 &&pointerInfo.getLocation().y <= 918 )){
				sound.sfxSelect("ButtonClick1");
				gw.startRanking();
			} else {
				sound.sfxSelect("MouseClick1");
			}
		}
	}

	@Override
	public void render(Graphics g) {
		//이미지 출력
		bg.render(g);
		loginButton.render(g);
		joinButton.render(g);
		finishButton.render(g);
		rankingButton.render(g);
	}
	
}
