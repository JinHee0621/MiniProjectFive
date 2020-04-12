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
import com.kh.mini.model.vo.UserInfo;

public class Join extends JFrame { //���콺 ������ �ؼ� ��ġ ����
	private JFrame mf;
	private JPanel panel;	

	public Join(JFrame mf) {
		//������
		this.setSize(950,770);
		this.setTitle("During 14days");
		this.setResizable(false); //â ������ ���� ���ϰ� ��.
		this.setLocationRelativeTo(null);//â ��� �߰� �ϴ°�
		this.setLayout(null);

		//��ư
		JButton btn = new JButton(new ImageIcon("images\\titleImages\\jooin.png"));
		btn.setLocation(674,620);
		btn.setSize(200,70);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		this.add(btn);
		
		//������ȣ������ ��ư
		JButton numBtn = new JButton("������ȣ ����");
		numBtn.setLocation(624,520);
		numBtn.setSize(200,70);
		numBtn.setContentAreaFilled(false);
		numBtn.setBorderPainted(false);
		this.add(numBtn);
		
		//��� �̹���
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
		tid.setFont(new Font("Sanscerif", Font.PLAIN, 30));

		JTextField tname = new JTextField();
		tname.setLocation(331,429);
		tname.setSize(277,43);
		panel.add(tname);
		tname.setOpaque(false);
		tname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tid.setFont(new Font("Sanscerif", Font.PLAIN, 30));

		JTextField temail = new JTextField();
		temail.setLocation(331,532);
		temail.setSize(277,43);
		panel.add(temail);
		temail.setOpaque(false);
		temail.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tid.setFont(new Font("Sanscerif", Font.PLAIN, 30));

		JTextField tkey = new JTextField();
		tkey.setLocation(331,632);
		tkey.setSize(277,43);
		panel.add(tkey);
		tkey.setOpaque(false);
		tkey.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tid.setFont(new Font("Sanscerif", Font.PLAIN, 30));

		numBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				System.out.println("������ȣ�� �����մϴ�.");
			}
		});
		
		//���ԿϷ� ��ư ������ txt���Ϸ� ������ ����
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JoinManager jm = new JoinManager();
				String id = tid.getText();
				if(jm.duplicateId(id) == 1) {
					new ResultPrinter().idDuplicate();
					return;
				} else if (tid.getText().equals("") || tpw.getText().equals("") || tname.getText().equals("")
						|| temail.getText().equals("") || tkey.getText().equals("")) {
					new ResultPrinter().checkList();
				} else {
					String pw = tpw.getText();
					String name = tname.getText();
					String email = temail.getText();
					String key = tkey.getText();
					UserInfo userinfo = new UserInfo(id,pw,name,email,key);
					jm.insertMember(userinfo);
					new ResultPrinter().joinSuccess();//�̰� �ٽ� ���ֱ�
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setVisible(false);
				}
			}
		});
		
		this.setVisible(true);//������ ������ �ȶ�.
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

}
