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

public class Finish extends JFrame{
	
	private JFrame mf;
	private JPanel panel;
	
	public Finish(JFrame mf) {
		this.setSize(400,215);
		this.setTitle("During 14Days");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		JButton yes = new JButton(new ImageIcon("images\\titleImages\\yes.png"));
		yes.setContentAreaFilled(false);
		yes.setBorderPainted(false);
		yes.setLocation(70, 100);
		yes.setSize(120, 50);
		this.add(yes);
		
		JButton no = new JButton(new ImageIcon("images\\titleImages\\no.png"));
		no.setContentAreaFilled(false);
		no.setBorderPainted(false);
		no.setLocation(200, 100);
		no.setSize(120, 50);
		this.add(no);
		
		yes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		no.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);
			}
		});
		
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\askFinish.png").getImage().getScaledInstance(400, 200, 0)));
		label.setBounds(0, 0, 400, 200);
		this.add(label);

		JPanel panel = new JPanel();
		panel.setSize(400, 200);
		panel.setLayout(null);
		
		try {
			this.setIconImage(ImageIO.read(new File("images\\titleImages\\monsterLogo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.add(panel);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
