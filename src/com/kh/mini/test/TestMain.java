package com.kh.mini.test;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.model.gameObject.GameScene;

import com.kh.mini.view.GameWindow;

public class TestMain {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub			
		
		GameWindow gw = new GameWindow();
		
		GameScene gs = new GameScene();
		
		gs.init();	
		
		gw.addKeyListener(KeyManager.Instance());
		
		gw.addMouseListener(KeyManager.Instance());
		
		gs.setBgPosition(gw.WIDTH / 2, gw.HEIGHT / 2);
		
		gw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gw.setVisible(true);		
		//gw.repaint();
		gw.createBufferStrategy(2);

		while(true) {		
		
			BufferStrategy bs = gw.getBufferStrategy();
			
			Graphics g = bs.getDrawGraphics();
			
			g.clearRect(0, 0, gw.getWidth(), gw.getHeight());
			
			//gw.repaint();
			gw.repaint();
			
			gs.render(g);
			
			gs.update(); //ĳ������ ��ġ�� Ȯ���ϱ� ���� ��� ������Ʈ��

			g.dispose();
			
			bs.show();

		}
		
	}

}
