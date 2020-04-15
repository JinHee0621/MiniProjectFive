package com.kh.mini.model.gameObject;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.GameWindow;

public class RankingScene extends BaseScene{
	   ImageClass bg;
	   PointerInfo pointerInfo;
	   GameWindow gw;
	   int cnt = 0;
	   
	   public RankingScene(GameWindow gw) {
	      this.gw = gw;
	   }


	   @Override
	   public void init() {
	      //�̹����� �ʱ�ȭ �ϰ� ��ġ�� ���Ѵ�.

	      //��� �̹��� Ŭ���� ���� �Ҵ�
	      bg = new ImageClass();
	      bg.Init("images\\titleImages\\ranking.png");
	      bg.setIsOn(true);
	      bg.setPosition(0, 0);

	   }


	   @Override
	   public void release() {
	      // TODO Auto-generated method stub

	   }

	   @Override
	   public void update() {

	   }

	   @Override
	   public void render(Graphics g) {
	      bg.render(g);

	   }


	}
