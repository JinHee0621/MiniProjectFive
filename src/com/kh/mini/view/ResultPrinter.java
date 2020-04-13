package com.kh.mini.view;

import javax.swing.ImageIcon;
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
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\login_success.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		JPanel panel = new JPanel();
		this.add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void logFail() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\login_fail.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		JPanel panel = new JPanel();
		this.add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void joinSuccess() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\join_success.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		JPanel panel = new JPanel();
		this.add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void idDuplicate() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\idDuplicate.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		JPanel panel = new JPanel();
		this.add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void checkList() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\checkList.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		JPanel panel = new JPanel();
		this.add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void emailSuccess() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\email_success.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		JPanel panel = new JPanel();
		this.add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void codeFail() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\code_fail.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		JPanel panel = new JPanel();
		this.add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void idEng() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\id_eng.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		JPanel panel = new JPanel();
		this.add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void pwEng() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\id_eng.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		JPanel panel = new JPanel();
		this.add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void pwNotCorrect() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\pwNotCorrect.png")
				.getImage().getScaledInstance(500, 200, 0)));
		label.setBounds(0,0,500,200);
		this.add(label);
		JPanel panel = new JPanel();
		this.add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
