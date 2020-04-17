package com.kh.mini.model.gameObject;

import com.kh.mini.model.vo.GameObject;

public class BossMonster extends Monster implements Runnable{
	
	Monster SponeMonster;
	
	public BossMonster(Player target, String path, int imgSizeX, int imgSizeY, int frameCount, int patternType,
			double mobSpeed, int monsterType, int monsterRect) {
		super(target, path, imgSizeX, imgSizeY, frameCount, patternType, mobSpeed, monsterType, monsterRect);
		super.isBoss = true;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		try {
			System.out.println("보스몬스터 패턴");
			if (getDamage) {
				mobSpeed = 0;
				Thread.sleep(500);
				getDamage = false;
		
				mobSpeed = firstSpeed;
				checkPattern = false;
			} 
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
