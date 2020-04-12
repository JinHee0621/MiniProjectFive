package com.kh.mini.Model.vo.Manager;

import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class BaseScene {
	
	public abstract void init();
	
	public abstract void release();
	
	public abstract void update();
	
	public abstract void render(Graphics g);
}
