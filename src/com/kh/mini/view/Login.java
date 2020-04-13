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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.mini.controller.JoinManager;

public class Login extends JFrame {

	//이 클래스는 사용하지 않았습니다.
	
	private JFrame mf;
	private JPanel panel;

	public Login(JFrame mf) {
		this.setSize(850,350);
		this.setTitle("로그인");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		JButton btn = new JButton(new ImageIcon("images\\titleImages\\loggin.png"));
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setLocation(615, 223);
		btn.setSize(185, 65);
		this.add(btn);

		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\login_pop.png").getImage().getScaledInstance(850, 350, 0)));
		label.setBounds(0, 0, 850, 350);
		this.add(label);

		JPanel panel = new JPanel();
		panel.setSize(850, 350);
		panel.setLayout(null);


		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.add(panel);

		JTextField tid = new JTextField();
		tid.setLocation(292, 153);
		tid.setSize(277, 42);
		panel.add(tid);
		tid.setOpaque(false);
		tid.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tid.setFont(new Font("Sanscerif", Font.PLAIN, 30));

		JPasswordField tpw = new JPasswordField();
		tpw.setLocation(292, 237);
		tpw.setSize(277, 42);
		panel.add(tpw);
		tpw.setOpaque(false);
		tpw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tpw.setFont(new Font("Sanscerif", Font.PLAIN, 50));

		//로그인 확인 버튼
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JoinManager jm = new JoinManager(null);

				if(tid.getText() == "" || tpw.getText() == "") {	
					new ResultPrinter().checkList();	//수정 필요
				}else {
					jm.idPwCorrect(tid.getText(), tpw.getText());
					setVisible(false);
				}
			}			
		});
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}










