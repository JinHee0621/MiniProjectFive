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
import com.kh.mini.controller.SendMailManager;
import com.kh.mini.model.vo.UserInfo;

public class Join extends JFrame { //���콺 ������ �ؼ� ��ġ ����
   private JFrame mf;
   private JPanel panel;   
   SendMailManager sm = new SendMailManager();
   public Join(JFrame mf) {
      //������
      this.setSize(950,770);
      this.setTitle("During 14days");
      this.setResizable(false); //â ������ ���� ���ϰ� ��.
      this.setLocationRelativeTo(null);//â ��� �߰� �ϴ°�
      this.setLayout(null);

      //�����ϱ� ��ư
      JButton btn = new JButton(new ImageIcon("images\\titleImages\\jooin.png"));
      btn.setLocation(677,658);
      btn.setSize(200,70);
      btn.setContentAreaFilled(false);
      btn.setBorderPainted(false);
      this.add(btn);
      
      //������ȣ������ ��ư
      JButton numBtn = new JButton(new ImageIcon("images\\titleImages\\mailBtn.png"));
      numBtn.setLocation(677,560);
      numBtn.setSize(200,70);
      numBtn.setContentAreaFilled(false);
      numBtn.setBorderPainted(false);
      this.add(numBtn);
      
      //��� �̹���
      JLabel label = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\joinPop2.png").getImage().getScaledInstance(950,770, 0)));
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
      tid.setLocation(331,178);
      tid.setSize(277,43);
      panel.add(tid);
      tid.setOpaque(false);
      tid.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tid.setFont(new Font("Sanscerif", Font.PLAIN, 30));
      
      JPasswordField tpw = new JPasswordField();
      tpw.setLocation(331,277);
      tpw.setSize(277,43);
      panel.add(tpw);
      tpw.setOpaque(false);
      tpw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tpw.setFont(new Font("Sanscerif", Font.PLAIN, 30));

      JPasswordField tpwCheck = new JPasswordField();
      tpwCheck.setLocation(331,376);
      tpwCheck.setSize(277,43);
      panel.add(tpwCheck);
      tpwCheck.setOpaque(false);
      tpwCheck.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tpwCheck.setFont(new Font("Sanscerif", Font.PLAIN, 30));
      
      JTextField tname = new JTextField();
      tname.setLocation(331,474);
      tname.setSize(277,43);
      panel.add(tname);
      tname.setOpaque(false);
      tname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tname.setFont(new Font("Sanscerif", Font.PLAIN, 30));

      JTextField temail = new JTextField();
      temail.setLocation(332,574);
      temail.setSize(277,43);
      panel.add(temail);
      temail.setOpaque(false);
      temail.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      temail.setFont(new Font("Sanscerif", Font.PLAIN, 30));

      JTextField tkey = new JTextField();
      tkey.setLocation(332,674);
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

      
      
      //���ԿϷ� ��ư ������ txt���Ϸ� ������ ����
      btn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            
            //���̵� ���ڿ� ���� �ҹ��ڸ� �Է¹޴� ����.
            boolean flag1 = false;
            char[]carr1 = tid.getText().toCharArray();//���̵� �ѱ��ھ� �迭�� ����
            for(int i = 0; i < carr1.length; i++) {
               if(!((carr1[i] >= 'a' && carr1[i] <= 'z')||(carr1[i] >= '0' && carr1[i] <= '9'))) {                  
                  flag1 = true;
               }
            }
            
            //��й�ȣ ���ڿ� ���� �ҹ��ڸ� �Է¹޴� ����.
            boolean flag2 = false;
            char[]carr2 = tpw.getText().toCharArray();//���̵� �ѱ��ھ� �迭�� ����
            for(int i = 0; i < carr2.length; i++) {
               if(!((carr2[i] >= 'a' && carr2[i] <= 'z')||(carr2[i] >= '0' && carr2[i] <= '9'))) {
                  flag2 = true;
               }
            }
            
            JoinManager jm = new JoinManager();
            String id = tid.getText();
            if (jm.duplicateId(id) == 1) {
               new ResultPrinter().idDuplicate();
               return;
            } else if (!(tkey.getText().equals(sm.getKey()))) {
               new ResultPrinter().codeFail();
               
            } else if (tid.getText().equals("") || tpw.getText().equals("") || tname.getText().equals("")
                  || temail.getText().equals("") || tkey.getText().equals("")) {
               new ResultPrinter().checkList();
            } else if (flag1 == true) {
               new ResultPrinter().idEng();
            } else if (flag2 == true) {
               new ResultPrinter().pwEng();
            } else if (!(tpw.getText().equals(tpwCheck.getText()))) {
               new ResultPrinter().pwNotCorrect();
            } else {
               String pw = tpw.getText();
               String name = tname.getText();
               String email = temail.getText();
               String key = tkey.getText();
               int point = 0;
               UserInfo userinfo = new UserInfo(id,pw,name,email,key,point);
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