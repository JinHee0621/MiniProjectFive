package com.kh.mini.test;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.kh.mini.Manager.*;
import com.kh.mini.mapTool.MapChip;
import com.kh.mini.mapTool.MapTool;

public class TestMain {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub			
		
		GameWindow gw = new GameWindow();
		
		GameScene gs = new GameScene();
		
		MapTool mt = new MapTool();
		
		gs.init();
		
		mt.init();
		
		gw.setSize(1200, 760);		
		
		gw.addKeyListener(KeyManager.Instance());
		
		gw.addMouseListener(KeyManager.Instance());
		
		gs.setBgPosition(gw.WIDTH / 2, gw.HEIGHT / 2);
		
		gw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gw.setVisible(true);		
		
		gw.createBufferStrategy(2);
		
		while(true) {		
			gs.update(); //캐릭터의 위치를 확인하기 위해 계속 업데이트함
			
			BufferStrategy bs = gw.getBufferStrategy();
			
			Graphics g = bs.getDrawGraphics();
			
			g.clearRect(0, 0, gw.getWidth(), gw.getHeight());
			
			gw.repaint();
			
			gs.render(g);			
	
			mt.render(g);
			
			//mchips.render(g);
			
			g.dispose();
			
			bs.show();

		}
		
	}

}
