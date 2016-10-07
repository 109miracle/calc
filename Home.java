package cal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JLabel label,label1;

    private JButton button1;

    private JButton button2;

    private JButton button3;

    JPanel panel3;

    JPanel panel4;

    JLabel label2;

    JButton button4;

    JButton button5;

    public Home() {

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        ImageIcon image = new ImageIcon("E:\\wechat\\pikaqiu.jpg");//图片路径
        label1 = new JLabel(image);
        label = new JLabel("Welcome!");
        label.setFont(new Font("微软雅黑",Font.BOLD,20));
        
        button1 = new JButton("基础计算");
        button1.setFont(new Font("微软雅黑",Font.BOLD,15));
        button2 = new JButton("校园生活");
        button2.setFont(new Font("微软雅黑",Font.BOLD,15));
        button3 = new JButton("金融理财");
        button3.setFont(new Font("微软雅黑",Font.BOLD,15));

        button1.addActionListener(this);//增加监听器
        button2.addActionListener(this);
        button3.addActionListener(this);


        panel1.add(label);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
     
        Container myCP = getContentPane();//将组件加入到内容面板中
        setLayout(new BorderLayout(5,5)); 
        myCP.add(panel1, BorderLayout.NORTH);
        myCP.add(panel2, BorderLayout.SOUTH);
        myCP.add(label1, BorderLayout.CENTER);
        
        setTitle("miracle calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 500);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1){
        	new Calculator2().setVisible(true);
        	this.setVisible(false);
        }
        if (e.getSource() == button2){
            new Face1().setVisible(true);
            this.setVisible(false);
            }
        if (e.getSource() == button3){
            new Face2().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        Home home = new Home();
        home.setVisible(true);

    }
}