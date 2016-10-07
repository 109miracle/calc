package cal;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExRate extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double x1,x2,y1,y2,z1,z2,z;
	String s,s1,s2,l,l1,l2;
	Label label,label1,label2,label3,label4,label5;
	JPanel p1,p2,p3;
	JTextField text1,text2,text3,text4,text5;
	JButton bcal,bclean,back;
	JButton[] b=new JButton[10];
	Font font =new Font("微软雅黑",Font.BOLD,15);
	
	public ExRate(){
		super("Exchange Rate");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		setLayout(new FlowLayout());
		p1.setLayout(new GridLayout(5,1,3,3));//文本框面板
		p2.setLayout(new GridLayout(5,1,3,3));//数字面板
		p3.setLayout(new GridLayout(3,1,3,3));
		label = new Label("Exchange Rate");
		label.setFont(font);
		add(label);
		
        label1 = new Label("人民币金额");
        label1.setFont(font);
        label2 = new Label("美元金额");
        label2.setFont(font);
        label3 = new Label("当前美元汇率");
        label3.setFont(font);
        label4 = new Label("英镑金额");
        label4.setFont(font);
        label5 = new Label("当前英镑汇率");
        label5.setFont(font);
        
		p1.add(label1);
		p1.add(label2);
		p1.add(label3);
		p1.add(label4);
		p1.add(label5);
		
		text1 = new JTextField(15);
		text1.setFont(font);
		text2 = new JTextField(15);
		text2.setFont(font);
		text3 = new JTextField(15);
		text3.setFont(font);
		text4 = new JTextField(15);
		text4.setFont(font);
		text5 = new JTextField(15);
		text5.setFont(font);
		p2.add(text1);
		p2.add(text2);
		p2.add(text3);
		p2.add(text4);
		p2.add(text5);
			
	    bcal = new JButton("开始计算");
	    bcal.setFont(font);
	    bclean = new JButton("结果重置");
	    bclean.setFont(font);
	    back = new JButton("返回");
	    back.setFont(font);
	    p3.add(bcal);
		p3.add(bclean);
		p3.add(back);
		bcal.addActionListener(this);
		bclean.addActionListener(this);
		back.addActionListener(this);
		
		add(p1);
		add(p2);
		add(p3);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
		setLocationRelativeTo(null);
		this.setVisible(true);
		}
	
	public void actionPerformed(ActionEvent e) {
		/*汇率转换*/		
		if(e.getSource()==bcal){
			s1 = text1.getText();
			s = httpGet("http://hq.sinajs.cn/?list=fx_susdcny");
			s = s.substring(32);
			String a[] = s.split("\\,");
			s = a[0];
			x1 = Double.valueOf(s1);
			z1 = Double.valueOf(s);
			
			l1 = text1.getText();
			l = httpGet("http://hq.sinajs.cn/list=GBP");
			l = l.substring(25);
			String b[] = l.split("\\,");
			l = b[0];
			x2 = Double.valueOf(l1);
			z2 = Double.valueOf(l);
			z = z1*z2;
			y1 = x1/z1;
			y2 = x1/z;
			s2 = String.valueOf(y1);
			text2.setText(s2);
			text3.setText(s);
			l2 = String.valueOf(y2);
			l = String.valueOf(z);
			l = l.substring(0,6);
			text4.setText(l2);
			text5.setText(l);
		}
		
		if(e.getSource()==bclean){//清空文本框
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");
            text5.setText("");
            x1 = 0; x2 = 0;
            y1 = 0; y2 = 0;
            z1 = 0; z2 = 0;
            
        }
		if(e.getSource()==back){
			this.dispose();
        	new Face2().setVisible(true);
        }
	}

	public static String httpGet(String url)
    {
        // 定义一个字符串用来存储网页内容
        String result = "";
        // 定义一个缓冲字符输入流
        BufferedReader in = null;
        try
        {
            // 将string转成url对象
            URL realUrl = new URL(url);
            // 初始化一个链接到那个url的连接
            URLConnection connection = realUrl.openConnection();
            // 开始实际的连接
            connection.connect();
            // 初始化 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            // 用来临时存储抓取到的每一行的数据
            String line;
            while ((line = in.readLine()) != null)
            {
                // 遍历抓取到的每一行并将其存储到result里面
                result += line;
            }
        } catch (Exception e)
        {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally来关闭输入流
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
            } catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
        return result;
    }
	public static void main(String[] args){
		new ExRate();//
 
        
		}
	



}
