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
		jd.fileSave(list);
	
	}
}
