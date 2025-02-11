package awt;

import java.awt.Frame;
//AWT : Abstract Window Toolkit
//Frame : component , 윈도우 상의 모든 구성 요소 

public class AwtEx1 extends Frame{
	
	AwtEx1(String title){
		super(title); // 타이틀, 창 위쪽에 출력되는 문장
		setSize(300,300); // x, y 축 길이, 여기선 300 * 300 정사각형
		setLocation(400,200);  // 창이 출력될 위치 , x : 400, y : 200 픽셀
		setVisible(true); // 창이 보여질 것이냐? true 보여짐, false 안보여짐

		///깃 업로드 테스트
	}

	public static void main(String[] args) {
		AwtEx1 ae = new AwtEx1("내가 처음 만든 윈도우");
	}

}
