package com.kh.mini.view;

import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.kh.mini.mapTool.MapTool;
import com.kh.mini.model.vo.ImageClass;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GameWindow extends JFrame {

	//BufferedImage fImg;
	//BufferedImage bImg;
	
	BufferStrategy bs;
	//MapTool mt = new MapTool();
	
	ImageClass img;
	
	
	public GameWindow() {
	}
	
	public void Init() {
		
	}
	
	int frame = 0;
	int count = 0;
	
	public void paint(Graphics g) {

	}
	
	public void update(Graphics g) {
		System.out.println("���� ȣ��");
		paint(g);
	}
	
	public void destroy() {
		
	}
	
	
	
}
