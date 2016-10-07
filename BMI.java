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
    
    Font font =new Font("΢���ź�",Font.BOLD,15);
    DecimalFormat dformat = new DecimalFormat("#.00");/*��λС��*/
    public BMI(){
        lblHeight = new JLabel("���(��/m)");
        lblHeight.setFont(font);
        txtHeight = new JTextField(15);
        txtHeight.setFont(font);
        lblWeight = new JLabel("����(ǧ��/kg)");
        lblWeight.setFont(font);
        txtWeight = new JTextField(15);
        txtWeight.setFont(font);
        lblResult = new JLabel("�ο����");
        lblResult.setFont(font);
        txtResult = new JTextField(15);
        txtResult.setFont(font);
        lblBMI = new JLabel("����ֵ(BMI)");
        lblBMI.setFont(font);
        txtBMI = new JTextField(15);
        txtBMI.setFont(font);
        btnRun = new JButton("����");
        btnRun.setFont(font);
        back = new JButton("����");
        back.setFont(font);
        lblSex = new JLabel("�Ա�");
        lblSex.setFont(font);
        txtSex = new JTextField(15);
        txtSex.setFont(font);
        txtAdvice = new JTextArea();
        txtAdvice.setFont(font);
        lblAdvice = new JLabel("��ܰ��ʿ");
        lblAdvice.setFont(font);
        
        pnlMain = new JPanel();
        pnlMain.setLayout(null);/*��ղ��ֹ�����*/
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
        setTitle("��������");
        setVisible(true);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);/*���ô��ڳ�������Ļ����*/

        btnRun.addActionListener(this);
        back.addActionListener(this);
    }
        
    public void actionPerformed(ActionEvent e) {
            	txtAdvice.setText(null);
            	if(e.getSource() == btnRun){
            		if( txtWeight.getText() == null){
                    JOptionPane.showMessageDialog(null, "���Ϊ�գ�������һ����ֵ��ߣ�");
                    return;
            		}
            		if( txtHeight.getText() == null){
            			JOptionPane.showMessageDialog(null, "����Ϊ�գ�������һ����ֵ���أ�");
            			return; 
            		}
            		double weight = Double.valueOf(txtWeight.getText());
            		if(weight <= 0 ){
            			JOptionPane.showMessageDialog(null, "����Ϊ0��������һ����ֵ���ء�");
            			return;
            		}
            		double height = Double.valueOf(txtHeight.getText());
            		if(height <= 0 ){
            			JOptionPane.showMessageDialog(null, "���Ϊ0��������һ����ֵ��ߡ�");
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
    	if(txtSex.getText().equals("��")){
	        if(bmi < 20){
	            return "����";
	        }else if( bmi >= 20 && bmi < 25){
	            return "����";
	        }else if( bmi >= 26 && bmi < 30){
	            return "����";
	        }else if( bmi >= 30 && bmi < 35){
	        	return "����";
	        }else 
	        	return "�ǳ�����";
	        }
	    	else if(txtSex.getText().equals("Ů"))
	    	{
		    	if(bmi < 19 ){
		    		return "����";
		    	}else if(bmi >= 19 && bmi < 24){
		    		return "����";
		        }else if( bmi >= 24 && bmi < 29){
		            return "����";
		        }else if( bmi >= 29 && bmi < 34){
		        	return "����";
		        }else 
		        	return"�ǳ�����";
		    		}
	    	else return "an error exists";
	    }
    private String getAdvice(double bmi) {if(txtSex.getText().equals("��")){
        if(bmi < 20){
            return "һ�����ع�����˳�θ�������ܱȽ���������һ�ٷ����߰˷ֱ�,���ӽ��ʹ�����ҹ����ò�Ҫ�������岻�á�";
        }else if( bmi >= 20 && bmi < 25){
            return "����������ȡ��֧����ƽ�⣬����һЩ��������ʳ�������ʳ��������ʳ�����׷��֣����ܵ������򲡡���Ѫѹ������ĳЩ��֢��";
        }else if( bmi >= 26 && bmi < 30){
            return "�����ܵ��������룬ÿ�ٷ��������ʳ��һ�����ˣ����ˮ��������Ʒ���ٳԸ��Ρ���֬��������ʳ�����Ȼ�Ĳ�������ġ�";
        }else if( bmi >= 30 && bmi < 35){
        	return "���ˮ�ܰ������ų����ڶ��඾�أ����ӱ����У��Ǽ�������ļ�Ʒ����Ҫ���ʵ��㣬Ҫ�ǵ�ÿ�����ٺ�3000cc��ˮŶ��";
        }else 
        	return "���������ҽ����ָ���½��У�����ҽ���İ��Ž���ͳһ����ʳ����Ϳ��ƣ��ʵ���ʱ��ɽ���ҩ��Ŀ��ơ�";
        }
    	else if(txtSex.getText().equals("Ů"))
    	{
	    	if(bmi < 19 ){
	    		return "һ�����ع�����˳�θ�������ܱȽ���������һ�ٷ����߰˷ֱ�,���ӽ��ʹ�����ҹ����ò�Ҫ�������岻�á�";
	    	}else if(bmi >= 19 && bmi < 24){
	    		return "����������ȡ��֧����ƽ�⣬����һЩ��������ʳ�������ʳ��������ʳ�����׷��֣����ֿ��ܵ������򲡡���Ѫѹ�����Ĳ�����ĳЩ��֢��";
	        }else if( bmi >= 24 && bmi < 29){
	            return "�����ܵ��������룬ÿ�ٷ��������ʳ��һ�����ˣ����ˮ��������Ʒ���ٳԸ��Ρ���֬��������ʳ������صġ�����Ȼ�Ĳ�������ġ�";
	        }else if( bmi >= 29 && bmi < 34){
	        	return "���ˮ�ܰ������ų����ڶ��඾�أ����ӱ����У��Ǽ�������ļ�Ʒ����Ҫ���ʵ��㣬Ҫ�ǵ�ÿ�����ٺ�3000cc��ˮŶ��";
	        }else 
	        	return"���������ҽ����ָ���½��У�����ҽ���İ��Ž���ͳһ����ʳ����Ϳ��ƣ��ʵ���ʱ��ɽ���ҩ��Ŀ��ơ�";
	    		}
    	else return "an error exists";
    }

    public static void main(String[] args) {
        BMI bmi = new BMI();
        bmi.setLocationRelativeTo(null);
    } 
   
}