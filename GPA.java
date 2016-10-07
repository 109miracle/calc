package cal;

 import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.text.DecimalFormat;  
import java.util.StringTokenizer;  
  
import javax.swing.JFrame;
import javax.swing.JPanel;

  
public class GPA extends JFrame implements ActionListener  
{  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TextArea text1;  
    TextArea text2;  
    TextArea text3;
    TextArea text4;
    TextArea text5;
    TextArea text6;
    TextArea text7;
    TextArea text8;
    Label label1; 
    Label label2;
    Label label3;
    Label label4;
    Label label5;
    Label label6;
    Label label7;
    Label label8;
    Button button1;
    Button button2;
    Font font =new Font("微软雅黑",Font.BOLD,15); 
      
    public GPA()  
    { 
        setExtendedState(Frame.MAXIMIZED_VERT);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(450, 500);
        setLocationRelativeTo(null);
        setTitle("GPA和奖学金分数计算");  
 
        Container con = getContentPane(); 
        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        con.setLayout(new GridLayout(9,2));  
        pan1.setLayout(new FlowLayout());
        pan2.setLayout(new FlowLayout());
       
        label1 = new Label("请输入各学科绩点：");
        label1.setFont(font);
        label2 = new Label("请输入各学科学分：");
        label2.setFont(font);
        label3 = new Label("结果：");
        label3.setFont(font);
        label4 = new Label("请输入各学科成绩：");
        label4.setFont(font);
        label5 = new Label("请输入两个学期的体育成绩：");
        label5.setFont(font);
        label6 = new Label("请输入奖学金加分：");
        label6.setFont(font);
        label7 = new Label("请输入体育课学分：");
        label7.setFont(font);
        label8 = new Label("请输入德育分数：");
        label8.setFont(font);
        text1 = new TextArea();
        text1.setFont(font);
        text3 = new TextArea();
        text3.setFont(font);
        text4 = new TextArea();
        text4.setFont(font);
        text2 = new TextArea(); 
        text2.setFont(font);
        text5 = new TextArea();
        text5.setFont(font);
        text6 = new TextArea();
        text6.setFont(font);
        text7 = new TextArea();
        text7.setFont(font);
        text8 = new TextArea();
        text8.setFont(font);
        button1 = new Button("返回");
        button1.setFont(font);
        button2 = new Button("确认");
        button2.setFont(font);
    
        con.add(label1);
        con.add(text1); 
        con.add(label2);
        con.add(text3);
        con.add(label4);
        con.add(text4);
        con.add(label5);
        con.add(text5);
        con.add(label6);
        con.add(text6);
        con.add(label7);
        con.add(text7);
        con.add(label8);
        con.add(text8);
        con.add(label3);
        con.add(text2); 
        con.add(pan1);
        con.add(pan2);
        pan1.add(button2);
        pan2.add(button1);
        text2.setEditable(false);  
        button1.addActionListener(this);
        button2.addActionListener(this);
        setVisible(true);  
         
    }  
  
