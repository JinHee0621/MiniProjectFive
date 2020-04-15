package com.kh.mini.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.mini.model.vo.UserInfo;

public class JoinDao {
	public JoinDao() {}

	public void fileSave(ArrayList<UserInfo> list) {//UserInfo 객체 정보를 전부 받는다.

		ObjectOutputStream obj = null;
		
		try {
			obj = new ObjectOutputStream(new FileOutputStream("user1.txt"));
			obj.writeObject(list);
			obj.flush();	//내용 전송하고 비우는거
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void openingSave(String userID, boolean isOpening) {
		ObjectOutputStream obj = null;
		ArrayList<UserInfo> list = fileOpen();
		try {
			obj = new ObjectOutputStream(new FileOutputStream("user1.txt"));
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getId().equals(userID)) {
					list.get(i).setOpening(isOpening);
					break;
				}
			}
			obj.writeObject(list);
			obj.flush();	//내용 전송하고 비우는거
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void scoreSave(String userID, int score) {
		ObjectOutputStream obj = null;
		ArrayList<UserInfo> list = fileOpen();
		try {
			obj = new ObjectOutputStream(new FileOutputStream("user1.txt"));
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getId().equals(userID)) {
					list.get(i).setPoint(score);
					break;
				}
			}
			obj.writeObject(list);
			obj.flush();	//내용 전송하고 비우는거
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@SuppressWarnings("unused")
	public ArrayList<UserInfo> fileOpen() {
		ObjectInputStream ois = null;
		ArrayList<UserInfo> list = null;

		
		try {
			list = new ArrayList<UserInfo>();
			ois = new ObjectInputStream(new FileInputStream("user1.txt"));
			
			list=  (ArrayList<UserInfo>) ois.readObject();
			
			if(list != null) {
				for(int i = 0 ; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
			}else {
				System.out.println("게시물이 없습니다.");
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
			
		} catch (ClassNotFoundException |IOException e) {
			e.printStackTrace();
		} finally {
			if(ois != null) {
					try { 
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		return list; 
	}
	
}
