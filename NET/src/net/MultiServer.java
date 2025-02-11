package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(5000);
			while(true) {
				System.out.println("사용자 접속 대기중....");
				Socket s = ss.accept();
				MServer ms = new MServer(s);
				ms.start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