    public void actionPerformed(ActionEvent e) { 
    	if(e.getSource() == button2){
	        String s1 = text1.getText();  
	        StringTokenizer st1 = new StringTokenizer(s1, " ,'\n'");  
	        int n1 = st1.countTokens();  /*数输入了几个数*/
	        
	        
	        String s2 = text3.getText();
	        StringTokenizer st2 = new StringTokenizer(s2, " ,'\n'");  
	        int n2 = st2.countTokens();
	        
	        String s3 = text4.getText();
	        StringTokenizer st3 = new StringTokenizer(s3, " ,'\n'");  
	        int n3 = st3.countTokens();
	        
	        String s4 = text5.getText();
	        StringTokenizer st4 = new StringTokenizer(s4, " ,'\n'");  
	        int n4 = st4.countTokens();
	        
	        String s5 = text6.getText();
	        StringTokenizer st5 = new StringTokenizer(s5, " ,'\n'"); 
	        int n5 = st5.countTokens();
	        
	        String s6 = text7.getText();
	        StringTokenizer st6 = new StringTokenizer(s6, " ,'\n'"); 
	        int n6 = st6.countTokens();
	       
	        
	        String s7 = text8.getText();
	        StringTokenizer st7 = new StringTokenizer(s7, " ,'\n'"); 
	        int n7 = st7.countTokens();
	       
	        
	        double addResult = 0;
	        double addCredit = 0;
	        double aveResult = 0; 
	        double aveSport = 0;
	        double addMark = 0;
	        double aveMark = 0;
	        double annex = 0;
	        double sportCredit = 0;
	        double moralMark = 0;
	        
	        if(n1!= 0 && n1==n2 && n3==0 && n4==0 && n5==0 && n6==0 && n7==0)
	        {
	        	String a1[] = new String[n1];     
		        for(int i1 = 0; i1 <= n1 - 1; i1++)  
		        {  
		            String temp1 = st1.nextToken();  
		            a1[i1] = temp1; 
		        } 
		        
		        String a2[] = new String[n2];
		        
		        for(int i2 = 0;i2 <= n2 - 1; i2++)
			        {
			        	String temp2 = st2.nextToken();
			        	a2[i2] = temp2;
			        }
		        
	        	for(int j = 0; j < n1; j++)  
	            {  
	                addResult = addResult + Double.valueOf(a1[j]) * Double.valueOf(a2[j]);
	                addCredit = addCredit + Double.valueOf(a2[j]);
	            } 
	        	aveResult = addResult / addCredit;  
	        	text2.setText(null); 
	            text2.append(n1 + "门学科学分总和：" + addCredit + "\n"); 
	            DecimalFormat d = new DecimalFormat("#.00");   
	            text2.append("各科平均绩点：" + d.format(aveResult) + "\n"); 
	        }
	        else if(n1!=0 && n1==n2 && n1==n3 && n4==2 && n5==1 && n6==1 && n7==1)
	        {
	        	String a1[] = new String[n1]; 
	        	for(int i1 = 0; i1 <= n1 - 1; i1++)  
		        {  
		            String temp1 = st1.nextToken();  
		            a1[i1] = temp1; 
		        } 
		        
		        String a2[] = new String[n2];
		        for(int i2 = 0;i2 <= n2 - 1; i2++)
			        {
			        	String temp2 = st2.nextToken();
			        	a2[i2] = temp2;
			        }
		        
		        String a3[] = new String[n3];
		        for(int i3 = 0;i3 <= n3 - 1; i3++)
			        {
			        	String temp3 = st3.nextToken();
			        	a3[i3] = temp3;
			        }
		        
		        String a4[] = new String[n4];
		        for(int i4 = 0;i4 <= n4 - 1; i4++)
			        {
			        	String temp4 = st4.nextToken();
			        	a4[i4] = temp4;
			        }
		        
		        for(int j = 0; j < n1; j++)  
		        {  
		            addResult = addResult + Double.valueOf(a1[j]) * Double.valueOf(a2[j]);
		            addCredit = addCredit + Double.valueOf(a2[j]);
		            addMark = addMark + Double.valueOf(a3[j]) * Double.valueOf(a2[j]);
		        }  
		        String a5 = st5.nextToken();
		        String a6 = st6.nextToken();
		        String a7 = st7.nextToken();
		     
		        	sportCredit = Double.valueOf(a6);
		        	moralMark = Double.valueOf(a7);
		        	aveSport = (Double.valueOf(a4[0]) + Double.valueOf(a4[1])) / 2;
		        	annex = Double.valueOf(a5);
		            aveResult = addResult / addCredit;  
		            aveMark = (addMark - aveSport * 2 * sportCredit) / (addCredit - sportCredit*2) * 0.6 + aveSport * 0.1 + annex + moralMark;
		 
			       text2.setText(null); 
			       text2.append(n1 + "门学科学分总和： " + addCredit + "\n"); 
			       DecimalFormat d = new DecimalFormat("#.00");   
			       text2.append("各科平均绩点： " + d.format(aveResult) + "\n"); 
			       text2.append("最终平均成绩： " + d.format(aveMark) + "\n");
	    	}
	        else {
	    		text2.setText(null);
	    		text2.append("输入有误，请检查并重新输入");
	    	}
    	}
    	
    	if(e.getSource() == button1){
    		new Face1().setVisible(true);
            this.setVisible(false);
    	}
    }    
  
  
   public static void main(String[] args) {  
	   new GPA();  
   }


} 