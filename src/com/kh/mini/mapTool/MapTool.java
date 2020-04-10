package com.kh.mini.mapTool;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Stack;

import com.kh.mini.Manager.BaseScene;
import com.kh.mini.Manager.ImageClass;
import com.kh.mini.Manager.KeyManager;
import com.kh.mini.Model.vo.GameObject.GameObject;

public class MapTool extends GameObject{

	ArrayList<MapChip> maps = new ArrayList<MapChip>();
	private int posX;
	private int posY;
	MapChip mc;
	
	static int index = 0;
	
	public void setBgPosition(int x, int y) {
		mc.setPosition(x, y);
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	@Override
	public void init() {

	}
	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render(Graphics g) {
		if (key.onceMouseClicked(MouseEvent.BUTTON1)) {
			mc = new MapChip();
			mc.init();
			mc.setPosition(MapChip.getImgPosX(), MapChip.getImgPosY());
			maps.add(mc);
			mc.render(g);
		}
		for(int i = 0; i < maps.size(); i++) {
			maps.get(i).getImg().render(g);
		}
	}
}
