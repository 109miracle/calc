package cal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** 
 * Ȥζ������
 */
public class Calculator2 extends JFrame implements ActionListener {    
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = -169068472193786457L;
    
    /**�������ť*/
    private static final String add = "��";//��
    private static final String sub = "��";//��
    private static final String mul = "��";//��
    private static final String div = "��";//��
    private static final String eql = "��";//��
    
    /**�㷨��ť*/
    private static final String mulSelf = "ƽ��";//ƽ��
    private static final String factorial = "�׳�";//�׳�
    
    /**ʱ��*/
    private static final String recipocal = "����";//��ǰʱ��
    private static final String openRoot= "����";//��ǰ����

    
    /**���Ǻ���*/
    private static final String sin = "sin";//��
    private static final String cos = "cos";//����
    private static final String tan = "tan";//����
    private static final String cot = "cot";//����
    
    int i;
    // Strings for Digit & Operator buttons.
    private final String[] str = { "7", "8", "9", div, "4", "5", "6", mul, "1",
           "2", "3", sub, ".", "0", eql, add, mulSelf, factorial, recipocal, openRoot, sin, cos, tan, cot};
    // Build buttons.
    JButton[] buttons;
    // For cancel or reset.
    JButton reset,back;    
    // Build the text field to show the result.
    JTextField display;
    JPanel panel1,panel2,panel3;
    // Font
    Font font =new Font("΢���ź�",Font.BOLD,20);
    
    
    public Calculator2(){

    	buttons = new JButton[str.length];
    	reset = new JButton("����");
    	back = new JButton("����������");
    	reset.setPreferredSize(new Dimension(105,60));
    	back.setPreferredSize(new Dimension(150,60));
    	reset.setFont(font);/*��������*/
    	back.setFont(font);
    	display = new JTextField("0");
    	display.setFont(font);
   
       panel1 = new JPanel(new GridLayout(6, 4));
       for (i = 0; i < str.length; i++) {
           buttons[i] = new JButton(str[i]);
           buttons[i].setFont(font);
           panel1.add(buttons[i]);
       }
       
       panel2 = new JPanel(new BorderLayout());
       panel2.add("Center", display);
       panel2.add("East", reset);
       
       panel3 = new JPanel(new FlowLayout());
       panel3.add(back);

       // Add action listener 
       for (i = 0; i < str.length; i++){
    	   buttons[i].addActionListener(this); 
       }          
       reset.addActionListener(this);
       back.addActionListener(this);
       display.addActionListener(this);
       
       add(panel2,BorderLayout.NORTH);
       add(panel1);
       add(panel3,BorderLayout.SOUTH);
       
       setSize(450, 500);
       setVisible(true);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
       Object target = e.getSource();
       String label = e.getActionCommand();
       if (target == reset)
           handleReset();
       else if (target == back){
    	   new Home().setVisible(true);
    	   this.setVisible(false);
       }
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
     * ������ť�¼�
     * @param key pressed operator's key.
     * @throws IllegalAccessException 
     */
    
    public void handleOperator(String key){
    	String resultStr = "0.0";
    	//�㷨
    	if(operator.equals(add) || operator.equals(sub) || operator.equals(mul) || operator.equals(div) || operator.equals(eql) || operator.equals(mulSelf) || operator.equals(factorial)||operator.equals(recipocal)
    			||operator.equals(openRoot)||operator.equals(sin)||operator.equals(cos)||operator.equals(tan)||operator.equals(cot)){
    		Arith arith = new Arith();
    		Double arithNum = Double.valueOf(display.getText());//�������������
    		//��
    		if (operator.equals(add)){
    			number = arith.addArith(number, arithNum);
    		}   		
    		//��
    	    else if (operator.equals(sub)){
    	    	number = arith.subArith(number, arithNum);
    	    }   	   
    		//��
    	    else if (operator.equals(mul)){
    	     number = arith.mulArith(number, arithNum);
    	    }    	
    		//��
    	    else if (operator.equals(div)){
    	    	try {
    	    		number = arith.divArith(number, arithNum,10);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
    	    }
    		//ƽ��
    	    else if (operator.equals(mulSelf)){
    	     number = arith.mulArith(number, number);
    	    }
    		//�׳�
    	    else if (operator.equals(factorial)){    	    	
    	    	int facResult = (int) number;//�׳˽��
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
     * ����ر��¼�
     */

    public static void main(String[] args) {
    	new Calculator2();			
    }	
}
    
  