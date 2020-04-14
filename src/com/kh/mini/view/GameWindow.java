package com.kh.mini.view;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.model.gameObject.GameScene;
import com.kh.mini.model.gameObject.LoginScene;
import com.kh.mini.model.gameObject.TitleScene;
import com.kh.mini.model.vo.ImageClass;

public class GameWindow extends JFrame {

	//BufferedImage fImg;
	//BufferedImage bImg;
	
	BufferStrategy bs;
	//MapTool mt = new MapTool();
	
	ImageClass img;

	int frame = 0;
	int count = 0;
	
	boolean islogin = false;
	
	
	
	public GameWindow(int type, String user) {
		switch(type) {
		case 0:
			startTitle();
			break;
		case 1:
			startGame(user);
			break;
		}
	}
	
	public void startTitle() {
		this.setSize(1408, 896);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		TitleScene titleScene = new TitleScene(this);
		titleScene.init();
		
		
		//GameScene gs = new GameScene();
		
		//gs.init();	
		
		this.addKeyListener(KeyManager.Instance());
		
		this.addMouseListener(KeyManager.Instance());
		
		//gs.setBgPosition(gw.WIDTH / 2, gw.HEIGHT / 2);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
		//gw.repaint();
		this.createBufferStrategy(2);

		while(true) {		
			if(islogin) break;
			
			BufferStrategy bs = this.getBufferStrategy();
			
			Graphics g = bs.getDrawGraphics();
			
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			
			//gw.repaint();
			
			this.repaint();
			titleScene.render(g);
			titleScene.update();
			//]gs.render(g);
			
			//gs.update(); //캐릭터의 위치를 확인하기 위해 계속 업데이트함

			g.dispose();
			
			bs.show();
		}
	}
	
	
	public void startLogin() {
		
		islogin = true;
		LoginScene ls = new LoginScene(this);
		ls.init();

		this.setLocationRelativeTo(null);
		
		this.addKeyListener(KeyManager.Instance());
		
		this.addMouseListener(KeyManager.Instance());
		
		//ls.setBgPosition(this.WIDTH / 2, this.HEIGHT / 2);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
		//gw.repaint();
		//this.createBufferStrategy(2);

		while(true) {		
			ls.update();
		}
	}
	
	public void startGame(String user) {	
				
		this.addKeyListener(KeyManager.Instance());
		
		this.addMouseListener(KeyManager.Instance());
		
		GameScene gs = new GameScene(this);
		gs.setUser(user);
		gs.init();
		
		this.setSize(1408, 896);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
			
		gs.setBgPosition(this.WIDTH / 2, this.HEIGHT / 2);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
		//gw.repaint();
		this.createBufferStrategy(2);

		while(true) {		
		
			BufferStrategy bs = this.getBufferStrategy();
			
			Graphics g = bs.getDrawGraphics();
			
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			
			//gw.repaint();
			
			this.repaint();
			gs.render(g);
			gs.update();
			
			gs.update(); //캐릭터의 위치를 확인하기 위해 계속 업데이트함

			g.dispose();
			
			bs.show();
		}
	}
	
	
	public void Init() {
		
	}

	public void paint(Graphics g) {

	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void destroy() {
		
	}
//	
}
