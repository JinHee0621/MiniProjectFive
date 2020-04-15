package com.kh.mini.test;

import com.kh.mini.view.GameWindow;

public class TestMain {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {		
		//GameWindow gw = new GameWindow(0, null);
		GameWindow gw = new GameWindow();
		gw.startRanking();
	}
}
