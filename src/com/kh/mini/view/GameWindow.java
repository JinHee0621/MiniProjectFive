package com.kh.mini.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.kh.mini.model.vo.ImageClass;

public class GameWindow extends JFrame {

	//BufferedImage fImg;
	//BufferedImage bImg;
	
	BufferStrategy bs;
	//MapTool mt = new MapTool();
	
	ImageClass img;
	
	int frame = 0;
	int count = 0;
	
	public GameWindow() {
		this.setSize(1408, 896);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
