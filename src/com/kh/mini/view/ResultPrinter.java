package com.kh.mini.view;

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

public class ResultPrinter extends JFrame{

	public ResultPrinter() {
		this.setSize(500,235);
		this.setResizable(false); //창 사이즈 조절 못하게 함.
		this.setLocationRelativeTo(null);//창 가운데 뜨게 하는것
		this.setLayout(null);
		this.setVisible(true);//없으면 프레임 안뜸.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//콘솔도 멈추게 함.
	}

	public void logSuccess() {
		JButton btn = new JButton(new ImageIcon("images\\titleImages\\oh_yes.png"));
		btn.setLocation(160,110);
		btn.setSize(185,65);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		this.add(btn);

		//팝업 배경
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\login_success.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		btn.addActionListener(new ActionListener() {
			//확인버튼 누르면 우선 팝업 프레임 안보이게 해야함.

			@Override
			public void actionPerformed(ActionEvent e) {
				//게임 실행
				dispose();
				System.out.println("게임실행");
			}
		});
	}

	public void logFail() {
		//gw.startLogin();
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\login_fail.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		this.repaint();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void joinSuccess() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\join_success.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		this.repaint();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void idDuplicate() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\idDuplicate.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void checkList() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\checkList.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		this.repaint();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void emailSuccess() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\email_success.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void codeFail() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\code_fail.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void idEng() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\id_eng.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void pwEng() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\pw_eng.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pwNotCorrect() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\pwNotCorrect.png")
				.getImage().getScaledInstance(500, 200, 0)));
		label.setBounds(0,0,500,200);
		this.add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
