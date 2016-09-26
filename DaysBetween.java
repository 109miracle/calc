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
		static String date1=new String("");//��������ĵ�1������
		static String date2=new String("");//��������ĵ�2������
		Label label1,label2,label3;
		JPanel p1,p2,p3,p4,p5,panel1,panel2;
		JTextField text1,text2,text3;
		JButton daysb,bh,beq,bclean;

	    /**ʱ��*/
	    private static final String currentTime = "ʱ��";//��ǰʱ��
	    private static final String currentDate = "����";//��ǰ����
		private static final String summerHoliady = "���";//���
	    private static final String mayDay = "�Ͷ���";//��ͯ��
	    private static final String nationalDay = "�����";//�����
	    private static final String newYear = "Ԫ��";//Ԫ��
	    

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
			p1.setLayout(new GridLayout(3,1,10,10));//��ǩ���
			p4.setLayout(new GridLayout(3,1,10,10));//�ı������
			p2.setLayout(new GridLayout(3,2));//ʱ�����
			p3.setLayout(new GridLayout(2,1,10,10));//��ť���
			//label = new Label("magic calendar");
			label1 = new Label("��һ��");
			//label1.setFont(new Font("����",Font.BOLD,18));
			label2 = new Label("ĳһ��");
			//label2.setFont(new Font("����",Font.BOLD,18));
			label3 = new Label("������");
			//label3.setFont(new Font("����",Font.BOLD,18));
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
			    b[i].addActionListener(this);  //Ϊ���ְ�ťb[i]ע�������
				}
			bh=new JButton("-");//�̺ᰴť
			beq=new JButton("~");//
			p2.add(bh);
			p2.add(beq);
			bh.addActionListener(this);
		    beq.addActionListener(this);*/
			
		    bclean = new JButton("���");
		    daysb=new JButton("����");
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
			/*�������������ڣ����¼�¸����ڣ������ı�������ʾ*/
		 	/*for(int i=0;i<10;i++){
			if(e.getSource() == bh || e.getSource() ==  b[i]){
				date2=date2+e.getActionCommand();//������������������,�����浽date2
		        text1.setText(date2);
		        break;
			}
			}
		 	if(e.getSource()==beq){ 
	            date1=date2;//�����һ����������date1
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
		 	
		 	if(target==bclean){//����ı���
	            text1.setText("");
	            text2.setText("");
	            display.setText("");
	            date2="";
	        }
		 	
		 	if(target==daysb){
				long daysBetween=(getTimeLong(date2)-getTimeLong(date1))/(3600*24*1000);
				date2=String.valueOf(daysBetween);
				text3.setText(date2+"��");
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
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy��MM��dd��@HH:mm:ss");
	    	String[] DateAndTime = dateFormat.format(current).split("@"); 
	    	
	    	if(key.equals(currentDate)){
	    		result = DateAndTime[0];//����
	    	}else{
	    		result = DateAndTime[1];//ʱ��
	    	}
	    	return result;
	    }
	    
		
		private String holiday(String key){
	    	String day = "";
	    	String[] dateInfo = getDateOrTime(currentDate).split("��");
	    	String currentYear = dateInfo[0];//����
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
	    	long endTime = calendar.getTimeInMillis();//�ڼ���
	    	long startTime = new Date().getTime();//����
	    	if(endTime < startTime){
	    		calendar.set(Calendar.YEAR, Integer.valueOf(currentYear) + 1);
	    		endTime = calendar.getTimeInMillis();
	    	}
	    	day = String.valueOf(1 + (endTime - startTime)/ (1000 * 3600 * 24));   	
	    	return "����һ�Ρ�" + key + "������" + day + "��";
	    }
	    


		
		public static void main(String[] args) throws ParseException {
			DaysBetween db=new DaysBetween();//
	        db.setVisible(true); 
	        db.setSize(500,300);
	        
		}
	}



