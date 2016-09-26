package cal;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{//����ʵ��Action�¼��������ӿ�
	  int flag=0;
	  double x;  //��������ĵ�1��������
	  String s=new String("");//��������ĵ�2��������
	  JPanel p1,p2,p3;
	  Label label;
	  JTextField text;
	  JButton bpoint,bclean,badd,bsbb,bmul,bdiv,beq;
	  JButton[] b=new JButton[10];
	
	  public Calculator(){ //���췽������ƽ���
	  super("My Calculator");//��������
		
   /*�ڹ��췽���н��н������*/
      p1=new JPanel();//�ı������ڵ�panel
	  p2=new JPanel();//���ְ�ť���ڵ�panel
	  p3=new JPanel();//��������ڵ�panel
	  setLayout(new FlowLayout());  //������������Ľ��沼��Ϊ��ʽ
	  p1.setLayout(new FlowLayout()); //�ı������
	  p2.setLayout(new GridLayout(4,3));  //�������ּ����Ϊ4x3�����񲼾�
	  p3.setLayout(new GridLayout(4,1)); //��������
	  label = new Label("������");
	  text = new JTextField(12);//��ʾ������̺ͽ�����ı���
	  bclean = new JButton("���");//����ı���İ�ť
	  add(label);
	  this.setVisible(true);
		
	/*���ı������հ�ť���ڵ�һ��panel��*/
      p1.add(text);
	  p1.add(bclean);
	  bclean.addActionListener(this);
               
		
	/*���������ְ�ť��"."��"="���ڵڶ���panel��*/
 	  for(int i=0;i<10;i++){
	    b[i]=new JButton(Integer.toString(i));
	    p2.add(b[i]);
	    b[i].addActionListener(this);  //Ϊ���ְ�ťb[i]ע�������
		}
      bpoint=new JButton(".");//С���㰴ť
	  beq=new JButton("=");//�ȺŰ�ť
	  p2.add(bpoint);
	  p2.add(beq);
	  bpoint.addActionListener(this);
      beq.addActionListener(this);
       
      	/*��������Ű�ť���ڵ�����panel��*/
      badd=new JButton("+");//�ӷ���ť
      bsbb=new JButton("-");//������ť
      bmul=new JButton("*");//�˷���ť
      bdiv=new JButton("/");//������ť
      p3.add(badd);
	  p3.add(bsbb);
	  p3.add(bmul);
	  p3.add(bdiv);
	 	
    /*Ϊ�������ťע�������*/
	  badd.addActionListener(this);
	  bsbb.addActionListener(this);
	  bmul.addActionListener(this);
	  bdiv.addActionListener(this);
	  add(p1);
	  add(p2);
	  add(p3);
	  add(new Label(""));
	  }           
      /*���췽��������������ƽ���*/
	
public void actionPerformed(ActionEvent e){   //���а�ť��action�¼�������
	    
	/*����������ֻ�����С���㰴ť������¸���,�����ı�������ʾ*/
 	for(int i=0;i<10;i++){
        if(e.getSource() == bpoint|| e.getSource() == b[i]){ //�жϰ��µ��Ƿ�Ϊ���ְ�ť��С���㰴ť
        s=s+e.getActionCommand();//������������������,�����浽s
        text.setText(s);
        break;
	 }
	}
	
	/*�ж�������Ű�ť�������ϱ�� */
     	if(e.getSource()==badd){ // +��
            x=Double.parseDouble(s);//�����һ����������x 
            flag=1;//��������
            text.setText("+");
            s="";
        }
         if(e.getSource()==bsbb){// -��
            x=Double.parseDouble(s);
            flag=2;
            text.setText("-");
            s="";
        }
        if(e.getSource()==bmul){// *��
            x=Double.parseDouble(s);
            flag=3;
            text.setText("*");
            s="";
        }
        if(e.getSource()==bdiv){// /��
            x=Double.parseDouble(s);
            flag=4;
            text.setText("/");
            s="";
        }
        
	
        if(e.getSource()==bclean){//����ı���
            text.setText("");
            s="";
            flag=0;
        }

        /*����=�ţ����������*/
        if(e.getSource()==beq){
        switch(flag){
        case 1:{ //�ӷ������㷨
                x=Double.parseDouble(s)+x; //s����ڶ�������������x=s+x;
                s=String.valueOf(x);//��Doubleת��Ϊstring
                text.setText(s);
                break;
                }
        case 2:{  //���������㷨
              //����6. �ڴ��������������� 
                x=x-Double.parseDouble(s); //s����ڶ�������������x=x-s;
                s=String.valueOf(x);//��Doubleת��Ϊstring
                text.setText(s);
                break;

 }
                
		  case 3:{    //�˷�����
                //����7. �ڴ�����˷��������
                x=Double.parseDouble(s)*x; //s����ڶ�������������x=s*x;
                s=String.valueOf(x);//��Doubleת��Ϊstring
                text.setText(s);
                break;

}  
                
		  case 4:{     //��������
                if(Double.parseDouble(s)==0){
                text.setText("��������Ϊ0��");break;}
                x=x/Double.parseDouble(s);
                s=String.valueOf(x);
                text.setText(s);
                break;
                }
           }
          }
     }

     public static void main(String[] arg){
          Calculator cal=new Calculator();//
          cal.setVisible(true);
          cal.pack();
         
          //����8; ����ע��������Ĵ����¼�����������,��Ӧ���ڹرղ���
          cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}

