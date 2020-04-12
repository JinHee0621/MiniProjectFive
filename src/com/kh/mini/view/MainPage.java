package com.kh.mini.view;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MainPage extends JFrame{
	
	public MainPage() {
		this.setSize(1408,930);
		this.setLocation(0,0);
		this.setLocationRelativeTo(null);	//창 가운데 뜨게 하는것 (메인 프레임이라서)
		this.add(new BackgroundPanel(this));
		this.setResizable(false);
		
		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
