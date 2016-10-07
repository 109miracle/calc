package cal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Face1 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
    JButton button1;
    JButton button2;
    JButton button3;
    JPanel panel3;
    JPanel panel4;
    JLabel label2;
    JButton button4;
    JButton button5;
    JButton button6;
    
    public Face1(){

    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLayout(null);
    	setTitle("У԰����");
    	label = new JLabel("У԰����",JLabel.CENTER);
    	label.setFont(new Font("΢���ź�",Font.BOLD,20));
    	label.setBounds(125, 20, 200, 40);
    	button1 = new JButton("GPA����ѧ�����");
    	button1.setFont(new Font("΢���ź�",Font.BOLD,15));
    	button1.setBounds(125, 75, 200, 40);
    	button2 = new JButton("��������ָ��BMI");
    	button2.setFont(new Font("΢���ź�",Font.BOLD,15));
    	button2.setBounds(125, 130, 200, 40);
    	button3 = new JButton("�����յ���ʱ������");
    	button3.setFont(new Font("΢���ź�",Font.BOLD,15));
    	button3.setBounds(125, 185, 200, 40);
    	button4 = new JButton("Random��ǩ");
    	button4.setFont(new Font("΢���ź�",Font.BOLD,15));
    	button4.setBounds(125, 240, 200, 40);
    	button5 = new JButton("����������");
    	button5.setFont(new Font("΢���ź�",Font.BOLD,15));
    	button5.setBounds(125, 350, 200, 40);
    	button6 = new JButton("���ɼ�����");
    	button6.setFont(new Font("΢���ź�",Font.BOLD,15));
    	button6.setBounds(125, 295, 200, 40);
    	
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	button3.addActionListener(this);
    	button4.addActionListener(this);
    	button5.addActionListener(this);
    	button6.addActionListener(this);
    	
    	add(label);
    	add(button1);
    	add(button2);
    	add(button3);
    	add(button4);
    	add(button6);
    	add(button5);
    	
    	setSize(450,500);
    	setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1){
        	new GPA().setVisible(true);
        	this.setVisible(false);
        }
        if (e.getSource() == button2){
            new BMI().setVisible(true);
            this.setVisible(false);
            }
        if (e.getSource() == button3){
            new DaysBetween().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == button4){
           
            	this.setVisible(false);
				try {
					new RandomTest().setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
        }
        if (e.getSource() == button5){
            new Home().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == button6){
            new bodyexam().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        Face1 f1 = new Face1();
        f1.setVisible(true);
    }

}
