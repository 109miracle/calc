package cal;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DaysBetween extends JFrame implements ActionListener{
	    long daysBetween;
		static String date1=new String("");//运算所需的第1个日期
		static String date2=new String("");//运算所需的第2个日期
		Label label1,label2,label3;
		JPanel p1,p2,p3,p4,p5,panel1,panel2;
		JTextField text1,text2,text3;
		JButton daysb,bh,beq,bclean;

	    /**时间*/
	    private static final String currentTime = "时间";//当前时间
	    private static final String currentDate = "日期";//当前日期
		private static final String summerHoliady = "暑假";//暑假
	    private static final String mayDay = "劳动节";//儿童节
	    private static final String nationalDay = "国庆节";//国庆节
	    private static final String newYear = "元旦";//元旦
	    

	    int i;
	    // Strings for Digit & Operator buttons.
	    String[] str = {currentDate, currentTime,summerHoliady, mayDay, nationalDay, newYear};  
	    JButton[] buttons=new JButton[str.length];
	    JTextField display=new JTextField(15);
	   
		public DaysBetween(){
			super("magic calendar");
			p1=new JPanel();
			p2=new JPanel();
			p3=new JPanel();
			p4=new JPanel();
			p5=new JPanel();
			panel1=new JPanel();
			panel2=new JPanel();
			setLayout(new GridLayout(2,1));
			panel1.setLayout(new FlowLayout());
			panel2.setLayout(new FlowLayout());
			p1.setLayout(new GridLayout(3,1,10,10));//标签面板
			p4.setLayout(new GridLayout(3,1,10,10));//文本框面板
			p2.setLayout(new GridLayout(3,2));//时间面板
			p3.setLayout(new GridLayout(2,1,10,10));//按钮面板
			//label = new Label("magic calendar");
			label1 = new Label("第一天");
			//label1.setFont(new Font("宋体",Font.BOLD,18));
			label2 = new Label("某一天");
			//label2.setFont(new Font("宋体",Font.BOLD,18));
			label3 = new Label("已相恋");
			//label3.setFont(new Font("宋体",Font.BOLD,18));
			text1 = new JTextField(15);
			text2 = new JTextField(15);
			text3 = new JTextField(15);
			//add(label);
			this.setVisible(true);
		

			p1.add(label1);
			p4.add(text1);
			p1.add(label2);
			p4.add(text2);
			p1.add(label3);
			p4.add(text3);
			p5.add(display);

			for (i = 0; i < str.length; i++) {
			    buttons[i] = new JButton(str[i]);
			    p2.add(buttons[i]);
				buttons[i].addActionListener(this); 
			    }

		       
			
			/*for(int i=0;i<10;i++){
			    b[i]=new JButton(Integer.toString(i));
			    p2.add(b[i]);
			    b[i].addActionListener(this);  //为数字按钮b[i]注册监听器
				}
			bh=new JButton("-");//短横按钮
			beq=new JButton("~");//
			p2.add(bh);
			p2.add(beq);
			bh.addActionListener(this);
		    beq.addActionListener(this);*/
			
		    bclean = new JButton("清除");
		    daysb=new JButton("计算");
		    p3.add(bclean);
			p3.add(daysb);
			bclean.addActionListener(this);
			daysb.addActionListener(this);
			panel1.add(p1);
			panel1.add(p4);
			panel1.add(p3);
			panel2.add(p5);
			panel2.add(p2);

			display.addActionListener(this);
			
			add(panel1);
			add(panel2);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pack();
			
			}
		
		
		public void actionPerformed(ActionEvent e) {
			/*如果输入的是日期，则记录下该日期，并在文本框中显示*/
		 	/*for(int i=0;i<10;i++){
			if(e.getSource() == bh || e.getSource() ==  b[i]){
				date2=date2+e.getActionCommand();//把输入的数字组合起来,并保存到date2
		        text1.setText(date2);
		        break;
			}
			}
		 	if(e.getSource()==beq){ 
	            date1=date2;//保存第一个操作数到date1
	            text1.setText("~");
	            date2="";
		 	}*/
			Object target = e.getSource();
			String label = e.getActionCommand();
			if (label.equals(currentDate) || label.equals(currentTime) || label.equals(nationalDay) || label.equals(mayDay) || label.equals(summerHoliady) || label.equals(newYear)){
					handleStr(label);
			}
		    	 	
			date1=text1.getText();
			date2=text2.getText();
		 	
		 	if(target==bclean){//清空文本框
	            text1.setText("");
	            text2.setText("");
	            display.setText("");
	            date2="";
	        }
		 	
		 	if(target==daysb){
				long daysBetween=(getTimeLong(date2)-getTimeLong(date1))/(3600*24*1000);
				date2=String.valueOf(daysBetween);
				text3.setText(date2+"天");
		 	}
		}
		
		public void handleStr(String key){
	    	if(key.equals(currentTime) || key.equals(currentDate)){
	    		display.setText(getDateOrTime(key));
	    	}else if(key.equals(nationalDay) || key.equals(mayDay) || key.equals(summerHoliady) || key.equals(newYear)){
	    		display.setText(holiday(key));
	    	}
   	
	    }
		
		public static long getTimeLong(String date){
	        Calendar c=Calendar.getInstance();
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            Date d=sdf.parse(date);
	            c.setTime(d);
	            long result=c.getTimeInMillis();
	            return result;
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	        return 0;
	    }
		
		private String getDateOrTime(String key){
	    	String result = "";
	    	Date current = new Date(); 
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日@HH:mm:ss");
	    	String[] DateAndTime = dateFormat.format(current).split("@"); 
	    	
	    	if(key.equals(currentDate)){
	    		result = DateAndTime[0];//日期
	    	}else{
	    		result = DateAndTime[1];//时间
	    	}
	    	return result;
	    }
	    
		
		private String holiday(String key){
	    	String day = "";
	    	String[] dateInfo = getDateOrTime(currentDate).split("年");
	    	String currentYear = dateInfo[0];//今年
	    	Calendar calendar = Calendar.getInstance();
	    	if(key.equals(nationalDay)){
	    		calendar.set(Integer.valueOf(currentYear), 10-1, 1, 0, 0, 0);
	    	}else if(key.equals(mayDay)){
	    		calendar.set(Integer.valueOf(currentYear), 5-1, 1, 0, 0, 0);
	    	}else if(key.equals(summerHoliady)){
	    		calendar.set(Integer.valueOf(currentYear), 7-1, 1, 0, 0, 0);
	    	}else if(key.equals(newYear)){
	    		calendar.set(Integer.valueOf(currentYear), 1-1, 1, 0, 0, 0);
	    	}   	
	    	long endTime = calendar.getTimeInMillis();//节假日
	    	long startTime = new Date().getTime();//今天
	    	if(endTime < startTime){
	    		calendar.set(Calendar.YEAR, Integer.valueOf(currentYear) + 1);
	    		endTime = calendar.getTimeInMillis();
	    	}
	    	day = String.valueOf(1 + (endTime - startTime)/ (1000 * 3600 * 24));   	
	    	return "距下一次【" + key + "】还有" + day + "天";
	    }
	    


		
		public static void main(String[] args) throws ParseException {
			DaysBetween db=new DaysBetween();//
	        db.setVisible(true); 
	        db.setSize(500,300);
	        
		}
	}



