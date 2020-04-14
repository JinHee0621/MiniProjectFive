package com.kh.mini.model.gameObject;

import java.awt.Graphics;
import java.awt.Graphics2D;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.controller.SoundManager;

public abstract class BaseScene {
	
	protected static final SoundManager sound = SoundManager.Instance();
	
	public abstract void init();
	
	public abstract void release();
	
	public abstract void update();
	
	public abstract void render(Graphics g);
}
