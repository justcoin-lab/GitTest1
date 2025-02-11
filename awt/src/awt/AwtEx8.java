package awt;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AwtEx8 extends Frame implements WindowListener{
	
	public AwtEx8() {
		super("Window Listener");
		setSize(400, 300);
		setLocation(600, 200);
		setVisible(true);
		
		this.addWindowListener(this);
	}

	public static void main(String[] args) {
		new AwtEx8();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("윈도우 창이 열리면 호출");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0); // x 버튼을 누르면 프로그램 종료하는 처리
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("윈도우 창이 닫히면 호출");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("창이 아이콘화 되어있을때 호출");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("아이콘화 되어있는 것을 반대로 호출");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("윈도우 창이 활성화 되었을 때 호출");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("윈도우 창이 비활성화 되어 있을 때 호출");
		
	}

}
