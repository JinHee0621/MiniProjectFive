package com.kh.mini.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
		  JButton btn = new JButton(new ImageIcon("images\\titleImages\\oh_yes.png"));
	      btn.setLocation(160,110);
	      btn.setSize(185,65);
	      btn.setContentAreaFilled(false);
	      btn.setBorderPainted(false);
	      this.add(btn);
	      
	      //�˾� ���
	      JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\login_success.png")
	            .getImage().getScaledInstance(500,200, 0)));
	      label.setBounds(0, 0,500,200);
	      this.add(label);
	      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      
	      btn.addActionListener(new ActionListener() {
	         //Ȯ�ι�ư ������ �켱 �˾� ������ �Ⱥ��̰� �ؾ���.

	         @Override
	         public void actionPerformed(ActionEvent e) {
	            //���� ����
	        	 dispose();
	        	 System.out.println("���ӽ���");
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
	}
	
	public void joinSuccess() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\join_success.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		this.repaint();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void idDuplicate() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\idDuplicate.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void checkList() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\checkList.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		this.repaint();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void emailSuccess() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\email_success.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void codeFail() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\code_fail.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void idEng() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\id_eng.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void pwEng() {
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\pw_eng.png")
				.getImage().getScaledInstance(500,200, 0)));
		label.setBounds(0, 0,500,200);
		this.add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	   public void pwNotCorrect() {
		      JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\pwNotCorrect.png")
		            .getImage().getScaledInstance(500, 200, 0)));
		      label.setBounds(0,0,500,200);
		      this.add(label);
		      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   }
}
