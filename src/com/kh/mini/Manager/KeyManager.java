package com.kh.mini.Manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import com.kh.mini.mapTool.MapChip;

public class KeyManager implements KeyListener, MouseListener {

	private static KeyManager inst;
	
	private HashMap<Integer, Boolean> keyMap = new HashMap<Integer, Boolean>();
	
	public static KeyManager Instance() {
		
		if(inst != null) {
			return inst;	
		} else {
			inst = new KeyManager();
			return inst;
		}
	}

	boolean isUp = true;
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(keyMap.containsKey(e.getKeyCode()) == false || keyMap.get(e.getKeyCode()) == false)
		{
			keyMap.put(e.getKeyCode(), true);	
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(keyMap.containsKey(e.getKeyCode()) == true && keyMap.get(e.getKeyCode()) == true)
		{
			isUp = true;
			keyMap.put(e.getKeyCode(), false);
		}		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {		
	
	}	
	
	public boolean stayKeyDown(int keyCode) {
		boolean isPressKey = false;
		
		if(keyMap.containsKey(keyCode) == true && keyMap.get(keyCode) == true) {
			isPressKey = true;
		}
		
		return isPressKey;
	}
	
	public boolean onceKeyDown(int keyCode) {
		boolean isPressKey = false;
		if(keyMap.containsKey(keyCode) && keyMap.get(keyCode) == true && isUp == true) {
			isPressKey = true;
			keyMap.put(keyCode, false);			
			isUp = false;
		}
		
		return isPressKey;
	}
	
	public boolean keyUp(int keyCode) {
		boolean isUpKey = false;
		
		if(keyMap.containsKey(keyCode) == true && keyMap.get(keyCode) == false) {
			isUpKey = true;
		}	
		
		return isUpKey;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(keyMap.containsKey(MouseEvent.BUTTON1) == false || keyMap.get(MouseEvent.BUTTON1) == false)
		{
			System.out.println("마우스 클릭됨");
			
			MapChip.setImgPosX(e.getX());
			MapChip.setImgPosY(e.getY());
			
			keyMap.put(MouseEvent.BUTTON1, true);	
		}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(keyMap.containsKey(MouseEvent.BUTTON1) == false || keyMap.get(MouseEvent.BUTTON1) == false)
		{
			System.out.println("마우스 클릭됨");
			
			MapChip.setImgPosX(e.getX());
			MapChip.setImgPosY(e.getY());
			
			keyMap.put(MouseEvent.BUTTON1, true);	
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(keyMap.containsKey(MouseEvent.BUTTON1) == true && keyMap.get(MouseEvent.BUTTON1) == true)
		{
			isUp = true;
			keyMap.put(MouseEvent.BUTTON1, false);
		}		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean stayMouseClicked(int keyCode) {
		boolean isPressKey = false;
		if(keyMap.containsKey(keyCode) && keyMap.get(keyCode) == true && isUp == true) {
			isPressKey = true;
		}
		
		return isPressKey;
	}
	
	public boolean onceMouseClicked(int keyCode) {
		boolean isPressKey = false;
		if(keyMap.containsKey(keyCode) && keyMap.get(keyCode) == true && isUp == true) {
			isPressKey = true;
			keyMap.put(keyCode, false);			
			isUp = false;
		}
		
		return isPressKey;
	}
	
}

