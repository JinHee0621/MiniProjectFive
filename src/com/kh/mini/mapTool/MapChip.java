package com.kh.mini.mapTool;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.Stack;

import com.kh.mini.Manager.ImageClass;
import com.kh.mini.Model.vo.GameObject.GameObject;

public class MapChip extends GameObject{
	private ImageClass img;
	private static int imgPosX;
	private static int imgPosY;
	int imgNum = 0;
	boolean addedImg = false;
	@Override
	public void init() {
		img = new ImageClass();
		img.Init("images\\monsterImages\\Sprite-Mon5.png");
		img.setIsOn(true);
	}
	@Override
	public void release() {
	
	}
	@Override
	public void update() {//데이터 값 수정
		
	}
	
	@Override
	public void render(Graphics g) {
		img.setPosition(imgPosX, imgPosY);
		img.render(g);
	}
	
	public ImageClass getImg() {
		return img;
	}
	public void setImg(ImageClass img) {
		this.img = img;
	}
	public static int getImgPosX() {
		return imgPosX;
	}
	public static void setImgPosX(int imgPosX) {
		MapChip.imgPosX = imgPosX;
	}
	public static int getImgPosY() {
		return imgPosY;
	}
	public static void setImgPosY(int imgPosY) {
		MapChip.imgPosY = imgPosY;
	}

	
	
}
