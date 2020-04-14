package com.kh.mini.controller;

import java.util.ArrayList;

import com.kh.mini.model.dao.JoinDao;
import com.kh.mini.model.vo.UserInfo;
import com.kh.mini.view.GameWindow;
import com.kh.mini.view.ResultPrinter;


public class JoinManager {
	private JoinDao jd= new JoinDao();
	private GameWindow gw;
	
	public JoinManager(GameWindow gw) {
		this.gw = gw;
	}
	
	
	//�� ȸ�� ��� �޼ҵ�
	public void insertMember(UserInfo userinfo) {


		ArrayList<UserInfo> list = jd.fileOpen(); //���Ͽ� ����Ȱ� �о��
		
		if(list == null) {// �о�Դµ�, �ƹ��͵� ���ٸ�?????
			list = new ArrayList<UserInfo>();//���ο� ����Ʈ ����
		}
		
		list.add(userinfo); //�ҷ��� ����Ʈ���� �ű� ȸ�� �߰�
		jd.fileSave(list); // ��ü ���� �ٽ� ����
	}
	
	//���̵� ��� ��ġ����
	public void idPwCorrect(String tid, String tpw) {
//		gw.removeAll();
//		gw.startGame();
		//ȸ������ ���� ��������
		ArrayList<UserInfo> list = jd.fileOpen();
		
		//��ġ�ϴ� UserInfo ������ ���� �������� �ʱ�ȭ
		UserInfo selectedUserInfo = null;
		
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				//��ġ�ϴ� user id �� selectedUserInfo��  ���	
				if(list.get(i).getId().equals(tid) && list.get(i).getPw().equals(tpw)) {
					gw.removeAll();
					gw.repaint();
					gw.setVisible(false);
					gw = new GameWindow(1,tid);
					jd.fileSave(list);
					break;
				}else {
					new ResultPrinter().logFail();
				
				}
			}
		}
	}
	public int duplicateId(String id) {
		int result = 0;//�⺻��, �ߺ��Ǵ�  ��� ���� ��, 0 ��ȯ
		//ȸ������ ���� ��������
		ArrayList<UserInfo> list = jd.fileOpen();
		
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getId().equals(id)) {
					result = 1; //��ȸ �� �ߺ��� �߽߰� 1��ȯ�ϸ� �޼ҵ� ����.
					break;
				}
			}
		}
		return result;
	}
	
}
