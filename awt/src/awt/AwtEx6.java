package awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AwtEx6 extends Frame{

	Button btn;
	
	public AwtEx6() {
		super("Action Test");
		setSize(400,300);
		setLocation(600,200);
		setVisible(true);
		
		btn = new Button("click");
		add(btn, "South"); //Borderlayout객체가 아니고, Frame 배치시 South로 넣어줄 것
		
		Handler hd = new Handler(); //내부 클래스 Handler 객체 생성
		btn.addActionListener(hd);
		
	}
	
	public static void main(String[] args) {
		new AwtEx6();
	}
	
	class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("안녕하세요. 버튼을 누르면 종료됩니다.");
			System.exit(0); // 종료해라. 매개변수 0은 정상 종료를 의미
		}
		
	}

}
