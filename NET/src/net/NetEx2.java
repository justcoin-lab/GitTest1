package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class NetEx2 { //chat client

	public static void main(String[] args) {
		try {
			Socket s = new Socket("14.42.124.41", 5000); //소켓객체을 이용해서 서버에 접속
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			InputStreamReader isr1 = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr1);
			
			System.out.println("입력하세요: ");
			InputStreamReader isr2 = new InputStreamReader(System.in);//키보드 입력
			BufferedReader keyboard = new BufferedReader(isr2);
			
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw);
			
			String msg = null;
			String message = null;
			
			while((msg = keyboard.readLine()) !=null) {
				System.out.println("내가 입력한 내용 : " + msg);
				pw.println("클라이언트 메시지 : " + msg);
				pw.flush();
				
				message = br.readLine();
				System.out.println(message);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
