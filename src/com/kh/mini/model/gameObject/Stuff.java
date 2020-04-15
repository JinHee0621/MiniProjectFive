package com.kh.mini.model.gameObject;

import java.awt.Graphics;

import com.kh.mini.model.vo.CameraClass;
import com.kh.mini.model.vo.GameObject;
import com.kh.mini.model.vo.ImageClass;

public class Stuff extends GameObject{
	private ImageClass img;
	
	private String imgPath;
	
	private Player player;
	
	private int imgSizeX;
	private int imgSizeY;
	private int frameCount;
	
	public Stuff(String path, int imgSizeX, int imgSizeY, Player player) {
		this.player = player;
		this.imgPath = path;
		this.imgSizeX = imgSizeX;
		this.imgSizeY = imgSizeY;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		img = new ImageClass();
		img.Init(imgPath);
		img.setMagnification(1.0);
		
		x = this.getX();
		y = this.getY();
		
		img.setPosition(x-64, y+64);
		
		img.setIsOn(true);
		img.setMaxSpeed(100);
		
		this.makeCenterRect(this.getX(), this.getY(), imgSizeX,imgSizeY);
	}
	@Override
	public void update() {
		this.makeCenterRect(this.getX(), this.getY(), imgSizeX,imgSizeY);
		if (this.isCollisionRectToRect(player) == false) {
		} else {
			if (player.getX() > this.getX()) {
				System.out.println("플레이어와 부딫힌다.");
				player.setPosition(player.getX() + player.getPlayerMovSpeed(), player.getY());
			} else {
				player.setPosition(player.getX() - player.getPlayerMovSpeed(), player.getY());
			}
			
			if (player.getY() > this.getY()) {
				player.setPosition(player.getX(), player.getY()+player.getPlayerMovSpeed());
			} else {
				player.setPosition(player.getX(), player.getY()-player.getPlayerMovSpeed());
			}
		}
//		if (this.isCollisionRectToRect(instanceof Monster) == false) {
//		} else {
//			if (player.getX() > this.getX()) {
//				System.out.println("플레이어와 부딫힌다.");
//				player.setPosition(player.getX() + player.getPlayerMovSpeed(), player.getY());
//			} else {
//				player.setPosition(player.getX() - player.getPlayerMovSpeed(), player.getY());
//			}
//			
//			if (player.getY() > this.getY()) {
//				player.setPosition(player.getX(), player.getY()+player.getPlayerMovSpeed());
//			} else {
//				player.setPosition(player.getX(), player.getY()-player.getPlayerMovSpeed());
//			}
//		}
		
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics g) {
		img.setPosition(x-64, y+64);
		img.render(g);
	}

	public ImageClass getImage() {
		return img;
	}
}
