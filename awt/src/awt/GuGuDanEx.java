package awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GuGuDanEx extends Frame implements ActionListener, WindowListener{

	Button btn;
	
	public GuGuDanEx() {
		super("GuGuDan");
		setSize(400, 300);
		setLocation(600, 300);
		setVisible(true);
		
		this.addWindowListener(this);
		
		btn = new Button("Random GuGuDan");
		add(btn, "South");
		
		btn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new GuGuDanEx();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
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
		GuGuDan g = new GuGuDan();
		g.print();
	}

}
