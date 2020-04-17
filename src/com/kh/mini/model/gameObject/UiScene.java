package com.kh.mini.model.gameObject;

import java.awt.Graphics;

import javax.swing.JLabel;

import com.kh.mini.model.vo.ImageClass;

public class UiScene extends BaseScene{
	
	ImageClass uiBackGroundImg;
	
	ImageClass cleanGuage;
	ImageClass cleanBar;
	
	ImageClass maskBar;
	
	ImageClass weaponSlot;
	
	ImageClass weaponType;
	
	ImageClass haveCoinUi;
	ImageClass haveCoinNumTen;
	ImageClass haveCoinNumOne;
	
	ImageClass scoreUi;
	ImageClass[] scoreNum = new ImageClass[6];
	
	Player player;
	
	public static ImageClass miniMap;
	
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
		
		weaponSlot = new ImageClass();
		weaponSlot.Init("images\\uiImages\\WeaponUiSet\\WeaponWindow.png");
		weaponSlot.setIsOn(true);
		weaponSlot.setPosition(595, 50);
		
		weaponType = new ImageClass();
		weaponType.Init("images\\uiImages\\WeaponUiSet\\UI_WeaponType1.png");
		getWeaponUi();
		weaponType.setIsOn(true);
		weaponType.setPosition(625, 85);
		
		haveCoinUi = new ImageClass();
		haveCoinUi.Init("images\\uiImages\\CoinNumUI.png");
		haveCoinUi.setIsOn(true);
		haveCoinUi.setPosition(765, 90);
		
		haveCoinNumTen = new ImageClass();
		haveCoinNumTen.Init("images\\uiImages\\NumberSet\\0.png");
		haveCoinNumTen.setIsOn(true);
		haveCoinNumTen.setPosition(835, 100);
		
		haveCoinNumOne = new ImageClass();
		haveCoinNumOne.Init("images\\uiImages\\NumberSet\\0.png");
		haveCoinNumOne.setIsOn(true);
		haveCoinNumOne.setPosition(870, 100);
		
		scoreUi = new ImageClass();
		scoreUi.Init("images\\uiImages\\NumberSet\\ScoreText.png");
		scoreUi.setIsOn(true);
		scoreUi.setPosition(1065, 50);
		
		miniMap = new ImageClass();
		miniMap.Init("images\\miniMapImages\\0.2FDesk.png");
		miniMap.setIsOn(true);
		miniMap.setPosition(958, 180);
		
		for(int i = 0; i < scoreNum.length; i++) {
			scoreNum[i] = new ImageClass();
			scoreNum[i].Init("images\\uiImages\\NumberSet\\0.png");
			scoreNum[i].setIsOn(true);
			scoreNum[i].setPosition(1080 + (i * 35), 75);
		}
	}

	public void getWeaponUi() {
		if(player.getWeaponType() == 1) {
			weaponType.changeImage("images\\uiImages\\WeaponUiSet\\UI_WeaponType1.png");
		} else if(player.getWeaponType() == 2) {
			weaponType.changeImage("images\\uiImages\\WeaponUiSet\\UI_WeaponType2.png");
		}else if(player.getWeaponType() == 3) {
			weaponType.changeImage("images\\uiImages\\WeaponUiSet\\UI_WeaponType3.png");
		}
	}
	
	@Override
	public void release() {
		
	}

	@Override
	public void update() {
		int playerScore = player.getScore();
		getWeaponUi();
		haveCoinNumTen.changeImage("images\\uiImages\\NumberSet\\"+(player.getCoinCount()/10)+".png");
		haveCoinNumOne.changeImage("images\\uiImages\\NumberSet\\"+(player.getCoinCount()%10)+".png");
		
		for(int i = 0; i < scoreNum.length ;i++) {
			int showScore = (int) (playerScore / Math.pow(10, 5-i));
			playerScore %= Math.pow(10, 5-i);
			scoreNum[i].changeImage("images\\uiImages\\NumberSet\\"+showScore+".png");
		}
		
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
		weaponSlot.render(g);
		
		haveCoinUi.render(g);
		haveCoinNumTen.render(g);
		haveCoinNumOne.render(g);
		
		scoreUi.render(g);
		for(int i = 0; i < scoreNum.length ;i++) {
			scoreNum[i].render(g);
		}
		
		cleanGuage.render(g);
		cleanBar.render(g);
		maskBar.render(g);
		weaponType.render(g);
		
		miniMap.render(g);
	}

}
