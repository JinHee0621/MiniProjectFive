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

	public void fileSave(ArrayList<UserInfo> list) {//UserInfo ��ü ������ ���� �޴´�.

		ObjectOutputStream obj = null;
		
		try {
			obj = new ObjectOutputStream(new FileOutputStream("user1.txt"));
			obj.writeObject(list);
			obj.flush();	//���� �����ϰ� ���°�
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

	public ArrayList<UserInfo> fileOpen() {
		ObjectInputStream ois = null;
		ArrayList<UserInfo> list = null;

		
		try {
			ois = new ObjectInputStream(new FileInputStream("user1.txt"));
			list= (ArrayList<UserInfo>) ois.readObject();
			
			
			if(list != null) {
				for(int i = 0 ; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
			}else {
				System.out.println("�Խù��� �����ϴ�.");
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("������ �����ϴ�.");
			
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
