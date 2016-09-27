package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * 趣味计算器
 * @author zhangjc
 *
 */
public class Calculator2 extends JPanel implements ActionListener {    
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = -169068472193786457L;
    
    /**运算符按钮*/
    private static final String add = "＋";//加
    private static final String sub = "－";//减
    private static final String mul = "×";//乘
    private static final String div = "÷";//除
    private static final String eql = "＝";//除
    
    /**算法按钮*/
    private static final String mulSelf = "平方";//平方
    private static final String factorial = "阶乘";//阶乘
    
    /**字符串*/
    private static final String strOutput = "strOutput";//字符串输出
    
    /**时间*/
    private static final String recipocal = "倒数";//当前时间
    private static final String openRoot= "开根";//当前日期

    
    /**三角函数*/
    private static final String sin = "sin";//米
    private static final String cos = "cos";//分米
    private static final String tan = "tan";//厘米
    private static final String cot = "cot";//毫米
    
    int i;
    // Strings for Digit & Operator buttons.
    private final String[] str = { "7", "8", "9", div, "4", "5", "6", mul, "1",
           "2", "3", sub, ".", "0", eql, add, mulSelf, factorial, recipocal, openRoot, sin, cos, tan, cot};
    // Build buttons.
    JButton[] buttons;
    // For cancel or reset.
    JButton reset;    
    // Build the text field to show the result.
    JTextField display;
    // Font
    Font font =new Font("宋体",Font.BOLD,30);
    
    
    Calculator2(){
    	buttons = new JButton[str.length];
    	reset = new JButton("清零");
    	reset.setPreferredSize(new Dimension(100,100));
    	reset.setFont(font);/*设置字体*/
    	display = new JTextField("0");
    	display.setFont(font);
    }
   
    /**
     * Constructor without parameters.
     * @return 
     */
    public void JCalculator() {
       JPanel panel1 = new JPanel(new GridLayout(6, 4));
       for (i = 0; i < str.length; i++) {
           buttons[i] = new JButton(str[i]);
           buttons[i].setFont(font);
           panel1.add(buttons[i]);
       }
       JPanel panel2 = new JPanel(new BorderLayout());
       panel2.add("Center", display);
       panel2.add("East", reset);

       // Add action listener 
       for (i = 0; i < str.length; i++){
    	   buttons[i].addActionListener(this); 
       }          
       reset.addActionListener(this);
       display.addActionListener(this);
       
       // Set Frame
       Frame frm = new Frame ("Miracle");       
       frm.addWindowListener(new WindowCloser());
       frm.setSize(800, 600);
       frm.setLocationRelativeTo(null);
       frm.add(panel2,BorderLayout.NORTH);
       frm.add(panel1);
       frm.setVisible(true);
    }  
   
    public void actionPerformed(ActionEvent e) {
       Object target = e.getSource();
       String label = e.getActionCommand();
       if (target == reset)
           handleReset();
       else if ("0123456789.".indexOf(label) >= 0)
           handleNumber(label);
       else
    	   handleOperator(label);

    }
    // Is the first digit pressed?
    boolean isFirstDigit = true;
    int lengthOprNum = 0;
    /**
     * Number handling.
     * @param key the key of the button.
     */
    public void handleNumber(String key) {
       if (isFirstDigit)
           display.setText(key);
       else if ((key.equals(".")) && (display.getText().indexOf(".") < 0))
           display.setText(display.getText() + ".");
       else if (!key.equals("."))
           display.setText(display.getText() + key);
       isFirstDigit = false;
    }
   
    /**
     * Reset the calculator.
     */
    public void handleReset() {
       display.setText("0");
       isFirstDigit = true;
       lengthOprNum = 0;
       operator = eql;
    }
 
    double number = 0;
    String operator = eql;
   
    /**
     * 操作按钮事件
     * @param key pressed operator's key.
     * @throws IllegalAccessException 
     */
    
    public void handleOperator(String key){
    	String resultStr = "0.0";
    	//算法
    	if(operator.equals(add) || operator.equals(sub) || operator.equals(mul) || operator.equals(div) || operator.equals(eql) || operator.equals(mulSelf) || operator.equals(factorial)||operator.equals(recipocal)
    			||operator.equals(openRoot)||operator.equals(sin)||operator.equals(cos)||operator.equals(tan)||operator.equals(cot)){
    		Arith arith = new Arith();
    		Double arithNum = Double.valueOf(display.getText());//参与运算的数字
    		//加
    		if (operator.equals(add)){
    			number = arith.addArith(number, arithNum);
    		}   		
    		//减
    	    else if (operator.equals(sub)){
    	    	number = arith.subArith(number, arithNum);
    	    }   	   
    		//乘
    	    else if (operator.equals(mul)){
    	     number = arith.mulArith(number, arithNum);
    	    }    	
    		//除
    	    else if (operator.equals(div)){
    	    	try {
    	    		number = arith.divArith(number, arithNum,10);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
    	    }
    		//平方
    	    else if (operator.equals(mulSelf)){
    	     number = arith.mulArith(number, number);
    	    }
    		//阶乘
    	    else if (operator.equals(factorial)){    	    	
    	    	int facResult = (int) number;//阶乘结果
    	    	if(facResult != 1){
    	    		for(int facNum = 0; facNum < (int) number; facNum++){
        	    		facResult *= (int) number-1;   	    		
        	    		number--;
        	    	}  
    	    	}
    	    	number = facResult;
    	    }
    	    else if (operator.equals(recipocal)){
    	    	try {
    	    		number = arith.divArith(1, arithNum,10);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
    	    }
    	    else if(operator.equals(openRoot)){
    	    	try {
    	    	number = arith.openArith(number);	
    	    	} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
    	    }
    	    else if(operator.equals(sin)){
    	    	number = arith.sinArith(number);
    	    }
    	    else if(operator.equals(cos)){
    	    	number = arith.cosArith(number);
    	    }
    	    else if(operator.equals(tan)){
    	    	number = arith.tanArith(number);
    	    }
    	    else if(operator.equals(cot)){
    	    	number = arith.cotArith(number);
    	    }
    	    else if (operator.equals(eql)){
    	    	number = Double.valueOf(display.getText());
    	    }
    		resultStr = String.valueOf(number);	
    	}      
    	   	
        display.setText(resultStr);
        operator = key;
        isFirstDigit = true;
    }
    
    /**
     * 窗体关闭事件
     */
    private class WindowCloser extends WindowAdapter {
       public void windowClosing(WindowEvent we) {
           System.exit(0);
       }
    }
}
    
  