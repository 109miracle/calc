package cal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class RandomTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private JTextArea text1 = new JTextArea("Welcome");
	private JPanel panel = new JPanel();
	private JButton _start;
	private JButton _stop;
	private JButton back;
	
	private boolean flag = false;
	private boolean set = false;
	private String txtPath = "E:\\eclipse\\workplace\\cal\\src\\a.txt";
	private static int lineNo;
	private String str = readTxtLine(txtPath);
	
	public static String readTxtLine(String txtPath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(txtPath));
		StringBuilder sb = new StringBuilder();
		String line = null;
		lineNo = Integer.parseInt(br.readLine());
		while ( (line = br.readLine()) != null) {
			sb.append(line+"\n");
		}
		br.close();   
		return sb.toString();
	}

	public RandomTest() throws IOException {
		super("RandomTest");
		set = FIRST();
		
		Thread t = new Thread(new Runnable(){
		    public void run(){
		    	while (set) {
					if (flag == true) {
						Random ran = new Random();
						String [] stringArr= str.split(" "); 
						String ss = stringArr[Math.abs(ran.nextInt()) % lineNo];
						text1.setText(ss);
						text1.setFont(new Font("",Font.BOLD,50));
					}
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}				
				}
		}
		});
		t.start();
		
	}

		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();
			if (obj == _start) {
				flag = true;
				_start.setEnabled(false);
				_stop.setEnabled(true);
				text1.setEnabled(false);
				_start.setFocusable(false);
				_stop.setFocusable(true);	
			} else if (obj == _stop) {
				flag = false;
				_start.setEnabled(true);
				_stop.setEnabled(false);
				text1.setEnabled(false);
				_start.setFocusable(true);
				_stop.setFocusable(false);
			}else if(obj == back){
				this.setVisible(false);
				new Face1().setVisible(true);
				
			}
		}
		public boolean FIRST() {
			setSize(400, 400);
			text1.setFont(new Font("",Font.BOLD,50));
			_start = new JButton("start");
			_stop = new JButton("stop");
			back = new JButton("back");
			_stop.setEnabled(false);
			text1.setEnabled(false);
			panel.add(_start);
			panel.add(_stop);
			panel.add(back);
			
			_start.addActionListener(this);
			_stop.addActionListener(this);
			back.addActionListener(this);
			add(text1, BorderLayout.NORTH);
			add(panel, BorderLayout.SOUTH);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setVisible(true);
			return true;
		}
		
		
		
		public static void main(String[] args) throws IOException {
			new RandomTest();
		}
}

