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


public class BankDeposit extends JFrame {
	JLabel a1,a2,a3,a4;
	JTextField b1,b2,b3,b4;
	JButton c1,c2,c3;
	JTextArea text;
	JPanel p1,p2,p3,p4,p5,lp;
	
	public BankDeposit(){
		creatComponents();
		layoutComponents();
		registerHandlers();
		setTitle("复利存款计算");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		}
	private void creatComponents(){
		a1=new JLabel("存款本金");
		a1.setFont(new Font("宋体",Font.BOLD,18));
		a2=new JLabel("复利利率");
		a2.setFont(new Font("宋体",Font.BOLD,18));
		a3=new JLabel("存款年限");
		a3.setFont(new Font("宋体",Font.BOLD,18));
		a4=new JLabel("单利利率");
		a4.setFont(new Font("宋体",Font.BOLD,18));
		
		
		b1=new JTextField(10);
		b2=new JTextField(10);
		b3=new JTextField(10);
		b4=new JTextField(10);
		c1=new JButton("计算");
		c1.setFont(new Font("宋体",Font.BOLD,15));
		c2=new JButton("清除");
		c2.setFont(new Font("宋体",Font.BOLD,15));
		//c3=new JButton("单利计算");
		//c3.setFont(new Font("宋体",Font.BOLD,15));
		/*c3.setBackground(Color.GRAY);
		c3.setBorder(new LineBorder(Color.BLACK,3));
		c3.setForeground(Color.BLACK);*/
		text=new JTextArea();
		}
	
	private void layoutComponents(){
		setLayout(new FlowLayout());
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p1.add(a1);
		p1.add(b1);
		p5.add(a4);
		p5.add(b4);
		p2.add(a2);
		p2.add(b2);
		p3.add(a3);
		p3.add(b3);
		p4.add(c1);
		//p4.add(c3);
		p4.add(c2);
		lp=new JPanel(new GridLayout(5,1));
		lp.add(p1);
		lp.add(p5);
		lp.add(p2);
		lp.add(p3);
		lp.add(p4);
		JScrollPane p=new JScrollPane(text);
		p.setPreferredSize(new Dimension(250,200));
		add(lp);
		add(p);
	}
	private void registerHandlers(){
		c1ActionEventHander hander1=new c1ActionEventHander();
		c1.addActionListener(hander1);
		c2ActionEventHander hander2=new c2ActionEventHander();
		c2.addActionListener(hander2);
		//c3ActionEventHander hander3=new c3ActionEventHander();
		//c3.addActionListener(hander3);
		
	}
	private class c1ActionEventHander implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double principalf,amountf,ratef,principald,amountd,rated;
			int n;
			NumberFormat cf=NumberFormat.getCurrencyInstance();
			int year=1;
			principalf=Double.parseDouble(b1.getText());
			principald=Double.parseDouble(b1.getText());
			ratef=Double.parseDouble(b2.getText());
			rated=Double.parseDouble(b4.getText());
			n=Integer.parseInt(b3.getText());
			
			amountd=principald*(1+rated*n);
			String output=String.valueOf(n)+"年单利计算结果为  "+cf.format(amountd)+"\n\n"+String.valueOf(n)+"年复利计算结果如下:"+"\n";

			while(year<=n){
				amountf=principalf*Math.pow(1+ratef,year);
				output+=String.valueOf(year)+"\t"+cf.format(amountf)+"\n";
				year=year+1;
			}
			text.setText(output);
		}
	}
	private class c2ActionEventHander implements ActionListener{
		public void actionPerformed(ActionEvent e){
			b1.setText("");
			b2.setText("");
			b3.setText("");
			text.setText("");
			
		}
	}
	
	public static void main(String[] args){
		BankDeposit bd = new BankDeposit();
		bd.setVisible(true);
		bd.setSize(500,300);
	}
	
	

}
