package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MServer extends Thread{
	Socket client;
	
	public MServer(Socket client) {
		this.client = client;
	}
	
	public void run() {
		InetAddress inet = client.getInetAddress();
		String ip = inet.getHostAddress();
		System.out.println(ip + "님 입장");
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream())));
			BufferedReader br = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			String msg = null;
			while((msg = br.readLine()) != null) {
				System.out.println(ip + ":" + msg);
				pw.println(msg);
				pw.flush();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
