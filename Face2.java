package cal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Face2 extends JFrame implements ActionListener{
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
    
    public Face2(){
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setTitle("金融理财");
    	setLayout(null);
    	label = new JLabel("金融理财",JLabel.CENTER);
    	label.setFont(new Font("微软雅黑",Font.BOLD,20));
    	label.setBounds(125, 30, 200, 50);
    	button1 = new JButton("实时汇率换算");
    	button1.setFont(new Font("微软雅黑",Font.BOLD,15));
    	button1.setBounds(125, 110, 200, 50);
    	button2 = new JButton("银行存款利率计算");
    	button2.setFont(new Font("微软雅黑",Font.BOLD,15));
    	button2.setBounds(125, 190, 200, 50);
    	button3 = new JButton("返回主界面");
    	button3.setFont(new Font("微软雅黑",Font.BOLD,15));
    	button3.setBounds(125, 270, 200, 50);
    	
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	button3.addActionListener(this);
   
    	add(label);
    	add(button1);
    	add(button2);
    	add(button3);
    	
    	setSize(450,500);
    	setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1){
        	new ExRate().setVisible(true);
        	this.setVisible(false);
        }
        if (e.getSource() == button2){
            new BankDeposit().setVisible(true);
            this.setVisible(false);
            }
        if (e.getSource() == button3){
            new Home().setVisible(true);
            this.setVisible(false);
        }
 
    }
    
    public static void main(String[] args) {
        Face2 f2 = new Face2();
        f2.setVisible(true);
    }

}
