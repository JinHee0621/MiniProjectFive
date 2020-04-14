package com.kh.mini.model.gameObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.mini.controller.JoinManager;
import com.kh.mini.controller.KeyManager;
import com.kh.mini.view.GameWindow;
import com.kh.mini.view.ResultPrinter;

public class LoginScene extends BaseScene implements FocusListener{

	
	GameWindow gw;
	PointerInfo pointerInfo;
	
	JTextField tid;
	JPasswordField tpw;
	
	JPanel panel;
	
	public LoginScene(GameWindow gw) {
		this.gw = gw;
	}
	
	@Override
	public void init() {
		
		gw.setSize(850,350);
		gw.setTitle("�α���");
		gw.setResizable(false);
		gw.setLocationRelativeTo(null);
		gw.setLayout(null);
		
		panel = new JPanel();
		panel.setSize(850, 350);
		panel.setLayout(null);

		gw.add(panel);		
		tid = new JTextField();
		tid.setLocation(292, 153);
		tid.setSize(277, 42);
		panel.add(tid);
		tid.setOpaque(false);
		tid.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tid.setFont(new Font("Sanscerif", Font.PLAIN, 30));

		tpw = new JPasswordField();
		tpw.setLocation(292, 237);
		tpw.setSize(277, 42);
		panel.add(tpw);
		tpw.setOpaque(false);
		tpw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tpw.setFont(new Font("Sanscerif", Font.PLAIN, 50));
		
		
		JLabel btn= new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\loggin.png").getImage().getScaledInstance(185, 65, 0)));
		btn.setBackground(Color.WHITE);
		btn.setLocation(600, 150);
		btn.setSize(185, 65);
		
		panel.add(btn);
		
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\login_pop.png").getImage().getScaledInstance(850, 350, 0)));
		label.setBounds(0, 0, 850, 350);
		panel.add(label);
		
		panel.repaint();
		
		//�̹����� �ʱ�ȭ �ϰ� ��ġ�� ���Ѵ�.
	}

	@Override
	public void release() {
		// ������
	}

	@Override
	public void update() {
		pointerInfo	= MouseInfo.getPointerInfo();
		//pointerInfo�� ���콺 Ŭ���� ��ġ ��ǥ�� ��´�.

		if (KeyManager.Instance().onceMouseClicked(MouseEvent.BUTTON1)) {
		
			if ((pointerInfo.getLocation().x >= 1150 && pointerInfo.getLocation().x <= 1280)
					&& (pointerInfo.getLocation().y >= 535 && pointerInfo.getLocation().y <= 590)) {
				//Ŭ���� ��ġ�� ���ǹ��� ��ġ�ϸ�
				//JoinManager���� ���̵�� ��й�ȣ�� ��ġ�ϴ��� Ȯ���Ѵ�.
				
				JoinManager jm = new JoinManager(gw);

				if ((tid.getText().equals("")) || (tpw.getText().equals(""))) {
					sound.sfxSelect("InputError");
					new ResultPrinter().checkList(); // ���� �ʿ�
					
				} else {
					sound.sfxSelect("ButtonClick1");
					jm.idPwCorrect(tid.getText(), tpw.getText());
					
					gw.addKeyListener(KeyManager.Instance());
					gw.addMouseListener(KeyManager.Instance());
				}				
				//���� ����� ����Ǳ�� ������ ȭ�� �ּ�ȭ �Ŀ� Ű���� �Է��� �ޱ� ������.
			}else {
				sound.sfxSelect("MouseClick1");
			}
		}
	}

	@Override
	public void render(Graphics g) {
		//�̹��� ���
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
