package cal;
 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
 
@SuppressWarnings("serial")
public class bodyexam extends JFrame implements ActionListener{
	DecimalFormat dformat = new DecimalFormat("#.00");
	private JLabel BMIlb;
    private JLabel lunglb;
    private JLabel shortRunlb;
    private JLabel crooklb;
    private JLabel situplb;
    private JLabel longRunlb;
    private JLabel jumplb;
    private JLabel resultlb;

    private JButton btnRun,back;
    private JTextField BMItxt;
    private JTextField lungtxt;
    private JTextField shortRuntxt;
    private JTextField crooktxt;
    private JTextField situptxt;
    private JTextField longRuntxt;
    private JTextField jumptxt;
    private JTextField resulttxt;
    private JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7,mainPnl;
    private JTabbedPane tp;
    Font font =new Font("微软雅黑",Font.BOLD,15);
 
    public bodyexam()
    { 
    	setTitle("体测成绩计算");
      
       //创建JTabbedPane
       tp = new JTabbedPane(JTabbedPane.TOP);
       int width = 480;
       int height = 700;
      
       //创建第一个标签下的label
       //指定标签名，标签图标，panel，和提示信息
       panel1 = createPanel("panel1");
       ImageIcon i1= createImageIcon("E:\\eclipse\\workplace\\cal\\src\\BMI.jpg"); 
       i1.setImage(i1.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
       JLabel label1 = new JLabel(i1);
       panel1.add(label1);
       tp.addTab("BMI",panel1);
       //设置标签的快捷键
       tp.setMnemonicAt(0, KeyEvent.VK_1); 
       
       //第二个标签
       panel3 = createPanel("panel3");
       ImageIcon i3= createImageIcon("E:\\eclipse\\workplace\\cal\\src\\Lung.jpg"); 
       i3.setImage(i3.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
       JLabel label3 = new JLabel(i3);
       panel3.add(label3);
       tp.addTab("Lung",panel3);
       tp.setMnemonicAt(0, KeyEvent.VK_3);
       
       //第三个标签
       panel2 = createPanel("panel2");
       ImageIcon i2= createImageIcon("E:\\eclipse\\workplace\\cal\\src\\shortRun.jpg"); 
       i2.setImage(i2.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
       JLabel label2 = new JLabel(i2);
       panel2.add(label2);
       tp.addTab("shortRun",panel2);
       tp.setMnemonicAt(0, KeyEvent.VK_2);
 
       panel7 = createPanel("panel7");
       ImageIcon i7= createImageIcon("E:\\eclipse\\workplace\\cal\\src\\crook.jpg"); 
       i7.setImage(i7.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
       JLabel label7 = new JLabel(i7);
       panel7.add(label7);
       tp.addTab("crook",panel7);
       tp.setMnemonicAt(0, KeyEvent.VK_7);
       
       panel6 = createPanel("panel6");
       ImageIcon i6= createImageIcon("E:\\eclipse\\workplace\\cal\\src\\Jump.jpg"); 
       i6.setImage(i6.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
       JLabel label6 = new JLabel(i6);
       panel6.add(label6);
       tp.addTab("Jump",panel6);
       tp.setMnemonicAt(0, KeyEvent.VK_6);
       
       panel5 = createPanel("panel5");
       ImageIcon i5= createImageIcon("E:\\eclipse\\workplace\\cal\\src\\Situp.jpg"); 
       i5.setImage(i5.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
       JLabel label5 = new JLabel(i5);
       panel5.add(label5);
       tp.addTab("Situp",panel5);
       tp.setMnemonicAt(0, KeyEvent.VK_5);
       
       panel4 = createPanel("panel4");
       ImageIcon i4= createImageIcon("E:\\eclipse\\workplace\\cal\\src\\longRun.jpg"); 
       i4.setImage(i4.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
       JLabel label4 = new JLabel(i4);
       panel4.add(label4);
       tp.addTab("longRun",panel4);
       tp.setMnemonicAt(0, KeyEvent.VK_4);
       
       mainPnl = createPanel("mainPnl");
       BMIlb = new JLabel("体重指数(BMI)");
       BMIlb.setFont(font);
       lunglb = new JLabel("肺活量");
       lunglb.setFont(font);
       shortRunlb = new JLabel("50米跑");
       shortRunlb.setFont(font);
       crooklb = new JLabel("坐位体前屈");
       crooklb.setFont(font);
       jumplb = new JLabel("立定跳远");
       jumplb.setFont(font);
       situplb = new JLabel("引体向上(男)/仰卧起坐(女)");
       situplb.setFont(font);
       longRunlb = new JLabel("1000米跑(男)/800米跑(女)");
       longRunlb.setFont(font);
       resultlb = new JLabel("结果");
       resultlb.setFont(font);
       
       
       BMItxt = new JTextField(10);
       BMItxt.setFont(font);
       lungtxt = new JTextField(10);
       lungtxt.setFont(font);
       shortRuntxt = new JTextField(10);
       shortRuntxt.setFont(font);
       crooktxt = new JTextField(10);
       crooktxt.setFont(font);
       jumptxt = new JTextField(10);
       jumptxt.setFont(font);
       situptxt = new JTextField(10);
       situptxt.setFont(font);
       longRuntxt = new JTextField(10);
       longRuntxt.setFont(font);
       resulttxt = new JTextField(10);
       resulttxt.setFont(font);
       
       btnRun = new JButton("确认");
       btnRun.setFont(font);
       back = new JButton("返回");
       back.setFont(font);
       mainPnl.setLayout(null);
       BMIlb.setBounds(100, 50, 150, 25);
       BMItxt.setBounds(300, 50, 100, 25);
       lunglb.setBounds(100, 80, 150, 25);
       lungtxt.setBounds(300, 80, 100, 25);
       shortRunlb.setBounds(100, 110, 150, 25);
       shortRuntxt.setBounds(300, 110, 100, 25);   
       crooklb.setBounds(100, 140, 150, 25);
       crooktxt.setBounds(300, 140, 100, 25);
       jumplb.setBounds(100, 170, 150, 25);
       jumptxt.setBounds(300, 170, 100, 25);
       situplb.setBounds(100, 200, 200, 25);
       situptxt.setBounds(300, 200, 100, 25);
       longRunlb.setBounds(100, 230, 150, 25);
       longRuntxt.setBounds(300, 230, 100, 25);
       btnRun.setBounds(200, 280, 80, 25);
       resultlb.setBounds(100, 330, 150, 25);
       resulttxt.setBounds(300, 330, 100, 25);
       back.setBounds(200, 380, 80, 25);
       
       mainPnl.add(BMIlb);
       mainPnl.add(BMItxt);
       mainPnl.add(lunglb);
       mainPnl.add(lungtxt);
       mainPnl.add(shortRunlb);
       mainPnl.add(shortRuntxt);
       mainPnl.add(crooklb);
       mainPnl.add(crooktxt);
       mainPnl.add(jumplb);
       mainPnl.add(jumptxt);
       mainPnl.add(situplb);
       mainPnl.add(situptxt);
       mainPnl.add(longRunlb);
       mainPnl.add(longRuntxt);
       mainPnl.add(btnRun);
       mainPnl.add(resultlb);
       mainPnl.add(resulttxt);
       mainPnl.add(back);
       
       resulttxt.setEditable(false);
       tp.addTab("体测计算",mainPnl);
       tp.setMnemonicAt(0, KeyEvent.VK_6);
       
       
       btnRun.addActionListener(this);
       back.addActionListener(this);

       //设置合适的显示尺寸，这个是必须的，因为如果所有的标签都
       //不指定适合的显示尺寸，系统无法判断初始显示尺寸大小
       //默认是使用最小化，并且对一个标签设计即可
       tp.setPreferredSize(new Dimension(width,height));
       
 
       //将tabbedPanel添加到Jpanel中
       add(tp);
      
       //设置窗口过小时，标签的显示策略
       tp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
       //设置标签停放的位置，这里设置为左侧停放
       setLocation(700, 150);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       pack();
    }
    
    public void actionPerformed(ActionEvent e) {
               // TODO Auto-generated method stub
    	if(e.getSource() == back){
      	   new Face1().setVisible(true);
             this.setVisible(false);
         }
    	if(e.getSource() == btnRun){
    	if( BMItxt.getText() == null||lungtxt.getText() == null||shortRuntxt.getText() == null||
    			crooktxt.getText() == null||jumptxt.getText() == null||situptxt.getText() == null
    			||longRuntxt.getText() == null){
    		JOptionPane.showMessageDialog(null, "请填写所有的成绩，不能为空");
    		return;
    	}
    	double bmi = Double.valueOf(BMItxt.getText());
    	double lung = Double.valueOf(lungtxt.getText());
    	double shortRun = Double.valueOf(shortRuntxt.getText());
    	double crook = Double.valueOf(crooktxt.getText());
    	double jump = Double.valueOf(jumptxt.getText());
    	double situp = Double.valueOf(situptxt.getText());
    	double longRun = Double.valueOf(longRuntxt.getText());
               
    	double grade = 0.15*bmi + 0.15*lung + 0.2*shortRun + 0.1*crook 
    			+ 0.1*jump + 0.1*situp + 0.2*longRun;
    	resulttxt.setText(dformat.format(grade));
    	}
    	  
    }


   
   
   
    private JPanel createPanel(String string) {
       //创建一个JPanel，并为构造函数初始false
       //表示不适用双缓冲
       JPanel panel = new JPanel(false);
      
       //设置布局
       panel.setLayout(new GridLayout(1,1));
       return panel;
    }
 
 
 
    private ImageIcon createImageIcon(String url) {
       if(url == null)
       {
           System.out.println("the route "+url+" is not correct!");
           return null;
       }
       return new ImageIcon(url);
    }
 
   
    public static void main(String[] args) {
       new bodyexam();
    }
}