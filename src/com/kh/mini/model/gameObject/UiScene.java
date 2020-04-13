package com.kh.mini.model.gameObject;

import java.awt.Graphics;

import com.kh.mini.model.vo.ImageClass;

public class UiScene extends BaseScene{
	
	ImageClass uiBackGroundImg;
	
	ImageClass cleanGuage;
	ImageClass cleanBar;
	
	ImageClass maskBar;
	
	Player player;
	
	
	public UiScene(Player player) {
		this.player = player;
	}
	
	
	@Override
	public void init() {
		uiBackGroundImg = new ImageClass();
		uiBackGroundImg.Init("images\\uiImages\\UiBackGroundImg.png");
		
		uiBackGroundImg.setIsOn(true);
		
		cleanGuage = new ImageClass();
		cleanGuage.Init("images\\uiImages\\HealthGuage.png");
		cleanGuage.setIsOn(true);
		cleanGuage.setPosition(50, 50);
		
		cleanBar = new ImageClass();
		cleanBar.Init("images\\uiImages\\HealthBar_0.png");
		cleanBar.setIsOn(true);
		cleanBar.setPosition(cleanGuage.getX(),cleanGuage.getY());
		
		maskBar = new ImageClass();
		maskBar.Init("images\\uiImages\\HealthBar_0.png");
		maskBar.setIsOn(true);
		maskBar.setPosition(275, 50);
		
	}

	@Override
	public void release() {
		
	}

	@Override
	public void update() {
		
		switch(player.getPlayerClean()) {
		case 0:
			cleanBar.changeImage("images\\uiImages\\HealthBar_0.png");
			break;
		case 1:
			cleanBar.changeImage("images\\uiImages\\HealthBar_1.png");
			break;
		case 2:
			cleanBar.changeImage("images\\uiImages\\HealthBar_2.png");
			break;
		case 3:
			cleanBar.changeImage("images\\uiImages\\HealthBar_3.png");
			break;
		case 4:
			cleanBar.changeImage("images\\uiImages\\HealthBar_4.png");
			break;
		case 5:
			cleanBar.changeImage("images\\uiImages\\HealthBar_5.png");
			break;
		case 6:
			cleanBar.changeImage("images\\uiImages\\HealthBar_6.png");
			break;
		case 7:
			cleanBar.changeImage("images\\uiImages\\HealthBar_7.png");
			break;
		case 8:
			cleanBar.changeImage("images\\uiImages\\HealthBar_8.png");
			break;
		case 9:
			cleanBar.changeImage("images\\uiImages\\HealthBar_9.png");
			break;
		default:
			cleanBar.changeImage("images\\uiImages\\HealthBar_Full.png");
			break;
		}
	
		
		switch(player.getPlayerMask()) {
		case 0:
			maskBar.changeImage("images\\uiImages\\HealthBar_0.png");
			break;
		case 1:
			maskBar.changeImage("images\\uiImages\\MaskBar_1.png");
			break;
		case 2:
			maskBar.changeImage("images\\uiImages\\MaskBar_2.png");
			break;
		case 3:
			maskBar.changeImage("images\\uiImages\\MaskBar_3.png");
			break;
		case 4:
			maskBar.changeImage("images\\uiImages\\MaskBar_4.png");
			break;
		case 5:
			maskBar.changeImage("images\\uiImages\\MaskBar_Full.png");
			break;
		case 6:
			maskBar.changeImage("images\\uiImages\\MaskBar_Full2.png");
			break;
		case 7:
			maskBar.changeImage("images\\uiImages\\MaskBar_Full3.png");
			break;
		default:
			maskBar.changeImage("images\\uiImages\\MaskBar_Full3.png");
			break;
		}
	}

	@Override
	public void render(Graphics g) {
		uiBackGroundImg.render(g);
		
		cleanGuage.render(g);
		cleanBar.render(g);
		maskBar.render(g);

	}

}
