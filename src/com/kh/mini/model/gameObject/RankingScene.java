package com.kh.mini.model.gameObject;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.PointerInfo;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.mini.controller.PointManager;
import com.kh.mini.model.dao.JoinDao;
import com.kh.mini.model.vo.UserInfo;
import com.kh.mini.view.GameWindow;

public class RankingScene extends BaseScene {
   
   GameWindow gw;
   PointerInfo pointerInfo;

   JTextField tname1;
   JTextField tname2;
   JTextField tname3;
   JTextField tname4;
   JTextField tname5;
   JTextField tname6;

   JPanel panel;
   
   public RankingScene(GameWindow gw) {
      this.gw = gw;
   }

   @Override
   public void init() {
      
      //회원 정보를 포인트 기준으로 내림차순 하여 파일에 다시 저장한다.
         PointManager pm = new PointManager();
         pm.arrayListSort();

         //저장한 정보를 불러온다.
         ArrayList<UserInfo> list = new ArrayList<UserInfo>(); 
         JoinDao jd = new JoinDao();
         list = jd.fileOpen();

         //각 정보를 담을 배열.
         String[] name = new String[7]; 
         String[] id = new String[7]; 
         String[] point = new String[7];
         //1위부터 7위까지 정보
         //각각 이름배열, id배열, 포인트 배열에 순서대로 저장.

         if(list.size() < 7) {
            for(int i = 0; i < list.size() ; i++) {
               name[i] = list.get(i).getName();
               id[i] = list.get(i).getId();
               point[i] = Integer.toString(list.get(i).getPoint());
            }
            for(int i = list.size(); i < 7 ; i++) {
               name[i] = "";
               id[i] = "";
               point[i] = "";
            }
         }else {
            for(int i = 0; i < list.size() ; i++) {
               name[i] = list.get(i).getName();
               id[i] = list.get(i).getId();
               point[i] = Integer.toString(list.get(i).getPoint());
            }
         }
      
      //이미지를 초기화 하고 위치를 정한다.
      gw.setSize(950,770);
      gw.setTitle("Ranking");
      gw.setResizable(false);
      gw.setLocationRelativeTo(null);
      gw.setLayout(null);
      
      panel = new JPanel();
      panel.setSize(950, 770);
      panel.setLayout(null);
      gw.add(panel);   
      //---------------------------------------------------------
      JLabel rank1 = new JLabel("1");
      rank1.setBounds(75, 215, 100, 70);
      rank1.setFont(new Font("Sanscerif", Font.BOLD, 50));
      rank1.setHorizontalAlignment(JLabel.CENTER);
      panel.add(rank1);
      
      JLabel rank2 = new JLabel("2");
      rank2.setBounds(75, 290, 100, 70);
      rank2.setFont(new Font("Sanscerif", Font.BOLD, 50));
      rank2.setHorizontalAlignment(JLabel.CENTER);
      panel.add(rank2);
      
      JLabel rank3 = new JLabel("3");
      rank3.setBounds(75, 365, 100, 70);
      rank3.setFont(new Font("Sanscerif", Font.BOLD, 50));
      rank3.setHorizontalAlignment(JLabel.CENTER);
      panel.add(rank3);
      
      JLabel rank4 = new JLabel("4");
      rank4.setBounds(75, 440, 100, 70);
      rank4.setFont(new Font("Sanscerif", Font.BOLD, 50));
      rank4.setHorizontalAlignment(JLabel.CENTER);
      panel.add(rank4);
      
      JLabel rank5 = new JLabel("5");
      rank5.setBounds(75, 515, 100, 70);
      rank5.setFont(new Font("Sanscerif", Font.BOLD, 50));
      rank5.setHorizontalAlignment(JLabel.CENTER);
      panel.add(rank5);
      
      JLabel rank6 = new JLabel("6");
      rank6.setBounds(75, 590, 100, 70);
      rank6.setFont(new Font("Sanscerif", Font.BOLD, 50));
      rank6.setHorizontalAlignment(JLabel.CENTER);
      panel.add(rank6);
      
      JLabel rank7 = new JLabel("7");
      rank7.setBounds(75, 665, 100, 70);
      rank7.setFont(new Font("Sanscerif", Font.BOLD, 50));
      rank7.setHorizontalAlignment(JLabel.CENTER);
      panel.add(rank7);
      //----------------------------------------------------------------------------
      JLabel name1 = new JLabel(name[0]);
      name1.setBounds(275, 198, 200, 100);
      name1.setFont(new Font("Sanscerif", Font.BOLD, 40));
      name1.setHorizontalAlignment(JLabel.CENTER);
      panel.add(name1);
      
      JLabel name2 = new JLabel(name[1]);
      name2.setBounds(275, 273, 200, 100);
      name2.setFont(new Font("Sanscerif", Font.BOLD, 40));
      name2.setHorizontalAlignment(JLabel.CENTER);
      panel.add(name2);
      
      JLabel name3 = new JLabel(name[2]);
      name3.setBounds(275, 348, 200, 100);
      name3.setFont(new Font("Sanscerif", Font.BOLD, 40));
      name3.setHorizontalAlignment(JLabel.CENTER);
      panel.add(name3);
      
      JLabel name4 = new JLabel(name[3]);
      name4.setBounds(275, 423, 200, 100);
      name4.setFont(new Font("Sanscerif", Font.BOLD, 40));
      name4.setHorizontalAlignment(JLabel.CENTER);
      panel.add(name4);
      
      JLabel name5 = new JLabel(name[4]);
      name5.setBounds(275, 498, 200, 100);
      name5.setFont(new Font("Sanscerif", Font.BOLD, 40));
      name5.setHorizontalAlignment(JLabel.CENTER);
      panel.add(name5);
      
      JLabel name6 = new JLabel(name[5]);
      name6.setBounds(275, 573, 200, 100);
      name6.setFont(new Font("Sanscerif", Font.BOLD, 40));
      name6.setHorizontalAlignment(JLabel.CENTER);
      panel.add(name6);
      
      JLabel name7 = new JLabel(name[6]);
      name7.setBounds(275, 648, 200, 100);
      name7.setFont(new Font("Sanscerif", Font.BOLD, 40));
      name7.setHorizontalAlignment(JLabel.CENTER);
      panel.add(name7);
      //--------------------------------------------------------------
      JLabel id1 = new JLabel(id[0]);
      id1.setBounds(500, 198, 200, 100);
      id1.setFont(new Font("Sanscerif", Font.BOLD, 30));
      id1.setHorizontalAlignment(JLabel.CENTER);
      panel.add(id1);
      
      JLabel id2 = new JLabel(id[1]);
      id2.setBounds(500, 273, 200, 100);
      id2.setFont(new Font("Sanscerif", Font.BOLD, 30));
      id2.setHorizontalAlignment(JLabel.CENTER);
      panel.add(id2);
      
      JLabel id3 = new JLabel(id[2]);
      id3.setBounds(500, 348, 200, 100);
      id3.setFont(new Font("Sanscerif", Font.BOLD, 30));
      id3.setHorizontalAlignment(JLabel.CENTER);
      panel.add(id3);
      
      JLabel id4 = new JLabel(id[3]);
      id4.setBounds(500, 423, 200, 100);
      id4.setFont(new Font("Sanscerif", Font.BOLD, 30));
      id4.setHorizontalAlignment(JLabel.CENTER);
      panel.add(id4);
      
      JLabel id5 = new JLabel(id[4]);
      id5.setBounds(500, 498, 200, 100);
      id5.setFont(new Font("Sanscerif", Font.BOLD, 30));
      id5.setHorizontalAlignment(JLabel.CENTER);
      panel.add(id5);
      
      JLabel id6 = new JLabel(id[5]);
      id6.setBounds(500, 573, 200, 100);
      id6.setFont(new Font("Sanscerif", Font.BOLD, 30));
      id6.setHorizontalAlignment(JLabel.CENTER);
      panel.add(id6);
      
      JLabel id7 = new JLabel(id[6]);
      id7.setBounds(500, 648, 200, 100);
      id7.setFont(new Font("Sanscerif", Font.BOLD, 30));
      id7.setHorizontalAlignment(JLabel.CENTER);
      panel.add(id7);
      //--------------------------------------------------------
      JLabel point1 = new JLabel(point[0]);
      point1.setBounds(710, 198, 200, 100);
      point1.setFont(new Font("Sanscerif", Font.BOLD, 40));
      point1.setHorizontalAlignment(JLabel.CENTER);
      panel.add(point1);
      
      JLabel point2 = new JLabel(point[1]);
      point2.setBounds(710, 273, 200, 100);
      point2.setFont(new Font("Sanscerif", Font.BOLD, 40));
      point2.setHorizontalAlignment(JLabel.CENTER);
      panel.add(point2);
      
      JLabel point3 = new JLabel(point[2]);
      point3.setBounds(710, 348, 200, 100);
      point3.setFont(new Font("Sanscerif", Font.BOLD, 40));
      point3.setHorizontalAlignment(JLabel.CENTER);
      panel.add(point3);
      
      JLabel point4 = new JLabel(point[3]);
      point4.setBounds(710, 423, 200, 100);
      point4.setFont(new Font("Sanscerif", Font.BOLD, 40));
      point4.setHorizontalAlignment(JLabel.CENTER);
      panel.add(point4);
      
      JLabel point5 = new JLabel(point[4]);
      point5.setBounds(710, 498, 200, 100);
      point5.setFont(new Font("Sanscerif", Font.BOLD, 40));
      point5.setHorizontalAlignment(JLabel.CENTER);
      panel.add(point5);
      
      JLabel point6 = new JLabel(point[5]);
      point6.setBounds(710, 573, 200, 100);
      point6.setFont(new Font("Sanscerif", Font.BOLD, 40));
      point6.setHorizontalAlignment(JLabel.CENTER);
      panel.add(point6);
      
      JLabel point7 = new JLabel(point[6]);
      point7.setBounds(710, 648, 200, 100);
      point7.setFont(new Font("Sanscerif", Font.BOLD, 40));
      point7.setHorizontalAlignment(JLabel.CENTER);
      panel.add(point7);
      
      JLabel bg = new JLabel(new ImageIcon(new ImageIcon("images\\titleImages\\ranking.png").getImage().getScaledInstance(950, 770, 0)));
      bg.setBounds(0, 0, 950, 770);
      panel.add(bg);
      panel.repaint();
      
      
   }
   

   @Override
   public void release() {

   }

   @Override
   public void update() {
      
   }

   @Override
   public void render(Graphics g) {

   }
   
}
