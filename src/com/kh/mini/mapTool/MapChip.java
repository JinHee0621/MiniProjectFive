package com.kh.mini.mapTool;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.Stack;

import com.kh.mini.model.vo.GameObject;
import com.kh.mini.model.vo.ImageClass;

public class MapChip extends GameObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6122884571732384238L;
	
	private ImageClass img;
	private static int imgPosX;
	private static int imgPosY;
	int imgNum = 0;
	boolean addedImg = false;
	@Override
	public void init() {
		img = new ImageClass();
		System.out.println("마우스 x: " + imgPosX + " 마우스 Y: " + imgPosY);
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
