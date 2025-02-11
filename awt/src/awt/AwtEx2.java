package awt;

import java.awt.Frame; //container : 다른 component를 담을 수 있는 component이다.
import java.awt.Button;//클릭할 수 있는 버튼

public class AwtEx2 extends Frame{
	
	Button btn; //Button 객체 먼저 선언
	
	public AwtEx2(String title) {
		super(title);
		setSize(400,200);
		setLocation(597,289);
		btn = new Button("Click~!"); // 생성자 안에 버튼위에 올라갈 텍스트를 입력
		add(btn);
		setVisible(true);
	}

	public static void main(String[] args) {
		AwtEx2 ad = new AwtEx2("버튼이 있는 윈도우");
	}

}
