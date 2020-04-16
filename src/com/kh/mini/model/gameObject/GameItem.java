package com.kh.mini.model.gameObject;

import java.awt.Graphics;

import com.kh.mini.model.gameObject.maps.DesktoLeft2F;
import com.kh.mini.model.vo.GameObject;
import com.kh.mini.model.vo.ImageClass;

public class GameItem extends GameObject {

	private Player player;

	private ImageClass img;

	private String imgPath;
	private int imgX;
	private int imgY;
	private int imgFrame;
	private int itemType;

	private boolean shop;
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
			x = itemPosX;
			y = itemPosY;
			img.setPosition(x, y);
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
				}
			} else {
				if (player.getCoinCount() > price) {
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
					}
					player.setCoinCount(player.getCoinCount() - price);
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
		img.render(g);
	}

}
