package awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AwtEx7 extends Frame implements ActionListener{
	
	Button btn;
	
	public AwtEx7() {
		super("Action Test");
		setSize(400, 300);
		setLocation(600, 200);
		setVisible(true);
		
		btn = new Button("Click");
		add(btn, "South");
		
		btn.addActionListener(this);
	}

	public static void main(String[] args) {
		new AwtEx7();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("안녕하십니까?");
		System.out.println("e: " + e.getSource());
		Object obj = e.getSource(); // 액션 이벤트 e 객체, e.getSource() 넘어오는 객체를 가져옴
		if(obj == btn) {
			this.setBackground(Color.RED);
		}
	}

}
