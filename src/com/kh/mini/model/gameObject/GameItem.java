package com.kh.mini.model.gameObject;

import java.awt.Graphics;

import com.kh.mini.model.gameObject.maps.DesktoLeft2F;
import com.kh.mini.model.vo.GameObject;
import com.kh.mini.model.vo.ImageClass;

public class GameItem extends GameObject {

	private Player player;

	private ImageClass img;
	private ImageClass itemBase;
	private ImageClass itemPrice;
	
	private String imgPath;
	private int imgX;
	private int imgY;
	private int imgFrame;
	private int itemType;

	private boolean shop;
	private boolean purchaseItem = false;
	private int price;

	private int itemPosX;
	private int itemPosY;

	private GameScene gameScene;

	public GameItem(Player player, int itemType, GameScene gameScene) {

		this.player = player;
		this.itemType = itemType;
		this.gameScene = gameScene;
	}

	public GameItem(Player player, int itemType, boolean shop, int price, int itemPosX, int itemPosY) {

		this.player = player;
		this.itemType = itemType;
		this.shop = shop;
		this.price = price;

		this.itemPosX = itemPosX;
		this.itemPosY = itemPosY;
	}

	@Override
	public void init() {
		img = new ImageClass();
		itemBase = new ImageClass();
		itemPrice = new ImageClass();
		// img.Init("images\\charImages\\MainCharSideR.png", 90, 150, 11, 1, true);
		switch (itemType) {
		case 0:
			img.Init("images\\ItemImage\\coin.png");
			break;
		case 1:
			img.Init("images\\ItemImage\\HandCleaner.png", 64, 64, 10, 1, true);
			break;
		case 2:
			img.Init("images\\ItemImage\\IceAmericano.png", 64, 64, 13, 1, true);
			break;
		case 3:
			img.Init("images\\ItemImage\\Mask1.png", 64, 64, 19, 1, true);
			break;
		case 4:
			img.Init("images\\ItemImage\\Mask2.png", 64, 64, 17, 1, true);
			break;
		case 5:
			img.Init("images\\ItemImage\\Mask3.png", 64, 64, 13, 1, true);
			break;
		case 6:
			img.Init("images\\ItemImage\\spray.png", 64, 64, 10, 1, true);
			break;
		case 7:
			img.Init("images\\ItemImage\\WeaponType2.png", 64, 64, 18, 1, true);
			break;
		case 8:
			img.Init("images\\ItemImage\\WeaponType3.png", 64, 64, 18, 1, true);
			break;
		}
		// img.Init(imgPath,imgX,imgY,imgFrame,1,true);
		// item = new GameItem("images\\ItemImage\\HandCleaner.png",this,p,64,64,10,1);
		if (!shop) {
			img.setMagnification(1.0);
			img.setIsOn(true);
			img.setMaxSpeed(100);
			x = 650;
			y = 550;
			img.setPosition(x, y);
		} else {
			img.setMagnification(1.0);
			img.setIsOn(true);
			img.setMaxSpeed(100);
			
			itemBase.Init("images\\ItemImage\\itemBase.png");
			itemPrice.Init("images\\ItemImage\\payTack_"+price+"coin.png");
			
			
			x = itemPosX;
			y = itemPosY;
			img.setPosition(x, y);
			itemBase.setPosition(x, y + 30);
			itemPrice.setPosition(x + 12, y + 30);
			
		}
		this.makeCenterRect(x, y, 70, 70);
	}

	@Override
	public void update() {
		this.makeCenterRect(x, y, 70, 70);
		img.isFrameUpdate();

		if (player != null && this.isCollisionRectToRect(player) == false) {
		} else {
			if (!shop) {
				gameScene.popItem = false;
				gameScene.eatItem();
				switch (itemType) {
				case 0:
					player.setCoinCount(player.getCoinCount() + 1);
					break;
				case 1:
					player.setPlayerClean(10);
					break;
				case 2:
					player.setPlayerMovSpeed(player.getPlayerMovSpeed() + 0.5);
					break;
				case 3:
					player.setPlayerMask(player.getPlayerMask() + 2);
					break;
				case 4:
					player.setPlayerMask(player.getPlayerMask() + 5);
					break;
				case 5:
					player.setPlayerMask(player.getPlayerMask() + 7);
					break;
				case 6:
					player.setWeaponType(1);
					player.eatSprayTypeWeapon();
					player.setPlayerRange(player.getPlayerRange() + 10);
					player.getUiScene().getWeaponUi();
					break;
				case 7:
					player.setWeaponType(2);
					player.setGunShotSpeed(1);
					player.eatGunTypeWeapon();
					player.getUiScene().getWeaponUi();
					break;
				case 8:
					player.setWeaponType(3);
					player.setGunShotSpeed(2);
					player.setPlayerPower(player.getPlayerPower() + 1);
					player.eatGunTypeWeapon();
					player.getUiScene().getWeaponUi();
					break;
				}
			} else {
				if (player.getCoinCount() >= price && !purchaseItem) {
					switch (itemType) {
					case 0:
						player.setCoinCount(player.getCoinCount() + 1);
						break;
					case 1:
						player.setPlayerClean(10);
						break;
					case 2:
						player.setPlayerMovSpeed(player.getPlayerMovSpeed() + 0.5);
						break;
					case 3:
						player.setPlayerMask(player.getPlayerMask() + 2);
						break;
					case 4:
						player.setPlayerMask(player.getPlayerMask() + 5);
						break;
					case 5:
						player.setPlayerMask(player.getPlayerMask() + 7);
						break;
					case 6:
						player.setWeaponType(1);
						player.eatSprayTypeWeapon();
						player.setPlayerRange(player.getPlayerRange() + 10);
						break;
					case 7:
						player.setWeaponType(2);
						player.setGunShotSpeed(1);
						player.eatGunTypeWeapon();
						break;
					case 8:
						player.setWeaponType(3);
						player.setGunShotSpeed(2);
						player.setPlayerPower(player.getPlayerPower() + 1);
						player.eatGunTypeWeapon();
						break;
						
					}
					player.setCoinCount(player.getCoinCount() - price);
					purchaseItem = true;
				} else {
					if (player.getX() > this.getX()) {
						player.setPosition(player.getX() + player.getPlayerMovSpeed(), player.getY());
					} else {
						player.setPosition(player.getX() - player.getPlayerMovSpeed(), player.getY());
					}

					if (player.getY() > this.getY()) {
						player.setPosition(player.getX(), player.getY() + player.getPlayerMovSpeed());
					} else {
						player.setPosition(player.getX(), player.getY() - player.getPlayerMovSpeed());
					}
				}
			}
		}
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		img.setPosition(this.getX(), this.getY());
		if (shop) {
			itemBase.render(g);
			if(!purchaseItem)img.render(g);
			itemPrice.render(g);
		} else {
			img.render(g);
		}
	}

	public boolean isPurchaseItem() {
		return purchaseItem;
	}

	public void setPurchaseItem(boolean purchaseItem) {
		this.purchaseItem = purchaseItem;
	}

}
