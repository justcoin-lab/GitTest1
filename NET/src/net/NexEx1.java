package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NexEx1 {

	public static void main(String[] args) throws UnknownHostException{
		InetAddress inet = InetAddress.getLocalHost(); // InetAddress는 추상클래스
		System.out.println(inet); // 자신의 아이피, 호스트 이름 모든 정보
		System.out.println(inet.getHostAddress()); // 자신의 아이피
		System.out.println(inet.getHostName()); // 자산의 호스트이름
		//네이버 정보
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println(naver.getHostName());
		System.out.println(naver.getHostAddress());
		//다음 정보
		InetAddress daum = InetAddress.getByName("www.daum.net");
		System.out.println(daum.getHostName());
		System.out.println(daum.getHostAddress());
	}

}
