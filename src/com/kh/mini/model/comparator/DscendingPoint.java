package com.kh.mini.model.comparator;

import java.util.Comparator;

import com.kh.mini.model.vo.UserInfo;

public class DscendingPoint implements Comparator {

	@Override
	public int compare(Object ob1, Object ob2) {
		
		UserInfo ui1 = (UserInfo) ob1;
		UserInfo ui2 = (UserInfo) ob2;
		int result = 0;
		
		if(ui1.getPoint() == ui2.getPoint()) {
			result = 0;
		}
		if(ui1.getPoint() > ui2.getPoint()) {
			result = -1;
		}
		if(ui1.getPoint() < ui2.getPoint()) {
			result = 1;
		}
		
		return result;
	}
	
}
