package awt;

import java.awt.Button;
import java.awt.FlowLayout; // 물 흐르듯 자연스럽게 레이아웃이 생성 됨
import java.awt.Frame;

public class AwtEx4 extends Frame{
	
	Button btn1, btn2, btn3, btn4, btn5;
	
	public AwtEx4() {
		super("FlowLayout");
		setSize(400,300);
		setLocation(600,300);
		setVisible(true);
		
		FlowLayout fl = new FlowLayout();
		setLayout(fl);
		
		btn1 = new Button("EAST");
		btn2 = new Button("WEST");
		btn3 = new Button("SOUTH");
		btn4 = new Button("NORTH");
		btn5 = new Button("CENTER");
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);		
	}

	public static void main(String[] args) {
		new AwtEx4();
	}

}
