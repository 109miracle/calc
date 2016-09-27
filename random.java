import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class random {
public static void main(String[] args) throws IOException {
	
new test1();
}
}


class test1 extends JFrame implements ActionListener {
private JTextArea text1 = new JTextArea("Welcome");
private JPanel panel = new JPanel();
private JButton _start;
private JButton _stop;
private boolean flag = false;
private Container c = getContentPane();
private String txtPath = "/Users/cailingyu/Documents/first test/src/a.txt";
private static int lineNo;
private String str = readTxtLine(txtPath);
private int count = 0;

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

public test1() throws IOException {
setSize(400, 400);
text1.setFont(new Font("",Font.BOLD,50));
_start = new JButton("start");
_stop = new JButton("stop");
_stop.setEnabled(false);
text1.setEnabled(false);
panel.add(_start);
panel.add(_stop);
_start.addKeyListener(new KeyListener() {
public void keyPressed(KeyEvent e) {
if (e.getKeyCode() == KeyEvent.VK_SPACE)
count++;
if (count % 2 == 0) {
_start.setEnabled(true);
_stop.setEnabled(false);
_start.setFocusable(true);
_stop.setFocusable(false);
flag = false;
} else if (count % 2 == 1) {
_start.setEnabled(false);
_stop.setEnabled(true);
_stop.setFocusable(true);
_start.setFocusable(false);
flag = true;
}
}

public void keyReleased(KeyEvent arg0) {
}

public void keyTyped(KeyEvent arg0) {
}
});
_start.addActionListener(this);
_stop.addActionListener(this);
c.add(text1, BorderLayout.NORTH);
c.add(panel, BorderLayout.SOUTH);
this.setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
setLocation(300, 300);
RUN();
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
}
}

public void RUN() {
while (true) {
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
;
}
}
}