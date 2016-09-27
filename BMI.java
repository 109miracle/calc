package cal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class BMI extends JFrame{

    private JLabel lblHeight;
    private JLabel lblWeight;
    private JLabel lblBMI;
    private JLabel lblResult;
    private JLabel lblSex;
    private JLabel lblAdvice;

    private JButton btnRun;
    private JPanel pnlMain;
    private JTextField txtHeight;
    private JTextField txtWeight;
    private JTextField txtBMI;
    private JTextField txtResult;
    private JTextField txtSex;
    private JTextArea txtAdvice;
    
    DecimalFormat dformat = new DecimalFormat("#.00");/*两位小数*/
    public BMI(){
        lblHeight = new JLabel("身高(米/m)");
        txtHeight = new JTextField(10);
        lblWeight = new JLabel("体重(千克/kg)");
        txtWeight = new JTextField(10);
        lblResult = new JLabel("参考结果");
        txtResult = new JTextField(10);
        lblBMI = new JLabel("健康值(BMI)");
        txtBMI = new JTextField(10);
        btnRun = new JButton("测试");
        lblSex = new JLabel("性别");
        txtSex = new JTextField(10);
        txtAdvice = new JTextArea();
        lblAdvice = new JLabel("温馨贴士");
        
        pnlMain = new JPanel();
        pnlMain.setLayout(null);/*清空布局管理器*/
        lblHeight.setBounds(100, 50, 80, 25);
        txtHeight.setBounds(200, 50, 100, 25);
        lblWeight.setBounds(100, 80, 80, 25);
        txtWeight.setBounds(200, 80, 100, 25);
        lblSex.setBounds(100, 110, 80, 25);
        txtSex.setBounds(200, 110, 100, 25);
        btnRun.setBounds(150, 140, 80, 25);
        lblBMI.setBounds(100, 200, 80, 25);
        txtBMI.setBounds(200, 200, 100, 25);
        lblResult.setBounds(100, 230, 80, 25);
        txtResult.setBounds(200, 230, 100, 25);
        lblAdvice.setBounds(100, 260, 80, 25);
        txtAdvice.setBounds(200, 260, 100, 200);


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
        txtAdvice.setSize(100,200);
        txtAdvice.setEditable(false);
        txtBMI.setEditable(false);
        txtResult.setEditable(false);
        txtAdvice.setLineWrap(true);
        txtAdvice.setWrapStyleWord(true);
        this.setContentPane(pnlMain);
        setSize(350,500);
        setTitle("健康评估");
        setVisible(true);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);/*设置窗口出现在屏幕中央*/

        btnRun.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	txtAdvice.setText(null);
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

        });
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
            return "一般体重过轻的人肠胃消化功能比较弱，可以一顿饭少吃一些，七八分饱就可以。增加进餐次数，比如下午茶时间可以多吃一顿，夜宵最好不要，对身体不好。";
        }else if( bmi >= 20 && bmi < 25){
            return "保持热量摄取与支出的平衡，避免一些高热量的食物经常进食高热量的食物会容易肥胖，肥胖可能导致糖尿病、高血压、冠心病甚至某些癌症。";
        }else if( bmi >= 26 && bmi < 30){
            return "饮食上吃到七分饱，限制总的能量摄入。而且每顿饭最好有主食，一汤三菜，外加水果和乳制品。少吃高盐、高脂、高能量食物，最朴素的、最天然的才是最健康的。";
        }else if( bmi >= 30 && bmi < 35){
        	return "多喝水能帮助你排除体内的多余毒素和增加你的饱腹感，是减肥瘦身的佳品。想要减肥的你，要记得每天至少喝3000cc的水哦！";
        }else 
        	return "建议减肥在医生的指导下进行，根据医生的安排进行统一的饮食调理和控制，适当的时候可进行药物的控制。";
        }
    	else if(txtSex.getText().equals("女"))
    	{
	    	if(bmi < 19 ){
	    		return "一般体重过轻的人肠胃消化功能比较弱，可以一顿饭少吃一些，七八分饱就可以。增加进餐次数，比如下午茶时间可以多吃一顿，夜宵最好不要，对身体不好。";
	    	}else if(bmi >= 19 && bmi < 24){
	    		return "保持热量摄取与支出的平衡，避免一些高热量的食物经常进食高热量的食物会容易肥胖，肥胖可能导致糖尿病、高血压、冠心病甚至某些癌症。";
	        }else if( bmi >= 24 && bmi < 29){
	            return "饮食上吃到七分饱，限制总的能量摄入。而且每顿饭最好有主食，一汤三菜，外加水果和乳制品。少吃高盐、高脂、高能量食物，最朴素的、最天然的才是最健康的。";
	        }else if( bmi >= 29 && bmi < 34){
	        	return "多喝水能帮助你排除体内的多余毒素和增加你的饱腹感，是减肥瘦身的佳品。想要减肥的你，要记得每天至少喝3000cc的水哦！";
	        }else 
	        	return"建议减肥在医生的指导下进行，根据医生的安排进行统一的饮食调理和控制，适当的时候可进行药物的控制。";
	    		}
    	else return "an error exists";
    }

    public static void main(String[] args) {
        new BMI();
    }
   
}