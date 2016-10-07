package cal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class BMI extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblHeight;
    private JLabel lblWeight;
    private JLabel lblBMI;
    private JLabel lblResult;
    private JLabel lblSex;
    private JLabel lblAdvice;

    private JButton btnRun;
    private JButton back;
    private JPanel pnlMain;
    private JTextField txtHeight;
    private JTextField txtWeight;
    private JTextField txtBMI;
    private JTextField txtResult;
    private JTextField txtSex;
    private JTextArea txtAdvice;
    
    Font font =new Font("微软雅黑",Font.BOLD,15);
    DecimalFormat dformat = new DecimalFormat("#.00");/*两位小数*/
    public BMI(){
        lblHeight = new JLabel("身高(米/m)");
        lblHeight.setFont(font);
        txtHeight = new JTextField(15);
        txtHeight.setFont(font);
        lblWeight = new JLabel("体重(千克/kg)");
        lblWeight.setFont(font);
        txtWeight = new JTextField(15);
        txtWeight.setFont(font);
        lblResult = new JLabel("参考结果");
        lblResult.setFont(font);
        txtResult = new JTextField(15);
        txtResult.setFont(font);
        lblBMI = new JLabel("健康值(BMI)");
        lblBMI.setFont(font);
        txtBMI = new JTextField(15);
        txtBMI.setFont(font);
        btnRun = new JButton("测试");
        btnRun.setFont(font);
        back = new JButton("返回");
        back.setFont(font);
        lblSex = new JLabel("性别");
        lblSex.setFont(font);
        txtSex = new JTextField(15);
        txtSex.setFont(font);
        txtAdvice = new JTextArea();
        txtAdvice.setFont(font);
        lblAdvice = new JLabel("温馨贴士");
        lblAdvice.setFont(font);
        
        pnlMain = new JPanel();
        pnlMain.setLayout(null);/*清空布局管理器*/
        lblHeight.setBounds(100, 50, 100, 25);
        txtHeight.setBounds(220, 50, 125, 25);
        lblWeight.setBounds(100, 80, 100, 25);
        txtWeight.setBounds(220, 80, 125, 25);
        lblSex.setBounds(100, 110, 100, 25);
        txtSex.setBounds(220, 110, 125, 25);
        btnRun.setBounds(175, 150, 85, 25);
        lblBMI.setBounds(100, 190, 100, 25);
        txtBMI.setBounds(220, 190, 125, 25);
        lblResult.setBounds(100, 220, 100, 25);
        txtResult.setBounds(220, 220, 125, 25);
        lblAdvice.setBounds(100, 250, 100, 25);
        txtAdvice.setBounds(220, 250, 125, 170);
        back.setBounds(175, 440, 85, 25);


        pnlMain.add(lblHeight);
        pnlMain.add(txtHeight);
        pnlMain.add(lblWeight);
        pnlMain.add(txtWeight);
        pnlMain.add(lblBMI);
        pnlMain.add(txtBMI);
        pnlMain.add(lblResult);
        pnlMain.add(txtResult);
        pnlMain.add(btnRun);
        pnlMain.add(lblSex);
        pnlMain.add(txtSex);
        pnlMain.add(lblAdvice);
        pnlMain.add(txtAdvice);
        pnlMain.add(back);
        txtAdvice.setSize(125,170);
        txtAdvice.setBorder(new LineBorder(Color.GRAY));
        txtAdvice.setEditable(false);
        txtBMI.setBorder(new LineBorder(Color.GRAY));
        txtBMI.setEditable(false);
        txtResult.setBorder(new LineBorder(Color.GRAY));
        txtResult.setEditable(false);
        txtAdvice.setLineWrap(true);
        txtAdvice.setWrapStyleWord(true);
        this.setContentPane(pnlMain);
        setSize(450,550);
        setTitle("健康评估");
        setVisible(true);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);/*设置窗口出现在屏幕中央*/

        btnRun.addActionListener(this);
        back.addActionListener(this);
    }
        
    public void actionPerformed(ActionEvent e) {
            	txtAdvice.setText(null);
            	if(e.getSource() == btnRun){
            		if( txtWeight.getText() == null){
                    JOptionPane.showMessageDialog(null, "身高为空，请输入一个正值身高！");
                    return;
            		}
            		if( txtHeight.getText() == null){
            			JOptionPane.showMessageDialog(null, "体重为空，请输入一个正值体重！");
            			return; 
            		}
            		double weight = Double.valueOf(txtWeight.getText());
            		if(weight <= 0 ){
            			JOptionPane.showMessageDialog(null, "体重为0，请输入一个正值体重。");
            			return;
            		}
            		double height = Double.valueOf(txtHeight.getText());
            		if(height <= 0 ){
            			JOptionPane.showMessageDialog(null, "身高为0，请输入一个正值身高。");
            			return;
            		}
            		double bmi = weight/height/height;
            		txtBMI.setText(dformat.format(bmi));
            		txtResult.setText(getResult(bmi));
            		txtAdvice.append(getAdvice(bmi));
            	}
                
                if (e.getSource() == back){
              	   this.setVisible(false);
             	   new Face1().setVisible(true);
                }
                }

    private String getResult(double bmi) {
        // TODO Auto-generated method stub
    	if(txtSex.getText().equals("男")){
	        if(bmi < 20){
	            return "过轻";
	        }else if( bmi >= 20 && bmi < 25){
	            return "适中";
	        }else if( bmi >= 26 && bmi < 30){
	            return "过重";
	        }else if( bmi >= 30 && bmi < 35){
	        	return "肥胖";
	        }else 
	        	return "非常肥胖";
	        }
	    	else if(txtSex.getText().equals("女"))
	    	{
		    	if(bmi < 19 ){
		    		return "过轻";
		    	}else if(bmi >= 19 && bmi < 24){
		    		return "适中";
		        }else if( bmi >= 24 && bmi < 29){
		            return "过重";
		        }else if( bmi >= 29 && bmi < 34){
		        	return "肥胖";
		        }else 
		        	return"非常肥胖";
		    		}
	    	else return "an error exists";
	    }
    private String getAdvice(double bmi) {if(txtSex.getText().equals("男")){
        if(bmi < 20){
            return "一般体重过轻的人肠胃消化功能比较弱，可以一顿饭吃七八分饱,增加进餐次数，夜宵最好不要，对身体不好。";
        }else if( bmi >= 20 && bmi < 25){
            return "保持热量摄取与支出的平衡，避免一些高热量的食物，经常进食高热量的食物容易肥胖，可能导致糖尿病、高血压、甚至某些癌症。";
        }else if( bmi >= 26 && bmi < 30){
            return "限制总的能量摄入，每顿饭最好有主食，一汤三菜，外加水果和乳制品。少吃高盐、高脂、高能量食物，最天然的才是最健康的。";
        }else if( bmi >= 30 && bmi < 35){
        	return "多喝水能帮助你排除体内多余毒素，增加饱腹感，是减肥瘦身的佳品。想要减肥的你，要记得每天至少喝3000cc的水哦！";
        }else 
        	return "建议减肥在医生的指导下进行，根据医生的安排进行统一的饮食调理和控制，适当的时候可进行药物的控制。";
        }
    	else if(txtSex.getText().equals("女"))
    	{
	    	if(bmi < 19 ){
	    		return "一般体重过轻的人肠胃消化功能比较弱，可以一顿饭吃七八分饱,增加进餐次数，夜宵最好不要，对身体不好。";
	    	}else if(bmi >= 19 && bmi < 24){
	    		return "保持热量摄取与支出的平衡，避免一些高热量的食物，经常进食高热量的食物容易肥胖，肥胖可能导致糖尿病、高血压、冠心病甚至某些癌症。";
	        }else if( bmi >= 24 && bmi < 29){
	            return "限制总的能量摄入，每顿饭最好有主食，一汤三菜，外加水果和乳制品。少吃高盐、高脂、高能量食物，最朴素的、最天然的才是最健康的。";
	        }else if( bmi >= 29 && bmi < 34){
	        	return "多喝水能帮助你排除体内多余毒素，增加饱腹感，是减肥瘦身的佳品。想要减肥的你，要记得每天至少喝3000cc的水哦！";
	        }else 
	        	return"建议减肥在医生的指导下进行，根据医生的安排进行统一的饮食调理和控制，适当的时候可进行药物的控制。";
	    		}
    	else return "an error exists";
    }

    public static void main(String[] args) {
        BMI bmi = new BMI();
        bmi.setLocationRelativeTo(null);
    } 
   
}