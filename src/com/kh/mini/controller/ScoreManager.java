package com.kh.mini.controller;

import java.util.ArrayList;

import com.kh.mini.model.dao.JoinDao;
import com.kh.mini.model.vo.UserInfo;

public class ScoreManager {
	public void arrayListSort() {
		ArrayList<UserInfo> list = new ArrayList<>();
		JoinDao jd = new JoinDao();
		list = jd.fileOpen();
		
		
		
	}
}
