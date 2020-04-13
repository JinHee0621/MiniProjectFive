package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.mini.controller.JoinManager;
import com.kh.mini.controller.SendMailManager;
import com.kh.mini.model.vo.UserInfo;

public class Join extends JFrame { //마우스 리스너 해서 위치 잡음
	private JFrame mf;
	private JPanel panel;	
	SendMailManager sm = new SendMailManager();
	public Join(JFrame mf) {
		//프레임
		this.setSize(950,770);
		this.setTitle("During 14days");
		this.setResizable(false); //창 사이즈 조절 못하게 함.
		this.setLocationRelativeTo(null);//창 가운데 뜨게 하는것
		this.setLayout(null);

		//버튼
		JButton btn = new JButton(new ImageIcon("images\\titleImages\\jooin.png"));
		btn.setLocation(674,620);
		btn.setSize(200,70);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		this.add(btn);

		//인증번호보내기 버튼
		JButton numBtn = new JButton(new ImageIcon("images\\titleImages\\code_send.png"));
		numBtn.setLocation(624,508);
		numBtn.setSize(300,80);
		numBtn.setContentAreaFilled(false);
		numBtn.setBorderPainted(false);
		this.add(numBtn);

		//배경 이미지
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\join_pop.png").getImage().getScaledInstance(950,770, 0)));
		label.setBounds(0, 0, 950,770);
		this.add(label);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setSize(950,770);
		panel.setLayout(null); 

		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.add(panel);

		JTextField tid = new JTextField();
		tid.setLocation(331,227);
		tid.setSize(277,43);
		panel.add(tid);
		tid.setOpaque(false);
		tid.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tid.setFont(new Font("Sanscerif", Font.PLAIN, 30));

		JTextField tpw = new JTextField();
		tpw.setLocation(331,325);
		tpw.setSize(277,43);
		panel.add(tpw);
		tpw.setOpaque(false);
		tpw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tpw.setFont(new Font("Sanscerif", Font.PLAIN, 30));

		JTextField tname = new JTextField();
		tname.setLocation(331,429);
		tname.setSize(277,43);
		panel.add(tname);
		tname.setOpaque(false);
		tname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tname.setFont(new Font("Sanscerif", Font.PLAIN, 30));

		JTextField temail = new JTextField();
		temail.setLocation(331,532);
		temail.setSize(277,43);
		panel.add(temail);
		temail.setOpaque(false);
		temail.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		temail.setFont(new Font("Sanscerif", Font.PLAIN, 30));

		JTextField tkey = new JTextField();
		tkey.setLocation(331,632);
		tkey.setSize(277,43);
		panel.add(tkey);
		tkey.setOpaque(false);
		tkey.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tkey.setFont(new Font("Sanscerif", Font.PLAIN, 30));

		numBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sm.gmailSend(temail.getText());
			}
		});

		
		
		//가입완료 버튼 누르면 txt파일로 데이터 저장
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//아이디 숫자와 영문 소문자만 입력받는 조건.
				boolean flag1 = false;
				char[]carr1 = tid.getText().toCharArray();//아이디 한글자씩 배열에 넣음
				for(int i = 0; i < carr1.length; i++) {
					if(!((carr1[i] >= 'a' && carr1[i] <= 'z')||(carr1[i] >= '0' && carr1[i] <= '9'))) {
					flag1 = true;
					}
					System.out.println(carr1[i]);
				}
				
				//비밀번호 숫자와 영문 소s문자만 입력받는 조건.
				boolean flag2 = false;
				char[]carr2 = tpw.getText().toCharArray();//아이디 한글자씩 배열에 넣음
				for(int i = 0; i < carr2.length; i++) {
					if(!((carr2[i] >= 'a' && carr2[i] <= 'z')||(carr2[i] >= '0' && carr2[i] <= '9'))) {
					flag2 = true;
					}
					System.out.println(carr1[i]);

				}
				
				JoinManager jm = new JoinManager();
				String id = tid.getText();
				if(jm.duplicateId(id) == 1) {
					new ResultPrinter().idDuplicate();
					return;
				} else if(!(tkey.getText().equals(sm.getKey()))) {
					new ResultPrinter().codeFail();

				}else if (tid.getText().equals("") || tpw.getText().equals("") || tname.getText().equals("")
						|| temail.getText().equals("") || tkey.getText().equals("")) {
					new ResultPrinter().checkList();
				}else if (flag1 == true) {
					new ResultPrinter().idEng();
				}else if (flag2 == true) {
					new ResultPrinter().pwEng();
				}else {
					String pw = tpw.getText();
					String name = tname.getText();
					String email = temail.getText();
					String key = tkey.getText();
					UserInfo userinfo = new UserInfo(id,pw,name,email,key);
					jm.insertMember(userinfo);
					new ResultPrinter().joinSuccess();//이거 다시 써주기
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setVisible(false);
				}
			}
		});

		this.setVisible(true);//없으면 프레임 안뜸.
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

}
