package net;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, KeyListener, Runnable{
	
	JButton jbtn1, jbtn2, jbtn3;
	JPanel jp1, jp2, jp3;
	JTextField jtf1, jtf2;
	JTextArea jta;
	JLabel jl;
	JScrollPane jsp;
	CardLayout layout; // GUI를 위한 멤버 변수
	
	Socket s;
	PrintWriter pw;
	BufferedReader br; // 접속, 인아웃풋 관련 멤버변수
	
	String ip; //ip 정보를 담기 위한 멤버 변수
	
	public ChatClient() {
		super("채팅클라이언트 v1.0");
		setBounds(100, 100, 400, 300);//크기와 위치를 동시에 설정, x100, y100 위치에, 400,300크기
		setDefaultCloseOperation(EXIT_ON_CLOSE);//창 종료시 실행한 액션설정, 창닫기
		
		layout = new CardLayout();
		setLayout(layout);
		
		jbtn1 = new JButton("Login");
		jbtn2 = new JButton("Exit");
		jbtn3 = new JButton("Insert");
		
		jbtn1.setBounds(60, 200, 60, 50); // x축위치, y축위치, x길이, y길이
		jbtn2.setBounds(180, 200, 60, 50);
		
		jl = new JLabel("IP : ");
		jl.setBounds(40, 60, 60, 50);
		
		jtf1 = new JTextField("14.42.124.41");
		jtf1.setBounds(100, 60, 152, 40);
		
		jtf2 = new JTextField(25);
		jta = new JTextArea();
		jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jp1.setLayout(null);
		jp1.add(jbtn1);
		jp1.add(jbtn2);
		jp1.add(jtf1);
		jp1.add(jl);
		
		Color c1 = new Color(229,234,245);
		jp1.setBackground(c1);
		add(jp1, "Login View");
		
		Color c2 = new Color(241,232,92);
		jp2.setLayout(new BorderLayout());
		jp2.add(jsp, "Center");
		add(jp2, "Chat");
		
		jp3.setBackground(c2);
		jp3.add(jtf2);
		jp3.add(jbtn3);
		
		jp2.add(jp3, "South");
		
		jbtn1.addActionListener(this);
		jbtn2.addActionListener(this);
		
		jtf2.addKeyListener(this);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}

	@Override
	public void run() {
		try {
			s = new Socket("14.42.124.41", 5000);
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())));
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String msg = null;
			while(true) {
				msg = br.readLine();
				jta.append(msg + "\n");
				JScrollBar bar = jsp.getVerticalScrollBar();
				int position = bar.getMaximum();
				bar.setValue(position);
			}
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int v = e.getKeyCode();
		if(v==KeyEvent.VK_ENTER) {
			String msg = jtf2.getText();
			jta.append("["+ip+"]" + msg + "\n");
			pw.println(msg);
			pw.flush();
			jtf2.setText("");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==jbtn1) {
			ip = jtf1.getText();
			layout.show(getContentPane(), "Chat");
			Thread th = new Thread(this);
			th.start();
		}else if(o==jbtn2) {
			int result = JOptionPane.showConfirmDialog(this, "종료합니까?", "진짜", 
					JOptionPane.YES_NO_CANCEL_OPTION);
			if(result == JOptionPane.OK_OPTION) {
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
		
	}

}
