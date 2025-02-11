package net;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.management.modelmbean.ModelMBeanNotificationBroadcaster;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatServer extends JFrame implements ActionListener{

	ArrayList<MTserver> list = new ArrayList<MTserver>();
	ServerSocket ss;
	PrintWriter pw;
	BufferedReader br;
	
	JButton jbtn1;
	JTextArea jta1;
	JScrollPane jsp;
	Font f;
	
	public ChatServer() {
		super("채팅서버 v1.0");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(30, 30, 800, 600);
		
		f = new Font("고딕", ABORT, 30);
		jbtn1 = new JButton("Exit");
		jta1 = new JTextArea();
		jta1.setFont(f);
		
		add(jbtn1, "South");
		add(jta1, "Center");
		
		jsp = new JScrollPane(jta1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(jsp, "Center");
		jbtn1.addActionListener(this);
		setVisible(true);
		startChat();
	}
	
	private void startChat() {
		try {
			ss = new ServerSocket(5000);
			while(true) {
				Socket client = ss.accept();
				MTserver ms = new MTserver(client);
				list.add(ms);
				ms.start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(this, "종료합니까?","진짜?", 
				JOptionPane.YES_NO_OPTION);	
		if(result == JOptionPane.OK_OPTION) {
			System.out.println("종료합니다.");
			System.exit(0);
		}
	}
	
	class MTserver extends Thread{
		Socket client;
		PrintWriter pw;
		BufferedReader br;
		String ip;
		
		public MTserver(Socket client) {
			this.client = client;
			try {
				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter
						(client.getOutputStream())));
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				InetAddress inet = client.getInetAddress();
				ip = inet.getHostAddress();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			String msg = null;
			while(true) {
				try {
					msg = br.readLine();
					jta1.append("["+ip+"]"+msg+"\n");
					JScrollBar bar = jsp.getVerticalScrollBar();
					int position = bar.getMaximum();
					bar.setValue(position);
					broadCast("["+ip+"]" + msg);
				}catch(IOException e) {
					e.printStackTrace();
					list.remove(this);
				}
			}
		}
		
		void broadCast(String msg) {
			for(MTserver ms : list) {
				ms.pw.println(msg);
				ms.pw.flush();
			}
		}
	}

}
