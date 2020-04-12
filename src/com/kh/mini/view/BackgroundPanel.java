package com.kh.mini.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
	
	private JFrame mf;
	private JPanel panel;
	
	public BackgroundPanel(JFrame mf) {
	
		JButton btn1 = new JButton(new ImageIcon("images\\titleImages\\login.png"));//로그인 버튼
		JButton btn2 = new JButton(new ImageIcon("images\\titleImages\\join.png"));//회원가입 버튼
		JButton btn3 = new JButton(new ImageIcon("images\\titleImages\\finish.png"));//종료 버튼

		//버튼 크기 및 투명도 설정
		btn1.setBounds(201,472,360,120);
		btn2.setBounds(201,618,360,120);
		btn3.setBounds(201,768,360,120);
		
		btn1.setBorderPainted(false);
		btn2.setBorderPainted(false);
		btn3.setBorderPainted(false);
		
		btn1.setContentAreaFilled(false);
		btn2.setContentAreaFilled(false);
		btn3.setContentAreaFilled(false);
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					new Login(mf);	
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Join(mf);
			}
		});
		
		
		btn3.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Finish(mf);
			}
		});
		
		//메인 배경 (로그인 첫 페이지)
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\mainpage2.png").getImage().getScaledInstance(1408,896, 0)));
		label.setBounds(0, 0, 1408,896);
		
		this.add(label);
		
	}
	
	
}
