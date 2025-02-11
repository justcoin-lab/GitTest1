package awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AwtEx9 extends Frame implements ActionListener, WindowListener{

	Button btn1, btn2;
	int cnt = 0;
	
	public AwtEx9() {
		super("신호등?");
		setSize(400, 300);
		setLocation(600, 300);
		setVisible(true);
		setLayout(null);
		
		addWindowListener(this);
		
		btn1 = new Button("NEXT");
		btn2 = new Button("EXIT");
		
		add(btn1); 
		add(btn2);
		
		btn1.setSize(200, 100);
		btn2.setSize(200, 100);
		
		btn1.setLocation(0, 200);
		btn2.setLocation(200, 200);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		new AwtEx9();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("종료합니다.");
		System.exit(0); // 정상 종료
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		System.out.println(obj);
		
		if(obj == btn1) {
			System.out.println("NEXT버튼 눌려짐");
			if(cnt == 0) {
				System.out.println(cnt);
				this.setBackground(Color.RED);
				cnt++;
			}else if(cnt == 1) {
				System.out.println(cnt);
				this.setBackground(Color.YELLOW);
				cnt++;
			}else if(cnt == 2) {
				System.out.println(cnt);
				this.setBackground(Color.GREEN);
				cnt = 0;
			}
		} //btn1 처리
		else if(obj == btn2) {
			System.out.println("EXIT 버튼이 눌려짐");
			System.exit(0);
		} //btn2 처리
	}

}
