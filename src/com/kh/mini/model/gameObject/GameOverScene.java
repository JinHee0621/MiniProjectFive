package com.kh.mini.model.gameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;

import com.kh.mini.controller.KeyManager;
import com.kh.mini.model.vo.ImageClass;
import com.kh.mini.view.Finish;
import com.kh.mini.view.GameWindow;
import com.kh.mini.view.Join;

public class GameOverScene extends BaseScene{

   ImageClass uiBackGround;

   ImageClass okButton;

   ImageClass whoEnemy;

   ImageClass howToImg;

   PointerInfo pointerInfo;

   GameWindow gw;

   int mobType;

   //�����Ģ���� 6����
   //prevention6�� �Ÿ� �α� �����Ģ --> �ΰ������� 6���� ����

   ImageClass prevention1;
   ImageClass prevention2;
   ImageClass prevention3;
   ImageClass prevention4;
   ImageClass prevention5;
   ImageClass prevention6;
   ImageClass mob1;
   ImageClass mob2;
   ImageClass mob3;
   ImageClass mob4;
   ImageClass mob5;
   ImageClass mob6;
   ImageClass mobboss;
   ImageClass npc; //99�� mobType! (�ȳ�����ũ npc)

   int no;

   public GameOverScene(GameWindow gw, int mobType) {
      this.gw = gw;
      this.mobType = mobType;
   }

   @Override
   public void init() {
      gw.setBackground(Color.BLACK);
      System.out.println("������ ���� Ÿ���� ���Ͱ� �÷��̾ �׿���!: " + mobType);
      uiBackGround = new ImageClass();
      uiBackGround.Init("images\\uiImages\\GameOverUI.png");
      uiBackGround.setIsOn(true);
      uiBackGround.setPosition(250 , 100);

      //      okButton = new ImageClass();
      //      okButton.Init("images\\titleImages\\login.png");
      //      okButton.setIsOn(true);
      //      okButton.setPosition(198, 465);



      if(mobType >= 1 && mobType <= 7) {//����
         //���ӿ����� �����ʿ� �����Ģȭ�����
         //�����Ģ�� �� 6���ε�,�����Ģ 6���� mobType 99�� �ȳ�����ũ npc ������ ���Ŷ� 1~5�� ���� ����.
         //1���� 5������ ���� �������� ���� �� no�� �־��� ()
         no = (int)(Math.random() * 5) + 1;
         System.out.println("��� �����Ģ �������� Ȯ�� : " + no);
         switch(mobType) {
         case 1 : 
            mob1 = new ImageClass();
            mob1.Init("images\\titleImages\\mop1.png");
            mob1.setIsOn(true);
            mob1.setPosition(370, 270);
            break;
         case 2 : 
            mob2 = new ImageClass();
            mob2.Init("images\\titleImages\\mop2.png");
            mob2.setIsOn(true);
            mob2.setPosition(370, 270);
            break;
         case 3 : 
            mob3 = new ImageClass();
            mob3.Init("images\\titleImages\\mop3.png");
            mob3.setIsOn(true);
            mob3.setPosition(370, 270);
            break;
         case 4 : 
            mob4 = new ImageClass();
            mob4.Init("images\\titleImages\\mop4.png");
            mob4.setIsOn(true);
            mob4.setPosition(370, 270);
            break;
         case 5 : 
            mob5 = new ImageClass();
            mob5.Init("images\\titleImages\\mop5.png");
            mob5.setIsOn(true);
            mob5.setPosition(370, 270);
            break;
         case 6 :   
            mob6 = new ImageClass();
            mob6.Init("images\\titleImages\\mop6.png");
            mob6.setIsOn(true);
            mob6.setPosition(370, 270);
         case 7 : 
            mobboss = new ImageClass();
            mobboss.Init("images\\titleImages\\mop7.png");
            mobboss.setIsOn(true);
            mobboss.setPosition(370, 270);
            break;
         }

         switch(no) {
         case 1 : 
            prevention1 = new ImageClass();
            prevention1.Init("images\\titleImages\\prevention1.png");
            prevention1.setIsOn(true);
            prevention1.setPosition(780, 380);
            break;
         case 2 :
            prevention2 = new ImageClass();
            prevention2.Init("images\\titleImages\\prevention2.png");
            prevention2.setIsOn(true);
            prevention2.setPosition(780, 380);
            break;
         case 3 :
            prevention3 = new ImageClass();
            prevention3.Init("images\\titleImages\\prevention3.png");
            prevention3.setIsOn(true);
            prevention3.setPosition(780, 380);
            break;
         case 4 :
            prevention4 = new ImageClass();
            prevention4.Init("images\\titleImages\\prevention4.png");
            prevention4.setIsOn(true);
            prevention4.setPosition(780, 380);
            break;
         case 5 :
            prevention5 = new ImageClass();
            prevention5.Init("images\\titleImages\\prevention5.png");
            prevention5.setIsOn(true);
            prevention5.setPosition(780, 380);
            break;
         }
      }else {
    	  npc = new ImageClass();
    	  npc.Init("images\\titleImages\\npctwo.png");
    	  npc.setIsOn(true);
    	  npc.setPosition(370, 270);



         prevention6 = new ImageClass();
         prevention6.Init("images\\titleImages\\prevention6.png");
         prevention6.setIsOn(true);
         prevention6.setPosition(780, 380);
      }



   }

   @Override
   public void release() {
      // TODO Auto-generated method stub

   }

   @Override
   public void update() {
      pointerInfo   = MouseInfo.getPointerInfo();
      //���콺 Ŭ����ǥ�� ��´�.      
      if(KeyManager.Instance().onceMouseClicked(MouseEvent.BUTTON1)) {   
         System.out.println(pointerInfo.getLocation());
         sound.sfxSelect("MouseClick1");
      }
   }

   @Override
   public void render(Graphics g) {
      uiBackGround.render(g);
      switch(no) {
      case 1 : prevention1.render(g); break;
      case 2 : prevention2.render(g); break;
      case 3 : prevention3.render(g); break;
      case 4 : prevention4.render(g); break;
      case 5 : prevention5.render(g); break;
      }

      switch(mobType) {
      case 1 : mob1.render(g); break;
      case 2 : mob2.render(g); break;
      case 3 : mob3.render(g); break;
      case 4 : mob4.render(g); break;
      case 5 : mob5.render(g); break;
      case 6 : mob6.render(g); break;
      case 7 : mobboss.render(g); break;
      case 99 : npc.render(g); break;
      }


   }

}