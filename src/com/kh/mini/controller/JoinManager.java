package com.kh.mini.controller;

import java.util.ArrayList;

import com.kh.mini.model.dao.JoinDao;
import com.kh.mini.model.vo.UserInfo;
import com.kh.mini.view.ResultPrinter;


public class JoinManager {
	private JoinDao jd= new JoinDao();
	
	//새 회원 등록 메소드
	public void insertMember(UserInfo userinfo) {


		ArrayList<UserInfo> list = jd.fileOpen(); //파일에 저장된거 읽어옴
		
		if(list == null) {// 읽어왔는데, 아무것도 없다면?????
			list = new ArrayList<UserInfo>();//새로운 리스트 생성
		}
		
		list.add(userinfo); //불러온 리스트에서 신규 회원 추가
		jd.fileSave(list); // 전체 내역 다시 저장
	}
	
	//아이디 비번 일치여부
	public void idPwCorrect(String tid, String tpw) {
		//회원정보 전부 가져오기
		ArrayList<UserInfo> list = jd.fileOpen();
		
		//일치하는 UserInfo 정보를 담을 참조변수 초기화
		UserInfo selectedUserInfo = null;
		
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				//일치하는 user id 를 selectedUserInfo에  담기	
				if(list.get(i).getId().equals(tid) && list.get(i).getPw().equals(tpw)) {
					selectedUserInfo = list.get(i);
					new ResultPrinter().logSuccess();
					break;
				}
			}
		}
		
		//일치하는 게시물 없으면 에러 출력
		if(selectedUserInfo == null) {
			new ResultPrinter().logFail();
		}else {
			jd.fileSave(list);
		}
	}
	
	public int duplicateId(String id) {
		int result = 0;//기본값, 중복되는  경우 없을 때, 0 반환
		//회원정보 전부 가져오기
		ArrayList<UserInfo> list = jd.fileOpen();
		
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getId().equals(id)) {
					result = 1; //조회 후 중복값 발견시 1반환하며 메소드 종료.
					break;
				}
			}
			
		}
		return result;
	}
	
}
