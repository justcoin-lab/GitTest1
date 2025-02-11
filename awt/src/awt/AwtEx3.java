package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class AwtEx3 extends Frame{
	
	Button btn1, btn2, btn3, btn4, btn5;
	
	public AwtEx3() {
		super("Board Layout"); //창의 타이틀에 메시지 출력
		setSize(400,300);
		setLocation(600,300);
		setVisible(true);
		
		BorderLayout bl = new BorderLayout(); //배치 관리자 : 컨테이너에는 컴포넌트를 어떻게 배치할지
		//도와주는 배치 관리자가 있다. Frame을 상속받으면 기본적으로 BorderLayout 사용 가능
		setLayout(bl);
		
		btn1 = new Button("EAST"); //버튼의 캡션값, 버튼에 보여질 내용
		btn2 = new Button("WEST");
		btn3 = new Button("SOUTH");
		btn4 = new Button("NORTH");
		btn5 = new Button("CENTER");
		
		add(btn1, bl.EAST); // bl 보더레이아웃 객체이고 배치 관련 작업을 한다. 동쪽에 배치한다.
		add(btn2, bl.WEST);
		add(btn3, bl.SOUTH);
		add(btn4, bl.NORTH);
		add(btn5, bl.CENTER);
	}

	public static void main(String[] args) {
		new AwtEx3();
	}

}
