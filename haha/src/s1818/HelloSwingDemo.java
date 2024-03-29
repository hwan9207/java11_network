package s1818;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * 배치 관리자의 종류
 * FlowLayout : 창 크기에 따라 위치 달라진다.
 * BorderLayout : 동서남북센터  
 * ex.) BorderLayout.EAST ..이런식으로 배치
 * 다른거 잘 사용 안한다
 * JPanel panel = new JPanel(new BorderLayout()); - 생성자 이용
 * Panel.setLayout(new FlowLayout()); - 메소드 이용
 */


public class HelloSwingDemo extends JFrame {
	HelloSwingDemo() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("진짜 짜증난다");
		JLabel labelImg = new JLabel(new ImageIcon("imgs/sea.jpg"));
		JTextField field = new JTextField(20);
		JTextArea area = new JTextArea(30,50);
//		JLabel lb1 = new JLabel(" ", JLabel.CENTER);
//		ImageIcon icon = new ImageIcon("imgs/sea.jpg");
		JButton button1 = new JButton("짜증난다");
		Font font = new Font("굴림", Font.BOLD, 15);
		setTitle("존나 짜증난다");
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label.setFont(font);
//		lb1.setIcon(icon);
//		panel.add(lb1);
		panel.add(area);
		panel.add(field);
		panel.add(labelImg);
		panel.add(label);
		panel.add(button1);
		add(panel);
	}
	
	public static void main(String[] args) {
		new HelloSwingDemo();
	}

}
