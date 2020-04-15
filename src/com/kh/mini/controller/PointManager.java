package com.kh.mini.controller;

import java.util.ArrayList;

import com.kh.mini.model.comparator.DscendingPoint;
import com.kh.mini.model.dao.JoinDao;
import com.kh.mini.model.vo.UserInfo;

public class PointManager {

	public void arrayListSort() {
		
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		
		JoinDao jd = new JoinDao();
		list = jd.fileOpen();
		
		list.sort(new DscendingPoint());
		System.out.println("스코어 내림차순");
		for(int i = 0; i < list.size(); i++) {
			System.out.println("id : " + list.get(i).getId());
			System.out.println("name : " + list.get(i).getName());

			System.out.println("point : " + list.get(i).getPoint());
		}	
	}
}
