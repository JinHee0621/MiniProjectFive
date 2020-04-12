package com.kh.mini.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultPrinter extends JFrame{

	public ResultPrinter() {
		this.setSize(500,235);
		this.setResizable(false); //â ������ ���� ���ϰ� ��.
		this.setLocationRelativeTo(null);//â ��� �߰� �ϴ°�
		this.setLayout(null);
		this.setVisible(true);//������ ������ �ȶ�.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ֵܼ� ���߰� ��.
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

}
