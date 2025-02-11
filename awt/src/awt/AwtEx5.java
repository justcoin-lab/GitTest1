package awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AwtEx5 extends Frame{
	
	Button BtnYes, BtnNo;
	
	public AwtEx5() {
		super("Event");
		setSize(400,300);
		setLocation(600,300);
		setVisible(true);
		
		setLayout(null); // 기본 배치 관리자를 사용하지 않겠다.
		
		BtnYes = new Button("Yes");
		BtnNo = new Button("No");
		
		BtnYes.setSize(80,30); //버튼의 크기 설정
		BtnYes.setLocation(30,250); // 버튼의 위치 설정
		
		BtnNo.setSize(80,30);
		BtnNo.setLocation(150,250);
		
		add(BtnYes);
		add(BtnNo);
		
		Handler hd = new Handler();
		BtnYes.addActionListener(hd); //ActionListener 액션 감지하는 메서드
	}

	public static void main(String[] args) {
		new AwtEx5();
	}
	
	class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Hello~~!");
		}
		
	}

}
