package cal;

//import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import javax.swing.border.LineBorder;


public class BankDeposit extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel a1,a2,a3,a4;
	JTextField b1,b2,b3,b4;
	JButton c1,c2,c3,c4;
	JTextArea text;
	JPanel p1,p2,p3,lp,lp1,lp2;
	
	public BankDeposit(){
		super("BankDeposit");
		setTitle("银行存款计算");
		//setSize(450,500);

		a1=new JLabel("存款本金");
		a1.setFont(new Font("微软雅黑",Font.BOLD,15));
		a2=new JLabel("银行利率");
		a2.setFont(new Font("微软雅黑",Font.BOLD,15));
		a3=new JLabel("存款年限");
		a3.setFont(new Font("微软雅黑",Font.BOLD,15));
		
		b1=new JTextField(10);
		b1.setFont(new Font("微软雅黑",Font.BOLD,15));
		b2=new JTextField(10);
		b2.setFont(new Font("微软雅黑",Font.BOLD,15));
		b3=new JTextField(10);
		b3.setFont(new Font("微软雅黑",Font.BOLD,15));
		//b4=new JTextField(10);
		c1=new JButton("复利");
		c1.setFont(new Font("微软雅黑",Font.BOLD,15));
		c1.setBounds(100, 10, 80, 30);
		c2=new JButton("清除");
		c2.setFont(new Font("微软雅黑",Font.BOLD,15));
		c2.setBounds(10, 50, 80, 30);
		c3=new JButton("返回");
		c3.setFont(new Font("微软雅黑",Font.BOLD,15));
		c3.setBounds(100, 50, 80, 30);
		c4=new JButton("单利");
		c4.setFont(new Font("微软雅黑",Font.BOLD,15));
		c4.setBounds(10, 10, 80, 30);

		text=new JTextArea();
		text.setFont(new Font("微软雅黑",Font.BOLD,15));

		setLayout(new FlowLayout());
		lp=new JPanel(new GridLayout(2,1));
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();


		p1.add(a1);
		p1.add(b1);
		p2.add(a2);
		p2.add(b2);
		p3.add(a3);
		p3.add(b3);
		lp2=new JPanel();
		lp2.setLayout(null);
		lp2.add(c4);
		lp2.add(c1);
		lp2.add(c2);
		lp2.add(c3);
		
		c1.addActionListener(this);
		c2.addActionListener(this);
		c3.addActionListener(this);
		c4.addActionListener(this);
		
		lp1=new JPanel(new GridLayout(3,1));
		
		lp1.add(p1);
		lp1.add(p2);
		lp1.add(p3);
		lp.add(lp1);
		lp.add(lp2);
		JScrollPane p=new JScrollPane(text);
		p.setPreferredSize(new Dimension(250,200));
		add(lp);
		add(p);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
    	setLocationRelativeTo(null);

	}
	
	public void actionPerformed(ActionEvent e){
		Object target = e.getSource();
		if(target==c1){//计算利率
			double principalf,amountf,ratef;
			int n;
			NumberFormat cf=NumberFormat.getCurrencyInstance();
			int year=1;
			principalf=Double.parseDouble(b1.getText());
			
			ratef=Double.parseDouble(b2.getText());
			
			n=Integer.parseInt(b3.getText());
			
			String output=String.valueOf(n)+"年复利计算结果如下:"+"\n";

			while(year<=n){
				amountf=principalf*Math.pow(1+ratef,year);
				output+=String.valueOf(year)+"\t"+cf.format(amountf)+"\n";
				year=year+1;
			}
			text.setText(output);
        }
		if(target==c4){//计算利率
			double principald,amountd,rated;
			int n;
			principald=Double.parseDouble(b1.getText());
			rated=Double.parseDouble(b2.getText());
			n=Integer.parseInt(b3.getText());
			amountd=principald*(1+rated*n);
			String output=String.valueOf(n)+"年单利计算结果为:"+amountd+"\n";

			text.setText(output);
        }
		if(target==c2){//清除文本框
			b1.setText("");
			b2.setText("");
			b3.setText("");
			text.setText("");
			
		}
		if(target==c3){//关闭本界面，返回主界面
			if (e.getSource() == c3){
				this.dispose();
	        	new Face2().setVisible(true);
			}
		}
	}
		
		
	
	
	public static void main(String[] args){
		BankDeposit bd = new BankDeposit();
		bd.setVisible(true);
		bd.setLocationRelativeTo(null);

	}
	
	

}
