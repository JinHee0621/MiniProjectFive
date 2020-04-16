package com.kh.mini.model.gameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.Finish;
import com.kh.mini.view.GameWindow;
import com.kh.mini.view.Join;

public class GameOverScene extends BaseScene{

	ImageClass uiBackGround;

	ImageClass okButton;
	
	ImageClass whoEnemy;
	
	ImageClass howToImg;
	
	PointerInfo pointerInfo;
	
	GameWindow gw;
	
	int mobType;
	
	public GameOverScene(GameWindow gw, int mobType) {
		this.gw = gw;
		this.mobType = mobType;
	}
	
	@Override
	public void init() {
		gw.setBackground(Color.BLACK);
		System.out.println("다음과 같은 타입의 몬스터가 플레이어를 죽였다!: " + mobType);
		uiBackGround = new ImageClass();
		uiBackGround.Init("images\\uiImages\\GameOverUI.png");
		uiBackGround.setIsOn(true);
		uiBackGround.setPosition(250 , 100);
		
//		okButton = new ImageClass();
//		okButton.Init("images\\titleImages\\login.png");
//		okButton.setIsOn(true);
//		okButton.setPosition(198, 465);
		
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
			sound.sfxSelect("MouseClick1");
		}
	}

	@Override
	public void render(Graphics g) {
		uiBackGround.render(g);
	}

}
