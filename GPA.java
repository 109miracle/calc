 import java.awt.Container;  
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.TextEvent;  
import java.awt.event.TextListener;  
import java.text.DecimalFormat;  
import java.util.StringTokenizer;  
  
import javax.swing.JFrame;

  
public class GPA extends JFrame implements TextListener, ActionListener  
{  
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
    //MyImageJPanel image;  
      
    public GPA()  
    { 
        setExtendedState(Frame.MAXIMIZED_VERT);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setBounds(450, 150, 100, 200);  
        setSize(500, 500);    
        this.setTitle("GPA和奖学金分数计算");  
        //setLocationRelativeTo(this);  
        Container con = getContentPane();  
        con.setLayout(new GridLayout(8,2));  
        //image = new MyImageJPanel();  
        //image.setBounds(0, 0, this.getWidth(), this.getHeight());  
        label1 = new Label("请输入各学科绩点：");
        label2 = new Label("请输入各学科学分：");
        label3 = new Label("结果：");
        label4 = new Label("请输入各学科成绩：");
        label5 = new Label("请输入两个学期的体育成绩：");
        label6 = new Label("请输入奖学金加分：");
        label7 = new Label("请输入体育课学分：");
        label8 = new Label("请输入德育分数：");
        text1 = new TextArea(); 
        text3 = new TextArea();
        text4 = new TextArea();
        text2 = new TextArea(); 
        text5 = new TextArea();
        text6 = new TextArea();
        text7 = new TextArea();
        text8 = new TextArea();
        //con.add(image);
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
        text2.setEditable(false);  
        text1.addTextListener(this);  
        text3.addTextListener(this);
        text4.addTextListener(this);
        text5.addTextListener(this);
        text6.addTextListener(this);
        text7.addTextListener(this);
        text8.addTextListener(this); 
        setVisible(true);  
        validate();  
    }  
  
    public void textValueChanged(TextEvent e) {  
        String s1 = text1.getText();  
        StringTokenizer st1 = new StringTokenizer(s1, " ,'\n'");  
        int n1 = st1.countTokens();  /*数输入了几个数*/
        String a1[] = new String[n1];  
          
        for(int i1 = 0; i1 <= n1 - 1; i1++)  
        {  
            String temp1 = st1.nextToken();  
            a1[i1] = temp1;  
        } 
        
        String s2 = text3.getText();
        StringTokenizer st2 = new StringTokenizer(s2, " ,'\n'");  
        int n2 = st2.countTokens();
        String a2[] = new String[n2];
        
        for(int i2 = 0;i2 <= n2 - 1; i2++)
	        {
	        	String temp2 = st2.nextToken();
	        	a2[i2] = temp2;
	        }
        
        String s3 = text4.getText();
        StringTokenizer st3 = new StringTokenizer(s3, " ,'\n'");  
        int n3 = st3.countTokens();
        String a3[] = new String[n3];
        
        for(int i3 = 0;i3 <= n3 - 1; i3++)
	        {
	        	String temp3 = st3.nextToken();
	        	a3[i3] = temp3;
	        }
        
        String s4 = text5.getText();
        StringTokenizer st4 = new StringTokenizer(s4, " ,'\n'");  
        String a4[] = new String[2];
        
        for(int i4 = 0;i4 <= 1; i4++)
	        {
	        	String temp4 = st4.nextToken();
	        	a4[i4] = temp4;
	        }
        
        String s5 = text6.getText();
        StringTokenizer st5 = new StringTokenizer(s5, " ,'\n'"); 
        String a5 = st5.nextToken();
        
        String s6 = text7.getText();
        StringTokenizer st6 = new StringTokenizer(s6, " ,'\n'"); 
        String a6 = st6.nextToken();
        
        String s7 = text8.getText();
        StringTokenizer st7 = new StringTokenizer(s7, " ,'\n'"); 
        String a7 = st7.nextToken();
        
        double addResult = 0;
        double addCredit = 0;
        double aveResult = 0; 
        double aveSport = 0;
        double addMark = 0;
        double aveMark = 0;
        double annex = 0;
        double sportCredit = 0;
        double moralMark = 0;
        
        for(int j = 0; j < n1; j++)  
        {  
            addResult = addResult + Double.valueOf(a1[j]) * Double.valueOf(a2[j]);
            addCredit = addCredit + Double.valueOf(a2[j]);
            addMark = addMark + Double.valueOf(a3[j]) * Double.valueOf(a2[j]);
        }  
     
        if(n1 != 0)  
        {  
        	sportCredit = Double.valueOf(a6);
        	moralMark = Double.valueOf(a7);
        	aveSport = (Double.valueOf(a4[0]) + Double.valueOf(a4[1])) / 2;
        	annex = Double.valueOf(a5);
            aveResult = addResult / addCredit;  
            aveMark = (addMark - aveSport * 2 * sportCredit) / (addCredit - sportCredit*2) * 0.6 + aveSport * 0.1 + annex + moralMark;
            
        }  
       text2.setText(null); 
       text2.append(n1 + "学分总和：   " + addCredit + "\n"); 
       DecimalFormat d = new DecimalFormat("#.00");   
       text2.append("各科平均绩点:  " + d.format(aveResult) + "\n"); 
       text2.append("最终平均成绩： " + d.format(aveMark) + "\n");
               
    }  
      
    public void actionPerformed(ActionEvent e) {  
        text1.setText(null);  
    }  
  
  
} 